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

  Scenario Outline: Verify if the <city> city is in <country> country
    When I enter "/v2/networks" as a resource
    Then I verify the response code as 200
    And I verify the city "<city>" is in country "<country>"
    And I verify the latitude <latitude> and longitude <longitude>
    Examples:
      | city      | country | latitude | longitude |
      | Frankfurt | DE      | 50.1072  | 8.66375   |
      | Moscow    | RU      | 55.75    | 37.616667 |

  Scenario: Validate Field filtering response
    When I pass the filter fields in resource url
      | id              |
      | name            |
      | href            |
    And I enter "/v2/networks/visa-frankfurt" as a resource
    Then I verify the response code as 200
    And I verify the response is render only with filter fields
      | id              |
      | name            |
      | href            |

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