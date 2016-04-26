package com.chl.nbcluster.core.algotithm;

import java.util.ArrayList;
import java.util.List;

import com.chl.nbcluster.utils.Util;

/**
 * ��ȡ�������ĵ�
 * <p> �㷨��飺<code>rho</code> �� <code>sigma</code> �˻����ļ���ֵΪ��������
 * 
 * @author Hanlin
 *
 */
public class ClusterCenter {

	/**
	 * ���� <code>rho</code>
	 */
	private List<Integer> rho;
	/**
	 * ���� <code>sigma</code>
	 */
	private List<Double> sigma;

	/**
	 * <code>rho</code> �� <code>sigma</code> �ĳ˻�
	 */
	private List<Double> beta = new ArrayList<>();
	private Integer size = 0;

	/**
	 * ���췽��
	 * @param rho ���� <code>rho</code>
	 * @param sigma ���� <code>sigma</code>
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
	 * ��ȡ�������ĵ�����
	 * @param num �������ĵ�����
	 * @return ���
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
