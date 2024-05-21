package com.ekan.ekanproject.application.entrypoint.resource.remove;

import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import static com.ekan.ekanproject.infrastructure.util.Constants.*;

public interface IResourceRemove {

    /**
     * This feature provides access to remove information by id
     *
     * @param uuid    String
     * @param product Product
     * @param id      Long
     * @return void
     */
    @Operation(summary = SERVICE_AVAILABLE_TO_REMOVE_REGISTERED_INFORMATION_BY_ID)
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = RECORD_REMOVED,
                    content = {@Content(mediaType = "application/json")}),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = UNKNOWN_ERROR,
                    content = @Content)
    })
    ResponseEntity<Void> execute(final String uuid, final ProductType product, Long id);

}
