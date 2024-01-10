import manager.TaskManager;

public class Main {
    public static void main(String[] args) throws Exception{
        if(args.length != 2)
            throw new Exception("Invalid parameters");
        TaskManager taskManager = new TaskManager(args[1]);

        Console cmd = new Console();

        cmd.run();
    }
}
