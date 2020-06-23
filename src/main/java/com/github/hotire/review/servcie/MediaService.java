package com.github.hotire.review.servcie;

import com.github.hotire.review.common.model.ReviewType;

@ReviewComponent(type = ReviewType.MEDIA, strategy = ReviewStrategy.LMP)
public class MediaService implements ReviewService {
}
