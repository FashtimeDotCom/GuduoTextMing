package org.guduo.textming.webView.utils;

import java.util.Map;
import java.util.Queue;

/**
 * @athor Lijian
 * @date 2016年05月10日
 */
public class Work implements Runnable{

    protected Queue<Object> workQueue;
    protected Map<String ,Object> resultMap;

    public void setWorkQueue(Queue<Object> workQueue){
        this.workQueue= workQueue;
    }

    public void setResultMap(Map<String ,Object> resultMap){
        this.resultMap=resultMap;
    }

    public Object handle(Object job){
        return job;
    }

    @Override
    public void run() {
        while (true){
         Object job = workQueue.poll();
            if (job==null){
                break;
            }
            Object re = handle(job);
            resultMap.put(Integer.toString(job.hashCode()),re);
        }
    }
}
