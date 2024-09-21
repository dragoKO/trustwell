Feature: Add Nutrient to Nutrients Dashboard

  @ui @smoke @regression @us_1
  Scenario Outline: Add a new nutrient with specified details
    Then I log in with valid credentials
    When I select Add Nutrient
    And I enter the following nutrient details:
      | Protein   | Carbs   | Fat   | Alcohol   | Sugar Alcohol  |
      | <protein> | <carbs> | <fat> | <alcohol> | <sugarAlcohol> |
    Then I should see the nutrient in the table
    And the calories calculation should be correct based on the entered values "<expectedValue>"

    Examples:
      | protein | carbs | fat | alcohol | sugarAlcohol | expectedValue |
      | 0.45    | 15    | 8   | 5       | 3            | 188           |


  Scenario: Edit nutrient
    Given a nutrient exists
    And I am on the nutrients dashboard page
    When I select the action "Edit"
    Then I can edit nutrient details
    And the data should change in the table

  Scenario: Delete nutrient
    Given a nutrient exists
    And I am on the nutrients dashboard page
    When I click the action "Delete"
    Then the nutrient should be deleted
