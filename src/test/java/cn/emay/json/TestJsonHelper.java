package cn.emay.json;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;

public class TestJsonHelper {

	private TestBean bean;

	private TestTokenBean<TestBean> tokenBean;

	@Before
	public void before() {
		bean = new TestBean();
		bean.setAge(1);
		bean.setHeight(1.78d);
		bean.setName("jack");
		bean.setStudent(true);
		bean.setBirth(new Date());

		tokenBean = new TestTokenBean<>();
		tokenBean.setLove(bean);
		tokenBean.setAge(2);
		tokenBean.setHeight(2.78d);
		tokenBean.setName("tom");
		tokenBean.setStudent(false);
		tokenBean.setBirth(new Date());
	}

	@Test()
	public void testDefault() {

		String jsonString = JsonHelper.toJsonString(bean);
		TestBean bean1 = JsonHelper.fromJson(TestBean.class, jsonString);

		String jsonString1 = JsonHelper.toJsonStringWithoutNull(bean);
		TestBean bean2 = JsonHelper.fromJson(TestBean.class, jsonString1);

		Assert.assertEquals(bean.getName(), bean1.getName());
		Assert.assertEquals(bean.getAge(), bean1.getAge());
		Assert.assertEquals(bean.getHeight(), bean1.getHeight());
		Assert.assertEquals(bean.getStudent(), bean1.getStudent());
		Assert.assertEquals(bean.getBirth().getTime() / 1000, bean1.getBirth().getTime() / 1000);

		Assert.assertEquals(bean.getName(), bean2.getName());
		Assert.assertEquals(bean.getAge(), bean2.getAge());
		Assert.assertEquals(bean.getHeight(), bean2.getHeight());
		Assert.assertEquals(bean.getStudent(), bean2.getStudent());
		Assert.assertEquals(bean.getBirth().getTime() / 1000, bean2.getBirth().getTime() / 1000);

	}

	@Test()
	public void testDatePattern() {

		String jsonString = JsonHelper.toJsonString(bean, "yyyyMMddHHmmssSSS");
		TestBean bean1 = JsonHelper.fromJson(TestBean.class, jsonString, "yyyyMMddHHmmssSSS");

		String jsonString1 = JsonHelper.toJsonStringWithoutNull(bean, "yyyyMMddHHmmssSSS");
		TestBean bean2 = JsonHelper.fromJson(TestBean.class, jsonString1, "yyyyMMddHHmmssSSS");

		Assert.assertEquals(bean.getName(), bean1.getName());
		Assert.assertEquals(bean.getAge(), bean1.getAge());
		Assert.assertEquals(bean.getHeight(), bean1.getHeight());
		Assert.assertEquals(bean.getStudent(), bean1.getStudent());
		Assert.assertEquals(bean.getBirth(), bean1.getBirth());

		Assert.assertEquals(bean.getName(), bean2.getName());
		Assert.assertEquals(bean.getAge(), bean2.getAge());
		Assert.assertEquals(bean.getHeight(), bean2.getHeight());
		Assert.assertEquals(bean.getStudent(), bean2.getStudent());
		Assert.assertEquals(bean.getBirth(), bean2.getBirth());

	}

