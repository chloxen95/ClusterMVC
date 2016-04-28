package com.chl.nbcluster.core.algotithm;

import java.util.ArrayList;
import java.util.List;

import com.chl.nbcluster.utils.Util;

/**
 * ����ֲ��ܶ� <code>rho</code>
 * <p>
 * <li>�㷨���ܣ�����ָ����ĳ���������������Ŀ
 * 
 * @author Hanlin
 *
 */
public class Rho {

	/**
	 * ����뾶
	 */
	private Double dc;

	/**
	 * ���ݼ�
	 */
	private List<Double[]> dataset;

	public void setDc(Double dc) {
		this.dc = dc;
	}

	public void setDataset(List<Double[]> dataset) {
		this.dataset = dataset;
	}

	/**
	 * �ֲ��ܶ���Ĺ��췽��
	 * 
	 * @param dc ����뾶
	 * @param dataset ���ݼ�
	 */
	public Rho(Double dc, List<Double[]> dataset) {
		super();
		this.dc = dc;
		this.dataset = dataset;
	}

	/**
	 * ����ֲ��ܶ� <code>rho</code>
	 * 
	 * @return �ֲ��ܶ� <code>rho</code>
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
