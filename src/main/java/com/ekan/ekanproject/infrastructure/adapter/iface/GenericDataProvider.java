package com.ekan.ekanproject.infrastructure.adapter.iface;

import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericDataProvider<Res, Req> {
    Page<Res> findAll(String uuid,
                      ProductType product,
                      Pageable pageable);

    Res findById(String uuid,
             ProductType product,
             Long arg);

    Res save(String uuid,
               ProductType product,
             Req arg);

    Res update(String uuid,
             ProductType product,
             Req arg);

    void remove(String uuid,
             ProductType product,
             Long arg);

}
