package com.prime.task.prime.common.mappers;

import com.prime.task.prime.dto.SampleDTO;
import com.prime.task.prime.model.Sample;
import org.modelmapper.ModelMapper;

public class SampleMapper {

    public static SampleDTO toSampleDTO(Sample sample) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(sample, SampleDTO.class);

    }

    public static Sample toSample(SampleDTO sampleDTO) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(sampleDTO, Sample.class);

    }
}


