package com.chl.nbcluster.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * �ӱ��ػ�ȡ����
 * @author Hanlin
 *
 */
public class DataLoader {
	
	/**
	 * �����ļ�·��
	 */
	private String path;
	
	/**
	 * ���ݻ�ȡ�Ĺ��췽��
	 * @param path �����ļ�·��
	 */
	public DataLoader(String path) {
		this.path = path;
	}
	
	/**
	 * ��ȡ����
	 * @return ���ݼ�
	 */
	public  List<Double[]> LoadData() {
		File file = new File(path);
		BufferedReader reader = null;
		List<Double[]> array = new ArrayList<>();

		try {
			reader = new BufferedReader(new FileReader(file));
			String temp_str = reader.readLine();

			while ((temp_str != null)) {
				String[] temp = temp_str.split(",");
				Double[] temp1 = {Double.parseDouble(temp[0]), Double.parseDouble(temp[1])};
				array.add(temp1);
				temp_str = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}

		return array;
	}
}
