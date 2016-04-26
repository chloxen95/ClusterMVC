package com.chl.nbcluster.core.algotithm;

import java.util.ArrayList;
import java.util.List;

import com.chl.nbcluster.utils.Util;

/**
 * 计算每个点与 比它的局部密度更大的点 的距离 的最小值 <code>sigma</code>
 * 
 * @author Hanlin
 *
 */
public class Sigma {

	/**
	 * 数据集
	 */
	private List<Double[]> dataset;
	/**
	 * 局部密度集
	 */
	private List<Integer> rho;
	/**
	 * 计算 Sigma(i) 时点 j 坐标的序号
	 */
	private List<Integer> jIndex = new ArrayList<>();
	
	public List<Integer> getJIndex(){
		return jIndex;
	}

	public void setDataset(List<Double[]> dataset) {
		this.dataset = dataset;
	}

	public void setRho(List<Integer> rho) {
		this.rho = rho;
	}

	/**
	 * <code>sigma</code> 类的构造方法
	 * 
	 * @param dataset
	 *            数据集
	 * @param rho
	 *            局部密度
	 */
	public Sigma(List<Double[]> dataset, List<Integer> rho) {
		super();
		this.dataset = dataset;
		this.rho = rho;
	}
	

	/**
	 * 计算 <code>sigma</code>
	 * 
	 * @return <code>sigma</code>
	 */
	public List<Double> getSigma() {
		List<Double> sigma = new ArrayList<>();
		int total = dataset.size();

		for (int i = 0; i < total; i++) {
			Double sigma_temp = Double.MAX_VALUE;
			int j_temp = -1;
			for (int j = 0; j < total; j++) {
				double dij = Util.PointDistance(dataset.get(i), dataset.get(j));
				if ((rho.get(j) > rho.get(i))
						// ↑ --- 判断 j 的局部密度是否大于 j
						&&
						// ↓ --- 判断两点距离是否更小
						(dij < sigma_temp)){
					sigma_temp = dij;
					j_temp = j;
				}
			}

			if (sigma_temp == Double.MAX_VALUE) {
				for (Double[] point : dataset) {
					sigma_temp = 0.0;
					double dij = Util.PointDistance(dataset.get(i), point);
					sigma_temp = dij > sigma_temp ? dij : sigma_temp;
				}
				jIndex.add(-1);
			} else {
				jIndex.add(j_temp);
			}
			
			sigma.add(sigma_temp);
		}

		return sigma;
	}

}
