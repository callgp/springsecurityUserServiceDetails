package main.java.com.telusko.spring_sec_demo.service;

import com.telusko.spring_sec_demo.dao.UserRepo;
import com.telusko.spring_sec_demo.model.User;
import com.telusko.spring_sec_demo.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
   private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byUserName = repo.findByUserName(username);
        if (byUserName==null){
            System.out.println("err 404 usersss not found");
            throw new UsernameNotFoundException("usr 404 exc");

        }
        return new UserPrincipal(byUserName);
    }
}
