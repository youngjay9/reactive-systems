package com.jay.operator;

import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxAndMonoMapOperator {

  public Flux<String> namesFlux() {
    return Flux
        .fromIterable(List.of("Jay", "Thuy", "Ping", "Ang"))
        .map(String::toUpperCase)
        .log();
  }

  public Mono<String> nameMono() {
    return Mono
        .just("Jay")
        .map(String::toUpperCase)
        .log();
  }


  public static void main(String[] args) {
    FluxAndMonoMapOperator operator = new FluxAndMonoMapOperator();

    operator.namesFlux()
        .subscribe(name -> {
          System.out.println("Flux name:" + name);
        });
  }

}
