package com.github.hotire.review.common.entity;

import com.github.hotire.review.common.model.ReviewType;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Review {
    @Id
    private Long id;

    private ReviewType reviewType;
}
