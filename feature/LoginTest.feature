Feature: Test Petstore Login

  Scenario Outline: Test Petstore login
    Given I open Chrome browser
    And I go to Petstore page
    And I enter Petstore
    And I go to login page
    When I enter valid "<username>" and "<password>" combination
    Then I should be able to login successfully
    
    Examples: 
      | username  | password |
      | j2ee | j2ee |
      | quality1 | 12345678 |
      | quality2 | 12345678 |