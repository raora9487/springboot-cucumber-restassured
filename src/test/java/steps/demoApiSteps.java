package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import utils.ApiUtils;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class demoApiSteps {

    Response response;
    Map<String, Object> body = new HashMap<>();

    @Given("user sets base URI")
    public void setBaseUri() {
        ApiUtils.setBaseUri();
    }

    @Given("user sets request body")
    public void setRequestBody(DataTable dataTable) {
        body = dataTable.asMap(String.class, Object.class);
    }

    @When("user sends GET request to {string}")
    public void sendGet(String endpoint) {
        response = ApiUtils.get(endpoint);
    }

    @When("user sends POST request to {string}")
    public void sendPost(String endpoint) {
        response = ApiUtils.post(endpoint, body);
    }

    @When("user sends DELETE request to {string}")
    public void sendDelete(String endpoint) {
        response = ApiUtils.delete(endpoint);
    }

    @Then("response status code should be {int}")
    public void validateStatus(int code) {
        assertEquals(code, response.getStatusCode());
    }

    @Then("response should contain {string}")
    public void validateContains(String key) {
        assertTrue(response.getBody().asString().contains(key));
    }
}