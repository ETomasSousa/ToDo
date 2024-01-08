package task;

import java.time.LocalDate;

public class Task{

    private enum State{
        NEW,
        URGENT,
        ON_GOING
    }

    private int taskId;
    private String title;
    private String description;
    private LocalDate date;
    private State state;

    public Task(Task task){
        this.taskId = task.taskId;
        this.title = task.title;
        this.description = task.description;
        this.date = task.date;
        this.state = task.state;
    }

    public Task(int taskId, String title, String description, LocalDate date, State state) throws TaskException{
        setTaskId(taskId);
        setTitle(title);
        setDescription(description);
        setDate(date);
        setState(state);
    }

    /*Getters*/
    public int getTaskId(){
        return this.taskId;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public LocalDate getDate(){
        return this.date;
    }

    public State getState(){
        return this.state;
    }

    /*Setters*/
    public void setTaskId(int taskId){
        this.taskId = taskId;
    }

    public void setTitle(String title) throws TaskException{
        if(title.equals(""))
            throw new TaskException("Invalid Title");
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public void setState(State state){
        this.state = state;
    }

    /* Verification of equality between task and object*/
    public boolean equals(Object o) {

        /* Verification of identical objects*/
        if (this == o)
            return true;

        /* Verification of class equality*/
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;

        /* Verifications of properties*/
        Task task = (Task) o;
        return this.taskId == task.taskId || this.title.equals(task.title) || this.description.equals(task.description) 
        || this.date.equals(task.date) || this.state.equals(task.state);
    }

    /* Cloning of a Task*/
    public Task clone() {
        return new Task(this);
    }

    /* Conversion of a Task to string format*/
    public String toString() {

        /* Inicialization of an string constructor*/
        StringBuilder builder = new StringBuilder();

        /* Builder of a String */
        builder.append("\nTitle: ").append(this.title);
        builder.append("\nDescription: ").append(this.description);
        builder.append("\n\nDate: ").append(this.date);
        builder.append("\tState: ").append(this.state.toString());

        /* Return of the String built */
        return builder.toString();
    }
}