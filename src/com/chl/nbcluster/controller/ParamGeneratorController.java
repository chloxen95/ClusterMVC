package com.chl.nbcluster.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chl.nbcluster.service.impl.ParamGeneratorImpl;

@Controller
@RequestMapping("/point")
public class ParamGeneratorController {

	@RequestMapping(value = "/generator", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> GeneratePointAndParam(HttpServletRequest request) {

		ParamGeneratorImpl pg = new ParamGeneratorImpl();
		List<Double[]> point = pg.GeneratePoints(request);
		List<Object[]> param = pg.GenerateParam(point);
		List<Integer> jIndex = pg.GenerateJIndex();

		Map<String, Object> map = new HashMap<>();
		map.put("point", point);
		map.put("param", param);
		map.put("jIndex", jIndex);

		return map;
	}

}
