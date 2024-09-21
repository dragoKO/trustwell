Feature: Add Nutrient to Nutrients Dashboard

  Scenario Outline: Add a new nutrient with specified details
    Given I am on the Nutrients login page
    Then I log in with valid credentials
    When I select "Add Nutrient"
    And I enter the following nutrient details:
      | Protein   | Carbs   | Fat   | Alcohol   | Sugar Alcohol  |
      | <protein> | <carbs> | <fat> | <alcohol> | <sugarAlcohol> |
    Then I should see the nutrient in the table
    And the calories calculation should be correct based on the entered values "<expectedValue>"

    Examples:
      | protein | carbs | fat | alcohol | sugarAlcohol | expectedValue |
      | 0.45    | 15    | 8   | 5       | 3            | 188           |


  Scenario 2: edit nutrient
    Given a nutrient
    And I am on the nutrients dashboard page
    When I select the action edit
    Then I can edit nutrient details
    And the data should change in the table.

  Scenario 3: delete nutrient
    Given a nutrient
    And I am on the nutrients dashboard page
    When I click the action x
    Then the nutrient should be deleted.
