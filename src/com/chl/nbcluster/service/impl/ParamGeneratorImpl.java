package com.chl.nbcluster.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.chl.nbcluster.core.algotithm.Rho;
import com.chl.nbcluster.core.algotithm.Sigma;
import com.chl.nbcluster.service.ParamGenerator;
import com.chl.nbcluster.utils.RandomPoints;

public class ParamGeneratorImpl implements ParamGenerator {

	private Double dc;
	List<Double[]> list;
	Rho rhoData;
	Sigma sigmaData;

	public List<Double[]> GeneratePoints(HttpServletRequest request) {
		Double x1_upper = Double.parseDouble(request.getParameter("x1_upper"));
		Double x1_lower = Double.parseDouble(request.getParameter("x1_lower"));
		Double y1_upper = Double.parseDouble(request.getParameter("y1_upper"));
		Double y1_lower = Double.parseDouble(request.getParameter("y1_lower"));
		Double x2_upper = Double.parseDouble(request.getParameter("x2_upper"));
		Double x2_lower = Double.parseDouble(request.getParameter("x2_lower"));
		Double y2_upper = Double.parseDouble(request.getParameter("y2_upper"));
		Double y2_lower = Double.parseDouble(request.getParameter("y2_lower"));
		Integer number = Integer.parseInt(request.getParameter("num"));
		dc = Double.parseDouble(request.getParameter("dc"));

		RandomPoints rp1 = new RandomPoints(number, x1_lower, x1_upper, y1_lower, y1_upper);
		RandomPoints rp2 = new RandomPoints(number, x2_lower, x2_upper, y2_lower, y2_upper);
		List<Double[]> list1 = rp1.getRandomPoints();
		List<Double[]> list2 = rp2.getRandomPoints();
		list = new ArrayList<>();

		list.addAll(list1);
		list.addAll(list2);

		return list;
	}

	public List<Object[]> GenerateParam(List<Double[]> point) {
		int num = point.size();

		rhoData = new Rho(dc, point);
		List<Integer> rho = rhoData.getRho();
		sigmaData = new Sigma(point, rho);
		List<Double> sigma = sigmaData.getSigma();

		List<Object[]> param = new ArrayList<>();
		for (int i = 0; i < num; i++)
			param.add(new Object[] { rho.get(i), sigma.get(i)});

		return param;
	}
	
	public List<Integer> GenerateJIndex(){
		List<Integer> jIndex = sigmaData.getJIndex();
		System.out.println(jIndex);
		
		return jIndex;
	}

}
