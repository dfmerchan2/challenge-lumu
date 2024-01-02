package co.com.wordcounter.utilities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Operations {
    public static String getCountWords(String word) {
        return String.valueOf(getListWords(word).size());
    }

    public static String getCountCharacters(String word) {
        return String.valueOf(word.length());
    }

    public static List<String> getListWords(String word) {
        return Arrays.stream(word.split(" ")).toList();
    }

    public static String getValue(Target element, Actor actor) {
        return element.resolveFor(actor).getText().split(" ")[0];
    }

    public static Map<String, Long> getKeywordDensity(List<String> word) {
        return word.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static List<String> removeExcludedWords(String word) {
        return getListWords(word).stream()
                .filter(Operations::theWordIsExcluded)
                .collect(Collectors.toList());
    }

    public static boolean theWordIsExcluded(String valor) {
        return Arrays.stream(ListExcludedWords.values())
                .anyMatch(enumValue -> !enumValue.name().equalsIgnoreCase(valor));
    }

}
