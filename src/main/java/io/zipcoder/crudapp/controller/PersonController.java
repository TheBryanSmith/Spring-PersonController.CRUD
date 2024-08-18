package io.zipcoder.crudapp.controller;

import io.zipcoder.crudapp.model.Person;
import io.zipcoder.crudapp.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    @Autowired
    PersonRepo personRepository;

    @PostMapping(value = "/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){

        personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

   @GetMapping(value = "/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Integer id){
        return new ResponseEntity<>(personRepository.findOne(id),HttpStatus.OK);
   }

   @GetMapping( value = "/people/")
    public ResponseEntity<Iterable<Person>> getListOfMandem(){
        return new ResponseEntity<>(personRepository.findAll(),HttpStatus.OK);
   }

   @PutMapping(value = "people/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Integer id, Person person){
       Person person1 = new Person();
       person1.setFirstName(person.getFirstName());
       person1.setLastName(person.getLastName());
        return new ResponseEntity<>(personRepository.save(person1),HttpStatus.OK);

    }

    @DeleteMapping(value = "/person/{id}")
    public void deleteMandem(@PathVariable Integer id, @RequestBody Person person){
     personRepository.delete(person);
    }


}
