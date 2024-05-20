package com.ekan.ekanproject.domain.usecase.iface;

import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;

public interface GenericRemoveByIdUseCase {
    void execute(
            String uuid,
            ProductType product,
            Long id);
}