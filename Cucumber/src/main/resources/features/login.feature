Feature: Authorized user able to login
  As an authorized user, I should be able to login with username and password

  @Tester
  Scenario:
    Given user is on the login page
    When user logs in with user name and password
    Then verify that user is on the login page

