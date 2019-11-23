package com.emsi.anas.web;

import com.emsi.anas.entities.AppUser;
import com.emsi.anas.services.AccountService;
import com.emsi.anas.services.AccountServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class TestController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountServiceImpl accountServiceimpl;


    @PostMapping("/register")
    public AppUser register(@RequestBody AppUser user){
        return accountService.saveUser(user);
    }

    @GetMapping("/All")
    public List<AppUser> getAll(){
        return accountServiceimpl.getAll();
    }


    @GetMapping("/{id}")
    public AppUser getUser(@PathVariable long id){
        return accountServiceimpl.findById(id);   //
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long  id){
        accountServiceimpl.deleteUser(id);
    }

    @PutMapping("/{id}")
    public AppUser updateUser(@RequestBody AppUser user, @PathVariable long id)
    {
        return accountServiceimpl.updateUser(user,id);
    }

}


@Data
class UserForm{
    private String username;
    private String password;
    private String repassword;


}
