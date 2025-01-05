package com.gersimuca.cma.common.repository;

import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@NoRepositoryBean
public class BaseRepositoryImpl<T, I extends Serializable> extends SimpleJpaRepository<T, I>
        implements BaseRepository<T, I> {
    private final EntityManager entityManager;

    public BaseRepositoryImpl(
            JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public <S extends T> S statefulSave(final S entity) {
        final S savedEntity = super.save(entity);
        entityManager.refresh(savedEntity);
        return savedEntity;
    }
}

