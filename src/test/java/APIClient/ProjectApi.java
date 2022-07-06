package APIClient;

import APIClient.dto.Project;
import com.google.gson.Gson;

public class ProjectApi extends BaseApi {

    public void createNewProject(Project project) {
        post(gson.toJson(project), "project");
    }

    public Project getProjectByCode(String code) {

        return gson.fromJson(get("project/" + code).path("result").toString(), Project.class);
    }
}
