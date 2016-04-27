package com.chl.nbcluster.core.algotithm;

import java.util.ArrayList;
import java.util.List;

import com.chl.nbcluster.utils.Util;

/**
 * @author Hanlin
 *
 */
public class ClusterCore {

	private List<Double[]> point;
	private List<Integer> center;
	private List<Integer> jinx;

	public ClusterCore(List<Double[]> point, List<Integer> center, List<Integer> jinx) {
		super();
		this.point = point;
		this.center = center;
		this.jinx = jinx;
		
		for (int i : center) 
			jinx.remove(i);
	}

	public List<Object> getCore() {
		List<Object> core = new ArrayList<>();

		for (Integer c : center) {
			List<Integer> temp = Util.Search(jinx, c);
			if (!temp.isEmpty()) {
				for(Integer c_t: temp){
					
				}
			}
		}

		return core;
	}

}
