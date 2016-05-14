package cn.guoduo.test;

import org.guduo.textming.algorithm.vec.Learn;
import org.guduo.textming.algorithm.vec.Word2VEC;
import org.guduo.textming.algorithm.vec.domain.WordEntry;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

/**
 * @athor Lijian
 * @date 2016年05月12日
 */
public class TestVec {
    public static void main(String[] args) throws IOException {
        Learn learn = new Learn();
        long start = System.currentTimeMillis();
        learn.learnFile(new File("E:/bag of word/all"));
        System.out.println("use time " + (System.currentTimeMillis() - start));
        learn.saveModel(new File("E:/bag of word/library/javaVector"));

        Word2VEC vec = new Word2VEC();
        vec.loadJavaModel("E:/bag of word/library/javaVector");
        System.out.println("京东" + "\t" + Arrays.toString(vec.getWordVector("京东")));
        Set<WordEntry> df = vec.distance("京东");
        for (WordEntry wordEntry : df) {
            System.out.println(wordEntry);
        }
    }
}
