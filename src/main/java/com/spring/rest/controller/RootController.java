package  com.spring.rest.controller;

import com.spring.rest.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/root")
public class RootController {

    @GetMapping(value = "/word/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> doReverse(@PathVariable String name) {
        Person p = new Person();
        p.setId(UUID.randomUUID().toString());
        p.setName(new StringBuilder(name).reverse().toString());
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

}