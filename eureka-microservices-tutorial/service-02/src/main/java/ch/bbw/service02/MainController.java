package ch.bbw.service02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("api")
    public String getData() {
        return "Hello World from Service 02";
    }
}
