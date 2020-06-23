package com.github.hotire.review.servcie;


import com.github.hotire.review.common.entity.Review;
import com.github.hotire.review.common.model.ReviewType;
import com.github.hotire.review.servcie.annoation.Approve;
import com.github.hotire.review.servcie.annoation.Reject;

@ReviewComponent(type = ReviewType.MEDIA, strategy = ReviewStrategy.ARA)
public class MediaAraService {

    @Approve
    public void approved(final Review review) {

    }

    @Reject
    public Review reject() {
        return new Review();
    }
}
