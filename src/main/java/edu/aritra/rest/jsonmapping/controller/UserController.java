package edu.aritra.rest.jsonmapping.controller;

import edu.aritra.rest.jsonmapping.dto.Individual;
import edu.aritra.rest.jsonmapping.dto.Organization;
import edu.aritra.rest.jsonmapping.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private List<User> users = new ArrayList<>();

    @GetMapping
    public List<User> getUsers() {
        return users;
    }

    @GetMapping(value = "/{userCode}")
    public User findByUserCode(@PathVariable String userCode) {
        Optional<User> user = users.stream().filter(u -> u.getUserCode().equals(userCode)).findFirst();
        return user.orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public long create(@RequestBody User user) {

        if (user instanceof Individual) {
            Individual individual = (Individual) user;
            users.add(individual);
        } else if (user instanceof Organization) {
            Organization organization = (Organization) user;
            users.add(organization);
        }

        return users.size();
    }

    @PostConstruct
    private void createUsers() {
        users.add(new Individual("DON01", "Don Quixote", "Baker Street"));
        users.add(new Organization("SPC02", "ORG_SC_0010", "Space Jam Inc.", "Connaught Place"));
    }
}

