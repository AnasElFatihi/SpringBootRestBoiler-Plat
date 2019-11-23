package com.emsi.anas.services;



import com.emsi.anas.entities.AppRole;
import com.emsi.anas.entities.AppUser;

import java.util.List;

public interface AccountService

{
    public AppUser saveUser(AppUser user);
    public AppRole save(AppRole role);
    public AppUser loadUserByUsername(String username);
    public void addRoleToUser(String username,String rolename);


    List<AppUser> getAll();

    //AppUser saveUserR(String username, String password, String repassword, long id);
}
