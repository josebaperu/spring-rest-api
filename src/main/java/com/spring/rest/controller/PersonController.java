package  com.spring.rest.controller;

import com.spring.rest.entity.Person;
import com.spring.rest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonRepository personRepository;
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doPost(@RequestBody Person person) {
        Optional<Person> p = personRepository.findById(person.getId());
        if(p.isPresent()){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        Person savedPerson = personRepository.save(person);
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doGet(@PathVariable String id) {
        Optional<Person> p = personRepository.findById(id);
        if(p.isEmpty()){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(p.get(), HttpStatus.OK);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Person>> doGetAll() {
        List<Person> persons = (List<Person>) personRepository.findAll();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

}