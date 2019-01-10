#Feature: As user,
#  I want to be abe to perform GET request
#  So that i can see the detail response
#
#  Scenario: Verify one author of the Request
#    Given User perform GET operation for "/posts" endpoint
#    Then User should see the author name as "Jayesh"
#
#  Scenario: Verify collection of authors of the request
#    Given User perform GET operation for "/posts" end point
#    Then User should see the authors name
#
#  Scenario: Verify path parameter feature for the request
#    Given User perform GET operation for "/post" end point
#    Then User should see list of Path parameter
#
#  Scenario: Verify Query parameter feature for the request
#    Given User perform GET operation for "/post" end point
#    Then User should see list of Query parameter
#    #And User perform GET operation for "1" params
#
#  Scenario: Verify post operation using path params
#    Given User perform POST operation for "/posts/{profileNumber}/profile" endpoint with below body
#      | profile | name   |
#      | 1       | Jayesh |
#    And User should see body has name "Jayesh"