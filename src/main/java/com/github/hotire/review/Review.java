package com.github.hotire.review;

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
