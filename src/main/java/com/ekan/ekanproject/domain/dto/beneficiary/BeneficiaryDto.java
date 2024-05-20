package com.ekan.ekanproject.domain.dto.beneficiary;

import com.ekan.ekanproject.application.port.in.InputPort;
import com.ekan.ekanproject.application.port.out.OutputPort;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
public class BeneficiaryDto implements InputPort, OutputPort, Serializable {

    private Long id;
    private String name;
    private String phone;
    private LocalDate birthDay;
    private LocalDate eventDate;
    private LocalDate updateDate;


}
