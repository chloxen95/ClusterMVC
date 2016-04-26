package com.chl.nbcluster.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 随机点坐标生成器
 * 
 * @author Hanlin
 *
 */
public class RandomPoints {

	/**
	 * 点坐标范围
	 */
	private Double x1, x2, y1, y2;
	/**
	 * 小数点保留位数，默认保留两位
	 */
	private Integer r = 2;
	/**
	 * 需要生成点的数目
	 */
	private Integer num;

	/**
	 * 随机点坐标构造器
	 * 
	 * @param num
	 *            需要生成点的数目
	 * @param x1
	 *            x下界
	 * @param x2
	 *            x上界
	 * @param y1
	 *            y下界
	 * @param y2
	 *            y上界
	 * @param r
	 *            小数点保留位数
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
	 * 随机点坐标构造器，小数点默认保留两位 ( <code>r = 2</code> )
	 * 
	 * @param num
	 *            需要生成点的数目
	 * @param x1
	 *            x下界
	 * @param x2
	 *            x上界
	 * @param y1
	 *            y下界
	 * @param y2
	 *            y上界
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
	 * 生成随机点 
	 * <p><li>存在的问题： 
	 * <p><li>	1. 当某次循环结果中只有一个数符合要求时，两个数同时作废 
	 * <p><li>	2. 每次判断都在随机数规范化后执行，并且规范化过程会占用较多时间，如果这次随机结果作废，那么会浪费太多时间
	 * <p><li>	3. 可以改为静态方法
	 * 
	 * @return 随机点
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

			// 随机数规范化
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
