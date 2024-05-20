package com.ekan.ekanproject.application.rest.v1.beneficiary.mapper;

import com.ekan.ekanproject.domain.dto.beneficiary.BeneficiaryDto;
import com.ekan.ekanproject.domain.dto.shared.mapper.GenericMapper;
import com.ekan.ekanproject.domain.dto.shared.mapper.MapperSupport;
import com.ekan.ekanproject.domain.model.Beneficiary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeneficiaryMapperImpl extends MapperSupport implements GenericMapper<BeneficiaryDto, Beneficiary> {

    /**
     * Service available to convert DTOs to models
     * @param arg List<BeneficiaryDto>
     * @return List<Beneficiary>
     */
    @Override
    public List<Beneficiary> dtoToModelWithList(List<BeneficiaryDto> arg) {
        return arg.stream()
                .map(e -> modelMapper.map(e, Beneficiary.class))
                .collect(Collectors.toList());
    }

    /**
     * Service available to convert models to DTOs
     * @param arg List<Beneficiary>
     * @return List<BeneficiaryDto>
     */
    @Override
    public List<BeneficiaryDto> modelToDtoWithList(List<Beneficiary> arg) {
        return arg.stream()
                .map(e -> BeneficiaryDto.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .phone(e.getPhone())
                        .birthDay(e.getBirthDay())
                        .eventDate(e.getEventDate())
                        .updateDate(e.getUpdateDate())
                        .build())
                .collect(Collectors.toList());
    }

    /**
     * Service available to convert DTO to model
     * @param arg BeneficiaryDto
     * @return Beneficiary
     */
    @Override
    public Beneficiary dtoToModel(BeneficiaryDto arg) {
        return modelMapper.map(arg, Beneficiary.class);
    }

    /**
     * Service available to convert model to DTO
     * @param arg Beneficiary
     * @return BeneficiaryDto
     */
    @Override
    public BeneficiaryDto modelToDto(Beneficiary arg) {
        return BeneficiaryDto.builder()
                .id(arg.getId())
                .name(arg.getName())
                .phone(arg.getPhone())
                .birthDay(arg.getBirthDay())
                .eventDate(arg.getEventDate())
                .updateDate(arg.getUpdateDate())
                .build();
    }

}
