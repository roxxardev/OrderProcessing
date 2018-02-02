package com.example.restspringbootangular.restController;

import com.example.restspringbootangular.model.User;
import com.example.restspringbootangular.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@Api(tags = "User")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Returns current logged in user")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<User> getCurrentUser() {
        Optional<User> loggedInUser = userService.getLoggedInUser();

        return loggedInUser
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Returns user by username")
    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable String username) {
        return userService.getByUsername(username)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Add user")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User addedUser = userService.save(user);
            return ResponseEntity.created(new URI("/user/" + addedUser.getUsername())).body(addedUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
