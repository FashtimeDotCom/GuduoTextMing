package org.guduo.textming.algorithm.batch;

import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @athor Lijian
 * @date 2016年04月25日
 */
public class Batch {
    static ArrayList<Term> list = new ArrayList<Term>();

    public static void main(String[] args) {
        BatchReader batchReader = new BatchReader();
        Thread thread = new Thread(batchReader);
        thread.start();
    }

    static class BatchReader implements Runnable{
        Segment defaultSegment = StandardTokenizer.SEGMENT;
        @Override
        public void run() {
            try {
                File file = new File("E:/dic/weibo");//Text文件
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = "";
                int i = 0;
                while ((line=br.readLine()) != null){
                    List<Term> seg = defaultSegment.seg(line);
                    list.addAll(seg);
                    System.out.println(seg.size());
                    System.out.println("list: " + list.size());
                }
                br.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
