package com.emsi.anas.dao;


import com.emsi.anas.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.io.Serializable;

@RepositoryRestResource
public interface AppRoleRepository  extends JpaRepository<AppRole,Long>, Serializable {

    public AppRole findByRoleName(String rolename);
}

