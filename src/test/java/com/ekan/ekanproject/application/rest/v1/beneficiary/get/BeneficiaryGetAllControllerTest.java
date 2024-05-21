package com.ekan.ekanproject.application.rest.v1.beneficiary.get;

import com.ekan.ekanproject.TestSupport;
import com.ekan.ekanproject.application.port.out.TransferObject;
import com.ekan.ekanproject.domain.dto.beneficiary.BeneficiaryDto;
import com.ekan.ekanproject.domain.usecase.ekan.beneficiary.BeneficiaryGetAllUseCaseImpl;
import com.ekan.ekanproject.infrastructure.util.Constants;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class BeneficiaryGetAllControllerTest extends TestSupport {

    private final AtomicReference<MockMvc> mockMvc = new AtomicReference<MockMvc>();
    @Mock
    private BeneficiaryGetAllUseCaseImpl useCase;

    @InjectMocks
    private BeneficiaryGetAllController controller;

    @Test
    public void testExecuteWithSuccess() throws Exception {

        this.mockMvc.set(MockMvcBuilders.standaloneSetup(controller)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .build());

        var transferObject = TransferObject.<List<BeneficiaryDto>>builder().build();

        when(useCase.execute(UUID, PRODUCT_TYPE, OF)).thenReturn(transferObject);

        mockMvc.get().perform(get("/v1/api/beneficiary")
                        .param("page", "0")
                        .param("size", "10")
                        .header(Constants.UUID, UUID)
                        .header(Constants.PRODUCT, PRODUCT_TYPE)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        var response = controller.execute(UUID, PRODUCT_TYPE, OF);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(transferObject, response.getBody());
    }

}