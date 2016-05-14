package org.guduo.textming.webView.utils;

import org.guduo.textming.algorithm.Sentiment.SentimentAnalyze;

/**
 * @athor Lijian
 * @date 2016年05月14日
 */
public class SemanticUtils {

    public double getSentiment(String text){
        SentimentAnalyze analyze = new SentimentAnalyze();
        return analyze.getDat(text);
    }
}
