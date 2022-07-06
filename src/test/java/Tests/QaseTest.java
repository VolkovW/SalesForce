package Tests;

import com.google.gson.Gson;
import APIClient.dto.Projects;
import lombok.var;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QaseTest {


    @Test
    public void GetAllProjects() {

        String body =
                given().
                    header("Token", "6db29bd8035ddcc276efc194fd5ae3b191cfc16b").
                when().
                    get("https://api.qase.io/v1/project").
                then().
                    statusCode(200).
                    extract().body().asString();

        System.out.println(body);

        Gson gson = new Gson();
        var projects =  gson.fromJson(body, Projects.class);
        System.out.println(projects);
    }
}