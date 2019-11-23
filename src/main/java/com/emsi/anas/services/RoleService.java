package com.emsi.anas.services;

import com.emsi.anas.dao.AppRoleRepository;
import com.emsi.anas.dao.AppUserRepository;
import com.emsi.anas.entities.AppRole;
import com.emsi.anas.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class RoleService {
    @Autowired
    private AppRoleRepository appRoleRepository;

    public List<AppRole> getAll(){

        return appRoleRepository.findAll();
    }

    public AppRole save(AppRole approle) {
        return appRoleRepository.save(approle);
    }

    public void deleteRole(long id) {
        appRoleRepository.delete(appRoleRepository.findById(id).get());
    }

    public AppRole updateRole(AppRole user) {
        return appRoleRepository.save(user);
    }
}
