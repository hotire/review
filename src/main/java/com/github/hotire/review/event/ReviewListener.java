package com.github.hotire.review.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReviewListener {

    @EventListener
    public void consume(final ReviewEvent reviewEvent) {
        log.info("event : {}", reviewEvent);
    }

}
