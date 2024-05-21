package com.ekan.ekanproject.infrastructure.annotation.listenner;

import com.ekan.ekanproject.infrastructure.annotation.UpdatedAt;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.lang.reflect.Field;
import java.time.LocalDateTime;

public class UpdatedDateAtListener {

    /**
     * Annotation available to insert new update date in the field
     * @param entity
     * @throws IllegalAccessException
     */
    @PrePersist
    @PreUpdate
    public void setUpdatedAt(Object entity) throws IllegalAccessException {
        Class<?> clazz = entity.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(UpdatedAt.class)) {
                field.setAccessible(true);
                field.set(entity, LocalDateTime.now());
            }
        }
    }

}
