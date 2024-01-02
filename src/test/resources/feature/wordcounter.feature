Feature: Analyze the different phrases in WordCounter

  Scenario Outline: Analyze the sentences
    Given that "Diego" entered the WordCounter page
    When enter the phrase "<word>"
    And it generated an analysis of the entered word
    Then should can validate the Keyword Density
    And should look at the detail of the word
    Examples:
      | word                                                                                                                  |
      | lumu lumu lumu lumu lumu illuminates illuminates attacks and adversaries                                              |
      | lumu illuminates all attacks and adversaries                                                                          |
      | lumu lumu lumu lumu lumu illuminates illuminates attacks and adversaries lumu illuminates all attacks and adversaries |
