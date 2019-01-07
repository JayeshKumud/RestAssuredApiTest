Feature: As user,
  I want to be abe to perform GET request
  So that i can see the detail response

  Background: Perform URL using REST Assured
    Given User perform "http://localhost:3000" URL using REST Assured

  Scenario: Perform GET operation using REST Assured
    Given User perform GET operation for "/post" end point
    And User perform GET operation for "1" params
    Then User should see the author name as "Jayesh"