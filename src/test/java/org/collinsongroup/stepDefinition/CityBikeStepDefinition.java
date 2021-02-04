package org.collinsongroup.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.collinsongroup.bean.Root;
import org.hamcrest.Matchers;

import java.util.*;

import static io.restassured.RestAssured.given;

public class CityBikeStepDefinition {

  private RequestSpecification request;
  private ValidatableResponse response;

  @Given("I access the bike sharing api url")
  public void i_access_the_bike_sharing_api_url() {
    request = given()
        .baseUri("http://api.citybik.es");
  }

  @When("I enter {string} as a resource")
  public void i_enter_as_a_resource(String string) {
    request.basePath(string);
    response = request.get().then();
    ArrayList<LinkedHashMap<String, Object>> locationData = request.get().getBody().jsonPath().get("networks");
//request.get().getBody().jsonPath().get("networks.findAll{a -> a.location.city == 'Frankfurt'}")

   /* Set<String> company = new HashSet<>();
    for (LinkedHashMap<String, Object> locationInfo : locationData) {
      if(locationInfo.get("company") instanceof String) {
        company.add(locationInfo.get("company").toString());
      } else {
        company.add(((List<String>) locationInfo.get("company")).get(0));
      }*/
      /*if (locationInfo.get("city").equals("Frankfurt") && locationInfo.get("country").equals("DE")) {
        System.out.println(locationInfo);
      } else {
        System.out.println("No location information found for city Frankfurt in Germany");
      }*/

  }

  @Then("I verify the response code as {int}")
  public void i_verify_the_response_code_as(Integer int1) {
    response.statusCode(int1);
  }

  @Then("I verify the content type as json")
  public void i_verify_the_content_type_as_json() {
    response.header("Content-Type", ContentType.JSON.toString());
  }

  @Then("I verify the size of networks is greater than {int}")
  public void i_verify_the_size_of_networks_is_greater_than(Integer int1) {
    response.assertThat().body("networks.size()", Matchers.greaterThan(0));
    Root r = response.extract().as(Root.class);
    System.out.println(r);
  }


/*  @Then("I verify the json schema of the response")
  public void i_verify_the_json_schema_of_the_response() {
    response.body(JsonSchemaValidator
        .matchesJsonSchemaInClasspath("city-bikes-json-schema.json"));
  }*/

}
