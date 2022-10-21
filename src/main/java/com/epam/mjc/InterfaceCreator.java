package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        Predicate<String> startsWithUpCase = text -> Character.isUpperCase(text.charAt(0));
        Predicate<List<String>> allWordsStartsWithUpCase = temp -> {
            boolean result = true;
            for (String current : temp) {
                result = result && startsWithUpCase.test(current);
            }
            return result;
        };
        return allWordsStartsWithUpCase;
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        Consumer<List<Integer>> isNumberEven = num -> {
            int length = num.size();
            for (int i = 0; i < length; i++) {
                if(num.get(i) % 2 == 0){
                    num.add(num.get(i));
                }
            }
        };
        return isNumberEven;
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        Supplier<List<String>> wordsCompareToConditions = () -> {
            List<String> temp = new ArrayList<>();
            for (String value : values) {
                if (Character.isUpperCase(value.charAt(0)) &&
                        value.charAt(value.length() - 1) == '.' &&
                        value.split(" ").length > 3){
                    temp.add(value);
                }
            }
            return temp;
        };
        return wordsCompareToConditions;
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        Function<List<String>, Map<String, Integer>> wordAndSize = list -> {
            Map<String, Integer> result = new HashMap<>();
            for (String currentList : list) {
                result.put(currentList, currentList.length());
            }
            return result;
        };
        return wordAndSize;
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        BiFunction<List<Integer>, List<Integer>, List<Integer>> concatenate = (listFirst, listSecond) -> {
            listFirst.addAll(listSecond);
            return listFirst;
        };
        return concatenate;
    }

}
