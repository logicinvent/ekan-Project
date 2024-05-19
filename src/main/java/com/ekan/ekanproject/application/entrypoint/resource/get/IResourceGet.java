package com.ekan.ekanproject.application.entrypoint.resource.get;

import com.ekan.ekanproject.application.port.in.InputPort;
import com.ekan.ekanproject.application.port.out.OutputPort;
import com.ekan.ekanproject.domain.dto.shared.product.Product;
import com.ekan.ekanproject.infrastructure.util.Constants;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface IResourceGet<TOutputPort extends OutputPort> {

    /**
     * This feature provides access to the complete list of items
     *
     * @param uuid String
     * @param product Product
     * @return List<TOutputPort>
     */
    @ApiOperation(value = "Service available to obtain all registered beneficiaries", authorizations = {@Authorization(value = "OAuth2")})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = Constants.REQUEST_COMPLETED_SUCCESSFULLY),
            @ApiResponse(code = 201, message = Constants.UPDATE_OR_INCLUSION_CARRIED_OUT_SUCCESSFULLY),
            @ApiResponse(code = 401, message = Constants.UNAUTHORIZED_ACCESS),
            @ApiResponse(code = 500, message = Constants.UNKNOWN_ERROR)})
    ResponseEntity<List<TOutputPort>> execute(final String uuid, final Product product);

}
