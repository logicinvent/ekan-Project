package com.ekan.ekanproject.application.rest.v1.beneficiary.getbyid;

import com.ekan.ekanproject.application.entrypoint.resource.getbyid.IResourceGetById;
import com.ekan.ekanproject.application.port.out.TransferObject;
import com.ekan.ekanproject.domain.dto.beneficiary.BeneficiaryDto;
import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.domain.usecase.iface.GenericGetByIdUseCase;
import com.ekan.ekanproject.infrastructure.util.Constants;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/api/beneficiary")
@Api(tags = {"Services available to beneficiaries"})
public class BeneficiaryGetByIdController implements IResourceGetById<BeneficiaryDto> {

    private final GenericGetByIdUseCase<TransferObject<BeneficiaryDto>> useCase;

    public BeneficiaryGetByIdController(GenericGetByIdUseCase<TransferObject<BeneficiaryDto>> useCase) {
        this.useCase = useCase;
    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransferObject<BeneficiaryDto>> execute(
            @RequestHeader(value = Constants.UUID) final String uuid,
            @RequestHeader(value = Constants.PRODUCT) final ProductType product,
            @PathVariable(value = "id") Long id) {
        log.info("UUID: {} - PRODUCT: {} - CLASS: {}", uuid, product, this);
        return ResponseEntity.status(HttpStatus.OK).body(useCase.execute(uuid, product, id));
    }
}
