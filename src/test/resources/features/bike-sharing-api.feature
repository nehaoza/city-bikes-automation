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

  Scenario: Incorrect URL in GET request
    And I enter "/v2/networks-invalid-url" as a resource
    Then I verify the response code as 404

#  Scenario Outline: Verify response code after sending <http_method> http method
#    When I enter "/v2/networks" as a resource
#    When I send the "<http_method>" http method
#    Then I verify the response code as 404
#
#    Examples:
#      | http_method |
#      | post        |
#      | put         |
#      | delete      |