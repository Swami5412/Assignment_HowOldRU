Feature:verify user must get age with name on howoldru web

  Background:
    Given user is on Howoldru web page
  @smoke
  Scenario Outline:verify age calculation by entering input details
    When user enters "<name>" in required field
    And enters "<birthday>" in birthday-input box
    And click on submit button
    Then user must see name with age no.
    Examples:
      | name  | birthday |
      | Harry | 21041967 |
      | carol | 14031978 |

  @smoke
  Scenario:verify when user enters invalid input
    When user enters name "peter" and dob "23072025" in require fields
    And click on submit button
    Then user must get error message

  @smoke
  Scenario:verify when user clicks on submit button without input
   When click on submit button
   Then notify by text

 #below Scenario is in requirement scope or not as my tests are passing with numerical formate datatype in name field
  @smoke
  Scenario:verify when user enters number formate input in name box
    When user enters name "4356gf" and dob "24051968" in required fields
    Then click on submit button




