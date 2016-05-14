package org.guduo.textming.webView.Controller;

import org.guduo.textming.webView.Entry.SubTask;
import org.guduo.textming.webView.Entry.WordCloud;
import org.guduo.textming.webView.Service.AnalysisService;
import org.guduo.textming.webView.Service.CommentsService;
import org.guduo.textming.webView.utils.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * @athor Lijian
 * @date 2016年04月22日
 */

@Controller
@RequestMapping("/sentiment")
public class SentimentController {

    @Autowired
    private CommentsService commentsService;
    @Autowired
    private AnalysisService analysisService;

    @ResponseBody
    @RequestMapping("/getinfo")
    public TreeMap<String, Object> getSentimentPercent(HttpServletRequest request, String text) {
        TreeMap<String, Object> map = new TreeMap<String, Object>();
        if (text != null) {
            ArrayList<WordCloud> tfSortList = TextUtil.getTFSortList(text);
            map.put("data", tfSortList);
        } else {
            map.put("error", "输入为空");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/getSemantics")
    public Map<String, Integer> getContexts(String teleplay, @RequestParam("likes[]") String[] likes,int set, String name) {
        Map<String, Integer> resultMap = null;
        List<String> context;
        ArrayList<Integer> sets = new ArrayList<>();
        for (int i = 1; i <= set; i++) {
            SubTask ta = commentsService.getSetOfComment(teleplay, i, false);
            sets.add(ta.getSub_vid());
        }
        if (likes==null||likes.length==0){
            context = commentsService.getContext(sets);
        }else {
            context = analysisService.search(likes, sets);
        }
        resultMap = analysisService.runThread(context,name);
        return resultMap;
    }

    @ResponseBody
    @RequestMapping("/m")
    public Map<String, Integer> getSemantics(HttpServletRequest request,int set, @RequestParam("likes[]") String[] likes, String name) throws UnsupportedEncodingException {
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        String teleplay = new String(request.getParameter("teleplay").getBytes("utf-8"), "utf-8");
        ArrayList<Integer> sets = new ArrayList<>();
        for (int i = 0; i<=set; i++) {
            SubTask ta = commentsService.getSetOfComment(teleplay, i, false);
            sets.add(ta.getSub_vid());
        }
        List<String> search = analysisService.search(likes, sets);
        return map;
    }

    @ResponseBody
    @RequestMapping("/getFiles")
    public TreeMap<String, Object> getFiles(){
        TreeMap<String, Object> map = new TreeMap<String, Object>();
        ArrayList<String> files = new ArrayList<>();
        String root = this.getClass().getClassLoader().getResource("/").getPath() + "excel/";
        System.out.println(root);
        File classDir = new File(root);
        String[] ret = classDir.list();
        for (int i = 0; i < ret.length; i++)
        {
            files.add(ret[i]);
        }
        for (String file : files) {
            System.out.println(file);
        }
        map.put("data",files);
        return map;
    }

    @RequestMapping("/semantic")
    public String semantic() {
        return "semantic";
    }

    @ResponseBody
    @RequestMapping("/getSemantic")
    public String getSemantic(String text) {
        return String.valueOf(analysisService.getSentiment(text));
    }

    @ResponseBody
    @RequestMapping("/getClassify")
    public String getClassify(String text) {
        return String.valueOf(analysisService.getClassify(text));
    }

    @RequestMapping("/download")
    public String download(String fileName, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        try {
            String path = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "excel";
            InputStream inputStream = new FileInputStream(new File(path + File.separator + fileName));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
