package com.github.hotire.review.servcie;

import com.github.hotire.review.common.model.ReviewType;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;


@Component
public class ReviewServiceResolver {

    private final Map<ReviewType, Map<ReviewStrategy, Object>> beanMap;
    private final ReviewStatusMappingHandler mappingHandler;

    public ReviewServiceResolver(ApplicationContext context, ReviewStatusMappingHandler mappingHandler) {
        final Map<String, Object> map = context.getBeansWithAnnotation(ReviewComponent.class);
        beanMap = Arrays.stream(ReviewType.values())
              .collect(toMap(r -> r, r -> new HashMap<>()));

        map.values().forEach(o -> {
            final ReviewComponent reviewComponent = AnnotationUtils.findAnnotation(o.getClass(), ReviewComponent.class);
            beanMap.get(reviewComponent.type())
                   .put(reviewComponent.strategy(), o);
        });

        this.mappingHandler = mappingHandler;
    }

    public ReviewService resolve(ReviewType reviewType, ReviewStrategy reviewStrategy) {
        return resolve(reviewType, reviewStrategy, ReviewService.class);
    }

    public <T> T resolve(ReviewType reviewType, ReviewStrategy reviewStrategy, Class<T> serviceType) {
        return serviceType.cast(beanMap.get(reviewType).get(reviewStrategy));
    }

}
