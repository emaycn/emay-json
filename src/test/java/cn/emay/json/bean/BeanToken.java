package cn.emay.json.bean;

import java.io.Serializable;

/**
 * @author Frank
 */
public class BeanToken<T> extends Bean implements Serializable {

    private static final long serialVersionUID = 1L;

    private T love;

    public T getLove() {
        return love;
    }

    public void setLove(T love) {
        this.love = love;
    }

}
