package com.chl.nbcluster.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface ParamGenerator {
		
	public List<Double[]> GeneratePoints(HttpServletRequest request);
	
	public List<Object[]> GenerateParam(List<Double[]> point);

}
