package com.example.deletecontroller;

import com.example.requestModel.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Controller
@RestController
@ComponentScan(basePackages = {"com.example.*" })
@Component
@RequestMapping(value = "/api")
public class DeleteController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    UserService userService;

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> getuserbyId(@PathVariable("id") String id) {
        Map<String,Object> response=new HashMap<>();
        try {
            restTemplate.delete("https://reqres.in/api/users/"+id);
            response.put("status", "success");
            response.put("data", "User deleted successfully");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (HttpClientErrorException.Forbidden e){
            response.put("status", "fail");
            response.put("message", e.getMessage());

            return ResponseEntity.status(e.getStatusCode()).body(response);
        }
    }


}
