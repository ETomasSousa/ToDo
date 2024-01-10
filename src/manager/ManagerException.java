package manager;

/**
 * Object that defines an Exception that can be issued by a Manager in case
 * of an operation error.
 */
public class ManagerException extends Exception {
    public ManagerException(String msg) {
        super(msg);
    }
}

