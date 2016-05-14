package cn.guoduo.test;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.stopword.CoreStopWordDictionary;
import com.hankcs.hanlp.seg.common.Term;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @athor Lijian
 * @date 2016年04月21日
 */
public class SinaCollect {
    public static void main(String[] args) throws IOException {
        getContext(20);
    }

    public static void getContext(int i) throws IOException {
        FileWriter fw = new FileWriter("E:/dic/weibo");
        for (int j = 1; j < i + 1; j++) {
            Document parse = Jsoup.parse(new File("E:\\htnl\\"+j+".htm"), "utf-8");
            Elements elementsByClass = parse.getElementsByClass("WB_feed_v3").select("div.WB_feed_detail");
            String p = "<a .+?>[\\s\\S]+?</a>";
            String br = "<br />";
            for (Element context : elementsByClass) {
                Elements con = context.getElementsByClass("WB_text");
                String title = con.select("img").attr("title");
                con.select("img").remove();
                String fp = con.html().toString().replaceAll(p, "");
                String fbr = fp.replaceAll(br, "");
//                String text = "";
//                List<Term> seg = HanLP.newSegment().seg(fbr);
//                for (Term term : seg) {
//                    if (shouldInclude(term)){
//                        text = text + " " + term.word;
//                    }
//                }
                fw.write(fbr + " " + title+"\n");
            }
        }
        fw.close();
    }

    private static boolean shouldInclude(Term term) {
        if (term.nature == null) return false;
        String nature = term.nature.toString();
        char firstChar = nature.charAt(0);
        switch (firstChar)
        {
            case 'm':
            case 'b':
            case 'c':
            case 'e':
            case 'o':
            case 'p':
            case 'q':
            case 'u':
            case 'y':
            case 'z':
            case 'r':
            case 'w':
            {
                return false;
            }
            default:
            {
                if (term.word.trim().length() > 1 && !CoreStopWordDictionary.contains(term.word))
                {
                    return true;
                }
            }
            break;
        }
        return false;
    }
}
