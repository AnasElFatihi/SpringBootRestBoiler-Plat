package com.emsi.anas.web;

import com.emsi.anas.entities.AppRole;
import com.emsi.anas.entities.AppUser;
import com.emsi.anas.services.AccountService;
import com.emsi.anas.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;
    //service avec autowired

    @GetMapping("/All")
    public List<AppRole> getAll(){
        return roleService.getAll();
    }

    @PostMapping("/create")
    public AppRole createRole(@RequestBody AppRole approle)
    {
          return roleService.save(approle);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable long  id){
        roleService.deleteRole(id);
    }

    @PutMapping("/modification")
    public AppRole updateRole(@RequestBody AppRole approle)
    {
        return roleService.updateRole(approle);
    }


}
