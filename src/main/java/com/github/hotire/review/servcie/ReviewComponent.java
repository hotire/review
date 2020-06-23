package com.github.hotire.review.servcie;

import com.github.hotire.review.common.model.ReviewType;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface ReviewComponent {
    ReviewType type();
    ReviewStrategy strategy();

    @AliasFor(
            annotation = Component.class
    )
    String value() default "";
}
