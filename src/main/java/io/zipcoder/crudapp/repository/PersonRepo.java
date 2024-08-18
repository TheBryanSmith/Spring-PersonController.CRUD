package io.zipcoder.crudapp.repository;

import io.zipcoder.crudapp.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends CrudRepository<Person,Integer> {
}
