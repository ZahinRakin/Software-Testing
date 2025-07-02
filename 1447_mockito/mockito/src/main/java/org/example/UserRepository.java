package org.example;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private List<User> users = new ArrayList<User>();

    public User findByEmail(String email) {
//      throw if no user found.
//      extensive implementation.
        return new User("zahinabdullahrakin@gmail.com", "rakin123");
    }

}


