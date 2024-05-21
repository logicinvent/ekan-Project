package com.ekan.ekanproject.application.rest.v1.document.getbyid;

import com.ekan.ekanproject.application.entrypoint.resource.getbyid.IResourceGetByEmbeddedId;
import com.ekan.ekanproject.application.port.out.TransferObject;
import com.ekan.ekanproject.domain.dto.document.DocumentDto;
import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.domain.usecase.iface.GenericGetByEmbeddeIdUseCase;
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
@RequestMapping("/v1/api/document")
@Api(tags = {"Services available to documents"})
public class DocumentGetByEmbeddedIdController implements IResourceGetByEmbeddedId<DocumentDto> {

    private final GenericGetByEmbeddeIdUseCase<TransferObject<DocumentDto>> useCase;

    public DocumentGetByEmbeddedIdController(GenericGetByEmbeddeIdUseCase<TransferObject<DocumentDto>> useCase) {
        this.useCase = useCase;
    }

    @Override
    @GetMapping(value = "/{beneficiaryId}/{documentTypeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransferObject<DocumentDto>> execute(
            @RequestHeader(value = Constants.UUID) final String uuid,
            @RequestHeader(value = Constants.PRODUCT) final ProductType product,
            @PathVariable(value = "beneficiaryId") Long beneficiaryId,
            @PathVariable(value = "documentTypeId") Long documentTypeId) {
        log.info("UUID: {} - PRODUCT: {} - CLASS: {}", uuid, product, this);
        return ResponseEntity.status(HttpStatus.OK).body(useCase.execute(uuid, product, beneficiaryId, documentTypeId));
    }
}
