import io.IOReader;
import manager.TaskManager;

public class Main {
    public static void main(String[] args) throws Exception{
        if(args.length != 2)
            throw new Exception("Invalid parameters");

        IOReader ioreader = new IOReader(args[1]);
        TaskManager taskManager = new TaskManager(IOReader);

        taskManager.start();
    }
}
