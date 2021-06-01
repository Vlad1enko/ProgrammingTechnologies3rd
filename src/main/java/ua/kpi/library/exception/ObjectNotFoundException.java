package ua.kpi.library.exception;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException() {
        super("Object wasn't found.");
    }

    public ObjectNotFoundException(String resourceName, Integer id) {
        super(resourceName + " with id=" + id + " was not found.");
    }

    public ObjectNotFoundException(Integer id) {
        super("Object with id=" + id + " was not found.");
    }

}
