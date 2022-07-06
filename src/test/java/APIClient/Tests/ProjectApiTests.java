package APIClient.Tests;

import APIClient.dto.Counts;
import APIClient.dto.Project;
import org.testng.annotations.Test;


public class ProjectApiTests extends BaseApiTest{

    @Test
    public void CreateProject(){

        Project project = Project.
                builder().
                code("TMS1").
                title("trr").
                counts(new Counts(123)).
                description("sdfgsdg").
                build();

        projectApi.createNewProject(project);
    }



    @Test
    public void getProjectByCode(){

      Project actual = projectApi.getProjectByCode("TMS1");
      System.out.println(actual);

    }
}
