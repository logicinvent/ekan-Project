package com.ekan.ekanproject.application.rest.v1.documenttype.get;

import com.ekan.ekanproject.application.entrypoint.resource.get.IResourceGet;
import com.ekan.ekanproject.application.port.out.TransferObject;
import com.ekan.ekanproject.domain.dto.beneficiary.DocumentTypeDto;
import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.domain.model.DocumentType;
import com.ekan.ekanproject.domain.usecase.iface.GenericGetAllUseCase;
import com.ekan.ekanproject.infrastructure.util.Constants;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/api/document-type")
@Api(tags = {"Services available to document types"})
public class DocumentTypeGetAllController implements IResourceGet<DocumentTypeDto> {

    private final GenericGetAllUseCase<TransferObject<List<DocumentTypeDto>>, DocumentType> useCase;

    public DocumentTypeGetAllController(GenericGetAllUseCase<TransferObject<List<DocumentTypeDto>>, DocumentType> useCase) {
        this.useCase = useCase;
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransferObject<List<DocumentTypeDto>>> execute(
            @RequestHeader(value = Constants.UUID) final String uuid,
            @RequestHeader(value = Constants.PRODUCT) final ProductType product, Pageable pageable) {
        log.info("UUID: {} - PRODUCT: {} - CLASS: {}", uuid, product, this);
        return ResponseEntity.status(HttpStatus.OK).body(useCase.execute(uuid, product, pageable));
    }
}
