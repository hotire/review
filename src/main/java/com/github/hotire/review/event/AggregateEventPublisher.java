package com.github.hotire.review.event;

import org.springframework.data.domain.AbstractAggregateRoot;

public abstract class AggregateEventPublisher<T extends AbstractAggregateRoot<T>> extends AbstractAggregateRoot<T> {

    public <E> E publish(final E event) {
        return super.registerEvent(event);
    }

    @SuppressWarnings("unchecked")
    public T publish() {
        publish(getEvent());
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T publish(final EventCallback<T> callback) {
        publish(getEvent().setCallback(callback));
        return (T) this;
    }

    public abstract EventCallbackAware<T> getEvent();
}
