package com.prime.task.prime.controller;

import com.prime.task.prime.dto.SampleDTO;
import com.prime.task.prime.service.SampelSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(
        path = "/api/v1/sample",
        produces = {MediaType.APPLICATION_JSON_VALUE}
)

public class SampleController {
    @Autowired
    private SampelSevice sampleService;

    @GetMapping(path = "/{sampleId}")
    public ResponseEntity<SampleDTO> getSampleById(@PathVariable long sampleId) {
        return ResponseEntity.ok(sampleService.getSample(sampleId));

    }

    @PostMapping
    public ResponseEntity<SampleDTO> createSample(@Valid @RequestBody SampleDTO sampleDTO) {
        return new ResponseEntity(sampleService.createSample(sampleDTO), HttpStatus.CREATED);

    }

}
