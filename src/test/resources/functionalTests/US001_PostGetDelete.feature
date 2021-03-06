Feature: As User I want to be able to perform DELETE, GET operation after POST So that I can validate final request

  @Test1
  Scenario: Verify DELETE, GET operation after POST
    Given User perform POST operation for "/posts" endpoint with body as
      | id | title              | author            |
      | 8  | API Testing Course | ExecuteAutomation |
    And User perform GET operation for path parameter "/posts/{postId}"
      | id | statusCode |
      | 8  | 200        |
    And User should see body with title as "API Testing Course"
    And User perform DELETE operation for "/posts/{postId}"
      | id |
      | 8  |
    And User perform GET operation for path parameter "/posts/{postId}"
      | id | statusCode |
      | 8  | 404        |
    And User should not see body with title as "API Testing Course"
