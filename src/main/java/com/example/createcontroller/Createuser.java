package com.example.createcontroller;

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

public class Createuser {


    @Autowired
    RestTemplate restTemplate;
    @Autowired
    UserService userService;

  /*  @PostMapping("/saveuser")
    public void saveuser(@RequestBody User userrequestmodel)
    {
         userService.saveuser(userrequestmodel);
    }

*/
@PostMapping("/users")
    public ResponseEntity<Object> saveuser(@RequestBody User userrequestmodel)
    {
Map<String,Object> response=new HashMap<>();

        try {

            User result = restTemplate.postForObject("https://reqres.in/api/users", userrequestmodel, User.class);
           response.put("status", "created");
          response.put("message", "User created successfully.");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        catch (HttpClientErrorException.Forbidden e)
        {
            response.put("status", "fail");
            response.put("message", e.getMessage());

            return ResponseEntity.status(e.getStatusCode()).body(response);
        }
    }

}
