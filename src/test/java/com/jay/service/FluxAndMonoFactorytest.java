package com.jay.service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxAndMonoFactorytest {

  List<String> name = Arrays.asList("Jay", "Thuy", "Ping", "Ang");

  @Test
  void fluxFromStream() {
    Flux<String> stringFlux = Flux.fromStream(name.stream());

    stringFlux.subscribe(s->{
      System.out.println("Flux str:" + s);
    });
  }

  @Test
  void fluxUsingRange() {
    Flux<Integer> integerFlux = Flux.range(1,5);

    integerFlux.subscribe(i->{
      System.out.println("Flux integer:" + i);
    });

  }

  @Test
  void monoUsingSupplier() {

    Supplier<String> supplier = () -> "Jay";

    Mono<String> stringMono = Mono.fromSupplier(supplier);

    stringMono.subscribe(s->{
      System.out.println("Mono str:" + s);
    });

  }
}
