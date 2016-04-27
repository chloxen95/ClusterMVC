package com.chl.nbcluster.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface ParamGenerator {
		
	/**
	 * ���������
	 * @param request ҳ�洫��Ĳ���
	 * @return ���������
	 */
	public List<Double[]> GeneratePoints(HttpServletRequest request);
	
	/**
	 * ���ɲ��� <code>rho</code> �� <code>sigma</code>
	 * @param point ������
	 * @return ���� <code>rho</code> �� <code>sigma</code>
	 */
	public List<Object[]> GenerateParam(List<Double[]> point);
	
	/**
	 * ���ɲ��� <code>jIndex</code>
	 * @return ���� <code>jIndex</code>
	 */
	public List<Integer> GenerateJIndex();
	
	/**
	 * ���ɾ������ĵ� index
	 * @return �������ĵ� index
	 */
	public List<Integer> GenerateCenter();

}
