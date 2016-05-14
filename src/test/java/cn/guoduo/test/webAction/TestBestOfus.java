package cn.guoduo.test.webAction;

import org.guduo.textming.algorithm.Sentiment.SentimentAnalyze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @athor Lijian
 * @date 2016年05月13日
 */
public class TestBestOfus {
    public static void main(String[] args) {
        SentimentAnalyze analyze = new SentimentAnalyze();
        HashMap<String, Integer> map = new HashMap<>();
        int total = 0;
        try {
            String encoding="UTF-8";
            File file=new File("C:/Users/xljlx/Desktop/best.txt");
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt;
                while((lineTxt = bufferedReader.readLine()) != null){
                    double dat = analyze.getDat(lineTxt);
                    Thread.sleep(5000);
                    System.out.println(lineTxt+":"+dat);
                    if (dat > 0){
                        int i = map.containsKey("p") ? map.get("p") + 1 : 1;
                        map.put("p",i);
                    }
                    total ++;
                }
                read.close();
                System.out.println((double)map.get("p")/total);
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }
}
