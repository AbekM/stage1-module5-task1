package com.epam.mjc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {


  public Predicate<List<String>> isValuesStartWithUpperCase () {
    return x -> {
      for (String s : x) {
        if (Character.isLowerCase(s.charAt(0)) || Character.isDigit(s.charAt(0))) {
          return false;
        }
      }
      return true;
    };
  }

  public Consumer<List<Integer>> addEvenValuesAtTheEnd () {
    return x -> {
      List<Integer> evens = x.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
      x.addAll(evens);
    };
  }

  public Supplier<List<String>> filterCollection (List<String> values) {
    return () -> values.stream()
        .filter(s -> Character.isUpperCase(s.charAt(0)))
        .filter(s -> s.endsWith("."))
        .filter(s -> Arrays.stream(s.split(" ")).count() > 3).collect(
            Collectors.toList());
  }

  public Function<List<String>, Map<String, Integer>> stringSize () {
    return x -> {
      Map<String, Integer> result = new HashMap<>();
      for (String s : x) {
        result.put(s, s.length());
      }
      return result;
    };
  }

  public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList () {
    return (list1, list2) -> {
      List<Integer> result = new ArrayList<>();
      result.addAll(list1);
      result.addAll(list2);
      return result;
    };
  }
}
