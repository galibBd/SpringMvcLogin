package com.idb.service;

import com.idb.model.Users;
import java.util.List;
import java.util.Map;

public interface AppService {
    
      public void add(Users users);
      public List<Users> checkUser(String name, String password);
      public List<Users> grtAll();
}
