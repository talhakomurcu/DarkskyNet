Feature:Main Page Test
  Scenario:Verifying lowest and highest temperature
    Given User goes to main page
    When User enters location
    And User presses enter
    And User gets lowest temperature
    And User gets highest temperature
    Then Verify lowest and highest temps correct