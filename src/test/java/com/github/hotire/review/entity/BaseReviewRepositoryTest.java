package com.github.hotire.review.entity;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class BaseReviewRepositoryTest {

    @Autowired
    private BaseReviewRepository reviewRepository;

    @Test
    public void save() {
        //
        final BaseReview review = new BaseReview();

        //
        final BaseReview result = reviewRepository.saveAndFlush(review);

        log.info("{}", result);
        log.info("{}", reviewRepository.findById(result.getId()));

    }

}