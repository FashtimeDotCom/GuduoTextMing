package org.guduo.textming.webView.utils;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import org.guduo.textming.webView.Entry.WordCloud;

import java.util.*;

import static com.hankcs.hanlp.dictionary.stopword.CoreStopWordDictionary.shouldInclude;


/**
 * Created by xljlx on 2016/4/12.
 */
public class TextUtil {

    public static Map<String,Integer> getTF(String text){
        HashMap<String, Integer> TF = new HashMap<String, Integer>();
        List<Term> segment = HanLP.newSegment().seg(text);
        for (Term term : segment) {
            if (shouldInclude(term)){
                int value = TF.containsKey(term.word) ? TF.get(term.word) : 0;
                TF.put(term.word,value + 1);
            }
        }
        return TF;
    }

    public static Map<String,Integer> getTFSort(String text){
        Map<String, Integer> tf = getTF(text);
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(tf.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue() - o1.getValue());//根据value排序
            }
        });
        Map<String, Integer> SortTF = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> stringIntegerEntry : entryList) {
            SortTF.put(stringIntegerEntry.getKey(),stringIntegerEntry.getValue());
        }
        return SortTF;
    }

    public static ArrayList<WordCloud> getTFSortList(String text){
        ArrayList<WordCloud> wordClouds = new ArrayList<WordCloud>();
        Map<String, Integer> tf = getTF(text);
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(tf.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue() - o1.getValue());//根据value排序
            }
        });
        Map<String, Integer> SortTF = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : entryList) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            HashMap<String, String> shm = new HashMap<String, String>();
            shm.put("color",ColorUtil.getColor());
            map.put("normal",shm);
            WordCloud wordCloud = new WordCloud(entry.getKey(),entry.getValue()*100,map);
            wordClouds.add(wordCloud);
        }
        return wordClouds;
    }


}
