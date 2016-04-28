package com.chl.nbcluster.core.algotithm;

import java.util.ArrayList;
import java.util.List;

import com.chl.nbcluster.utils.Util;

/**
 * 计算局部密度 <code>rho</code>
 * <p>
 * <li>算法介绍：计算指定点某邻域内其他点的数目
 * 
 * @author Hanlin
 *
 */
public class Rho {

	/**
	 * 邻域半径
	 */
	private Double dc;

	/**
	 * 数据集
	 */
	private List<Double[]> dataset;

	public void setDc(Double dc) {
		this.dc = dc;
	}

	public void setDataset(List<Double[]> dataset) {
		this.dataset = dataset;
	}

	/**
	 * 局部密度类的构造方法
	 * 
	 * @param dc 邻域半径
	 * @param dataset 数据集
	 */
	public Rho(Double dc, List<Double[]> dataset) {
		super();
		this.dc = dc;
		this.dataset = dataset;
	}

	/**
	 * 计算局部密度 <code>rho</code>
	 * 
	 * @return 局部密度 <code>rho</code>
	 */
	public List<Integer> getRho() {
		List<Integer> rho = new ArrayList<>();

		int rho_temp = 0;
		double dij = 0;
		for (Double[] i : dataset) {
			rho_temp = 0;

			for (Double[] j : dataset) {
				dij = Util.PointDistance(i, j);
				rho_temp += (dij - dc <= 0 ? 1 : 0);
			}

			rho.add(rho_temp - 1);
		}

		return rho;
	}

}
