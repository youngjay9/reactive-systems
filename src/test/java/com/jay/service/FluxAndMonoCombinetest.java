package com.jay.service;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class FluxAndMonoCombinetest {

  @Test
  void combineusingMerge() {

    Flux<String> flux1 = Flux.just("A", "B", "C");

    Flux<String> flux2 = Flux.just("D", "E");

    Flux<String> combineFlux = Flux.merge(flux1, flux2);

    combineFlux.subscribe(System.out::println);

  }
}
