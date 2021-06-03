package com.jay.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxAndMonoGeneratorService {

  public Flux<String> namesFlux() {
    return Flux.fromIterable(
        List.of("Jay", "Thuy", "Ping", "Ang"))
        .log(); // Flux is a publisher from DB or remote service
  }

  /**
   * 將每一個 element 直接 transform(map) 成另一個 element
   * @return
   */
  public Flux<String> namesFluxMap() {
    return Flux
        .fromIterable(List.of("Jay", "Thuy", "Ping", "Ang"))
        .map(String::toUpperCase)
        .log();
  }

  public Mono<String> nameMonoMap() {
    return Mono
        .just("Jay")
        .map(String::toUpperCase)
        .log();
  }

  /**
   * Flux 內的元素是 immutable, 無法透過任何 operator 進行改變
   *
   * @return
   */
  public Flux<String> namesFluxImmutability() {
    var namesFlux = Flux
        .fromIterable(List.of("jay", "thuy", "ping", "ang"));

    namesFlux.map(String::toUpperCase); // 用 test 進行測試, 會發現裡面的元素沒變成 uppercase

    return namesFlux;
  }


  /**
   * 將每一個 element flatten(攤平)，Ex: List、Array、String
   * transform(map) 變成多個 element，Ex: List or Array
   * or Flux<String> 這種情境使用：flatMap， 有 one to many 的概念
   *
   * @return
   */
  public Flux<String> namesFluxFlatMap() {
    return Flux.fromIterable(List.of("jay", "thuy", "ping", "ang"))
        // 將每一個 String transform(map) 成 Flux<String>
        .flatMap(n -> splitString(n))
        .log();
  }


  /**
   * 將字串轉成字串陣列，轉換成 Flux<String> 一個一個輸出 jay => Flux(j,a,y)
   *
   * @param name
   * @return
   */
  public Flux<String> splitString(String name) {
    var stringArray = name.split("");
    return Flux.fromArray(stringArray);
  }

  public Mono<String> nameMono() {
    return Mono.just("Jay")
        .log();
  }

  public static void main(String[] args) {
    FluxAndMonoGeneratorService service = new FluxAndMonoGeneratorService();

    // 跟 Flux 進行 subscribe 才會印出 publisher 跟 subscriber 之間的互動：onSubscribe(...)、request(...)、onNext(..)
//    service.namesFlux()
//        .subscribe(n -> {
//          System.out.println("Family name:" + n);
//        });
//
//    service.nameMono().subscribe(n -> {
//      System.out.println("Mono name:" + n);
//    });

//    service.namesFluxFlatMap()
//        .subscribe(n -> {
//          System.out.println("FlatMap:" + n);
//        });

//    String word = "Hello";
//    String[] array = word.split("");
//    Stream<String> stream = Arrays.stream(array);
//    stream.forEach(s->{
//      System.out.println(s);
//    });

    List<String> list = List.of("Hello", "World");

    list.stream()
        .map(s -> s.split(""))
        .flatMap(Arrays::stream);


  }
}
