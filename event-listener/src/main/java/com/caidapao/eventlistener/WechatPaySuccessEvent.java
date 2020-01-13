package com.caidapao.eventlistener;

import org.springframework.context.ApplicationEvent;

/**
 * Created by caidapao on 2020/1/13
 * Time 23:45
 * address https://today.caidapao.com
 */
public class WechatPaySuccessEvent extends ApplicationEvent {

    private Order order;

    public WechatPaySuccessEvent(Object source) {
        super(source);
    }

    public WechatPaySuccessEvent(Object source,Order order) {
        super(source);
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
