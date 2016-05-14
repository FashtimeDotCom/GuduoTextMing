package org.guduo.textming.algorithm.Sentiment;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.dictionary.CoreDictionary;
import com.hankcs.hanlp.seg.common.Term;

import java.util.List;

public class SentimentAnalyze {
    private int[] resultArray = new int[]{0, 0, 0, 0, 0, 0, 0,0,0};
    private String[] strArray = new String[]{"", "", "", "", "", "", "","",""};
    public double getDat(String text) {
        List<Term> seg = HanLP.newSegment().seg(text);
        for (Term term : seg) {
            String word = term.word;
            if (SentimentDictionary.dat.containsKey(word)) {
                CoreDictionary.Attribute attribute = SentimentDictionary.dat.get(word);
                Nature[] nature = attribute.nature;
                String c = nature[0].toString();
                if (c.equals("PA") || c.equals("PE")) {
                    strArray[0] += word + ",";
                    resultArray[0]++;
                } else if (c.equals("PB") || c.equals("PD") || c.equals("PG") || c.equals("PH") || c.equals("PK")) {
                    strArray[1] += word + ",";
                    resultArray[1]++;
                } else if (c.equals("PT")) {
                    strArray[8] += word + ",";
                    resultArray[8]++;
                }else if (c.equals("NA")) {
                    strArray[2] += word + ",";
                    resultArray[2]++;
                } else if (c.equals("PF") || c.equals("NB") || c.equals("NH") || c.equals("NJ")) {
                    strArray[3] += word + ",";
                    resultArray[3]++;
                } else if (c.equals("NC") || c.equals("NG") || c.equals("NI")) {
                    strArray[4] += word + ",";
                    resultArray[4]++;
                } else if (c.equals("ND") || c.equals("NE") || c.equals("NK") || c.equals("NL") || c.equals("NN")) {
                    strArray[5] += word + ",";
                    resultArray[5]++;

                } else if (c.equals("PC")) {
                    strArray[6] += word + ",";
                    resultArray[6]++;
                }else if (c.equals("NT")){
                    strArray[7] += word + ",";
                    resultArray[7]++;
                }
            }
        }
        //情感正负计算公式A=happy*1,B=good*0.5,C=anger*0.5,D=sorrow*0.3,E=fear*0.7,F=evil*1,G=supprise*0.7;score=A+B-C-D-E-F+G
        double p = resultArray[0] + resultArray[1] * 0.6  + resultArray[6] * 0.7+resultArray[8] * 0.6;
        double n = resultArray[3] * 0.3 + resultArray[4] * 0.7 + resultArray[5]+ resultArray[2] * 0.6+resultArray[7] * 2.5;
        double pv = 0.5;
        if (p + n != 0){
            pv = (p / (p + n));
        }
        if (n == 0 && p != 0 && p < 1){
            pv = p;
        }
        if (pv >= 0.5) {
            return pv;
        } else {
            return -(1 - pv);
        }
    }
}