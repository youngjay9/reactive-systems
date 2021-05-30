package com.jay.service;

import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxAndMonoGeneratorService {

  public Flux<String> namesFlux() {
    return Flux.fromIterable(
        List.of("Jay", "Thuy", "Ping", "Ang"))
        .log(); // Flux is a publisher from DB or remote service
  }

  public Mono<String> nameMono() {
    return Mono.just("Jay")
        .log();
  }

  public static void main(String[] args) {
    FluxAndMonoGeneratorService service = new FluxAndMonoGeneratorService();

    // 跟 Flux 進行 subscribe 才會印出 publisher 跟 subscriber 之間的互動
    service.namesFlux()
        .subscribe(n -> {
          System.out.println("Family name:" + n);
        });

    service.nameMono().subscribe(n -> {
      System.out.println("Mono name:" + n);
    });
  }
}
