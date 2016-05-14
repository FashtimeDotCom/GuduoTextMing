package org.guduo.textming.webAction;

import com.alibaba.fastjson.JSONObject;
import org.guduo.textming.webAction.Entry.Constant;
import org.guduo.textming.webAction.Web.BaseWebAction;

import java.util.TreeMap;

/**
 * @athor Lijian
 * @date 2016年04月21日
 */
public class Action {
    public static void main(String[] args) {
        TreeMap<String, Object> params = new TreeMap<String, Object>();
        params.put("SecretId", Constant.SecretId);
        params.put("SecretKey", Constant.SecretKey);
        params.put("title", 0);
        params.put("limit", 3);
    }
}
