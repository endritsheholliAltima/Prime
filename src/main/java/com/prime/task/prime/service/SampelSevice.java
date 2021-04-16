package com.prime.task.prime.service;

import com.prime.task.prime.dto.SampleDTO;

public interface SampelSevice {

    SampleDTO getSample(long sampleId);

    SampleDTO createSample(SampleDTO sampleDTO);

}
