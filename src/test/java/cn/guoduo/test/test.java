package cn.guoduo.test;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.seg.common.Term;
import org.guduo.textming.webView.Entry.WordCloud;
import org.guduo.textming.webView.utils.TextUtil;

import java.util.*;

/**
 * @athor Lijian
 * @date 2016年04月21日
 */
public class test {
    public static void main(String[] args) {
        HashMap<String, Object> rmap = new HashMap<String, Object>();
        String text = "这部剧要火，看完两集多了1000w 的收视率。人物个性鲜明，节奏轻快，演员演技都过关。王子文当年的齐齐一直印象深刻，刘涛和蒋欣也是霸气养眼。关关和蚯蚓很真实，虽然蚯蚓有点闹的感觉但是整体就很出彩";
        HanLP.segment(text);
    }
}
