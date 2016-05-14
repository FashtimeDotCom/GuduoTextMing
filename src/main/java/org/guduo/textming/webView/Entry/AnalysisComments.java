package org.guduo.textming.webView.Entry;

import javax.persistence.*;

/**
 * @athor Lijian
 * @date 2016年05月10日
 */
@Entity
@Table(name = "analysis_comment")
public class AnalysisComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "sub_vid")
    private int subVid;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "up_count")
    private int upCount;
    @Column(name = "down_count")
    private int downCount;
    @Column(name = "type")
    private byte type;
    @Column(name = "context")
    private String context;
    @Column(name = "sentiment")
    private Double sentiment;
    @Column(name = "classify")
    private byte classify;
    @Column(name = "key_word")
    private String keyWord;

    public AnalysisComments() {
    }

    public AnalysisComments(Comments comments) {
        this.subVid = comments.getSubVid();
        this.userId = comments.getUserId();
        this.userName = comments.getUserName();
        this.upCount = comments.getUpCount();
        this.downCount = comments.getDownCount();
        this.type = comments.getType();
        this.context = comments.getContent();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubVid() {
        return subVid;
    }

    public void setSubVid(int subVid) {
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

    public int getUpCount() {
        return upCount;
    }

    public void setUpCount(int upCount) {
        this.upCount = upCount;
    }

    public int getDownCount() {
        return downCount;
    }

    public void setDownCount(int downCount) {
        this.downCount = downCount;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Double getSentiment() {
        return sentiment;
    }

    public void setSentiment(Double sentiment) {
        this.sentiment = sentiment;
    }

    public byte getClassify() {
        return classify;
    }

    public void setClassify(byte classify) {
        this.classify = classify;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
