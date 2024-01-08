import io.IOReader;
import io.IOWriter;
import manager.TaskManager;

public class Main {
    public static void main(String[] args) throws Exception{
        if(args.length != 2)
            throw new Exception("Invalid parameters");

        IOReader ioreader = new IOReader(args[1]);
        IOWriter iowriter = new IOWriter(args[1]);
        TaskManager taskManager = new TaskManager(IOReader,IOWriter);

        Console cmd = new Console();

        cmd.run();
    }
}
