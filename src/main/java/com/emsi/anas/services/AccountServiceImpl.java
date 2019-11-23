    package com.emsi.anas.services;

import com.emsi.anas.dao.AppRoleRepository;
import com.emsi.anas.dao.AppUserRepository;
import com.emsi.anas.entities.AppRole;
import com.emsi.anas.entities.AppUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

    @Service
@Transactional

public class AccountServiceImpl implements AccountService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;



    @Override
    public AppUser saveUser(AppUser u) {
        AppUser user = appUserRepository.findByUsername(u.getUsername());
        if( user != null)
            throw new RuntimeException("User Already Exists");

        AppUser appUser = new AppUser();
        appUser = u;



        appUser.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));


        appUserRepository.save(appUser);
        addRoleToUser(appUser.getUsername(),"USER");
        return appUser;
    }

    @Override
    public AppRole save(AppRole role) {
        return appRoleRepository.save(role);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByRoleName(rolename);
        appUser.getRoles().add(appRole);

    }

    @Override
    public List<AppUser> getAll(){

        return appUserRepository.findAll();
    }

    public void deleteUser(long id) {

        appUserRepository.deleteById(id);
    }

    public AppUser updateUser(AppUser user, long id) {
        AppUser userEx = appUserRepository.getOne(id);
        userEx.setUsername(user.getUsername());
        if( user.getPassword() != "")
        {
            userEx.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            System.out.println(user.getPassword());
        }


        appUserRepository.save(userEx);
        System.out.println(userEx);
        return userEx;
    }

    public AppUser findById(long id) {

        return appUserRepository.findById(id).get();
    }

    /*
    @Override
    public AppUser saveUserR(String username, String password, String confirmedPassword, long id) {


        AppUser user = appUserRepository.findByUsername(username);
        if( user != null)
            throw new RuntimeException("User Already Exists");
        if ( ! password.equals(confirmedPassword))
            throw new RuntimeException(("les mots de passes ne correspondent pas !"));
        AppUser appUser = new AppUser();
        appUser.setUsername(username);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUser.setActived(true);



        appUserRepository.save(appUser);
        addRoleToUser(username,"RESPONSABLE");
        return appUser;
    }*/



}
