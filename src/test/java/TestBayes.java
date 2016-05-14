import org.guduo.textming.algorithm.bayes.BayesClassifier;

/**
 * @athor Lijian
 * @date 2016年04月27日
 */
public class TestBayes {
    public static void main(String[] args) {
        BayesClassifier bayesClassifier = new BayesClassifier();
        String text = "谭松韵给人一步一个脚印的感觉 不管是什么原因 戏好看才重要 而不是谁火谁上";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            String result = bayesClassifier.classify(text);
            System.out.println("此项属于["+result+"]");
        }
    }
}
