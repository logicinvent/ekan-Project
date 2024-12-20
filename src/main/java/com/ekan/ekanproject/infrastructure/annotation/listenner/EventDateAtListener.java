package com.ekan.ekanproject.infrastructure.annotation.listenner;

import com.ekan.ekanproject.infrastructure.annotation.EventDateAt;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Objects;

public class EventDateAtListener {

    /**
     * Annotation available to insert new event date in the field
     * @param entity
     * @throws IllegalAccessException
     */
    @PrePersist
    @PreUpdate
    public void setEventDatedAt(Object entity) throws IllegalAccessException {
        Class<?> clazz = entity.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(EventDateAt.class)) {
                field.setAccessible(true);
                field.set(entity, Objects.isNull(field.get(entity)) ? LocalDateTime.now() : field.get(entity));
            }
        }
    }

}
