package com.ekan.ekanproject.domain.usecase.iface;

import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import org.springframework.data.domain.Pageable;

public interface GenericGetAllUseCase<Res, Req> {
    Res execute(
            String uuid,
            ProductType product,
            Pageable pageable);
}
