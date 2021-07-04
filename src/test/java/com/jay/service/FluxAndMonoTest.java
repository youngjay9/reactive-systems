package com.jay.service;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxAndMonoTest {

  @Test
  public void fluxTest() {

    Flux<String> strFlux = Flux
        .just("Spring", "Spring Boot", "reactive Spring")
//        .concatWith(Flux.error(new RuntimeException(
//            "My concat Flux exception!!"))) // 上面的 Flux 輸出完畢後，加入 Flux<RuntimeException>, 後面的 Flux 就不會再執行
        .concatWith(
            Flux.just("After runtimeException!!")) // 上面拋出 exception 後，Flux 就不會再 emit 任何 element
        .log(); // 將 Flux 與 subscriber 之間的交易都印出來

    strFlux
        .subscribe(
            System.out::println, // 取得 onNext 的 element
            (e) -> System.err.println(e), // 取得 onError 的 exception
            () -> System.out.println("My onComplete!!") // 取得 onComplete
        );
  }


  @Test
  void monoTest() {
    Mono<String> stringMono = Mono
        .just("Spring");

    stringMono
        .subscribe(
            System.out::println,
            (e) -> System.err.println(e),
            () -> System.out.println("Mono complete!!")
        );
  }
}
