package org.guduo.textming;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.summary.TextRankKeyword;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xljlx on 2016/4/21.
 */
public class start extends TextRankKeyword{
    public static void main(String[] args) {
        HashMap<String, Object> rmap = new HashMap<String, Object>();
        String text = "这部剧要火，看完两集多了1000w 的收视率。人物个性鲜明，节奏轻快，演员演技都过关。王子文当年的齐齐一直印象深刻，刘涛和蒋欣也是霸气养眼。关关和蚯蚓很真实，虽然蚯蚓有点闹的感觉但是整体就很出彩";
        List<String> strings = HanLP.extractKeyword(text, 10);
        List<Term> w = HanLP.newSegment().enableNameRecognize(true).seg(text);
        for (Term term : w) {
            if (term.nature == Nature.nr){
                System.out.println(term.word);
            }
        }
    }

    class BatchReader implements Runnable{

        @Override
        public void run() {
            try {
                    File file = new File("E:/dic/weibo");//Text文件
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = "";
                int i = 0;
                while ((line=br.readLine()) != null){
                    System.out.println(line);
                    System.out.println(++i);
                }
                br.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
