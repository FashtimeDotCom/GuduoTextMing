package org.guduo.textming.webView.Service;

import org.guduo.textming.webView.Entry.Comments;
import org.guduo.textming.webView.Entry.SubTask;

import java.util.Collection;
import java.util.List;
import java.util.TreeMap;

/**
 * @athor Lijian
 * @date 2016年05月09日
 */
public interface CommentsService {
    List<String> getContext(List<Integer> set);
    public SubTask getSetOfComment(String teleplay, int set, boolean advance);
}
