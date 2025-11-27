package ch.bbw.service01;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("api")
    public MyData getData() {
        return new MyData("Hello World from Service 01");
    }
}

@Data
@AllArgsConstructor
class MyData {
    private String name;
}
