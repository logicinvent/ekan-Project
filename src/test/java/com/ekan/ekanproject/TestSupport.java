package com.ekan.ekanproject;

import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;

import java.util.Random;

public abstract class TestSupport {

    protected static final PageRequest OF = PageRequest.of(0, 10);
    protected static final String UUID = String.valueOf(new Random().nextLong());
    protected static final ProductType PRODUCT_TYPE = ProductType.EKAN;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

}
