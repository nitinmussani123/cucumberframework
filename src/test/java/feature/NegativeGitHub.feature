@tag @NegativeScenarios @SignUpRegression
Feature: :Negative Scenarios for GitHub Search Repository

  @NegativeSceanrio1
  Scenario Outline: Verify We could not perform this search text when user enters invalid repo name
    Given User navigates to "signUpPage"
    When User enters "<Repository Name>" in "searchbox_xpath" and press enter
    And Verify text displayed in "wecouldnotperform_xpath" is "<Repository Link Text>"

    Examples: 
      | Repository Name    | Repository Link Text             |
      | asdbasdas@asdasdas | We could not perform this search |
