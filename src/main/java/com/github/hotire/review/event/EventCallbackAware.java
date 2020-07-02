package com.github.hotire.review.event;

public interface EventCallbackAware<T> {
    EventCallbackAware<T> setCallback(final EventCallback<T> eventCallback);
}
