package com.github.hotire.review.common.model;

import com.github.hotire.review.servcie.annoation.Approve;
import com.github.hotire.review.servcie.annoation.InReview;
import com.github.hotire.review.servcie.annoation.Reject;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.lang.annotation.Annotation;

@Getter
@RequiredArgsConstructor
public enum ReviewStatus {
    IN_REVIEW(InReview.class),
    APPROVE(Approve.class),
    REJECT(Reject.class)
    ;

    private final Class<? extends Annotation> annotation;
}
