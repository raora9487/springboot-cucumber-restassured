Feature: CRUD API tests

  @crud
  Scenario: Get a post by id
    Given I send a GET request to "/posts/1"
#    Then the status code should be 200
#    And the response should contain "id" as "1"
