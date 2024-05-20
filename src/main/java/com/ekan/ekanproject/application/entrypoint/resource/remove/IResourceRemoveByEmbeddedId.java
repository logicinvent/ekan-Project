package com.ekan.ekanproject.application.entrypoint.resource.remove;

import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import org.springframework.http.ResponseEntity;

import static com.ekan.ekanproject.infrastructure.util.Constants.RECORD_REMOVED;
import static com.ekan.ekanproject.infrastructure.util.Constants.UNKNOWN_ERROR;

public interface IResourceRemoveByEmbeddedId {

    /**
     * This feature provides access to remove information by composite key
     *
     * @param uuid String
     * @param product Product
     * @param id_1 Long
     * @param id_2 Long
     * @return TOutputPort
     */
    @Operation(summary = "Service available to remove registered information by composite key")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = RECORD_REMOVED,
                    content = {@Content(mediaType = "application/json")}),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = UNKNOWN_ERROR,
                    content = @Content)
    })
    ResponseEntity<Void> execute(final String uuid, final ProductType product, Long id_1, Long id_2);
    
}
