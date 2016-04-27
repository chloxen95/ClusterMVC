package com.chl.nbcluster.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface ParamGenerator {
		
	/**
	 * 生成随机点
	 * @param request 页面传入的参数
	 * @return 随机点数组
	 */
	public List<Double[]> GeneratePoints(HttpServletRequest request);
	
	/**
	 * 生成参数 <code>rho</code> 和 <code>sigma</code>
	 * @param point 点坐标
	 * @return 参数 <code>rho</code> 和 <code>sigma</code>
	 */
	public List<Object[]> GenerateParam(List<Double[]> point);
	
	/**
	 * 生成参数 <code>jIndex</code>
	 * @return 参数 <code>jIndex</code>
	 */
	public List<Integer> GenerateJIndex();
	
	/**
	 * 生成聚类中心点 index
	 * @return 聚类中心点 index
	 */
	public List<Integer> GenerateCenter();

}
