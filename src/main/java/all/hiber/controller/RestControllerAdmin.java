package all.hiber.controller;


import all.hiber.model.User;
import all.hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/api")
public class RestControllerAdmin {

    @Autowired
    public UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> allUser(){
        return ResponseEntity.ok(userService.allUsers());
    }

    @GetMapping("/")
    public ResponseEntity<UserDetails> getCurrentUser() {
        return ResponseEntity.ok(userService.loadUserByUsername("admin"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Long id) {
        System.out.println("get trabajo");
        return ResponseEntity.ok(userService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<User>> delete(@PathVariable Long id) {
        System.out.println("delete trabajo");
        userService.delete(id);
        return ResponseEntity.ok(userService.allUsers());
    }

    @PostMapping("/")
    public ResponseEntity<List<User>> post(@RequestBody User user) {
        System.out.println("post trabajo");
        userService.add(user);
        return ResponseEntity.ok(userService.allUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<User>> put(@PathVariable Long id, @RequestBody User user) {
        System.out.println("put start controller");
        userService.edit(id, user);
        System.out.println("привет из контроллера Put");
        return ResponseEntity.ok(userService.allUsers());
    }



}
