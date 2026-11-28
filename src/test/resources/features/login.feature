Feature: Login Feature of the Para Bank Application

  Background: When Playwright enters the QA Environment

  Scenario: Successful Login with Valid Credentials
    Given User is on the Para Bank Login Page
    When User enters valid username and password
    Then User Clicks on Login Button
    Then User should be Redirected to the Main Page of the Para Bank Application


  Scenario: Unsuccesful Login with Invalid Credentials
    Given User is on the Para Bank Login Page
    When User enters invalid username and password
    Then User Clicks on Login Button
    Then User should see an error message indicating invalid login credentials


  