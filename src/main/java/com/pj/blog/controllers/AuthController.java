/*
 * package com.pj.blog.controllers;
 * 
 * import javax.security.auth.message.callback.PrivateKeyCallback.Request;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.authentication.BadCredentialsException; import
 * org.springframework.security.authentication.DisabledException; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.pj.blog.Security.JwtTokenHelper; import
 * com.pj.blog.dtos.JwtAuthRequest; import com.pj.blog.dtos.JwtAuthResponse;
 * 
 * @RestController
 * 
 * @RequestMapping("/api/v1/auth/") public class AuthController {
 * 
 * @Autowired private JwtTokenHelper jwtTokenHelper;
 * 
 * @Autowired private UserDetailsService userDetailsService;
 * 
 * @Autowired private AuthenticationManager authenticationManager;
 * 
 * @PostMapping("/login") public ResponseEntity<JwtAuthResponse>
 * createToken(@RequestBody JwtAuthRequest request) throws Exception {
 * 
 * try { this.authenticate(request.getUserName(), request.getPassword()); }
 * catch (Exception e) { e.printStackTrace(); }
 * 
 * UserDetails userDetails =
 * this.userDetailsService.loadUserByUsername(request.getUserName()); String
 * token = this.jwtTokenHelper.generateToken(userDetails);
 * 
 * JwtAuthResponse response = new JwtAuthResponse(); response.setToken(token);
 * 
 * return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
 * 
 * }
 * 
 * private void authenticate(String userName, String password) throws Exception
 * {
 * 
 * UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new
 * UsernamePasswordAuthenticationToken( userName, password);
 * 
 * try {
 * 
 * this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
 * 
 * } catch (BadCredentialsException e) { System.out.println("invalid details");
 * 
 * throw new Exception("invalid un or ps"); } }
 * 
 * }
 */