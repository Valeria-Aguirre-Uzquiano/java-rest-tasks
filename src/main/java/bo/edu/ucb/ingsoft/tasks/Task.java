package bo.edu.ucb.ingsoft.tasks;

public class Task {
    private int idTask; 
    private String title;
    private String detail;
    private String task_status;
    private int status;
    
    public Task(int idTask, String title, String detail, String task_status, int status){
        this.idTask = idTask;
        this.title = title;
        this.detail = detail;
        this.task_status = task_status;
        this.status = status;
    }

    public int getIdTask() {
        return idTask;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

    public String getTask_status() {
        return task_status;
    }

    public int getStatus() {
        return status;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setTask_status(String task_status) {
        this.task_status = task_status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
