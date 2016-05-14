package org.guduo.textming.webView.Entry;

import javax.persistence.*;
import java.sql.Date;

/**
 * @athor Lijian
 * @date 2016年05月10日
 */
@Entity
@Table(name = "sub_video_task")
public class SubTask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sub_vid; //子任务ID
    private int vid; //任务ID
    private String page_url; //视频剧集链接
    private byte platform; //平台标识: tengxun; 1: youtu; 2: aqiyi; 3: letv; 4: sohu
    private String title; //标题
    private byte status;//状态: 初始; 1: 运行; 2: 完成; -1: 手动结束; -2: 异常结束
    private Date add_time;//添加时间
    private Date last_update_time;//最后更新时间

    public int getSub_vid() {
        return sub_vid;
    }

    public void setSub_vid(int sub_vid) {
        this.sub_vid = sub_vid;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getPage_url() {
        return page_url;
    }

    public void setPage_url(String page_url) {
        this.page_url = page_url;
    }

    public byte getPlatform() {
        return platform;
    }

    public void setPlatform(byte platform) {
        this.platform = platform;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Date getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }

    public Date getLast_update_time() {
        return last_update_time;
    }

    public void setLast_update_time(Date last_update_time) {
        this.last_update_time = last_update_time;
    }
}
