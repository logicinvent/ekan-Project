package com.ekan.ekanproject.domain.usecase.ekan.beneficiary;

import com.ekan.ekanproject.TestSupport;
import com.ekan.ekanproject.application.rest.v1.beneficiary.mapper.BeneficiaryMapperImpl;
import com.ekan.ekanproject.domain.dto.beneficiary.BeneficiaryDto;
import com.ekan.ekanproject.domain.exception.BeneficiaryNotFoundException;
import com.ekan.ekanproject.domain.model.Beneficiary;
import com.ekan.ekanproject.infrastructure.adapter.beneficiary.BeneficiaryDataProviderImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.PageImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class BeneficiaryGetAllUseCaseImplTest extends TestSupport {

    @Mock
    private BeneficiaryDataProviderImpl dataProvider;

    @Mock
    private BeneficiaryMapperImpl mapper;

    @InjectMocks
    private BeneficiaryGetAllUseCaseImpl useCase;

    @Test
    public void testExecute_Success() {

        var resultPage = new PageImpl<>(List.of(new Beneficiary()), OF, 1);
        var beneficiaryDtoList = List.of(BeneficiaryDto.builder().build());

        when(dataProvider.findAll(UUID, PRODUCT_TYPE, OF)).thenReturn(resultPage);
        when(mapper.modelToDtoWithList(resultPage.getContent())).thenReturn(beneficiaryDtoList);

        var result = useCase.execute(UUID, PRODUCT_TYPE, OF);

        verify(dataProvider, atLeastOnce()).findAll(UUID, PRODUCT_TYPE, OF);

        assertEquals(beneficiaryDtoList, result.getContent());
        assertEquals(OF.getPageNumber(), result.getPageNumber());
        assertEquals(resultPage.getNumberOfElements(), result.getPageSize());
        assertEquals(resultPage.getTotalElements(), result.getTotalElements());
        assertEquals(resultPage.getTotalPages(), result.getTotalPages());
    }

    @Test
    public void testExecute_BeneficiaryNotFoundException() {

        when(dataProvider.findAll(UUID, PRODUCT_TYPE, OF)).thenThrow(
                new BeneficiaryNotFoundException("Beneficiary not found"));

        assertThrows(BeneficiaryNotFoundException.class, () -> {
            useCase.execute(UUID, PRODUCT_TYPE, OF);
        });
    }
}