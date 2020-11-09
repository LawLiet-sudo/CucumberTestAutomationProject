Feature: As user, I want to be able to create new cars

  @add_car
  Scenario: 1. Add some car
    Given user is on the login page
    And user logs in as a "store manager"
    And user navigates to "Fleet" and "Vehicles"
    And user clicks on create car button
    When user adds new vehicle information
      | Licence Plate | SDET |
      | Model Year    | 2021 |

    And user clicks on save and close button

  @add_car_scenario_outline
  Scenario Outline: Add some car for <license plate>
    Given user is on the login page
    And user logs in as a "store manager"
    And user navigates to "Fleet" and "Vehicles"
    And user clicks on create car button
    When user adds new vehicle information
      | License Plate | <license plate> |
      | Model Year    | <model year>    |
    And user clicks on save and close button
    Examples: auto test data
      | license plate | model year |
      | Azamat        | 2020       |
      | Law           | 2021       |
      | Lite          | 2030       |
      | Esida         | 1999       |


