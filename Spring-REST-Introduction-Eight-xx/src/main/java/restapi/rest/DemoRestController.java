package restapi.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class DemoRestController {

    @GetMapping(value = "/hello")
    public String helloWorld(){
        return "hello-world";
    }
}
