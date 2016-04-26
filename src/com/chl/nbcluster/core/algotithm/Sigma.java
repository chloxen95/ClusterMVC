package com.chl.nbcluster.core.algotithm;

import java.util.ArrayList;
import java.util.List;

import com.chl.nbcluster.utils.UtilMethod;

/**
 * ����ÿ������ �����ľֲ��ܶȸ���ĵ� �ľ��� ����Сֵ <code>sigma</code>
 * 
 * @author Hanlin
 *
 */
public class Sigma {

	/**
	 * ���ݼ�
	 */
	private List<Double[]> dataset;
	/**
	 * �ֲ��ܶȼ�
	 */
	private List<Integer> rho;

	public void setDataset(List<Double[]> dataset) {
		this.dataset = dataset;
	}

	public void setRho(List<Integer> rho) {
		this.rho = rho;
	}

	/**
	 * <code>sigma</code> ��Ĺ��췽��
	 * 
	 * @param dataset
	 *            ���ݼ�
	 * @param rho
	 *            �ֲ��ܶ�
	 */
	public Sigma(List<Double[]> dataset, List<Integer> rho) {
		super();
		this.dataset = dataset;
		this.rho = rho;
	}

	/**
	 * ���� <code>sigma</code>
	 * 
	 * @return <code>sigma</code>
	 */
	public List<Double> getSigma() {
		List<Double> sigma = new ArrayList<>();
		int total = dataset.size();

		for (int i = 0; i < total; i++) {
			Double sigma_temp = Double.MAX_VALUE;
			for (int j = 0; j < total; j++) {
				double dij = UtilMethod.PointDistance(dataset.get(i), dataset.get(j));
				if ((rho.get(j) > rho.get(i))
						// �� --- �ж� j �ľֲ��ܶ��Ƿ���� j
						&&
						// �� --- �ж���������Ƿ��С
						(dij < sigma_temp))
					sigma_temp = dij;
			}

			if (sigma_temp == Double.MAX_VALUE) {
				for (Double[] point : dataset) {
					sigma_temp = 0.0;
					double dij = UtilMethod.PointDistance(dataset.get(i), point);
					sigma_temp = dij > sigma_temp ? dij : sigma_temp;
				}
			}

			sigma.add(sigma_temp);
		}

		return sigma;
	}

}