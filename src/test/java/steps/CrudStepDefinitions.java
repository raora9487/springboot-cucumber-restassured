package steps;

import config.ApiConfig;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reporting.ReportUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
public class CrudStepDefinitions {

    @Autowired
    private ApiConfig apiConfig;

    private Response response;

    @Given("I send a GET request to {string}")
    public void i_send_a_get_request(String endpoint) {

        System.out.println("this is the url for API "+apiConfig.getBaseUrl());
        ReportUtils.logInfo("logs are working fine from extent===");



//        response = given()
//                .baseUri(apiConfig.getBaseUrl())
//                .when()
//                .get(endpoint)
//                .then()
//                .extract()
//                .response();
    }

    @Then("the status code should be {int}")
    public void the_status_code_should_be(int statusCode) {
        assertThat(response.getStatusCode(), equalTo(statusCode));
    }

    @Then("the response should contain {string} as {string}")
    public void the_response_should_contain(String field, String value) {
        assertThat(response.jsonPath().getString(field), equalTo(value));
    }
}
