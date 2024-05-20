package com.ekan.ekanproject.infrastructure.adapter.iface;

import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;

public interface DocumentDataProvider<Res, Req> {

    Res findById(String uuid,
                 ProductType product,
                 Req arg);

    void deleteById(String uuid, ProductType product, Req arg);

}
