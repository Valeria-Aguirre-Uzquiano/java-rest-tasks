package bo.edu.ucb.ingsoft.tasks;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
public class Tasks {

    List<Task> taskList = new ArrayList();
    @GetMapping(path="/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Task> listAll(){
        return taskList;
    }
    
    @PostMapping(path="/tasks", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Task listAll(@RequestBody Task task){
        taskList.add(task);
        return task;
    }
    
}
