package com.jay.service;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class FluxAndMonoTransformTest {

  List<String> name = Arrays.asList("Jay", "Thuy", "Ping", "Ang");

  @Test
  void transformUsingMap() {

    Flux<String> namesFlux = Flux.fromIterable(name)
        .map(String::toUpperCase)
        .log();

    namesFlux.subscribe(n->{
      System.out.println("flux map:" + n);
    });
  }
}
