package lk.sliit.customerservice.wrapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseWrapper <T>{

    private String message;
    private T data;
    private boolean success;
}
