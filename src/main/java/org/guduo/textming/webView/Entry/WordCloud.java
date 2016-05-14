package org.guduo.textming.webView.Entry;

import java.util.List;
import java.util.Map;

/**
 * @athor Lijian
 * @date 2016年04月23日
 */
public class WordCloud {
    private String name;
    private Integer value;
    private Map<String,Object> itemStyle;

    public WordCloud(String name, Integer value, Map<String,Object> itemStyle) {
        this.name = name;
        this.value = value;
        this.itemStyle = itemStyle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Map<String,Object> getItemStyle() {
        return itemStyle;
    }

    public void setItemStyle(Map<String,Object> itemStyle) {
        this.itemStyle = itemStyle;
    }
}
