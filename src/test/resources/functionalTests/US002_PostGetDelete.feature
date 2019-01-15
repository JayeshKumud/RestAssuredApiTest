Feature: As User I want to be able to perform DELETE, GET operation after POST So that I can validate final request

  @Test2
  Scenario: Verify post operation using path params
    Given User perform POST operation for "/posts/{profileNumber}/profile" endpoint with below body
      | profile | name   |
      | 1       | Jayesh |
    And User should see body has name "Jayesh"
