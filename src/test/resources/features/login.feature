Feature: Application Login
  As a user when I enter valid user name and password I should be logged into the application
  so that I can use my user account specific functions

  Scenario: Successful login
    Given I am on the login page
    When I enter a valid user name and password
    Then I should not be logged in
