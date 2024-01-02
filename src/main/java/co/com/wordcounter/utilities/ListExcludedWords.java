package co.com.wordcounter.utilities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ListExcludedWords {

    AND("and");

    private final String key;
}
