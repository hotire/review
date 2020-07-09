package com.github.hotire.review.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.OffsetDateTime;


@Data
@EntityListeners(value = {AuditingEntityListener.class})
@Entity
public class BaseReview {

    @Id @GeneratedValue
    private Long id;

    @CreatedBy
    @Column(name = "CREATED_BY", nullable = false, updatable = false)
    private Long createdBy;

    @LastModifiedBy
    @Column(name = "UPDATED_BY", nullable = false)
    private Long updatedBy;

    @CreatedDate
    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime updatedAt;
}
