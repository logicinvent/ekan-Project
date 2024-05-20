package com.ekan.ekanproject.domain.usecase.iface;

import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;

public interface GenericSaveUseCase<Res, Req> {
    Res execute(
            String uuid,
            ProductType product,
            Req arg);
}
