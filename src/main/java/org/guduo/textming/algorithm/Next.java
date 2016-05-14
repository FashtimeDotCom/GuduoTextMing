package org.guduo.textming.algorithm;

/**
 * @athor Lijian
 * @date 2016年04月22日
 */
public class Next {

    private static int[] getNext(String pStr) {
        int len = pStr.length(), k = -1, j = 0;
        char[] p = new char[len + 1];
        System.arraycopy(pStr.toCharArray(), 0, p, 0, len);
        int[] next = new int[len + 1];
        next[0]= -1;
        while (j < len - 1) {
            if (k == -1 || p[j] == p[k]) {
                ++j;
                ++k;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        int[] ints = getNext("wfdtg");
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
