package com.ekan.ekanproject.domain.dto.beneficiary;

import com.ekan.ekanproject.application.port.in.InputPort;
import com.ekan.ekanproject.application.port.out.OutputPort;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class BeneficiaryDto implements InputPort, OutputPort, Serializable {

    private Long id;

    @NotNull(message = "The 'name' field is mandatory.")
    private String name;

    @NotNull(message = "The 'phone' field is mandatory.")
    private String phone;

    @NotNull(message = "The 'birthDay' field is mandatory.")
    private LocalDate birthDay;

    private LocalDateTime eventDate;

    private LocalDateTime updateDate;


}
