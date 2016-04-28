package com.chl.nbcluster.core.algotithm;

import java.util.ArrayList;
import java.util.List;

import com.chl.nbcluster.utils.Util;

/**
 * @author Hanlin
 *
 */
public class ClusterClassify {

	private List<Double[]> point;
	private List<Integer> center;
	private List<Integer> jinx;

	public ClusterClassify(List<Double[]> point, List<Integer> center, List<Integer> jinx) {
		super();
		this.point = point;
		this.center = center;
		this.jinx = jinx;

		for (int i : center)
			jinx.remove(i);
	}

	public List<Object> getClassify() {
		List<Object> classify = new ArrayList<>();

		for (Integer c : center) {
			List<Integer> temp = Util.Search(jinx, c);
			if (!temp.isEmpty()) {
				for (Integer c_t : temp) {

				}
			}
		}

		return classify;
	}

}
