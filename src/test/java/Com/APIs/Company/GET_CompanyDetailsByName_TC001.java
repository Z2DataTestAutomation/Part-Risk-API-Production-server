package Com.APIs.Company;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GET_CompanyDetailsByName_TC001 extends config {
    @Test
    public void CompanyDetailsByName() throws IOException {
        given().when()
                .get(url + '/' + "/api/CompanyDataSearch/CompanyDetailsByName?CompanyName=apple&Apikey="
                        + API_Key + "&CompanyID=1006096")
                .then().statusCode(200).statusLine("HTTP/1.1 200 OK")
                .header("Content-Type", "application/json; charset=utf-8")
                .body("numFound", equalTo(1))
                .body("results.CompanyID[0]", Is.is(1006096))
                .log().all();
    }

}
