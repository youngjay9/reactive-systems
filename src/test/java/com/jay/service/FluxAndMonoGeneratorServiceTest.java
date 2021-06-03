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
  void namesFluxMap() {

    // when
    var namesFlux = fluxAndMonoGeneratorService.namesFluxMap();

    // then
    StepVerifier.create(namesFlux)
        .expectNext("JAY", "THUY", "PING", "ANG")
        .verifyComplete();
  }

  @Test
  void nameFluxImmutability() {

    var namesFlux = fluxAndMonoGeneratorService.namesFluxImmutability();

    StepVerifier.create(namesFlux)
        .expectNext("JAY", "THUY", "PING", "ANG")
        .verifyComplete();
  }

}
