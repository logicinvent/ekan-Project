package com.ekan.ekanproject.domain.dto.shared.product;


import com.ekan.ekanproject.domain.dto.shared.enums.ProductTypeValues;

public record Product(
        ProductTypeValues productTypeValues
) {
}
