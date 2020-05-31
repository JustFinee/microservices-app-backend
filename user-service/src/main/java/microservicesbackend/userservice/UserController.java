package microservicesbackend.userservice;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/findUser/{email}")
    public ResponseEntity<User> findUser(@PathVariable(name = "email") String email) {
        try {
            return new ResponseEntity<>(userService.findUser(email), HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not found user with this email", e);
        }
    }

    @GetMapping("/findUserById/{id}")
    public ResponseEntity<User> findUserById(@PathVariable(name = "id") Long idUser) {
        try {
            return new ResponseEntity<>(userService.findUserById(idUser), HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not found user with this idUser", e);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {

        try{
            User newUser = userService.register(user);
            if (newUser != null)
                return new ResponseEntity<>(newUser, HttpStatus.CREATED);
            else
                return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        catch (IllegalStateException e)
        {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "This user already exists", e);
        }





    }

    @PutMapping("/changeUser")
    public ResponseEntity<User> changeUser(@RequestBody User user, @RequestParam String currentPassword) {
        System.out.println(user.getId());
        System.out.println(user.getEmail());
        try {
            return new ResponseEntity<>(userService.changeUser(user, currentPassword), HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not found user with this id", e);
        } catch (IllegalStateException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Current password is wrong", e);
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long userId, @RequestParam String currentPassword) {
        try {
            userService.deleteUser(userId, currentPassword);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not found user with this id", e);
        } catch (IllegalStateException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Current password is wrong", e);
        }
    }
}