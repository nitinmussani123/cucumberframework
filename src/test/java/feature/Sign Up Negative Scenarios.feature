@tag @NegativeScenarios @SignUpRegression
Feature: :Negative Scenarios for Sigup

  @NegativeSceanrio1
  Scenario Outline: Verify Error message is displayed when - Username = <Username>, Password = <Password>, Work Email = "WorkEmail" Message = <Message>
    Given User navigates to "signUpPage"
    When User enters "<Username>" in "username_id"
    And User enters "<WorkEmail>" in "workemail_id"
    And User enters "<Password>" in "password_id"
    And Clicks on "signupterms_xpath"
    And Clicks on "submit_xpath"
    And Verify text displayed in "<Error Locator>" is "<Message>"

    Examples: 
      | Username | Password   | WorkEmail   | Message                                      | Error Locator       |
      | name1    | successful |             | Please enter your email address.             | signUpError_xpath   |
      |          | successful | asdb@sad.co | Please enter your name.                      | signUpError_xpath   |
      | name1    |            | abcw@ckd.co | Please enter your password.                  | passwordError_xpath |
      | name1    | succ       | abcw@ckd.co | Please use 8+ characters for secure password | passwordhint_xpath  |

  @NegativeSceanrio2
  Scenario Outline: Verify user is not able to enter incorrect work email id sytax - <WorkEmail>
    Given User navigates to "signUpPage"
    When User enters "<Username>" in "username_id"
    And User enters "<WorkEmail>" in "workemail_id"
    And User enters "<Password>" in "password_id"
    And Clicks on "signupterms_xpath"
    And Clicks on "submit_xpath"
    And Verify text displayed in "<Error Locator>" is "<Message>"

    Examples: 
      | Username | Password   | WorkEmail | Message                                                                           | Error Locator     |
      | name1    | successful | abcd      | This doesn’t look like an email address. Please check it for typos and try again. | signUpError_xpath |
      | name1    | successful | asda@c.s  | This doesn’t look like an email address. Please check it for typos and try again. | signUpError_xpath |

  @NegativeSceanrio3
  Scenario Outline: Verify user is not able sign up without selecting Terms and Privacy Policy
    Given User navigates to "signUpPage"
    And Generate random valid email id and store in "$workemail"
    When User enters "<Username>" in "username_id"
    And User enters "$workemail" in "workemail_id"
    And User enters "<Password>" in "password_id"
    And Clicks on "signupupdates_xpath"
    And Clicks on "submit_xpath"
    And Verify text displayed in "signUpError_xpath" is "<Message>"

    Examples: 
      | Username | Password   | Message                                 |
      | name1    | successful | Please agree with the Terms to sign up. |

  @NegativeSceanrio4
  Scenario Outline: Verify User is unable to Sign Up when already signed up - <Message>
    Given User navigates to "signUpPage"
    When User enters "<Username>" in "username_id"
    And User enters "sadas@sdaa.co" in "workemail_id"
    And User enters "<Password>" in "password_id"
    And Clicks on "signupterms_xpath"
    And Clicks on "submit_xpath"
    And Verify text displayed in "signUpError_xpath" is "<Message>"

    Examples: 
      | Username | Password   | Message                                 |
      | name1    | successful | Sorry, this email is already registered |
