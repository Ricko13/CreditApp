package dawidw.creditapp.credit.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse implements Serializable {

    private int status;
    private String error;
    private String message;

}
