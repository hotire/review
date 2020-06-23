package com.github.hotire.review;

import com.github.hotire.review.common.model.ReviewType;
import com.github.hotire.review.servcie.*;
import lombok.RequiredArgsConstructor;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewServiceResolver reviewServiceResolver;

    @PostConstruct
    void init() {
        final ReviewService reviewService = reviewServiceResolver.resolve(ReviewType.MEDIA, ReviewStrategy.LMP);
        final MediaAraService mediaAraService = reviewServiceResolver.resolve(ReviewType.MEDIA, ReviewStrategy.ARA, MediaAraService.class);
        Assert.isInstanceOf(MediaService.class, reviewService);
        Assert.isInstanceOf(MediaAraService.class, mediaAraService);
    }
}
