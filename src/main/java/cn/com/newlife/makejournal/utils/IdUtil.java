package cn.com.newlife.makejournal.utils;

import java.util.UUID;

public class IdUtil {

	public static String getUUID() {
		return String.valueOf(UUID.randomUUID()).replaceAll("-", "");
	}

	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
		System.out.println(IdUtil.getUUID());
	}

}
