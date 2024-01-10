package manager;

import java.util.HashMap;
import java.util.Map;

import io.IOReader;
import io.IOWriter;
import task.Task;

public class TaskManager {
    private Map<Integer,Task> tasks;
    private IOWriter iowriter;
    private IOReader ioreader;

    public TaskManager(String path){
        this.tasks = new HashMap<Integer,Task>();
        this.iowriter = new IOWriter(path);
        this.ioreader = new IOReader(path);
    }

    /*Getters*/
    public Map<Integer,Task> getTasks(){
        return this.tasks;
    }

    public Task getTask(int taskId) throws ManagerException{
        if(!this.tasks.containsKey(taskId))
            throw new ManagerException("Task not found");
        return this.tasks.get(taskId);
    }

    /*Setters*/
    public void setTasks(Map<Integer,Task> tasks){
        this.tasks = new HashMap<Integer,Task>(tasks);
    }

    public void setIOReeder(String path){
        this.ioreader = new IOReader(path);
    }


    public void setIOWriter(String path){
        this.iowriter = new IOWriter(path);
    }
}
