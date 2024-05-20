package com.ekan.ekanproject.application.rest.v1.beneficiary.remove;

import com.ekan.ekanproject.application.entrypoint.resource.remove.IResourceRemove;
import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.domain.usecase.iface.GenericRemoveByIdUseCase;
import com.ekan.ekanproject.infrastructure.util.Constants;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/api/beneficiary")
@Api(tags = {"Services available to beneficiaries"})
public class BeneficiaryRemoveController implements IResourceRemove {

    private final GenericRemoveByIdUseCase useCase;

    public BeneficiaryRemoveController(@Qualifier("beneficiaryRemoveByIdUseCaseImpl") GenericRemoveByIdUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> execute(
            @RequestHeader(value = Constants.UUID) final String uuid,
            @RequestHeader(value = Constants.PRODUCT) final ProductType product,
            @PathVariable(value = "id") Long id) {
        log.info("UUID: {} - PRODUCT: {} - CLASS: {}", uuid, product, this);
        useCase.execute(uuid, product, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
