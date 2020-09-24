package cn.emay.json;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 自定义解析器
 *
 * @author Frank
 */
public class CustomJsonSerializers {

    /**
     * 获取LocalDateTime编码器
     */
    public static JsonSerializer<LocalDateTime> getLocalDateTimeJsonSerializer(String datePattern) {
        return (src, typeOfSrc, context) -> {
            String str = src.format(DateTimeFormatter.ofPattern(datePattern));
            return new JsonPrimitive(str);
        };
    }

    /**
     * 获取LocalDateTime解码器
     */
    public static JsonDeserializer<LocalDateTime> getLocalDateTimeJsonDeserializer(String datePattern) {
        return (json, typeOfT, context) -> {
            String datetime = json.getAsJsonPrimitive().getAsString();
            return LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern(datePattern));
        };
    }

    /**
     * 获取LocalDate编码器
     */
    public static JsonSerializer<LocalDate> getLocalDateJsonSerializer(String datePattern) {
        return (src, typeOfSrc, context) -> {
            LocalDateTime rs = LocalDateTime.of(src, LocalTime.of(0, 0, 0, 0));
            String str = rs.format(DateTimeFormatter.ofPattern(datePattern));
            return new JsonPrimitive(str);
        };
    }

    /**
     * 获取LocalDate解码器
     */
    public static JsonDeserializer<LocalDate> getLocalDateJsonDeserializer(String datePattern) {
        return (json, typeOfT, context) -> {
            String datetime = json.getAsJsonPrimitive().getAsString();
            LocalDateTime ldt = LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern(datePattern));
            return ldt.toLocalDate();
        };
    }

    /**
     * 获取LocalTime编码器
     */
    public static JsonSerializer<LocalTime> getLocalTimeJsonSerializer(String datePattern) {
        return (src, typeOfSrc, context) -> {
            LocalDateTime rs = LocalDateTime.of(LocalDate.of(0, 1, 1), src);
            String str = rs.format(DateTimeFormatter.ofPattern(datePattern));
            return new JsonPrimitive(str);
        };
    }

    /**
     * 获取LocalTime解码器
     */
    public static JsonDeserializer<LocalTime> getLocalTimeJsonDeserializer(String datePattern) {
        return (json, typeOfT, context) -> {
            String datetime = json.getAsJsonPrimitive().getAsString();
            LocalDateTime ldt = LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern(datePattern));
            return ldt.toLocalTime();
        };
    }

}
