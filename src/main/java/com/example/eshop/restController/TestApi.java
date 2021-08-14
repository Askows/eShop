package com.example.eshop.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Profile("dev")
@RestController
@RequiredArgsConstructor
public class TestApi {

    private final PersonRepository repository;

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable("name") String firstName) {
        return "Hello " + firstName;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping
    public List<Person> getAll() {
        return repository.findAll();
    }

    @PostMapping()
    public Person savePerson(@Valid @RequestBody Person person) {
        return repository.save(person);
    }

    @PutMapping("/{name}")
    public String updateAllPersonsWithName(
            @PathVariable("name") String firstName,
            @Valid @RequestBody Person person) {
        List<Person> allPersonsWithName = repository.findByName(firstName);
        List<Person> newPersons = allPersonsWithName.stream()
                .map(personFromList -> {
                    personFromList.setAge(person.getAge());
                    personFromList.setName(person.getName());
                    return personFromList;
                })
                .collect(Collectors.toList());
        repository.saveAll(newPersons);
        return "Updated";
    }

    @DeleteMapping("/{name}")
    public String delete(@PathVariable("name") String firstName) throws NameException {
        if(firstName.matches(".*\\d.*")){
            throw new NameException("Name must not contain numbers.");
        }
        List<Person> persons = repository.findByName(firstName);
        if (persons != null && persons.size() > 0) {
            repository.deleteAll(persons);
            return "Deleted";
        }
        return "Not deleted";
    }
}
