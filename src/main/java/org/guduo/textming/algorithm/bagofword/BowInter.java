package org.guduo.textming.algorithm.bagofword;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;

import java.io.IOException;
import java.util.List;

/**
 * Created by xljlx on 2016/4/20.
 */
public class BowInter {

    public double getScore(String text) throws IOException {
        // TODO Auto-generated method stub
        BowModel bm = new BowModel("E:/dic/all");//all=good+bad
        double[][] good = bm.generateFeature("E:/dic/good",454);
        double[][] bad = bm.generateFeature("E:/dic/bad",337);
        bm.train(good,0,200,bad,0,200);//指定训练数据
        //bm.test(good, 200, 340, bad, 200, 314);//指定测试数据

        List<Term> seg = HanLP.newSegment().seg(text);
        StringBuffer sf = new StringBuffer();
        for (Term term : seg) {
            sf.append(term.word+" ");
        }
        //System.out.println(sf);
        double[] fea = bm.docFea(sf.toString());
        Norm.arrayNorm2(fea);
        double re = bm.predict(fea);
//        if(re<0)
//        {
//            //System.out.println("good:"+re);
//            return "good: "+String.valueOf(re);
//        }
//        else
//        {
//            //System.out.println("bad:"+re);
//            return "bad: "+String.valueOf(re);
//        }
        return re;
    }
}
