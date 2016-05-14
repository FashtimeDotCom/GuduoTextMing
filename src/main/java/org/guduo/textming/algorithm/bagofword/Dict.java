package org.guduo.textming.algorithm.bagofword;

import java.io.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.StringTokenizer;

/**
 * Created by xljlx on 2016/4/20.
 */
public class Dict {
    HashMap<String,Integer> word2Index =null;
    Hashtable<String,Integer> word2Count = null;
    void loadFromLocalFile(String path) throws IOException
    {
        word2Index = new HashMap<String,Integer>();
        word2Count = new Hashtable<String,Integer>();
        int index = 0;
        File file = new File(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
        while(true)
        {
            String line=br.readLine();
            if(line == null)
                break;
            StringTokenizer tokenizer=new StringTokenizer(line," ");
            while(tokenizer.hasMoreElements())
            {
                String term=tokenizer.nextToken();
                if(word2Count.containsKey(term))
                {
                    int freq=word2Count.get(term)+1;
                    word2Count.put(term, freq);
                }
                else
                {
                    word2Count.put(term, 1);
                    word2Index.put(term, index++);
                }
            }
        }
        br.close();
    }

    public HashMap<String,Integer> getWord2Index()
    {
        return word2Index;
    }

    public void print()
    {
        Iterator<Entry<String, Integer>> iter=word2Count.entrySet().iterator();
        while(iter.hasNext())
        {
            Entry<String,Integer> item=(Entry<String,Integer>)iter.next();
            if(item.getValue()>30)
                System.out.printf("%s,%d\n",item.getKey(),item.getValue());
        }
    }
    public static void main(String[] args) throws IOException
    {
        // TODO Auto-generated method stub
        Dict dict = new Dict();
        dict.loadFromLocalFile("E:/bag of word/all");
        dict.print();

    }
}
