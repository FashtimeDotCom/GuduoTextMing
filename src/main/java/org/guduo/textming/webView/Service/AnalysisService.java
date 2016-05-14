package org.guduo.textming.webView.Service;

import org.guduo.textming.webView.Entry.AnalysisComments;
import org.guduo.textming.webView.Entry.Comments;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @athor Lijian
 * @date 2016年05月10日
 */
public interface AnalysisService {

    double getSentiment(String text);

    double getSentimentBG(String text) throws IOException;

    byte getClassify(String text);

    String getKeyWord(String text);

    String getKeyWordByNum(String text,int num);

    TreeMap<String, Integer> getKeyWord(List<String> contexts);

    AnalysisComments save(AnalysisComments analysisComments);

    List<String> search(String[] likes, List<Integer> set);

    Map<String, Integer> runThread(List<String> context, String name);

}
