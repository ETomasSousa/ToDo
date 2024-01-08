package task;

/**
 * Object that defines an Exception that can be issued by a task in case
 * of an operation error.
 */
public class TaskException extends Exception {
    public TaskException(String msg) {
        super(msg);
    }
}
