package org.guduo.textming.webView.Service.impl;

import com.hankcs.hanlp.HanLP;
import org.apache.commons.lang.StringUtils;
import org.guduo.textming.algorithm.Sentiment.SentimentAnalyze;
import org.guduo.textming.algorithm.bagofword.BowInter;
import org.guduo.textming.algorithm.bayes.BayesClassifier;
import org.guduo.textming.webView.Dao.AnalysisCommentsDao;
import org.guduo.textming.webView.Entry.AnalysisClassify;
import org.guduo.textming.webView.Entry.AnalysisComments;
import org.guduo.textming.webView.Entry.Comments;
import org.guduo.textming.webView.Service.AnalysisService;
import org.guduo.textming.webView.utils.SemanticMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.IOException;
import java.util.*;

/**
 * @athor Lijian
 * @date 2016年05月10日
 */
@Service
public class AnalysisServiceImpl implements AnalysisService {
    @Autowired
    private AnalysisCommentsDao analysisCommentsDao;

    @PersistenceContext(name = "jpa")
    private EntityManager entityManager;
    /**
     * 获取情感正负向
     * @param text
     * @return
     */
    @Override
    public double getSentiment(String text){
        SentimentAnalyze analyze = new SentimentAnalyze();
        return analyze.getDat(text);
    }

    @Override
    public double getSentimentBG(String text) throws IOException {
        BowInter bowInter = new BowInter();
        return bowInter.getScore(text);
    }

    /**
     * 获取分类
     * @param text
     * @return
     */
    @Override
    public byte getClassify(String text){
        BayesClassifier classifier = new BayesClassifier();
        String classify = classifier.classify(text);
        char c = classify.charAt(0);
        switch (c){
            case 'A': return AnalysisClassify.ACTOR;
            case 'B': return AnalysisClassify.BEAUTY;
            case 'C': return AnalysisClassify.CLOTHING;
            case 'D': return AnalysisClassify.DIRECTOR;
            case 'M': return AnalysisClassify.BMG;
            case 'P': return AnalysisClassify.PLOT;
            case 'S': return AnalysisClassify.SCENE;
            default: return AnalysisClassify.None;
        }
    }

    /**
     * 获取关键字（默认为20个）
     * @param text
     * @return
     */
    @Override
    public String getKeyWord(String text){
        List<String> keyword = HanLP.extractKeyword(text, 20);
        StringBuilder keys = new StringBuilder();
        for (String key : keyword) {
            keys.append(key + "|");
        }
        return keys.toString();
    }

    public AnalysisComments save(AnalysisComments analysisComments){
        return analysisCommentsDao.save(analysisComments);
    }

    @Override
    public List<String> search(String[] likes, List<Integer> set) {
        StringBuilder sb = new StringBuilder();
        sb.append("select content ");
        sb.append("from video_comments ");
        sb.append("where sub_vid in (");
        int batchReloadedSize =0;
        for (Integer integer : set) {
            if(batchReloadedSize > 0) {
                sb.append(',');
            }
            sb.append(integer);
            ++batchReloadedSize;
        }
        sb.append(")");
        sb.append("and content like ");
        int likeSize =0;
        for (String like : likes) {
            if(likeSize > 0) {
                sb.append("or content like");
            }
            sb.append("'%" + like +"%'");
            ++likeSize;
        }
        Query query = this.entityManager.createNativeQuery(sb.toString());
        return query.getResultList();
    }

    @Override
    public String getKeyWordByNum(String text,int num){
        List<String> keyword = HanLP.extractKeyword(text, num);
        StringBuilder keys = new StringBuilder();
        for (String key : keyword) {
            keys.append(key + "|");
        }
        return keys.toString();
    }

    public TreeMap<String, Integer> getKeyWord(List<String> contexts){
        TreeMap<String, Integer> keywordMap = new TreeMap<String, Integer>();
        for (String s : contexts) {
            List<String> keywords = HanLP.extractKeyword(s, 10);
            for (String string : keywords) {
                if(keywordMap.containsKey(string)){
                    int value = keywordMap.containsKey(string) ? keywordMap.get(string) : 0;
                    keywordMap.put(string,value + 1);
                }else {
                    keywordMap.put(string,1);
                }
            }
        }
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(keywordMap.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        TreeMap<String, Integer> result = new TreeMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            result.put(entry.getKey(),entry.getValue());
        }
        return result;
    }

    public Map<String, Integer> runThread(List<String> context, String name){
        Map<String, Integer> resultMap = null;
        SemanticMaster semanticMaster = null;
        int re = 0;
        try {
            semanticMaster = new SemanticMaster(context, name);
            semanticMaster.execute();
            Map<String, Integer> resultMaps = semanticMaster.getResultMap();
            while (resultMaps.size()>0|| !semanticMaster.isComplete()){
                Integer p = resultMaps.get("p");
                resultMap.put("p",p);
                re += p;
            }
            System.out.println(resultMap.get("p"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resultMap;
    }
}
