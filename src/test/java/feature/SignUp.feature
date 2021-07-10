@PositiveScenarios @SignUpRegression
Feature: :Positive Scenarios for Sigup

  @PositiveSceanrio1
  Scenario Outline: Verify User is able to Sign Up successfully by selecting terms and conditions and subscribtion checkbox
    Given User navigates to "signUpPage"
    And Generate random valid email id and store in "$workemail"
    When User enters "<Username>" in "username_id"
    And User enters "$workemail" in "workemail_id"
    And User enters "<Password>" in "password_id"
    And Clicks on "signupterms_xpath"
    And Clicks on "signupupdates_xpath"
    And Clicks on "submit_xpath"
    And Verify text displayed in "checkEmailMessage_xpath" is "<Check Email Message>"

    Examples: 
      | Username | Password   | Check Email Message |
      | name1    | successful | Check your email    |

  @PositiveSceanrio2
  Scenario Outline: Verify User is able to Sign Up successfully by selecting terms and conditions only
    Given User navigates to "signUpPage"
    And Generate random valid email id and store in "$workemail"
    When User enters "<Username>" in "username_id"
    And User enters "$workemail" in "workemail_id"
    And User enters "<Password>" in "password_id"
    And Clicks on "signupterms_xpath"
    And Clicks on "submit_xpath"
    And Verify text displayed in "checkEmailMessage_xpath" is "<Check Email Message>"

    Examples: 
      | Username | Password   | Check Email Message |
      | name1    | successful | Check your email    |

  @PositiveSceanrio3
  Scenario Outline: Verify user is able to sign up with warning messages for password lenght - Password - <Password>, Message - <Password Hint>
    Given User navigates to "signUpPage"
    And Generate random valid email id and store in "$workemail"
    When User enters "<Username>" in "username_id"
    And User enters "$workemail" in "workemail_id"
    And User enters "<Password>" in "password_id"
    And Verify text displayed in "passwordhint_xpath" is "<Password Hint>"
    And Clicks on "signupterms_xpath"
    And Clicks on "submit_xpath"
    And Verify text displayed in "checkEmailMessage_xpath" is "<Check Email Message>"

    Examples: 
      | Username | Password                  | Password Hint  | Check Email Message |
      | name1    | successf                  | So-so password | Check your email    |
      | name1    | successfullperson         | Good password  | Check your email    |
      | name1    | successfullpersonpassword | Great password | Check your email    |

  @PositiveSceanrio4
  Scenario Outline: Verify Terms and Privacy links and navigations to respective page - <Text>
    Given User navigates to "signUpPage"
    When Clicks on "<Page Locator>"
    Then Verify user is navigate to new page and verify text in "<Header Locator>" is "<Text>"

    Examples: 
      | Page Locator  | Header Locator       | Text             |
      | terms_xpath   | terms_header_xpath   | Terms of Service |
      | privacy_xpath | privacy_header_xpath | Privacy Policy   |

  @PositiveSceanrio5
  Scenario Outline: Verify integration of Sign Up with <Page Locator>
    Given User navigates to "signUpPage"
    When Clicks on "<Page Locator>"
    And Clicks on "termsCheckBoxSocial_xpath"
    And Clicks on "continueToSignUpCheckbox_xpath"
    Then Verify page title contains text "<Text>"

    Examples: 
      | Page Locator             | Text     |
      | signUpWithGoogle_id      | Google   |
      | signUpWithSlack_id       | Slack    |
      | signUpWithApple_id       | Apple    |
      | signUpWithMicrosoft_id   | account  |
      | signUpWithFacebook_xpath | Facebook |
