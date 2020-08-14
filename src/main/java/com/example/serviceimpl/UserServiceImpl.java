package com.example.serviceimpl;

import com.example.requestModel.User;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
@Service
public class UserServiceImpl implements UserService {

 /*   private List<User> usersList = new ArrayList<>(Arrays.asList(

            new User(1,"seshu","ANU"),
            new User(2,"ASHOK","JNTU"),
            new User(3,"sai","KLU")

    ));*/

/*

    @Override
    public void saveuser(User userrequestmodel) {
        usersList.add(userrequestmodel);

        System.out.println("usersList:" +  usersList);
    }

    @Override
    public List<User> getallusers() {
        return  usersList;
    }

    @Override
    public List<User> getuserbyId(int id) {
        return null;
    }

    @Override
    public void deleteuser(int id) {
        usersList.removeIf(userrequestmodel->userrequestmodel.getId().equals(id));

    }
*/
}


