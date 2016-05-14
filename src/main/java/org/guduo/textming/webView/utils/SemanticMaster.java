package org.guduo.textming.webView.utils;

import com.hankcs.hanlp.utility.TextUtility;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.hankcs.hanlp.utility.Predefine.logger;

/**
 * @athor Lijian
 * @date 2016年05月14日
 */
public class SemanticMaster {
    protected Map<String ,Integer> resultMap = new ConcurrentHashMap<String,Integer>();

    public void setResultMap(Map<String, Integer> resultMap) {
        this.resultMap = resultMap;
    }

    public Map<String, Integer> getResultMap() {
        return resultMap;
    }

    int threadNum = 1;
    int number = 0;
    List<String> context;
    SemanticWorker[] threadArray = null;
    String name;

    public SemanticMaster(List<String> context,String name) throws InterruptedException {
        this.context = context;
        this.number = context.size();
        if (number < 5000){
            this.threadNum = 2;
        }else if (number < 10000){
            this.threadNum = 5;
        }else if(number < 20000){
            this.threadNum = 10;
        }else {
            this.threadNum = 30;
        }
        this.threadArray = new SemanticWorker[this.threadNum];
        this.name =name;
    }

    public boolean isComplete(){
        for (int i = 0; i < this.threadNum - 1; ++i) {
            if(threadArray[i].getState()== Thread.State.TERMINATED){
                return false;
            }
        }
        return true;
    }

    public void execute(){
        int per = number / threadNum;
        for (int i = 0; i < threadNum - 1; ++i) {
            int from = i * per;
            threadArray[i] = new SemanticWorker(context, from, from + per, name + "_sentiment");
            threadArray[i].setResultMap(resultMap);
            threadArray[i].start();
        }
        try {
            for (SemanticWorker thread : threadArray) {
                thread.join();
            }
        } catch (InterruptedException e) {
            logger.severe("线程同步异常：" + TextUtility.exceptionToString(e));
            System.out.println("线程同步异常：" + TextUtility.exceptionToString(e));
        }
    }
}
