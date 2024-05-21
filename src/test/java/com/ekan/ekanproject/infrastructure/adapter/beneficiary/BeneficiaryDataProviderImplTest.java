package com.ekan.ekanproject.infrastructure.adapter.beneficiary;

import com.ekan.ekanproject.TestSupport;
import com.ekan.ekanproject.domain.exception.BeneficiaryNotFoundException;
import com.ekan.ekanproject.domain.model.Beneficiary;
import com.ekan.ekanproject.infrastructure.repository.BeneficiaryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class BeneficiaryDataProviderImplTest extends TestSupport {

    @Mock
    private BeneficiaryRepository repository;

    @InjectMocks
    private BeneficiaryDataProviderImpl service;

    @Test
    public void testFindAll_Success() {

        var beneficiaryList = List.of(new Beneficiary());
        var resultPage = new PageImpl<>(beneficiaryList, OF, beneficiaryList.size());

        when(repository.findAll(OF)).thenReturn(resultPage);
        var result = service.findAll(UUID, PRODUCT_TYPE, OF);
        verify(repository, atLeastOnce()).findAll(OF);
        assertEquals(resultPage, result);
    }

    @Test
    public void testFindAll_BeneficiaryNotFoundException() {

        when(repository.findAll(OF)).thenReturn(Page.empty(OF));
        assertThrows(BeneficiaryNotFoundException.class, () -> {
            service.findAll(UUID, PRODUCT_TYPE, OF);
        });

    }

}