package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Nicholas on 6/19/2016.
 * Description: Testing out Spring boot!
 */
@RestController
public class HelloController {
    @RequestMapping
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
