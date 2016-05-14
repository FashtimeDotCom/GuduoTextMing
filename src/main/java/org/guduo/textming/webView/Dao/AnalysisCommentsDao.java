package org.guduo.textming.webView.Dao;

import org.guduo.textming.webView.Entry.AnalysisComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @athor Lijian
 * @date 2016年05月10日
 */
@Component
public interface AnalysisCommentsDao extends JpaRepository<AnalysisComments,Integer> {
}
