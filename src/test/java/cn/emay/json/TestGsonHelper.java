package cn.emay.json;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

public class TestGsonHelper {

	Gson gson0 = GsonHelper.getGson();
	Gson gson1 = GsonHelper.getGson(GsonHelper.DEFAULT_DATE_PATTERN);
	Gson gson5 = GsonHelper.getGson(GsonHelper.DEFAULT_DATE_PATTERN, true, true);

	Gson gson2 = GsonHelper.getGsonWithoutNull();
	Gson gson4 = GsonHelper.getGsonWithoutNull(GsonHelper.DEFAULT_DATE_PATTERN);
	Gson gson6 = GsonHelper.getGson(GsonHelper.DEFAULT_DATE_PATTERN, true, false);

	Gson gson11 = GsonHelper.getGson("yyyyMMddHHmmssSSS");
	Gson gson15 = GsonHelper.getGson("yyyyMMddHHmmssSSS", true, true);

	Gson gson14 = GsonHelper.getGsonWithoutNull("yyyyMMddHHmmssSSS");
	Gson gson16 = GsonHelper.getGson("yyyyMMddHHmmssSSS", true, false);

	Gson gson7 = GsonHelper.getGson(GsonHelper.DEFAULT_DATE_PATTERN, false, true);

	Gson gson8 = GsonHelper.getGson(GsonHelper.DEFAULT_DATE_PATTERN, false, false);

	@Test()
	public void testGsonSize() {
		Assert.assertEquals(GsonHelper.getAllGsons().size(), 6);
	}

	@Test()
	public void testGsonObj() {

		Assert.assertEquals(gson0, gson1);
		Assert.assertEquals(gson0, gson5);

		Assert.assertEquals(gson2, gson4);
		Assert.assertEquals(gson2, gson6);

		Assert.assertEquals(gson11, gson15);

		Assert.assertEquals(gson14, gson16);

		Assert.assertNotEquals(gson7, gson8);

	}

	@Test()
	public void testGson() {

		TestBean bean = new TestBean();
		bean.setAge(1);
		bean.setHeight(1.78d);
		bean.setName("jack");
		bean.setStudent(true);
		bean.setBirth(new Date());

		String json = gson0.toJson(bean);

		TestBean bean1 = gson0.fromJson(json, TestBean.class);

		Assert.assertEquals(bean.getName(), bean1.getName());
		Assert.assertEquals(bean.getAge(), bean1.getAge());
		Assert.assertEquals(bean.getHeight(), bean1.getHeight());
		Assert.assertEquals(bean.getStudent(), bean1.getStudent());
		Assert.assertEquals(bean.getBirth().getTime() / 1000, bean1.getBirth().getTime() / 1000);

	}

}
