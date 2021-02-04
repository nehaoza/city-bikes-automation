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
  }

  @Then("I verify the response code as {int}")
  public void i_verify_the_response_code_as(Integer statusCode) {
    response.statusCode(statusCode);
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

  @When("I send the {string} http method")
  public void i_send_the_post_http_method(String string) {
    switch (string) {
      case "post" :
        response = request.post().then();
        break;
      case "put" :
        response = request.put().then();
        break;
      case "delete":
        response = request.delete().then();
        break;
    }
  }


/*  @Then("I verify the json schema of the response")
  public void i_verify_the_json_schema_of_the_response() {
    response.body(JsonSchemaValidator
        .matchesJsonSchemaInClasspath("city-bikes-json-schema.json"));
  }*/

}
