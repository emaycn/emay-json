package cn.emay.json;

import java.io.Serializable;

public class TestTokenBean<T extends Object> extends TestBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private T love;

	public T getLove() {
		return love;
	}

	public void setLove(T love) {
		this.love = love;
	}

}
