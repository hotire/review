package com.github.hotire.review.entity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.AuditingHandler;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AuditConfig {

    @Autowired
    private AuditingHandler auditingHandler;

    @PostConstruct
    public void init() {
        auditingHandler.setDateTimeProvider(new OffsetCurrentDateTimeProvider());
    }

    @Bean
    public AuditorAware<Long> auditorAware() {
        return () -> Optional.of(1L);
    }
}
