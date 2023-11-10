package fabiomarras.u5w2d5.controllers;

import fabiomarras.u5w2d5.entities.User;
import fabiomarras.u5w2d5.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUser(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String orderBy){
        return userService.getAllUser(page, size, orderBy);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable int id){
        return userService.findById(id);
    }

    @PostMapping("")
    public User saveNewUser(@RequestBody User body){
        return userService.save(body);
    }

    @PutMapping("/{id}")
    public User findByIdAndUpdate(@PathVariable int id, @RequestBody User body){
        return userService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    public void findByIdAndDelete(@PathVariable int id){
        userService.findByIdAndDelete(id);
    }
}
