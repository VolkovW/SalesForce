package APIClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseApi {

    Gson gson = new GsonBuilder().
            excludeFieldsWithoutExposeAnnotation().
            create();

    RequestSpecification requestSpecification;

    String baseUrl = "https://api.qase.io/v1/";

    public BaseApi() {
        requestSpecification =
                given().
                        header("Content-Type", "application/json").
                        header("Token", "6ba6b3ed1f4feb3d9473e7595f2c50bebd9a3805").
                        log().all();
    }

    protected Response post(String body, String uri) {

        return requestSpecification.
                    body(body).
                when().
                  log().all().
                    post(baseUrl + uri).
                then().
                    statusCode(200).
                    log().all().
                    extract().response();
    }

    protected Response get(String uri) {
        return requestSpecification.
                when().
                  get("https://api.qase.io/v1/" + uri).
                then().
                    log().all().
                    statusCode(200).
                    extract().response();
    }


}
