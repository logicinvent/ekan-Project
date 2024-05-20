package com.ekan.ekanproject.domain.usecase.iface;

import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;

public interface GenericRemoveByEmbeddeIdUseCase {
    void execute(
            String uuid,
            ProductType product,
            Long id_1,
            Long id_2);
}