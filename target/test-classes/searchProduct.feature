@homepage

  Feature: search
    @search
    Scenario: User want to search an item
      Given user open browser
      When user enter a keyword in the search field "blouse"
      And user clicks search button
      Then search result will be displayed "blouse"