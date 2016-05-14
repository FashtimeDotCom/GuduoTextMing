package org.guduo.textming.algorithm.bayes;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

/**
 * 朴素贝叶斯分类器
 */
public class BayesClassifier
{
	private TrainingDataManager tdm;//训练集管理器
	private String trainnigDataPath;//训练集路径
	private static double zoomFactor = 10.0f;
	//public String[] Classes;
	/**
	 * 默认的构造器，初始化训练集
	 */
	public BayesClassifier()
	{
		if (tdm == null){
			tdm =new TrainingDataManager();
		}
	}

	/**
	 * 计算给定的文本属性向量X在给定的分类Cj中的类条件概率
	 * <code>ClassConditionalProbability</code>连乘值
	 * @param X 给定的文本属性向量
	 * @param Cj 给定的类别
	 * @return 分类条件概率连乘值，即<br>
	 */
	float calcProd(List<Term> X, String Cj)
	{
		float ret = 1.0F;
		// 类条件概率连乘
		for (Term term : X) {
			String Xi = term.word;
			//因为结果过小，因此在连乘之前放大10倍，这对最终结果并无影响，因为我们只是比较概率大小而已
			ret *=ClassConditionalProbability.calculatePxc(Xi, Cj)*zoomFactor;
		}
		// 再乘以先验概率
		ret *= PriorProbability.calculatePc(Cj);
		return ret;
	}
	/**
	 * 对给定的文本进行分类
	 * @param text 给定的文本
	 * @return 分类结果
	 */
	@SuppressWarnings("unchecked")
	public String classify(String text)
	{
		List<Term> terms = HanLP.newSegment().seg(text);
		String[] Classes = tdm.getTraningClassifications();//分类
		float probility = 0.0F;
		List<ClassifyResult> crs = new ArrayList<ClassifyResult>();//分类结果
		for (int i = 0; i <Classes.length; i++)
		{
			String Ci = Classes[i];//第i个分类
			probility = calcProd(terms, Ci);//计算给定的文本属性向量terms在给定的分类Ci中的分类条件概率
			//保存分类结果
			ClassifyResult cr = new ClassifyResult();
			cr.classification = Ci;//分类
			cr.probility = probility;//关键字在分类的条件概率
			crs.add(cr);
		}
		//对最后概率结果进行排序
		java.util.Collections.sort(crs,new Comparator()
		{
			public int compare(final Object o1, final Object o2)
			{
				final ClassifyResult m1 = (ClassifyResult) o1;
				final ClassifyResult m2 = (ClassifyResult) o2;
				final double ret = m1.probility - m2.probility;
				if(ret < 0){
					return 1;
				}else {
					return -1;
				}
			}
		});
		//返回概率最大的分类
		return crs.get(0).classification;
	}
}