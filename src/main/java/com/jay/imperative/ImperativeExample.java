package com.jay.imperative;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ImperativeExample {

  public static void main(String[] args) {

    var nameList = List.of("jay", "thuy", "ping");

    var newNameList = nameGraterThanSize(nameList, 3);

    System.out.println(newNameList);

  }

  private static String getNameBirth(String name) {
    Map<String, String> mymap = new HashMap<>();
    mymap.put("jay", "0807");
    mymap.put("thuy", "0326");
    mymap.put("ping", "0620");

    return mymap.get(name);
  }

  private static List<String> nameGraterThanSize(List<String> nameList, int size) {
    return nameList
        .stream()
        .filter(n -> n.length() > size)
        .map(ImperativeExample::getNameBirth)
        .map(String::toUpperCase)
        .collect(Collectors.toList());
  }

}
