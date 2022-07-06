package APIClient.Tests;


import APIClient.ProjectApi;
import org.testng.annotations.BeforeMethod;

public class BaseApiTest {
    public ProjectApi projectApi;

    @BeforeMethod
    public void setup(){
        projectApi = new ProjectApi();

    }
}
