package com.covid.dashboard.security;

import com.covid.dashboard.User.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//@Api(tags = "Authentication")
@RestController
@RequestMapping(path = "api/public")
public class AuthApi {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    //private final UserViewMapper userViewMapper;

    public AuthApi(AuthenticationManager authenticationManager,
                   JwtTokenUtil jwtTokenUtil
               //    UserViewMapper userViewMapper
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
     //   this.userViewMapper = userViewMapper;
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthRequest request) {
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.getUsername(), request.getPassword()
                            )
                    );

            User user = (User) authenticate.getPrincipal();
            String token = jwtTokenUtil.generateAccessToken(user);
            AuthResponse response = new AuthResponse();
            response.setAccessToken(jwtTokenUtil.generateAccessToken(user));
            response.setTokenExpiryTime(jwtTokenUtil.getExpirationDate(token).toString());

            return ResponseEntity.ok()
            .body(response);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
