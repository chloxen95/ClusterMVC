package com.chl.nbcluster.utils;

import java.util.List;

/**
 * 炒鸡有用的工具类
 * 
 * @author Hanlin
 *
 */
public class UtilMethod {

	/**
	 * 计算欧式距离
	 * 
	 * @param i
	 *            第一个点坐标
	 * @param j
	 *            第二个点坐标
	 * @return 欧式距离
	 */
	public static Double PointDistance(double[] i, double[] j) {
		return Math.sqrt((i[0] - j[0]) * (i[0] - j[0]) + (i[1] - j[1]) * (i[1] - j[1]));
	}

	/**
	 * 计算欧式距离
	 * 
	 * @param i
	 *            第一个点坐标
	 * @param j
	 *            第二个点坐标
	 * @return 欧式距离
	 */
	public static Double PointDistance(Double[] i, Double[] j) {
		return Math.sqrt((i[0] - j[0]) * (i[0] - j[0]) + (i[1] - j[1]) * (i[1] - j[1]));
	}
	
	/**
	 * 计算数组列表的平均值
	 * @param number 数组列表
	 * @return 平均值
	 */
	public static Double AverageDouble(List<Double> number){
		Double result = 0.0;
		for(Double i: number)
			result += i;
		return result / number.size();
	}
	
	/**
	 * 计算数组列表中指定序号所对应数的平均值
	 * @param number 数组列表
	 * @param index 指定序号列表
	 * @return 平均值
	 */
	public static Double AverageDouble(List<Double> number, List<Integer> index) {
		Double result = 0.0;
		Integer size = index.size();
		for (Integer i :index)
			result += number.get(i);
		return result / size;
	}
	
	/**
	 * 计算数组列表的平均值
	 * @param number 数组列表
	 * @return 平均值
	 */
	public static Double AverageInt(List<Integer> number){
		Double result = 0.0;
		for(Integer i: number)
			result += i;
		return result / number.size();
	}

	/**
	 * 计算数组列表中指定序号所对应数的平均值
	 * @param number 数组列表
	 * @param index 指定序号列表
	 * @return 平均值
	 */
	public static Double AverageInt(List<Integer> number, List<Integer> index) {
		Double result = 0.0;
		Integer size = index.size();
		for (Integer i :index)
			result += number.get(i);
		return result / size;
	}

}
