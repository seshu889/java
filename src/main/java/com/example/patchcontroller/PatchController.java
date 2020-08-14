package com.example.patchcontroller;


import com.example.requestModel.User;
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
public class PatchController {
    @Autowired
    RestTemplate restTemplate;

    @PatchMapping("/users/{id}")
    public ResponseEntity<Object> patchuser(@PathVariable("id") String id, @RequestBody User userrequestmodel)
    {
        Map<String,Object> response=new HashMap<>();

        try {
            restTemplate.patchForObject("https://reqres.in/api/users/" + id, userrequestmodel, User.class);
            response.put("status", "success");
            response.put("message", "User updated successfully.");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (HttpClientErrorException.Forbidden e){
            response.put("status", "fail");
            response.put("message", e.getMessage());
            return ResponseEntity.status(e.getStatusCode()).body(response);
        }
    }


}
