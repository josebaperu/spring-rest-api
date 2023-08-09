package  com.spring.rest.controller;

import com.spring.rest.entity.Person;
import com.spring.rest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/root")
public class RootController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping(value = "/word/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> doReverse(@PathVariable String name) {
        Person p = new Person();
        p.setId(UUID.randomUUID().toString());
        p.setName(new StringBuilder(name).reverse().toString());
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
    @GetMapping(value = "/persons", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Person>> persons() {
        List<Person> persons = (List<Person>) personRepository.findAll();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

}