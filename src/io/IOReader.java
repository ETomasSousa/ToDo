package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import task.Task;
import task.TaskException;
import task.Task.State;

public class IOReader {
    private String path;

    public IOReader(){
        this.path = "/home/skyrush/Desktop";
    }

    public IOReader(String path){
        this.path = path;
    }

    public List<Task> readTask() throws NumberFormatException, TaskException{
        List<Task> tasks = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line using the semicolon as a delimiter
                String[] parts = line.split(";");
                State state;

                if(parts[3].equals("NEW"))
                    state = State.NEW;
                else if(parts[3].equals("URGENT"))
                    state = State.URGENT;
                else
                    state = State.ON_GOING;
                
                // Assuming you have a class named Item with the appropriate fields
                Task task = new Task(Integer.parseInt(parts[0]), parts[1], parts[2],LocalDate.parse(parts[3]), state);
                
                // Add the item to the list
                tasks.add(task);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tasks;
    }
}
