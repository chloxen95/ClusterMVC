package com.chl.nbcluster.core.algotithm;

import java.util.ArrayList;
import java.util.List;

import com.chl.nbcluster.utils.Util;

/**
 * 获取聚类中心点
 * <p> 算法简介：<code>rho</code> 与 <code>sigma</code> 乘积最大的几个值为聚类中心
 * 
 * @author Hanlin
 *
 */
public class ClusterCenter {

	/**
	 * 参数 <code>rho</code>
	 */
	private List<Integer> rho;
	/**
	 * 参数 <code>sigma</code>
	 */
	private List<Double> sigma;

	/**
	 * <code>rho</code> 与 <code>sigma</code> 的乘积
	 */
	private List<Double> beta = new ArrayList<>();
	private Integer size = 0;

	/**
	 * 构造方法
	 * @param rho 参数 <code>rho</code>
	 * @param sigma 参数 <code>sigma</code>
	 */
	public ClusterCenter(List<Integer> rho, List<Double> sigma) {
		super();
		this.rho = rho;
		this.sigma = sigma;

		size = rho.size();
		for (Integer i = 0; i < size; i++)
			beta.add(rho.get(i) * sigma.get(i));
	}

	/**
	 * 获取聚类中心点的序号
	 * @param num 聚类中心点数量
	 * @return 序号
	 */
	public List<Integer> getCenter(Integer num) {
		List<Integer> centerIndex = new ArrayList<>();
		List<Double> beta_temp = beta;

		for (Integer i = 0; i < num; i++) {
			int temp = Util.getMax(beta_temp);
			centerIndex.add(temp);
			beta_temp.remove(temp);
		}

		return centerIndex;
	}

}
