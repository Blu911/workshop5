package pl.coderslab.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JsonRespone {
    private String success;
    private String message;
}
