package org.guduo.textming.webView.utils;

import org.guduo.textming.algorithm.Sentiment.SentimentAnalyze;
import org.guduo.textming.webView.Service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @athor Lijian
 * @date 2016年05月14日
 */
@Resource
public class SemanticWorker extends Thread {

    protected Map<String ,Integer> resultMap = new ConcurrentHashMap<String,Integer>();

    public Map<String, Integer> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, Integer> resultMap) {
        this.resultMap = resultMap;
    }

    String root = this.getClass().getClassLoader().getResource("/").getPath() + "excel/";
    File file = null;
    List<String> context;
    int from;
    int to;

    public SemanticWorker(List<String> context, int from, int to, String fileName) {
        this.context = context;
        this.from = from;
        this.to = to;
        this.file = new File(root + fileName + ".csv");
    }

    @Override
    public void run() {
        try {
            SemanticUtils analyze = new SemanticUtils();
            for (int i = from; i < to; ++i) {
                FileWriter out = new FileWriter(file, true);
                double sentiment = analyze.getSentiment(context.get(i));
                if (sentiment > 0) {
                    int count = resultMap.containsKey("p") ? resultMap.get("p") + 1 : 1;
                    resultMap.put("p", count);
                }
                out.write(context.get(i) + "," + sentiment + "\n");
                out.flush();
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
