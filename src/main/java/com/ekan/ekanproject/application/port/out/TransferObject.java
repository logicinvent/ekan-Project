package com.ekan.ekanproject.application.port.out;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransferObject<T> {

    private T content;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer pageNumber;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer pageSize;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long totalElements;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer totalPages;

}
