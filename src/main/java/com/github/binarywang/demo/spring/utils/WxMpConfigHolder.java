package com.github.binarywang.demo.spring.utils;

import java.util.Hashtable;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;

public class WxMpConfigHolder {

	private static final Hashtable<String, WxMpInMemoryConfigStorage> configs = new Hashtable<>();
	static{
		final WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
	    config.setAppId("");// 设置微信公众号的appid
	    config.setSecret("");// 设置微信公众号的app corpSecret
	    config.setToken("token");// 设置微信公众号的token
	    config.setAesKey("123456");// 设置消息加解密密钥
		configs.put("test2", config);
	}

	//存String方便
	private static final ThreadLocal<String> aliasNames = new ThreadLocal<String>();

	public static void setAliasName(String aliasName) {
		aliasNames.set(aliasName);
	}

	public static String getAliasName() {
		return aliasNames.get();
	}

	public static WxMpInMemoryConfigStorage getWxMpInMemoryConfigStorage() {
		return configs.get(aliasNames.get());
	}
}
