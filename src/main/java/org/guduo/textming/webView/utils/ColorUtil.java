package org.guduo.textming.webView.utils;

/**
 * @athor Lijian
 * @date 2016年04月23日
 */
public class ColorUtil {

    public static String getColor(){
        StringBuffer sb = new StringBuffer();
        int rand1 = (int) (200 + Math.random() * (255-200+1));
        int rand2 = (int) (100 + Math.random() * (255-100+1));
        int rand3 = (int) (0 + Math.random() * (255-0+1));
        sb.append("rgb("+rand1+",");
        sb.append(rand2+",");
        sb.append(rand3+")");
        return sb.toString();
    }
}
