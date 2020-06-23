package com.github.hotire.review.common.entity;

import com.github.hotire.review.common.model.ReviewStatus;
import com.github.hotire.review.common.model.ReviewType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

@Accessors(chain = true)
@Entity
@Getter
@NoArgsConstructor
public class Review {
    @Id
    private Long id;

    private ReviewType reviewType;

    private ReviewStatus reviewStatus;

    public Review(ReviewType reviewType) {
        this.reviewType = reviewType;
        this.reviewStatus = ReviewStatus.IN_REVIEW;
    }
}
