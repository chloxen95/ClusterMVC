package com.chl.nbcluster.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * �������õĹ�����
 * 
 * @author Hanlin
 *
 */
public class Util {

	/**
	 * ����ŷʽ����
	 * 
	 * @param i
	 *            ��һ��������
	 * @param j
	 *            �ڶ���������
	 * @return ŷʽ����
	 */
	public static Double PointDistance(double[] i, double[] j) {
		return Math.sqrt((i[0] - j[0]) * (i[0] - j[0]) + (i[1] - j[1]) * (i[1] - j[1]));
	}

	/**
	 * ����ŷʽ����
	 * 
	 * @param i
	 *            ��һ��������
	 * @param j
	 *            �ڶ���������
	 * @return ŷʽ����
	 */
	public static Double PointDistance(Double[] i, Double[] j) {
		return Math.sqrt((i[0] - j[0]) * (i[0] - j[0]) + (i[1] - j[1]) * (i[1] - j[1]));
	}

	/**
	 * ���������б��ƽ��ֵ
	 * 
	 * @param number
	 *            �����б�
	 * @return ƽ��ֵ
	 */
	public static Double AverageDouble(List<Double> number) {
		Double result = 0.0;
		for (Double i : number)
			result += i;
		return result / number.size();
	}

	/**
	 * ���������б���ָ���������Ӧ����ƽ��ֵ
	 * 
	 * @param number
	 *            �����б�
	 * @param index
	 *            ָ������б�
	 * @return ƽ��ֵ
	 */
	public static Double AverageDouble(List<Double> number, List<Integer> index) {
		Double result = 0.0;
		Integer size = index.size();
		for (Integer i : index)
			result += number.get(i);
		return result / size;
	}

	/**
	 * ���������б��ƽ��ֵ
	 * 
	 * @param number
	 *            �����б�
	 * @return ƽ��ֵ
	 */
	public static Double AverageInt(List<Integer> number) {
		Double result = 0.0;
		for (Integer i : number)
			result += i;
		return result / number.size();
	}

	/**
	 * ���������б���ָ���������Ӧ����ƽ��ֵ
	 * 
	 * @param number
	 *            �����б�
	 * @param index
	 *            ָ������б�
	 * @return ƽ��ֵ
	 */
	public static Double AverageInt(List<Integer> number, List<Integer> index) {
		Double result = 0.0;
		Integer size = index.size();
		for (Integer i : index)
			result += number.get(i);
		return result / size;
	}

	/**
	 * ��ȡ���������ֵ����� <code>index</code>
	 * @param list ����
	 * @return ���ֵ���
	 */
	public static Integer getMax(List<Double> list) {
		Integer index = -1;
		Double temp = -Double.MAX_VALUE;

		for (Integer i = 0; i < list.size(); i++) {
			if(list.get(i) > temp){
				temp = list.get(i);
				index = i;
			}
		}

		return index;
	}

}
