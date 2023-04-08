package pl.polsl.projectsupport.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.projectsupport.dto.UserAccount;

import java.security.Principal;
import java.util.Base64;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserAccountController {


    @GetMapping("/login")
    public boolean login(@RequestBody UserAccount user) {
        return user.getUserName().equals("user") && user.getPassword().equals("user");
    }

    @GetMapping("/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization").substring("Basic".length()).trim();
        return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
    }


}
