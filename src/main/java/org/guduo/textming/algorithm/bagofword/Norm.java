package org.guduo.textming.algorithm.bagofword;

/**
 * Created by xljlx on 2016/4/20.
 */
public class Norm {
    public static void arrayNorm2(double[] array)
    {
        double sum;
        sum=0;
        for(int j=0;j<array.length;j++)
        {
            sum +=array[j]*array[j];
        }
        if(sum == 0) return;
        sum = Math.sqrt(sum);
        for(int j=0;j<array.length;j++)
        {
            array[j]/=sum;
        }

    }
    public static void tableNorm2(double[][] table)
    {
        double sum;
        for(int i=0;i<table.length;i++)
        {
            sum=0;
            for(int j=0;j<table[i].length;j++)
            {
                sum +=table[i][j]*table[i][j];
            }
            if(sum == 0) continue;
            sum = Math.sqrt(sum);
            for(int j=0;j<table[i].length;j++)
            {
                table[i][j]/=sum;
            }
        }
    }
}
