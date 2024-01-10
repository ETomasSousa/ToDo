package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import task.Task;

public class IOWriter {
    private String path;

    public IOWriter(){
        this.path = "/home/skyrush/Desktop";
    }

    public IOWriter(String path){
        this.path = path;
    }

    public void writeTask(Task task){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            // Join the item fields with a semicolon as a delimiter
            String line = String.join(";", String.valueOf(task.getTaskId()), task.getTitle(), task.getDescription(), String.valueOf(task.getDate()), String.valueOf(task.getState()));
            
            // Write the line to the file
            bw.write(line);
            bw.newLine(); // Add a newline character after each line
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
