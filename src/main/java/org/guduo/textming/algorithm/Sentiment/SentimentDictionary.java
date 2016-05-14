package org.guduo.textming.algorithm.Sentiment;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.collection.trie.DoubleArrayTrie;
import com.hankcs.hanlp.collection.trie.bintrie.BinTrie;
import com.hankcs.hanlp.corpus.io.ByteArray;
import com.hankcs.hanlp.corpus.io.IOUtil;
import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.corpus.util.CustomNatureUtility;
import com.hankcs.hanlp.dictionary.CoreDictionary;
import com.hankcs.hanlp.dictionary.other.CharTable;
import com.hankcs.hanlp.utility.LexiconUtility;
import com.hankcs.hanlp.utility.Predefine;
import com.hankcs.hanlp.utility.TextUtility;

import java.io.*;
import java.util.*;

import static com.hankcs.hanlp.utility.Predefine.logger;

/**
 * Created by xljlx on 2016/4/19.
 */
public class SentimentDictionary {
    /**
     * 用于储存用户动态插入词条的二分trie树
     */
    public static BinTrie<CoreDictionary.Attribute> trie;
    public static DoubleArrayTrie<CoreDictionary.Attribute> dat = new DoubleArrayTrie<CoreDictionary.Attribute>();

    /**
     * 第一个是主词典，其他是副词典
     */
    public final static String path = HanLP.Config.SentimentDictionaryPath;

    // 自动加载词典
    static {
        CustomNatureUtility.registerSwitchClass(SentimentDictionary.class);
        long start = System.currentTimeMillis();

        if (!loadMainDictionary(path)) {
            logger.warning("情感词典" + path + "加载失败");
        } else {
            logger.info("情感词典加载成功:" + dat.size() + "个词条，耗时" + (System.currentTimeMillis() - start) + "ms");
        }
    }

    private static boolean loadMainDictionary(String mainPath) {
        logger.info("情感词典开始加载:" + mainPath);
        if (loadDat(mainPath)) return true;
        TreeMap<String, CoreDictionary.Attribute> map = new TreeMap<String, CoreDictionary.Attribute>();
        LinkedHashSet<Nature> customNatureCollector = new LinkedHashSet<Nature>();
        try {
            Nature defaultNature = Nature.NN;
            logger.info("以NN词性[" + defaultNature + "]加载情感词典" + path + "中……");
            boolean success = load(path, defaultNature, map, customNatureCollector);
            if (!success) logger.warning("失败：" + path);
            if (map.size() == 0) {
                logger.warning("没有加载到任何词条");
                map.put(Predefine.TAG_OTHER, null);     // 当作空白占位符
            }
            logger.info("正在构建DoubleArrayTrie……");
            dat.build(map);
            // 缓存成dat文件，下次加载会快很多
            logger.info("正在缓存词典为dat文件……");
            // 缓存值文件
            List<CoreDictionary.Attribute> attributeList = new LinkedList<CoreDictionary.Attribute>();
            for (Map.Entry<String, CoreDictionary.Attribute> entry : map.entrySet()) {
                attributeList.add(entry.getValue());
            }
            DataOutputStream out = new DataOutputStream(new FileOutputStream(mainPath + Predefine.BIN_EXT));
            // 缓存用户词性
            IOUtil.writeCustomNature(out, customNatureCollector);
            // 缓存正文
            out.writeInt(attributeList.size());
            for (CoreDictionary.Attribute attribute : attributeList) {
                out.writeInt(attribute.totalFrequency);
                out.writeInt(attribute.nature.length);
                for (int i = 0; i < attribute.nature.length; ++i) {
                    out.writeInt(attribute.nature[i].ordinal());
                    out.writeInt(attribute.frequency[i]);
                }
            }
            dat.save(out);
            out.close();
        } catch (FileNotFoundException e) {
            logger.severe("情感词典" + mainPath + "不存在！" + e);
            return false;
        }
        catch (IOException e) {
            logger.severe("情感词典" + mainPath + "读取错误！" + e);
            return false;
        }
        catch (Exception e) {
            logger.warning("情感词典" + mainPath + "缓存失败！" + e);
        }
        return true;
    }

    /**
     * 加载用户词典（追加）
     *
     * @param path                  词典路径
     * @param defaultNature         默认词性
     * @param customNatureCollector
     * @return
     */
    public static boolean load(String path, Nature defaultNature, TreeMap<String, CoreDictionary.Attribute> map, LinkedHashSet<Nature> customNatureCollector) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] param = line.split("\\s");
                if (param[0].length() == 0) continue;   // 排除空行
                if (HanLP.Config.Normalization) param[0] = CharTable.convert(param[0]); // 正规化
                int natureCount = (param.length - 1) / 2;
                CoreDictionary.Attribute attribute;
                if (natureCount == 0) {
                    attribute = new CoreDictionary.Attribute(defaultNature);
                } else {
                    attribute = new CoreDictionary.Attribute(natureCount);
                    for (int i = 0; i < natureCount; ++i) {
                        attribute.nature[i] = LexiconUtility.convertStringToNature(param[1 + 2 * i], customNatureCollector);
                        attribute.frequency[i] = Integer.parseInt(param[2 + 1 * i]);
                        attribute.totalFrequency += attribute.frequency[i];
                    }
                }
                map.put(param[0], attribute);
            }
            br.close();
        } catch (Exception e) {
            logger.severe("情感词典用户词典: " + path + "读取错误！" + e);
            return false;
        }

        return true;
    }

    /**
     * 从磁盘加载双数组
     *
     * @param path
     * @return
     */
    static boolean loadDat(String path) {
        try {
            ByteArray byteArray = ByteArray.createByteArray(path + Predefine.BIN_EXT);
            if (byteArray == null) return false;
            int size = byteArray.nextInt();
            if (size < 0)   // 一种兼容措施,当size小于零表示文件头部储存了-size个用户词性
            {
                while (++size <= 0) {
                    Nature.create(byteArray.nextString());
                }
                size = byteArray.nextInt();
            }
            CoreDictionary.Attribute[] attributes = new CoreDictionary.Attribute[size];
            final Nature[] natureIndexArray = Nature.values();
            for (int i = 0; i < size; ++i) {
                // 第一个是全部频次，第二个是词性个数
                int currentTotalFrequency = byteArray.nextInt();
                int length = byteArray.nextInt();
                attributes[i] = new CoreDictionary.Attribute(length);
                attributes[i].totalFrequency = currentTotalFrequency;
                for (int j = 0; j < length; ++j) {
                    attributes[i].nature[j] = natureIndexArray[byteArray.nextInt()];
                    attributes[i].frequency[j] = byteArray.nextInt();
                }
            }
            if (!dat.load(byteArray, attributes) || byteArray.hasMore()) return false;
        } catch (Exception e) {
            logger.warning("读取失败，问题发生在" + TextUtility.exceptionToString(e));
            return false;
        }
        return true;
    }
}
