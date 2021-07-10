@PositiveScenarios
Feature: :Positive Scenarios for Github Search Repository

  @PositiveSceanrio1
  Scenario Outline: Verify User is able search a repository when it exists in GitHub
    Given User navigates to "signUpPage"
    When User enters "<Repository Name>" in "searchbox_xpath" and press enter
    And Verify text displayed in "repositoryLinkText_xpath" is "<Repository Link Text>"

    Examples: 
      | Repository Name                   | Repository Link Text |
      | nitinmussani123/cucumberframework | nitinmussani123      |

  @API
  Scenario Outline: Hit API and print details in desired format
    Given User save "<Owner>" in "owner"
    And User save "<Repository Name>" in "repo"
    When User hits the GET api "getRepoGitHub" by replacing "owner;repo" and fetches "full_name;stargazers_count" and stores in data
    When User hits the GET api "getReleases" by replacing "owner;repo" and fetches "[0].name;$.size()" and stores in data
    When User prints the data on the console for the variables "full_name;stargazers_count;[0].name;$.size()"

    Examples: 
      | Repository Name | Owner   |
      | libgit2         | libgit2 |
