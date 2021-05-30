package com.jay.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class FluxAndMonoGeneratorServiceTest {

  FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

  @Test
  void namesFlux() {
    var namesFlux = fluxAndMonoGeneratorService.namesFlux();

    StepVerifier.create(namesFlux)
        .expectNext("Jay", "Thuy", "Ping", "Ang")
        .verifyComplete();
  }

  @Test
  void nameMono() {
    var monoName = fluxAndMonoGeneratorService.nameMono();

  }
}
