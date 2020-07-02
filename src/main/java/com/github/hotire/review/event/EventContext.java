package com.github.hotire.review.event;

import org.springframework.context.ApplicationEvent;


public abstract class EventContext<T> extends ApplicationEvent implements EventCallbackAware<T> {
    public EventContext(Object source) {
        super(source);
    }
}
