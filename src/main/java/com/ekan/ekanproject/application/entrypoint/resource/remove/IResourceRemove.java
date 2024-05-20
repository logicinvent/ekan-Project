package com.ekan.ekanproject.application.entrypoint.resource.remove;

import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.infrastructure.util.Constants;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.http.ResponseEntity;

public interface IResourceRemove {

    /**
     * This feature provides access to remove information by id
     *
     * @param uuid String
     * @param product Product
     * @param id Long
     * @return TOutputPort
     */
    @ApiOperation(value = "Service available to remove registered beneficiary by id", authorizations = {@Authorization(value = "OAuth2")})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = Constants.REQUEST_COMPLETED_SUCCESSFULLY),
            @ApiResponse(code = 201, message = Constants.UPDATE_OR_INCLUSION_CARRIED_OUT_SUCCESSFULLY),
            @ApiResponse(code = 401, message = Constants.UNAUTHORIZED_ACCESS),
            @ApiResponse(code = 500, message = Constants.UNKNOWN_ERROR)})
    ResponseEntity<Void> execute(final String uuid, final ProductType product, Long id);
    
}
