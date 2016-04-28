package com.chl.nbcluster.core.algotithm;

import java.util.ArrayList;
import java.util.List;

import com.chl.nbcluster.utils.Util;

/**
 * �Զ�ѡ����߽߱� <code>dc</code> ��С
 * <p>
 * <li>���ڸþ����㷨ֻ�� <code>rho</code> ��ȡֵ���У����� <code>dc</code> ³����
 * �������ѡ���㷨��û��ʲô���ã���������������
 * 
 * @author Hanlin
 *
 */
@Deprecated
public class AutoDecision {

	private List<Double[]> point;
	private List<Integer> rho;
	private Integer x_upper;
	private Integer x_lower;
	private Integer y_upper;
	private Integer y_lower;
	private Double dc;

	private Double bound_area = 0.2;
	private Double x_halo;
	private Double y_halo;

	/**
	 * ���캯��
	 * 
	 * @param point
	 * @param x_upper
	 * @param x_lower
	 * @param y_upper
	 * @param y_lower
	 * @param dc
	 */
	public AutoDecision(List<Double[]> point, Integer x_upper, Integer x_lower, Integer y_upper, Integer y_lower,
			Double dc) {
		super();
		this.point = point;
		this.x_upper = x_upper;
		this.x_lower = x_lower;
		this.y_upper = y_upper;
		this.y_lower = y_lower;
		this.dc = dc;
	}

	/**
	 * �����޹ص�����귶Χ
	 * <p>
	 * <li>�޹ص���ָ������߽�һ����Χ <code>bound_area</code> �ڵĵ�
	 * 
	 * @param bound_area ����߽緶Χ
	 */
	public void setBound_area(Double bound_area) {
		this.bound_area = bound_area;
	}

	/**
	 * �Զ�ѡ����߽߱�
	 * <p>
	 * <li>��û�и��õı߽�ֵʱ������ԭֵ
	 * <p>
	 * <li>���㷨��δ��ɣ�����ûʲô����
	 * 
	 * @return
	 */
	public Double getDecision() {
		Double dc_temp = dc;
		setHalo();
		List<Integer> coreIndex = new ArrayList<>();

		for (Integer i = 0; i < point.size(); i++) {
			Double[] temp = point.get(i);
			if (!(Math.abs(temp[0] - x_upper) < x_halo || Math.abs(temp[0] - x_lower) < x_halo
					|| Math.abs(temp[1] - y_upper) < y_halo || Math.abs(temp[1] - y_lower) < y_halo))
				coreIndex.add(i);
		}

		Double average = Util.AverageInt(rho, coreIndex);
		if (average >= point.size() && average <= point.size()) {
			dc = dc_temp;
			return dc_temp;
		} else {
			dc -= 0.1;
			setRho();
			getDecision();
		}

		return dc;
	}

	private void setRho() {
		Rho rhoData = new Rho(dc, point);
		rho = rhoData.getRho();
	}

	private void setHalo() {
		x_halo = (x_upper - x_lower) * bound_area;
		y_halo = (y_upper - y_lower) * bound_area;
	}

}
