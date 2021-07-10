Feature: Reddit

  Scenario: Automate Reddit
    Given User launches reddit and logs in
    Then User is able to view subscribed subreddits
    When User selects first subreddit
    Then User is able to view details of the selected subreddit
    When User comments his name with the current time
    Then Comment is successfully made and post is closed
    When User downvotes a post
    And User upvotes a post
