package com.baidu.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	public static String md5(String str, boolean zero) {
		MessageDigest messageDigest = null;
		try {
			// ����ʵ��ָ��ժҪ�㷨�� MessageDigest ����//���ֵ���Ըü��ܷ�ʽ
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
			return null;
		}
		// ʹ��ָ���� byte �����ժҪ���������£�Ȼ�����ժҪ���㡣
		byte[] resultByte = messageDigest.digest(str.getBytes());
		// ����StringBufferƴ��resultByte
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < resultByte.length; ++i) {
			// 0xFF �Ǽ����ʮ�����Ƶı�ʾ�� 0x���Ǵ���ʮ�����ƣ�A B C D E F
			// �ֱ����10 11 12 13 14 15 F����15 һ��F ����4λ�����ƣ�
			// ���Կ��� �� 8 4 2 1��
			int v = 0xFF & resultByte[i];
			// �жϳ���2λ����16���������Ƿ���0��ʾ
			if (v < 16 && zero)
				result.append("0");
			// ƴ�� && ��ʮ�����ƣ����� 16���޷���������ʽ����һ�������������ַ�����ʾ��ʽ��
			result.append(Integer.toHexString(v));
		}
		return result.toString();
	}

	    public static void main(String[] args) {
	        //Md5Hash��shiro��װ����ĸ�Ϊ���ܵ�MD5
	        String md5 = md5("yanglaogou", true);
	        System.out.println(md5);
	    }//������Ǽ��ܺ��123456��123456�Ǹ�Ҫ���ܵ��ַ��� ����ô���� Md5�������
	    //��¼�Ļ��Ͱ�����һͬ����֮��Ƚ� �ж��Ƿ���ȣ� ��Ҫ���� ���ŵ��� ��controller����һ��
	
}
