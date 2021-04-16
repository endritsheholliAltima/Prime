package com.prime.task.prime.service;


import com.prime.task.prime.dto.SampleDTO;
import com.prime.task.prime.model.Sample;
import com.prime.task.prime.repository.SampleRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.prime.task.prime.common.mappers.SampleMapper.*;

import java.util.Optional;
import java.util.logging.Logger;
@Service
public class SampleServiceImplementation implements SampelSevice {

  //  private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    private final SampleRepository sampleRepository;

    public SampleServiceImplementation(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Override
    public SampleDTO getSample(long sampleId) {

        Optional<Sample> sample = sampleRepository.findById(sampleId);
        SampleDTO result = toSampleDTO(sample.get());
        return result;
    }

    @Override
    public SampleDTO createSample(SampleDTO sampleDTO) {

        Sample sample = sampleRepository.save(toSample((sampleDTO)));
        return  toSampleDTO(sample);
    }

}
