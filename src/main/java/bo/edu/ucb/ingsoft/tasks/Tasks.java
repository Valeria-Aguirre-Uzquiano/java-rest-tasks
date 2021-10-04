package bo.edu.ucb.ingsoft.tasks;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
public class Tasks {
    private int surrogateKey = 1;

    List<Task> taskList = new ArrayList();
    @GetMapping(path="/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Task> listAll(){
        return taskList;
    }
    
    @PostMapping(path="/tasks", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Task listAll(@RequestBody Task task){
        task.setIdTask(surrogateKey);
        taskList.add(task);
        surrogateKey++;
        return task;
    }

    @GetMapping(path="/tasks/{idTask}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Task getTask(@PathVariable int idTask){
        Task task = findTaskById(idTask);
        if(task == null) {
            throw new RuntimeException("Task id not found - "+idTask);
        }
        return task;
    }

    public Task findTaskById(int idTb){
        Task tb = null;
        for (int i=0; i< taskList.size(); i++){
            if(idTb == taskList.get(i).getIdTask()){
                tb = taskList.get(i);
                break;
            }
        }        
        return tb;
    }
 /*   @PutMapping(path="/tasks/{idTask}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTask(@PathVariable int idTask, @RequestBody Task t) {
        Task task = findTaskById(idTask);
        if(task != null) {
            task.setTitle(t.getTitle());
            task.setDetail(t.getDetail());
        }        
    }*/
/*
    @PutMapping(path="/tasks/{idTask}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStateTask(@PathVariable int idTask, @RequestParam(value = "task_tatus", defaultValue = "PENDING") String task_status) {
        System.out.println("estado que llega"+ task_status);
        /*Task task = findTaskById(idTask);
        if(task != null) {
            task.setTitle(t.getTitle());
            task.setDetail(t.getDetail());
        }        
    }*/

    @PutMapping(path="/tasks/{idTask}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String updateTask(@RequestParam(required = false) String task_status, @PathVariable int idTask, @RequestBody Task t) { 
        String msg = null;
        Task task = findTaskById(idTask);
        if(task != null) {
            if (task_status == null) {
                task.setTitle(t.getTitle());
                task.setDetail(t.getDetail());
                msg = "task modified";
            }else{
                task.setTask_status(task_status);
                msg = "task status modified";
            }
           
        }
        return msg;
    }

    @DeleteMapping(path="/tasks/{idTask}")
    public void DeleteTask(@PathVariable int idTask) {
        Task task = findTaskById(idTask);
        if(task != null) {
            task.setStatus(0);
        }      
    }
    
}
