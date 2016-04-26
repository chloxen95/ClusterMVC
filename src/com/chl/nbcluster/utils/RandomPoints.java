package com.chl.nbcluster.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ���������������
 * 
 * @author Hanlin
 *
 */
public class RandomPoints {

	/**
	 * �����귶Χ
	 */
	private Double x1, x2, y1, y2;
	/**
	 * С���㱣��λ����Ĭ�ϱ�����λ
	 */
	private Integer r = 2;
	/**
	 * ��Ҫ���ɵ����Ŀ
	 */
	private Integer num;

	/**
	 * ��������깹����
	 * 
	 * @param num
	 *            ��Ҫ���ɵ����Ŀ
	 * @param x1
	 *            x�½�
	 * @param x2
	 *            x�Ͻ�
	 * @param y1
	 *            y�½�
	 * @param y2
	 *            y�Ͻ�
	 * @param r
	 *            С���㱣��λ��
	 */
	public RandomPoints(Integer num, Double x1, Double x2, Double y1, Double y2, Integer r) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.r = r;
		this.num = num;
	}

	/**
	 * ��������깹������С����Ĭ�ϱ�����λ ( <code>r = 2</code> )
	 * 
	 * @param num
	 *            ��Ҫ���ɵ����Ŀ
	 * @param x1
	 *            x�½�
	 * @param x2
	 *            x�Ͻ�
	 * @param y1
	 *            y�½�
	 * @param y2
	 *            y�Ͻ�
	 */
	public RandomPoints(Integer num, Double x1, Double x2, Double y1, Double y2) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.num = num;
	}

	/**
	 * ��������� 
	 * <p><li>���ڵ����⣺ 
	 * <p><li>	1. ��ĳ��ѭ�������ֻ��һ��������Ҫ��ʱ��������ͬʱ���� 
	 * <p><li>	2. ÿ���ж϶���������淶����ִ�У����ҹ淶�����̻�ռ�ý϶�ʱ�䣬���������������ϣ���ô���˷�̫��ʱ��
	 * <p><li>	3. ���Ը�Ϊ��̬����
	 * 
	 * @return �����
	 */
	public List<Double[]> getRandomPoints() {
		long startMili = System.currentTimeMillis();
		Random random = new Random();
		List<Double[]> point = new ArrayList<>();
		int i = 0, j = 0;
		while (point.size() < num) {
			// (double) (((int) (random.nextDouble() * 100))) / 10;

			/*
			 * (double) (((int) (random.nextDouble() * Math.pow(10,
			 * r+(int)Math.log10(x2)+1)))) / Math.pow(10, r);
			 */

			// ������淶��
			Double x = (double) ((int) (random.nextDouble() * Math.pow(10, r + (int) Math.log10(x2) + 1)))
					/ Math.pow(10, r);
			Double y = (double) ((int) (random.nextDouble() * Math.pow(10, r + (int) Math.log10(y2) + 1)))
					/ Math.pow(10, r);
			Double[] p = { x, y };
			j++;
			// System.out.println("Random Point " + j + " : [ " + x + " , " + y
			// +" ]");

			if (!(x < x2 && x > x1 && y < y2 && y > y1))
				continue;
			point.add(p);
			i++;
			System.out.println(" -------------------- Point " + i + " added : [ " + p[0] + " , " + p[1] + " ]");
			// System.out.println("" + p[0] + "," + p[1] + "");
		}
		long endMili = System.currentTimeMillis();
		long runingTime = endMili - startMili;
		System.out.println(" -------------------- Time: " + runingTime + " ms. Loop count: " + j + " times.");
		return point;

	}

}
