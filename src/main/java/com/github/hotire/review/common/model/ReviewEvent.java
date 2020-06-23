package com.github.hotire.review.common.model;

import lombok.Data;

@Data
public class ReviewEvent {
    private String id;
    private ReviewType reviewType;
    private ReviewStatus reviewStatus;
    private String content;
}
