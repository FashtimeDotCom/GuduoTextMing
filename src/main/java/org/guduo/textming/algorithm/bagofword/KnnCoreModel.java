package org.guduo.textming.algorithm.bagofword;

/**
 * Created by xljlx on 2016/4/20.
 */
public class KnnCoreModel {
    double[] good_standard ;
    double[] bad_standard ;
    public void train(double[][] good,int train_good_start,int train_good_end,
                      double[][] bad,int train_bad_start,int train_bad_end){
        //double[][] good = generateFeature("/media/linger/G/sources/comment/test/good",340);
        //double[][] bad = generateFeature("/media/linger/G/sources/comment/test/bad",314);

        //double[] arv = new double[good[0].length];
        //double[] var = new double[good[0].length];

        //2范式归一化
        Norm.tableNorm2(good);
        Norm.tableNorm2(bad);
        good_standard = new double[good[0].length];
        bad_standard = new double[bad[0].length];
        for(int i=train_good_start;i<train_good_end;i++)
        {
            for(int j=0;j<good[i].length;j++)
            {
                good_standard[j]+=good[i][j];
            }
        }

        //System.out.println("\ngood core:");
        for(int j=0;j<good_standard.length;j++)
        {
            good_standard[j]/=(train_good_end-train_good_start);
            //System.out.printf("%f,",good_standard[j]);

        }

        for(int i=train_bad_start;i<train_bad_end;i++)
        {
            for(int j=0;j<bad[i].length;j++)
            {
                bad_standard[j]+=bad[i][j];
            }
        }
        //System.out.println("\nbad core:");
        for(int j=0;j<bad_standard.length;j++)
        {
            bad_standard[j]/=(train_bad_end-train_bad_start);
            //System.out.printf("%f,",bad_standard[j]);
        }
    }

    public void test(double[][] good,int test_good_start,int test_good_end,
                     double[][] bad,int test_bad_start,int test_bad_end)
    {
        Norm.tableNorm2(good);
        Norm.tableNorm2(bad);
        int error=0;
        double good_dis;
        double bad_dis;
        //test
        for(int i=test_good_start;i<test_good_end;i++)
        {
            good_dis= distance(good[i],good_standard);
            bad_dis = distance(good[i],bad_standard);
            //good_dis= allDistance(good[i],good,train_good_start,train_good_end);
            //bad_dis = allDistance(good[i],bad,train_bad_start,train_bad_end);
            double dis= good_dis-bad_dis;
            if(dis>0)
            {
                error++;
                System.out.println("-:"+(dis));
            }
            else
            {
                System.out.println("+:"+(dis));
            }
        }

        for(int i=test_bad_start;i<test_bad_end;i++)
        {
            good_dis= distance(bad[i],good_standard);
            bad_dis = distance(bad[i],bad_standard);
            //good_dis= allDistance(bad[i],good,train_good_start,train_good_end);
            //bad_dis = allDistance(bad[i],bad,train_bad_start,train_bad_end);
            double dis= good_dis-bad_dis;
            if(dis>0)
            {

                System.out.println("+:"+(dis));
            }
            else
            {
                error++;
                System.out.println("-:"+(dis));
            }
        }

        int count = (test_good_end-test_good_start+test_bad_end-test_bad_start);
        System.out.println("\nerror:"+error+",total:"+count);
        System.out.println("error rate:"+(double)error/count);
        System.out.println("acc rate:"+(double)(count-error)/count);
    }

    public double predict(double[] fea)
    {
        double good_dis = distance(fea,good_standard);
        double bad_dis = distance(fea,bad_standard);
        return good_dis-bad_dis;
    }

    private double distance(double[] src,double[] dst)
    {
        double sum=0;
        if(src.length!=dst.length)
        {
            System.out.println("size not right!");
            return sum;
        }
        for(int i=0;i<src.length;i++)
        {
            sum+=(dst[i]-src[i])*(dst[i]-src[i]);
        }
        //return Math.sqrt(sum);
        return sum;
    }
    private  double allDistance(double[]src,double[][] trainSet,int start,int end)
    {
        double sum=0;
        for(int i=start;i<end && i<trainSet.length;i++)
        {
            sum+=distance(src,trainSet[i]);
        }
        return sum;
    }
}
