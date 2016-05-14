package cn.guoduo.test;

import com.hankcs.hanlp.dictionary.CustomDictionary;
import org.guduo.textming.algorithm.Sentiment.SentimentAnalyze;

import java.util.Random;

/**
 * @athor Lijian
 * @date 2016年05月11日
 */
public class TestSemantic {
    public static void main(String[] args) {
        SentimentAnalyze analyze = new SentimentAnalyze();
        double dat = analyze.getDat("唉，蒋年年竟然暗恋张平。。");
        System.out.println(dat);
    }
}
