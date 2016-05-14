package org.guduo.textming.webView.Dao;

import org.guduo.textming.webView.Entry.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaPersistableEntityInformation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * @athor Lijian
 * @date 2016年05月09日
 */
@Component
public interface CommentsDao extends PagingAndSortingRepository<Comments, Integer>, JpaSpecificationExecutor<Comments> {

}
