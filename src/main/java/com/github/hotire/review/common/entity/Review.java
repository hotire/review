package com.github.hotire.review.common.entity;

import com.github.hotire.review.common.model.ReviewStatus;
import com.github.hotire.review.common.model.ReviewType;
import com.github.hotire.review.event.AggregateEventPublisher;
import com.github.hotire.review.event.EventCallbackAware;
import com.github.hotire.review.event.ReviewEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Accessors(chain = true)
@Entity
@Getter
@NoArgsConstructor
public class Review extends AggregateEventPublisher<Review> {
    @Id @GeneratedValue
    private Long id;

    private ReviewType reviewType;

    private ReviewStatus reviewStatus;

    public Review(ReviewType reviewType) {
        this.reviewType = reviewType;
        this.reviewStatus = ReviewStatus.IN_REVIEW;
    }

    @Override
    public EventCallbackAware<Review> getEvent() {
        return new ReviewEvent(this);
    }
}
