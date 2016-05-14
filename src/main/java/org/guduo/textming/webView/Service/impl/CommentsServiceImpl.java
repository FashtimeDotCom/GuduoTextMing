package org.guduo.textming.webView.Service.impl;

import org.guduo.textming.webView.Dao.CommentsDao;
import org.guduo.textming.webView.Dao.SubTaskDao;
import org.guduo.textming.webView.Entry.Comments;
import org.guduo.textming.webView.Entry.SubTask;
import org.guduo.textming.webView.Service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

/**
 * @athor Lijian
 * @date 2016年05月09日
 */
@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsDao commentsDao;
    @Autowired
    private SubTaskDao subTaskDao;

    @PersistenceContext(name = "jpa")
    private EntityManager entityManager;

    public SubTask getSetOfComment(String teleplay,int set,boolean advance){
        StringBuffer telName = new StringBuffer();
        telName.append(teleplay);
        telName.append("第"+String.valueOf(set)+"集");
        if (advance){
            telName.append("预告");
        }
        return subTaskDao.findOneBytitleLike(telName.toString());
    }

    @Override
    public List<String> getContext(List<Integer> set) {
        StringBuilder sb = new StringBuilder();
        sb.append("select content ");
        sb.append("from video_comments ");
        sb.append("where sub_vid in (");
        int batchReloadedSize =0;
        for (Integer integer : set) {
            if(batchReloadedSize > 0) {
                sb.append(',');
            }
            sb.append(integer);
            ++batchReloadedSize;
        }
        sb.append(")");
        Query query = this.entityManager.createNativeQuery(sb.toString());
        return query.getResultList();
    }
}
