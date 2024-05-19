package com.ekan.ekanproject.application.rest.v1.beneficiary;

import com.ekan.ekanproject.application.entrypoint.resource.get.IResourceGet;
import com.ekan.ekanproject.domain.dto.beneficiary.BeneficiaryDto;
import com.ekan.ekanproject.domain.dto.shared.product.Product;
import com.ekan.ekanproject.infrastructure.util.Constants;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class BeneficiaryController implements IResourceGet<BeneficiaryDto> {


    // rever
    @Override
    public ResponseEntity<List<BeneficiaryDto>> execute(
            @RequestHeader(value = Constants.UUID) final String uuid,
            @RequestHeader(value = Constants.PRODUCT)final Product product) {

        return ResponseEntity.status(HttpStatus.OK).body(List.of(BeneficiaryDto.builder().build()));
    }
}
