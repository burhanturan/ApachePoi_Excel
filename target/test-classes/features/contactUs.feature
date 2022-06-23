Feature: Contact Us Feature

  Scenario Outline: Contact Us scenario with different set of data
    Given user navigates to contact us page
    When user fills the form from the given sheetname "<SheetName>" and rownumber <RowNumber>
    And user clicks on send button
    Then user should see verify message

    Examples:
      | SheetName | RowNumber |
      | data      | 0         |
      | data      | 1         |