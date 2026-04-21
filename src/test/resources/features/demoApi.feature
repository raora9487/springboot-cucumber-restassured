@demoApiTests
Feature: Simple API Tests

  Background:
    Given user sets base URI

  Scenario: Get all posts
    When user sends GET request to "/posts"
    Then response status code should be 200

  Scenario: Get single post
    When user sends GET request to "/posts/1"
    Then response status code should be 200
    And response should contain "userId"

  Scenario: Create post
    Given user sets request body
      | title  | foo  |
      | body   | bar  |
      | userId | 1    |
    When user sends POST request to "/posts"
    Then response status code should be 201

  Scenario: Delete post
    When user sends DELETE request to "/posts/1"
    Then response status code should be 200