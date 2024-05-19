package com.ekan.ekanproject.application.rest.v1.beneficiary.getbyid;

import com.ekan.ekanproject.application.entrypoint.resource.get.IResourceGet;
import com.ekan.ekanproject.application.entrypoint.resource.getbyid.IResourceGetById;
import com.ekan.ekanproject.domain.dto.beneficiary.BeneficiaryDto;
import com.ekan.ekanproject.domain.dto.shared.product.Product;
import com.ekan.ekanproject.infrastructure.util.Constants;
import io.swagger.annotations.Api;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/beneficiary")
@Api(tags = {"Services available to beneficiaries"})
public class BeneficiaryGetByIdController implements IResourceGetById<BeneficiaryDto> {

    @Override
    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BeneficiaryDto> execute(
            @RequestHeader(value = Constants.UUID) final String uuid,
            @RequestHeader(value = Constants.PRODUCT) final Product product,
            @PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(BeneficiaryDto.builder().build());
    }
}
