package com.chl.nbcluster.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 炒鸡有用的工具类
 * 
 * @author Hanlin
 *
 */
public class Util {

	/**
	 * 计算欧式距离
	 * 
	 * @param i 第一个点坐标
	 * @param j 第二个点坐标
	 * @return 欧式距离
	 */
	public static Double PointDistance(double[] i, double[] j) {
		return Math.sqrt((i[0] - j[0]) * (i[0] - j[0]) + (i[1] - j[1]) * (i[1] - j[1]));
	}

	/**
	 * 计算欧式距离
	 * 
	 * @param i 第一个点坐标
	 * @param j 第二个点坐标
	 * @return 欧式距离
	 */
	public static Double PointDistance(Double[] i, Double[] j) {
		return Math.sqrt((i[0] - j[0]) * (i[0] - j[0]) + (i[1] - j[1]) * (i[1] - j[1]));
	}

	/**
	 * 计算数组列表的平均值
	 * 
	 * @param number 数组列表
	 * @return 平均值
	 */
	public static Double AverageDouble(List<Double> number) {
		Double result = 0.0;
		for (Double i : number)
			result += i;
		return result / number.size();
	}

	/**
	 * 计算数组列表中指定序号所对应数的平均值
	 * 
	 * @param number 数组列表
	 * @param index 指定序号列表
	 * @return 平均值
	 */
	public static Double AverageDouble(List<Double> number, List<Integer> index) {
		Double result = 0.0;
		Integer size = index.size();
		for (Integer i : index)
			result += number.get(i);
		return result / size;
	}

	/**
	 * 计算数组列表的平均值
	 * 
	 * @param number 数组列表
	 * @return 平均值
	 */
	public static Double AverageInt(List<Integer> number) {
		Double result = 0.0;
		for (Integer i : number)
			result += i;
		return result / number.size();
	}

	/**
	 * 计算数组列表中指定序号所对应数的平均值
	 * 
	 * @param number 数组列表
	 * @param index 指定序号列表
	 * @return 平均值
	 */
	public static Double AverageInt(List<Integer> number, List<Integer> index) {
		Double result = 0.0;
		Integer size = index.size();
		for (Integer i : index)
			result += number.get(i);
		return result / size;
	}

	/**
	 * 获取数组中最大值的序号 <code>index</code>
	 * 
	 * @param list 数组
	 * @return 最大值序号
	 */
	public static Integer getMax(List<Double> list) {
		Integer index = -1;
		Double temp = -Double.MAX_VALUE;

		for (Integer i = 0; i < list.size(); i++) {
			if (list.get(i) > temp) {
				temp = list.get(i);
				index = i;
			}
		}

		return index;
	}
	
	/**
	 * 获取数组中最大值的序号 <code>index</code>
	 * 
	 * @param list 数组
	 * @return 最大值序号
	 */
	public static Integer getMaxInt(List<Integer> list) {
		Integer index = -1;
		Integer temp = -Integer.MAX_VALUE;

		for (Integer i = 0; i < list.size(); i++) {
			if (list.get(i) > temp) {
				temp = list.get(i);
				index = i;
			}
		}

		return index;
	}

	/**
	 * 在数组列表中搜索指定的值
	 * 
	 * @param list 数组列表
	 * @param t 指定的值
	 * @return 匹配的序号列表
	 */
	public static List<Integer> Search(List<Integer> list, Integer t) {
		List<Integer> result = new ArrayList<>();

		for (Integer i = 0; i < list.size(); i++) {
			if (list.get(i) == t)
				result.add(i);
		}

		return result;
	}

	/**
	 * 降序排列
	 * @param list 目标列表
	 * @return 降序排列结果
	 */
	public static List<Integer> DecentSort(List<Integer> list) {
		List<Integer> result = new ArrayList<>();

		for (Integer i = 0; i < list.size(); i++) {
			Integer maxIndex = Util.getMaxInt(list);
			result.add(list.get(maxIndex));
			list.remove(maxIndex);
		}

		return result;
	}
}
