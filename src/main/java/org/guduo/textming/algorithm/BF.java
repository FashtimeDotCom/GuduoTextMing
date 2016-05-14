package org.guduo.textming.algorithm;

/**
 * @athor Lijian
 * @date 2016年04月22日
 */
public class BF {
/*
 * BF（Brute Force）算法思想：
 * 首先T[1]和P[1]比较，若相等，则再比较T[2]和P[2]，一直到P[M]为止；
 * 若T[1]和P[1]不等，则P向右移动一个字符的位置,再依次进行比较;
 * 如果存在k，1≤k≤N，且T[k+1…k+M]=P[1…M]，则匹配成功,否则失败;
 * 该算法最坏情况下要进行 M*(N-M+1)次比较，时间复杂度为O(M*N)。
 *
 * 需求：用Java语言实现Brute Force算法
 *
 * 思路：
 * 1.将文本串和模式串转换为字符数组
 * 2.创建带参数传递的方法匹配文本串和模式串
 * 3.判断模式串在文本串出现的起始位置并返回
 */

    /**
     * 匹配字符串，找到字符串位置
     * @param c
     * @param cs
     * @param begin
     * @return
     */
    public static int match(char c, char [] cs, int begin){
        //先考虑最好的情况：如果字符匹配且到了字符串尾部则表示全部匹配
        if (cs[begin] == c && begin == cs.length-1) {
            return begin;
        }
        //如果字符匹配，但还未到字符串尾部，则字符串往后移一位
        else if (cs[begin] == c) {
            return begin+1;
        }
        //完全没有匹配
        else{
            return -1;
        }
    }

    /**
     * 匹配字符串，判断str2字符串在str1字符串中出现的位置并返回，没有匹配返回-1；
     * @param str1
     * @param str2
     * @return
     */
    public static int indexOf(String str1, String str2){
        char [] text = str1.toCharArray();
        char [] pattern = str2.toCharArray();
        int j = 0;
        for (int i = 0; i < text.length; i++) {
            int index = match(text[i], pattern, j);
            //满足则表示已经找到
            if (index == j){
                return i-j;
            }
            //表示找到一个字符，继续比较
            else if (index >= 0){
                j = index;
            }
            //没有找到就继续找
            else{
                j =0;
            }
        }
        return -1;
    }

    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) {
        int index2 = indexOf("i love algorithms,you know.", "algorithms");
        System.out.println(index2);
    }
}
