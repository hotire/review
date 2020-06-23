package com.github.hotire.review;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewKafkaListener {
    private final ObjectMapper objectMapper;

//    @KafkaListener
//    public void listen(final String event) {
//        final ReviewEvent reviewEvent = objectMapper.convertValue(event, ReviewEvent.class);
//        reviewEvent.get
//
//    }
}
