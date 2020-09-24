package cn.emay.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Gson 工具类
 *
 * @author Frank
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
     * 到毫秒的日期格式
     */
    public final static String DATE_PATTERN_MILL = "yyyy-MM-dd HH:mm:ss SSS";

    /**
     * 默认Gson构造参数Key
     */
    private final static String DEFAULT_KEY = DEFAULT_DATE_PATTERN + "_true_true";

    /**
     * 排除Null字段的Gson构造参数Key
     */
    private final static String WITH_OUT_NULL_KEY = DEFAULT_DATE_PATTERN + "_true_false";

    /**
     * Gson对象集合
     */
    private static final Map<String, Gson> GSON_MAP = new HashMap<>();

    /**
     * 获取所有Gson对象集合
     *
     * @return 所有Gson对象集合
     */
    protected static Map<String, Gson> getAllGson() {
        return GSON_MAP;
    }

    /**
     * 获取Gson构造器
     *
     * @return GsonBuilder
     */
    public static GsonBuilder getGsonBuilder() {
        return getGsonBuilder(DEFAULT_DATE_PATTERN);
    }

    /**
     * 获取Gson构造器
     *
     * @param datePattern 日期格式
     * @return GsonBuilder
     */
    public static GsonBuilder getGsonBuilder(String datePattern) {
        final String newDatePattern = datePattern == null ? DEFAULT_DATE_PATTERN : datePattern;
        GsonBuilder gb = new GsonBuilder();
        gb.registerTypeAdapter(LocalDateTime.class, CustomJsonSerializers.getLocalDateTimeJsonSerializer(newDatePattern));
        gb.registerTypeAdapter(LocalDateTime.class, CustomJsonSerializers.getLocalDateTimeJsonDeserializer(newDatePattern));
        gb.registerTypeAdapter(LocalDate.class, CustomJsonSerializers.getLocalDateJsonSerializer(newDatePattern));
        gb.registerTypeAdapter(LocalDate.class, CustomJsonSerializers.getLocalDateJsonDeserializer(newDatePattern));
        gb.registerTypeAdapter(LocalTime.class, CustomJsonSerializers.getLocalTimeJsonSerializer(newDatePattern));
        gb.registerTypeAdapter(LocalTime.class, CustomJsonSerializers.getLocalTimeJsonDeserializer(newDatePattern));
        return gb;
    }

    /**
     * 获取Gson构造器
     *
     * @param datePattern           日期格式
     * @param isDisableHtmlEscaping 是否不进行HTML转义
     * @param isWithNulls           是否需要空字段
     * @return GsonBuilder
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
     * @return Gson
     */
    public static Gson getGson() {
        Gson gson = GSON_MAP.get(DEFAULT_KEY);
        if (gson == null) {
            synchronized (LOCK) {
                gson = GSON_MAP.get(DEFAULT_KEY);
                if (gson == null) {
                    gson = getGsonBuilder(DEFAULT_DATE_PATTERN, true, true).create();
                    GSON_MAP.put(DEFAULT_KEY, gson);
                }
            }
        }
        return gson;
    }

    /**
     * 获取Gson对象
     *
     * @param datePattern 日期格式
     * @return Gson
     */
    public static Gson getGson(String datePattern) {
        String key = datePattern + "_true_true";
        Gson gson = GSON_MAP.get(key);
        if (gson == null) {
            synchronized (LOCK) {
                gson = GSON_MAP.get(key);
                if (gson == null) {
                    gson = getGsonBuilder(datePattern, true, true).create();
                    GSON_MAP.put(key, gson);
                }
            }
        }
        return gson;
    }

    /**
     * 获取Gson对象【转换时不保留空字段】
     *
     * @return Gson
     */
    public static Gson getGsonWithoutNull() {
        Gson gson = GSON_MAP.get(WITH_OUT_NULL_KEY);
        if (gson == null) {
            synchronized (LOCK) {
                gson = GSON_MAP.get(WITH_OUT_NULL_KEY);
                if (gson == null) {
                    gson = getGsonBuilder(DEFAULT_DATE_PATTERN, true, false).create();
                    GSON_MAP.put(WITH_OUT_NULL_KEY, gson);
                }
            }
        }
        return gson;
    }

    /**
     * 获取Gson对象【转换时不保留空字段】
     *
     * @param datePattern 日期格式
     * @return Gson
     */
    public static Gson getGsonWithoutNull(String datePattern) {
        String key = datePattern + "_true_false";
        Gson gson = GSON_MAP.get(key);
        if (gson == null) {
            synchronized (LOCK) {
                gson = GSON_MAP.get(key);
                if (gson == null) {
                    gson = getGsonBuilder(datePattern, true, false).create();
                    GSON_MAP.put(key, gson);
                }
            }
        }
        return gson;
    }

    /**
     * 获取Gson对象
     *
     * @param datePattern           日期格式
     * @param isDisableHtmlEscaping 是否不进行HTML转义
     * @param isWithNulls           是否需要空字段
     * @return Gson
     */
    public static Gson getGson(String datePattern, boolean isDisableHtmlEscaping, boolean isWithNulls) {
        String key = datePattern + "_" + isDisableHtmlEscaping + "_" + isWithNulls;
        Gson gson = GSON_MAP.get(key);
        if (gson == null) {
            synchronized (LOCK) {
                gson = GSON_MAP.get(key);
                if (gson == null) {
                    gson = getGsonBuilder(datePattern, isDisableHtmlEscaping, isWithNulls).create();
                    GSON_MAP.put(key, gson);
                }
            }
        }
        return gson;
    }

}
