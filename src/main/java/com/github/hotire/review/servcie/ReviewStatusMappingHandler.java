package com.github.hotire.review.servcie;

import com.github.hotire.review.common.model.ReviewStatus;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Component
public class ReviewStatusMappingHandler {
    public Method findMethod(final Object service, final ReviewStatus reviewStatus) {
        return Arrays.stream(service.getClass().getDeclaredMethods())
                     .filter(method -> method.isAnnotationPresent(reviewStatus.getAnnotation()))
                     .findAny().orElseThrow(RuntimeException::new);
    }

//    public <T> T apply(final Object service, final ReviewStatus reviewStatus) {
//
//    }
}
