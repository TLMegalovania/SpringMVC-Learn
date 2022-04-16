package com.SpringExample.util;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class MyStringUtil extends StringUtils {
	
	public static Date getZero(Date date){
		Calendar c=Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		c.set(Calendar.MILLISECOND,0);
		return c.getTime();
	}

	public static Integer toInteger(String string) {
		try {
			return Integer.valueOf(string);
		} catch (Exception e) {
			return null;
		}
	}

	public static List<String> stringToList(String string) {
		List<String> list = new ArrayList<String>();

		if (!isEmpty(string)) {
			String[] array = string.split(",");

			for (String s : array)
				if (!isEmpty(s))
					list.add(s);
		}

		return list;
	}

	public static List<Integer> stringToIntList(String string, String splitChar) {
		List<Integer> list = new ArrayList<Integer>();

		if (!isEmpty(string)) {
			String[] array = string.split(splitChar);

			for (String s : array)
				if (!isEmpty(s))
					list.add(Integer.valueOf(s));
		}

		return list;
	}

	public static List<String> stringToStringList(String string, String splitChar) {
		List<String> list = new ArrayList<String>();

		if (!isEmpty(string)) {
			String[] array = string.split(splitChar);

			for (String s : array)
				if (!isEmpty(s))
					list.add(s);
		}

		return list;
	}

	public static String listToString(List<String> stringList, String splitChar) {
		if (stringList == null) {
			return null;
		}
		StringBuilder result = new StringBuilder();
		boolean flag = false;
		for (String string : stringList) {
			if (flag) {
				result.append(splitChar);
			} else {
				flag = true;
			}
			result.append(string);
		}
		return result.toString();
	}
	
	public static byte[] Encode(byte[] src) {
		byte[] encode2Bytes = new byte[src.length];
		if (src.length > 1) {
			for (int i = 0; i < src.length; i++) {
				encode2Bytes[i] = (byte) (src[i] ^ 0x75);
			}
		}
		return encode2Bytes;
	}

	/*
	public static String md5(String string) {
		final byte[] resultByte = DigestUtils.md5Digest(string.getBytes(Charset
				.forName("UTF8")));
		return Hex.encodeToString(resultByte);
	}
	*/

	/**
	 * 比较版本号的大小,前者大则返回一个正数,后者大返回一个负数,相等则返回0
	 * 
	 * @param version1
	 * @param version2
	 * @return
	 */
	public static int compareVersion(String version1, String version2)
			throws Exception {
		if (isEmpty(version1) || isEmpty(version2)) {
			throw new Exception("compareVersion error:illegal params.");
		}
		String[] versionArray1 = version1.trim().split("\\.");// 注意此处为正则匹配，不能用"."；
		String[] versionArray2 = version2.trim().split("\\.");
		int idx = 0;
		int minLength = Math.min(versionArray1.length, versionArray2.length);// 取最小长度值
		int diff = 0;
		while (idx < minLength
				&& (diff = versionArray1[idx].length()
						- versionArray2[idx].length()) == 0// 先比较长度
				&& (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {// 再比较字符
			++idx;
		}
		// 如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大；
		diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;
		return diff;
	}

	
}
