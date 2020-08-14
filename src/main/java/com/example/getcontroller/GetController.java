package com.example.getcontroller;

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
import java.util.List;
import java.util.Map;

@Controller
@RestController
@ComponentScan(basePackages = {"com.example.*" })
@Component
@RequestMapping(value = "/api")
public class GetController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    UserService userService;

/*
@GetMapping("/getusers")
    public List<User> allusers()
    {
        return userService.getallusers();
    }

    @GetMapping("/id")
public List<User>getuserbyId(@RequestParam  int id)
{

    return userService.getuserbyId(id);
}
*/
@GetMapping("/users/{id}")
    public ResponseEntity<Object> getuserbyId(@PathVariable("id") String id) {
    Map<String,Object> response=new HashMap<>();
    try {
        User result = restTemplate.getForObject("https://reqres.in/api/users/"+id, User.class);
        response.put("status", "success");
        response.put("data", result);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    } catch (HttpClientErrorException.Forbidden e){
        response.put("status", "fail");
        response.put("message", e.getMessage());

        return ResponseEntity.status(e.getStatusCode()).body(response);
    }
  }

  /*@GetMapping("/api/foos")
  @ResponseBody
  public String getFoos(@RequestParam String id) {
      return "ID: " + id;*/



}
