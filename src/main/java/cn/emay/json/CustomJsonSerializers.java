package cn.emay.json;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * 自定义解析器
 * 
 * @author Frank
 *
 */
public class CustomJsonSerializers {

	/**
	 * 获取LocalDateTime编码器
	 */
	public static JsonSerializer<LocalDateTime> getLocalDateTimeJsonSerializer(String datePattern) {
		return new JsonSerializer<LocalDateTime>() {
			@Override
			public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
				String str = null;
				try {
					str = src.format(DateTimeFormatter.ofPattern(datePattern));
				} catch (Exception e) {
				}
				return new JsonPrimitive(str);
			}
		};
	}

	/**
	 * 获取LocalDateTime解码器
	 */
	public static JsonDeserializer<LocalDateTime> getLocalDateTimeJsonDeserializer(String datePattern) {
		return new JsonDeserializer<LocalDateTime>() {
			@Override
			public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				LocalDateTime ldt = null;
				try {
					String datetime = json.getAsJsonPrimitive().getAsString();
					ldt = LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern(datePattern));
				} catch (Exception e) {
				}
				return ldt;
			}
		};
	}

	/**
	 * 获取LocalDate编码器
	 */
	public static JsonSerializer<LocalDate> getLocalDateJsonSerializer(String datePattern) {
		return new JsonSerializer<LocalDate>() {
			@Override
			public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
				String str = null;
				try {
					LocalDateTime rs = LocalDateTime.of(src, LocalTime.of(0, 0, 0, 0));
					str = rs.format(DateTimeFormatter.ofPattern(datePattern));
				} catch (Exception e) {
				}
				return new JsonPrimitive(str);
			}
		};
	}

	/**
	 * 获取LocalDate解码器
	 */
	public static JsonDeserializer<LocalDate> getLocalDateJsonDeserializer(String datePattern) {
		return new JsonDeserializer<LocalDate>() {
			@Override
			public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				LocalDateTime ldt = null;
				try {
					String datetime = json.getAsJsonPrimitive().getAsString();
					ldt = LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern(datePattern));
				} catch (Exception e) {
				}
				if (ldt == null) {
					return null;
				} else {
					return ldt.toLocalDate();
				}
			}
		};
	}

	/**
	 * 获取LocalTime编码器
	 */
	public static JsonSerializer<LocalTime> getLocalTimeJsonSerializer(String datePattern) {
		return new JsonSerializer<LocalTime>() {
			@Override
			public JsonElement serialize(LocalTime src, Type typeOfSrc, JsonSerializationContext context) {
				String str = null;
				try {
					LocalDateTime rs = LocalDateTime.of(LocalDate.of(0, 1, 1), src);
					str = rs.format(DateTimeFormatter.ofPattern(datePattern));
				} catch (Exception e) {
				}
				return new JsonPrimitive(str);
			}
		};
	}

	/**
	 * 获取LocalTime解码器
	 */
	public static JsonDeserializer<LocalTime> getLocalTimeJsonDeserializer(String datePattern) {
		return new JsonDeserializer<LocalTime>() {
			@Override
			public LocalTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				LocalDateTime ldt = null;
				try {
					String datetime = json.getAsJsonPrimitive().getAsString();
					ldt = LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern(datePattern));
				} catch (Exception e) {
				}
				if (ldt == null) {
					return null;
				} else {
					return ldt.toLocalTime();
				}
			}
		};
	}

}
