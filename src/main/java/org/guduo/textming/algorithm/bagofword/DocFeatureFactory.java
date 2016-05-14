package org.guduo.textming.algorithm.bagofword;

import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by xljlx on 2016/4/20.
 */
public class DocFeatureFactory {
    HashMap<String,Integer> word2Index;
    double[] feature;
    int dim;

    /**
     * 文本特征模型
     * @param w2i
     */
    public DocFeatureFactory(HashMap<String,Integer> w2i)
    {
        word2Index = w2i;
        dim = w2i.size();
    }

    /**
     * 获取文本特征
     * @param doc
     * @return
     */
    double[] getFeature(String doc)
    {
        feature = new double[dim];
        int wordNum=0;
        //while(wordNum<25)//这个作用跟规范化的一样啊
        //{
        StringTokenizer tokenizer=new StringTokenizer(doc," ");
        while(tokenizer.hasMoreElements())
        {
            wordNum++;
            String term =tokenizer.nextToken();
            Integer index = word2Index.get(term);
            if(index==null) continue;
            feature[index]++;
        }
        //}
        return feature;
    }
}
