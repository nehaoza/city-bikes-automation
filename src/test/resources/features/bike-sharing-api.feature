Feature: My First feature

  Background:
    Given I access the bike sharing api url

  Scenario: Verify schema
    When I enter "/v2/networks" as a resource
    Then I verify the response code as 200
    And I verify the content type as json



  Scenario: Verify networks size
    When I enter "/v2/networks" as a resource
    Then I verify the response code as 200
    And I verify the size of networks is greater than 0

 Scenario:Verify response code after sending post http meathod
   When I send the post http meathod
   Then Response should be 404