	@Test()
	public void testToken() {

		String jsonString = JsonHelper.toJsonString(tokenBean);
		TestTokenBean<TestBean> bean1 = JsonHelper.fromJson(new TypeToken<TestTokenBean<TestBean>>() {
		}, jsonString);

		String jsonString1 = JsonHelper.toJsonStringWithoutNull(tokenBean);
		TestTokenBean<TestBean> bean2 = JsonHelper.fromJson(new TypeToken<TestTokenBean<TestBean>>() {
		}, jsonString1);

		Assert.assertEquals(tokenBean.getName(), bean1.getName());
		Assert.assertEquals(tokenBean.getAge(), bean1.getAge());
		Assert.assertEquals(tokenBean.getHeight(), bean1.getHeight());
		Assert.assertEquals(tokenBean.getStudent(), bean1.getStudent());
		Assert.assertEquals(tokenBean.getBirth().getTime() / 1000, bean1.getBirth().getTime() / 1000);

		Assert.assertEquals(tokenBean.getLove().getName(), bean1.getLove().getName());
		Assert.assertEquals(tokenBean.getLove().getAge(), bean1.getLove().getAge());
		Assert.assertEquals(tokenBean.getLove().getHeight(), bean1.getLove().getHeight());
		Assert.assertEquals(tokenBean.getLove().getStudent(), bean1.getLove().getStudent());
		Assert.assertEquals(tokenBean.getLove().getBirth().getTime() / 1000, bean1.getLove().getBirth().getTime() / 1000);

		Assert.assertEquals(tokenBean.getName(), bean2.getName());
		Assert.assertEquals(tokenBean.getAge(), bean2.getAge());
		Assert.assertEquals(tokenBean.getHeight(), bean2.getHeight());
		Assert.assertEquals(tokenBean.getStudent(), bean2.getStudent());
		Assert.assertEquals(tokenBean.getBirth().getTime() / 1000, bean2.getBirth().getTime() / 1000);

		Assert.assertEquals(tokenBean.getLove().getName(), bean2.getLove().getName());
		Assert.assertEquals(tokenBean.getLove().getAge(), bean2.getLove().getAge());
		Assert.assertEquals(tokenBean.getLove().getHeight(), bean2.getLove().getHeight());
		Assert.assertEquals(tokenBean.getLove().getStudent(), bean2.getLove().getStudent());
		Assert.assertEquals(tokenBean.getLove().getBirth().getTime() / 1000, bean2.getLove().getBirth().getTime() / 1000);

	}

	@Test()
	public void testDatePatternToken() {
		String jsonString = JsonHelper.toJsonString(tokenBean, "yyyyMMddHHmmssSSS");
		TestTokenBean<TestBean> bean1 = JsonHelper.fromJson(new TypeToken<TestTokenBean<TestBean>>() {
		}, jsonString, "yyyyMMddHHmmssSSS");

		String jsonString1 = JsonHelper.toJsonStringWithoutNull(tokenBean, "yyyyMMddHHmmssSSS");
		TestTokenBean<TestBean> bean2 = JsonHelper.fromJson(new TypeToken<TestTokenBean<TestBean>>() {
		}, jsonString1, "yyyyMMddHHmmssSSS");

		Assert.assertEquals(tokenBean.getName(), bean1.getName());
		Assert.assertEquals(tokenBean.getAge(), bean1.getAge());
		Assert.assertEquals(tokenBean.getHeight(), bean1.getHeight());
		Assert.assertEquals(tokenBean.getStudent(), bean1.getStudent());
		Assert.assertEquals(tokenBean.getBirth(), bean1.getBirth());

		Assert.assertEquals(tokenBean.getLove().getName(), bean1.getLove().getName());
		Assert.assertEquals(tokenBean.getLove().getAge(), bean1.getLove().getAge());
		Assert.assertEquals(tokenBean.getLove().getHeight(), bean1.getLove().getHeight());
		Assert.assertEquals(tokenBean.getLove().getStudent(), bean1.getLove().getStudent());
		Assert.assertEquals(tokenBean.getLove().getBirth(), bean1.getLove().getBirth());

		Assert.assertEquals(tokenBean.getName(), bean2.getName());
		Assert.assertEquals(tokenBean.getAge(), bean2.getAge());
		Assert.assertEquals(tokenBean.getHeight(), bean2.getHeight());
		Assert.assertEquals(tokenBean.getStudent(), bean2.getStudent());
		Assert.assertEquals(tokenBean.getBirth(), bean2.getBirth());

		Assert.assertEquals(tokenBean.getLove().getName(), bean2.getLove().getName());
		Assert.assertEquals(tokenBean.getLove().getAge(), bean2.getLove().getAge());
		Assert.assertEquals(tokenBean.getLove().getHeight(), bean2.getLove().getHeight());
		Assert.assertEquals(tokenBean.getLove().getStudent(), bean2.getLove().getStudent());
		Assert.assertEquals(tokenBean.getLove().getBirth(), bean2.getLove().getBirth());

	}

}
