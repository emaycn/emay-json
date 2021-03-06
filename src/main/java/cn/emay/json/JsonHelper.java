package cn.emay.json;

import com.google.gson.reflect.TypeToken;

/**
 * Json工具类
 *
 * @author Frank
 */
public class JsonHelper {

    /**
     * 转换对象为Json
     *
     * @param obj 对象
     * @return Json字符串
     */
    public static String toJsonString(Object obj) {
        if (obj == null) {
            return null;
        }
        return GsonHelper.getGson().toJson(obj);
    }

    /**
     * 转换对象为Json【排除空值字段】
     *
     * @param obj 对象
     * @return Json字符串
     */
    public static String toJsonStringWithoutNull(Object obj) {
        if (obj == null) {
            return null;
        }
        return GsonHelper.getGsonWithoutNull().toJson(obj);
    }

    /**
     * 转换对象为Json【排除空值字段】
     *
     * @param obj         对象
     * @param datePattern 日期格式
     * @return Json字符串
     */
    public static String toJsonString(Object obj, String datePattern) {
        if (obj == null) {
            return null;
        }
        return GsonHelper.getGson(datePattern).toJson(obj);
    }

    /**
     * 转换对象为Json
     *
     * @param obj         对象
     * @param datePattern 日期格式
     * @return Json字符串
     */
    public static String toJsonStringWithoutNull(Object obj, String datePattern) {
        if (obj == null) {
            return null;
        }
        return GsonHelper.getGsonWithoutNull(datePattern).toJson(obj);
    }

    /**
     * 转换对象为Json【排除空值字段】【时间转换到毫秒数】
     *
     * @param obj 对象
     * @return Json字符串
     */
    public static String toJsonStringWithoutNullAndSSS(Object obj) {
        if (obj == null) {
            return null;
        }
        return GsonHelper.getGsonWithoutNull(GsonHelper.DATE_PATTERN_MILL).toJson(obj);
    }

    /**
     * 转换Json为对象实例
     *
     * @param clazz      对象类型
     * @param jsonString Json字符串
     * @return 对象
     */
    public static <T> T fromJson(Class<T> clazz, String jsonString) {
        if (jsonString == null) {
            return null;
        }
        return GsonHelper.getGson().fromJson(jsonString, clazz);
    }

    /**
     * 转换Json为对象实例
     *
     * @param token      泛型对象类型
     * @param jsonString Json字符串
     * @return 对象
     */
    public static <T> T fromJson(TypeToken<T> token, String jsonString) {
        if (jsonString == null) {
            return null;
        }
        return GsonHelper.getGson().fromJson(jsonString, token.getType());
    }

    /**
     * 转换Json为对象实例
     *
     * @param clazz       对象类型
     * @param jsonString  字符串
     * @param datePattern 日期格式
     * @return 对象
     */
    public static <T> T fromJson(Class<T> clazz, String jsonString, String datePattern) {
        if (jsonString == null) {
            return null;
        }
        return GsonHelper.getGson(datePattern).fromJson(jsonString, clazz);
    }

    /**
     * 转换Json为对象实例
     *
     * @param token       泛型对象类型
     * @param jsonString  字符串
     * @param datePattern 日期格式
     * @return 对象
     */
    public static <T> T fromJson(TypeToken<T> token, String jsonString, String datePattern) {
        if (jsonString == null) {
            return null;
        }
        return GsonHelper.getGson(datePattern).fromJson(jsonString, token.getType());
    }

    /**
     * 转换对象为Json【排除空值字段】【时间转换到毫秒数】
     *
     * @param clazz      类型
     * @param jsonString 字符串
     * @return 对象
     */
    public static <T> T fromJsonBySSS(Class<T> clazz, String jsonString) {
        if (jsonString == null) {
            return null;
        }
        return GsonHelper.getGson(GsonHelper.DATE_PATTERN_MILL).fromJson(jsonString, clazz);
    }

    /**
     * 转换对象为Json【排除空值字段】【时间转换到毫秒数】
     *
     * @param token      类型
     * @param jsonString json 字符串
     * @return 对象
     */
    public static <T> T fromJsonBySSS(TypeToken<T> token, String jsonString) {
        if (jsonString == null) {
            return null;
        }
        return GsonHelper.getGson(GsonHelper.DATE_PATTERN_MILL).fromJson(jsonString, token.getType());
    }

}
