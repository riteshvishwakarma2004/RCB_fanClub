//package com.Ritesh.RCB_FanClub.controller;
//
//import com.Ritesh.RCB_FanClub.Model.AppUser;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.WebAuthenticationDetails;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class AuthController {
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody AppUser request, HttpServletRequest httpRequest) {
//        try {
////            Authentication auth = authenticationManager.authenticate(
////                    new UsernamePasswordAuthenticationToken(
////                            request.getPhone(),
////                            request.getPassword()
////                    )
////            );
//
//            UsernamePasswordAuthenticationToken authToken =
//                    new UsernamePasswordAuthenticationToken(
//                            request.getPhone(),
//                            request.getPassword()
//                    );
//
//            // Set the session details (client IP, session ID)
//            authToken.setDetails(new WebAuthenticationDetails(httpRequest));
//
//            // Authenticate the token
//            Authentication auth = authenticationManager.authenticate(authToken);
//
//            SecurityContextHolder.getContext().setAuthentication(auth);
//            System.out.println(auth.getDetails()+" " + auth.getCredentials()+ " "+ auth.getName());
//            return ResponseEntity.ok("Login Successful");
//
//        } catch (AuthenticationException e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//        }
//    }
//
//}
