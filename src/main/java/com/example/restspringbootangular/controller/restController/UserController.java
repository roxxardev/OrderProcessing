package com.example.restspringbootangular.controller.restController;

import com.example.restspringbootangular.model.User;
import com.example.restspringbootangular.service.user.UserService;
import io.swagger.annotations.*;
import lombok.Data;
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

    /**
     * Dummy method for documentation puproses only, will never be reached
     * @param login required login information
     * @return dummy string
     */
    @ApiOperation(value = "Returns JWT token")
    //@ApiResponses(value = { @ApiResponse(code = 200, message = "Will return a security token, which must be passed in every request", response = String.class) })
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    String getSessionToken(@RequestBody Login login) {
        return "token";
    }

    @Data
    private class Login {
        @ApiModelProperty(example = "test", required = true)
        private String username = "";

        @ApiModelProperty(example = "test", required = true)
        private String password = "";
    }
}
