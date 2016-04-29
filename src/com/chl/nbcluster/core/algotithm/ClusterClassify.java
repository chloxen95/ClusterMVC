package com.chl.nbcluster.core.algotithm;

import java.util.ArrayList;
import java.util.List;

import com.chl.nbcluster.utils.Util;
import com.sun.glass.ui.Size;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

/**
 * ����ÿ����������
 * @author Hanlin
 *
 */
public class ClusterClassify {

	private List<Integer> rho;
	private List<Integer> center;
	private List<Integer> jinx;
	private List<Integer> decent;

	private List<Integer> classify = new ArrayList<>();

	/**
	 * ���췽��
	 * @param point
	 * @param center
	 * @param jinx
	 * @param decent
	 */
	public ClusterClassify(List<Integer> rho, List<Integer> center, List<Integer> jinx) {
		super();
		this.rho = rho;
		this.center = center;
		this.jinx = jinx;
		
		decent = Util.DecentSort(rho);

		int centerIndex = 1;
		for (Integer i = 0; i < rho.size(); i++) {
			if (!Util.Search(center, i).isEmpty()) {
				classify.add(centerIndex);
				centerIndex++;
			} else
				classify.add(-1);
		}
	}

	/**
	 * ����ÿ���������࣬
	 * <p> δ��ɣ��� <code>Classify()</code> ����
	 * @return ÿ�����������б�
	 */
	@Deprecated
	public List<Object> getClassify() {
		List<Object> classify = new ArrayList<>();

		for (Integer c : center) {
			List<Integer> nextLevel = Util.Search(jinx, c);
			if (!nextLevel.isEmpty()) {
				for (Integer c_t : nextLevel) {

				}
			}
		}

		return classify;
	}

	/**
	 * ����ÿ����������
	 * @return ÿ�����������б�
	 */
	public List<Integer> Classify() {
		for (Integer i = 0; i < rho.size(); i++) {
			Integer temp = decent.get(i);
			classify.set(temp, classify.get(jinx.get(temp)));
		}

		return classify;
	}

}
