package com.ekan.ekanproject.domain.usecase.iface;

import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;

public interface GenericGetByIdUseCase<Res> {
    Res execute(
            String uuid,
            ProductType product,
            Long id);
}