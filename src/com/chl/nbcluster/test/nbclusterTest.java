package com.chl.nbcluster.test;

import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.chl.nbcluster.core.algotithm.Rho;
import com.chl.nbcluster.core.algotithm.Sigma;
import com.chl.nbcluster.utils.DataLoader;
import com.chl.nbcluster.utils.RandomPoints;
import com.chl.nbcluster.utils.Util;

public class nbclusterTest {

	// ���߽߱�
	double dc = 0.25;

	// ʵ�ù���
	Util um;
	// ��������
	DataLoader dataLoader;
	List<Double[]> dataset;

	// ����ֲ��ܶ�
	Rho rhoData;
	List<Integer> rho;

	// �������ֲ��ܶȵ����Сֵ
	Sigma sigmaData;
	List<Double> sigma;

	@Before
	public void getParams() {
		// ��ȡ����
		dataLoader = new DataLoader("E:\\Cluster\\points.txt");
		dataset = dataLoader.LoadData();

		// ��ȡ Rho
		rhoData = new Rho(dc, dataset);
		rho = rhoData.getRho();
		System.out.println(rho.size());
		System.out.println(rho);

		// ��ȡ Sigma
		sigmaData = new Sigma(dataset, rho);
		sigma = sigmaData.getSigma();
		System.out.println(sigma.size());
		System.out.println(sigma);
	}

	@Test
	public void testParams() {
		 int total = dataset.size();
		
		 System.out.println("[");
		 for (int i = 0; i < total; i++) {
		 System.out.println("\t[" + rho.get(i) + "," + sigma.get(i) + "],");
		 }
		 System.out.println("]");
	}

	@Test
	public void testRandom() {
		Random random = new Random();

		int i = 0;
		while (i < 10) {
			System.out.println((double) (((int) (random.nextDouble() * 100))) / 10);
			i++;
		}
	}

	@Test
	public void testRandomPoint() {
		Double x1 = 15.0;
		Double x2 = 25.0;
		Double y1 = 15.0;
		Double y2 = 25.0;
		RandomPoints rp = new RandomPoints(100, x1, x2, y1, y2, 2);
		rp.getRandomPoints();

	}

}
