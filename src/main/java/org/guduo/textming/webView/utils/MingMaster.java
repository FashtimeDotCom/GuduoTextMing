package org.guduo.textming.webView.utils;

import org.omg.PortableInterceptor.ObjectReferenceFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @athor Lijian
 * @date 2016年05月10日
 */
public class MingMaster {
    protected Queue<Object> workQueue = new ConcurrentLinkedDeque<Object>();
    protected Map<String,Thread> threadMap = new HashMap<String,Thread>();
    protected Map<String ,Object> resultMap = new ConcurrentHashMap<String,Object>();

    public boolean isComplete(){
        for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
            if (entry.getValue().getState() == Thread.State.TERMINATED){
                return false;
            }
        }
        return true;
    }

    public MingMaster(Work work,int workThread){
        work.setWorkQueue(workQueue);
        work.setResultMap(resultMap);
        for (int i = 0; i < workThread; i++) {
                threadMap.put(Integer.toString(i),new Thread(work,Integer.toString(i)));
        }
    }

    public void submit(Object job){
        workQueue.add(job);
    }

    public Map<String,Object> getResultMap(){
        return resultMap;
    }

    public void execute(){
        for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
            entry.getValue().start();
        }
    }
}
