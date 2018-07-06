package cn.emay.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class TestJava8LocalDateTime {

	@Test
	public void test() {

		assertNull(JsonHelper.fromJson(LocalDateTime.class, null));
		assertNull(JsonHelper.fromJson(LocalDate.class, null));
		assertNull(JsonHelper.fromJson(LocalTime.class, null));

		assertEquals(JsonHelper.fromJson(LocalDateTime.class, "\"2018-06-11 13:02:02\"").format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), "2018-06-11 13:02:02");
		assertEquals(JsonHelper.fromJson(LocalDate.class, "\"2018-06-11 13:02:02\"").format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), "2018-06-11");
		assertEquals(JsonHelper.fromJson(LocalTime.class, "\"2018-06-11 13:02:02\"").format(DateTimeFormatter.ofPattern("HH:mm:ss")), "13:02:02");
	}

}
