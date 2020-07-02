package com.github.hotire.review.event;

import com.github.hotire.review.common.entity.Review;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
public class ReviewEvent extends EventContext<Review> {
    private Review review;
    @Accessors(chain = true)
    @Setter
    private EventCallback<Review> callback;

    public ReviewEvent(final Object source) {
        super(source);
        this.review = (Review) source;
    }

}
