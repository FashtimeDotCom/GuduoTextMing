package org.guduo.textming.webView.Entry;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * @athor Lijian
 * @date 2016年05月09日
 */
@Entity
@Table(name = "video_comments")
public class Comments implements Serializable {
    @Id
    @Column(name="comment_id")
    private String commentId;// PK
    @Column(name="vid")
    private Integer vid;// 视频任务ID
    @Column(name = "sub_vid")
    private Integer subVid;// 视频子任务ID
    @Column(name = "user_id")
    private String userId;// 用户ID
    @Column(name = "user_name")
    private String userName;// 用户名
    @Column(name = "publish_time")
    private Date publishTime;// 发布时间
    @Column(name = "up_count")
    private Integer upCount;// 顶
    @Column(name = "down_count")
    private Integer downCount;// 踩
    @Column(name = "re_count")
    private Integer reCount;// 回复数
    @Column(name = "type")
    private byte type;// 类型 0:短评; 1: ⻓长评
    @Column(name = "content")
    private String content;// 评论内

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public Integer getSubVid() {
        return subVid;
    }

    public void setSubVid(Integer subVid) {
        this.subVid = subVid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getUpCount() {
        return upCount;
    }

    public void setUpCount(Integer upCount) {
        this.upCount = upCount;
    }

    public Integer getDownCount() {
        return downCount;
    }

    public void setDownCount(Integer downCount) {
        this.downCount = downCount;
    }

    public Integer getReCount() {
        return reCount;
    }

    public void setReCount(Integer reCount) {
        this.reCount = reCount;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
