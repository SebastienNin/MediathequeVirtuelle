package mediatheque.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PersonnalizedListNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    public PersonnalizedListNotFoundException() {
        super("Personnalized list not found");
    }
}