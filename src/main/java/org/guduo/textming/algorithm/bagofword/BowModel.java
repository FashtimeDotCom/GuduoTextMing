package org.guduo.textming.algorithm.bagofword;

import java.io.*;

/**
 * Created by xljlx on 2016/4/20.
 */
public class BowModel extends KnnCoreModel {
    Dict dict;
    DocFeatureFactory dff;

    public BowModel(String path) throws IOException
    {
        dict = new Dict();
        dict.loadFromLocalFile(path);
        dff = new DocFeatureFactory(dict.getWord2Index());
    }

    public double[] docFea(String doc)
    {
        return dff.getFeature(doc);
    }
    public double[][] generateFeature(String docsFile,int docNum) throws IOException
    {
        double[][] featureTable = new double[docNum][];
        int docIndex=0;
        File file = new File(docsFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
        while(true)
        {
            String line=br.readLine();
            if(line == null)
                break;
            featureTable[docIndex++] = dff.getFeature(line);
        }
        br.close();
        return featureTable;
    }
}
