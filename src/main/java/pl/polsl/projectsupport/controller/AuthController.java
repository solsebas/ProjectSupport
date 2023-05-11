package pl.polsl.projectsupport.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.polsl.projectsupport.JSONWebToken.JwtUtils;
import pl.polsl.projectsupport.dao.RoleDao;
import pl.polsl.projectsupport.dao.UserDao;
import pl.polsl.projectsupport.enums.EnumRole;
import pl.polsl.projectsupport.model.RoleModel;
import pl.polsl.projectsupport.model.UserModel;
import pl.polsl.projectsupport.payload.request.LoginRequest;
import pl.polsl.projectsupport.payload.request.SignupRequest;
import pl.polsl.projectsupport.payload.response.JwtResponse;
import pl.polsl.projectsupport.payload.response.MessageResponse;
import pl.polsl.projectsupport.service.UserDetailsImpl;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDao userRepository;

    @Autowired
    RoleDao roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok("Wylogowano pomyślnie");
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: nazwa użytkownika jest już zajęta!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: e-mail jest już używany!"));
        }

        // Create new user's account
        UserModel user = new UserModel(signUpRequest.getUsername(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<RoleModel> roles = new HashSet<>();

        if (strRoles == null) {
            RoleModel userRole = roleRepository.findByName(EnumRole.ROLE_SUPERVISOR).orElseThrow(() -> new RuntimeException("Error: Nie znaleziono roli."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        RoleModel adminRole = roleRepository.findByName(EnumRole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Nie znaleziono roli."));
                        roles.add(adminRole);

                        break;
                    case "student":
                        RoleModel modRole = roleRepository.findByName(EnumRole.ROLE_STUDENT)
                                .orElseThrow(() -> new RuntimeException("Error: Nie znaleziono roli."));
                        roles.add(modRole);

                        break;
                    default:
                        RoleModel userRole = roleRepository.findByName(EnumRole.ROLE_SUPERVISOR)
                                .orElseThrow(() -> new RuntimeException("Error: Nie znaleziono roli."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("Użytkownik zarejestrowany pomyślnie!"));
    }
}
