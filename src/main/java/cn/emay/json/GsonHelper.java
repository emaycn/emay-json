package cn.emay.json;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Gson 工具类
 * 
 * @author Frank
 *
 */
public class GsonHelper {

	/**
	 * 锁对象
	 */
	private final static Object LOCK = new Object();

	/**
	 * 默认日期格式
	 */
	public final static String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 默认Gson构造参数Key
	 */
	private final static String DEFAULT_KEY = DEFAULT_DATE_PATTERN + "_true_true";

	/**
	 * 排除Null字段的Gson构造参数Key
	 */
	private final static String WITHOUTNULL_KEY = DEFAULT_DATE_PATTERN + "_true_false";

	/**
	 * Gson对象集合
	 */
	private static Map<String, Gson> GSONS = new HashMap<String, Gson>();

	/**
	 * 获取所有Gson对象集合
	 * 
	 * @return
	 */
	protected static Map<String, Gson> getAllGsons() {
		return GSONS;
	}

	/**
	 * 获取Gson构造器
	 * 
	 * @return
	 */
	public static GsonBuilder getGsonBuilder() {
		return new GsonBuilder();
	}

	/**
	 * 获取Gson构造器
	 * 
	 * @param datePattern
	 *            日期格式
	 * @param isDisableHtmlEscaping
	 *            是否不进行HTML转义
	 * @param isWithNulls
	 *            是否需要空字段
	 * @return
	 */
	protected static GsonBuilder getGsonBuilder(String datePattern, boolean isDisableHtmlEscaping, boolean isWithNulls) {
		GsonBuilder builder = getGsonBuilder();
		if (isDisableHtmlEscaping) {
			builder.disableHtmlEscaping();
		}
		if (isWithNulls) {
			builder.serializeNulls();
		}
		if (datePattern != null) {
			datePattern = datePattern.trim();
			if (datePattern.length() > 0) {
				builder.setDateFormat(datePattern);
			}
		} else {
			builder.setDateFormat(DEFAULT_DATE_PATTERN);
		}
		return builder;
	}

	/**
	 * 获取Gson对象
	 * 
	 * @return
	 */
	public static Gson getGson() {
		Gson gson = GSONS.get(DEFAULT_KEY);
		if (gson == null) {
			synchronized (LOCK) {
				if (gson == null) {
					gson = getGsonBuilder(DEFAULT_DATE_PATTERN, true, true).create();
					GSONS.put(DEFAULT_KEY, gson);
				}
			}
		}
		return gson;
	}

	/**
	 * 获取Gson对象
	 * 
	 * @param datePattern
	 *            日期格式
	 * @return
	 */
	public static Gson getGson(String datePattern) {
		String key = datePattern + "_true_true";
		Gson gson = GSONS.get(key);
		if (gson == null) {
			synchronized (LOCK) {
				if (gson == null) {
					gson = getGsonBuilder(datePattern, true, true).create();
					GSONS.put(key, gson);
				}
			}
		}
		return gson;
	}

	/**
	 * 获取Gson对象【转换时不保留空字段】
	 * 
	 * @return
	 */
	public static Gson getGsonWithoutNull() {
		Gson gson = GSONS.get(WITHOUTNULL_KEY);
		if (gson == null) {
			synchronized (LOCK) {
				if (gson == null) {
					gson = getGsonBuilder(DEFAULT_DATE_PATTERN, true, false).create();
					GSONS.put(WITHOUTNULL_KEY, gson);
				}
			}
		}
		return gson;
	}

	/**
	 * 获取Gson对象【转换时不保留空字段】
	 * 
	 * @param datePattern
	 *            日期格式
	 * @return
	 */
	public static Gson getGsonWithoutNull(String datePattern) {
		String key = datePattern + "_true_false";
		Gson gson = GSONS.get(key);
		if (gson == null) {
			synchronized (LOCK) {
				if (gson == null) {
					gson = getGsonBuilder(datePattern, true, false).create();
					GSONS.put(key, gson);
				}
			}
		}
		return gson;
	}

	/**
	 * 获取Gson对象
	 * 
	 * @param datePattern
	 *            日期格式
	 * @param isDisableHtmlEscaping
	 *            是否不进行HTML转义
	 * @param isWithNulls
	 *            是否需要空字段
	 * @return
	 */
	public static Gson getGson(String datePattern, boolean isDisableHtmlEscaping, boolean isWithNulls) {
		String key = datePattern + "_" + isDisableHtmlEscaping + "_" + isWithNulls;
		Gson gson = GSONS.get(key);
		if (gson == null) {
			synchronized (LOCK) {
				if (gson == null) {
					gson = getGsonBuilder(datePattern, isDisableHtmlEscaping, isWithNulls).create();
					GSONS.put(key, gson);
				}
			}
		}
		return gson;
	}

}
