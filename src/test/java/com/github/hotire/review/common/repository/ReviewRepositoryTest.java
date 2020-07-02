package com.github.hotire.review.common.repository;

import com.github.hotire.review.common.entity.Review;
import com.github.hotire.review.event.ReviewListener;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(ReviewListener.class)
@DataJpaTest
class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    void save() {
        // given
        final Review review = new Review();

        // when
        reviewRepository.save(review.publish());

        // then

    }

}