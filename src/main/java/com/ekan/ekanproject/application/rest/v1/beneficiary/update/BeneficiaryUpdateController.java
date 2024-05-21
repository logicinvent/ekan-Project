package com.ekan.ekanproject.application.rest.v1.beneficiary.update;

import com.ekan.ekanproject.application.entrypoint.resource.saveupdate.IResourceSaveUpdate;
import com.ekan.ekanproject.application.port.out.TransferObject;
import com.ekan.ekanproject.domain.dto.beneficiary.BeneficiaryDto;
import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.domain.usecase.iface.GenericSaveUseCase;
import com.ekan.ekanproject.infrastructure.util.Constants;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/api/beneficiary")
@Api(tags = {"Services available to beneficiaries"})
public class BeneficiaryUpdateController implements IResourceSaveUpdate<BeneficiaryDto, BeneficiaryDto> {

    private final GenericSaveUseCase<TransferObject<BeneficiaryDto>, BeneficiaryDto> useCase;

    public BeneficiaryUpdateController(GenericSaveUseCase<TransferObject<BeneficiaryDto>, BeneficiaryDto> useCase) {
        this.useCase = useCase;
    }

    @Override
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransferObject<BeneficiaryDto>> execute(
            @RequestHeader(value = Constants.UUID) final String uuid,
            @RequestHeader(value = Constants.PRODUCT) final ProductType product,
            @RequestBody @Valid BeneficiaryDto beneficiary) {
        log.info("UUID: {} - PRODUCT: {} - CLASS: {}", uuid, product, this);
        return ResponseEntity.status(HttpStatus.CREATED).body(useCase.execute(uuid, product, beneficiary));
    }

}
