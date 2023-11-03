/*
 * package com.pj.blog.config;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.config.http.SessionCreationPolicy; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.web.authentication.
 * UsernamePasswordAuthenticationFilter;
 * 
 * import com.pj.blog.Security.CustomUserDetailService; import
 * com.pj.blog.Security.JwtAuthenticationFilter; import
 * com.pj.blog.Security.JwtAuthonticationEntryPoint;
 * 
 * @SuppressWarnings("deprecation")
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfig extends
 * WebSecurityConfigurerAdapter{
 * 
 * @Autowired private CustomUserDetailService customUserDetailService;
 * 
 * @Autowired private JwtAuthonticationEntryPoint jwtAuthonticationEntryPoint;
 * 
 * @Autowired private JwtAuthenticationFilter jwtAuthenticationFilter;
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * 
 * 
 * // type of request http. csrf() .disable() .authorizeHttpRequests()
 * .anyRequest() .authenticated() .and()
 * .exceptionHandling().authenticationEntryPoint(this.
 * jwtAuthonticationEntryPoint) .and() .sessionManagement()
 * .sessionCreationPolicy(SessionCreationPolicy.STATELESS); //statless session
 * managmenet policy
 * 
 * 
 * http.addFilterBefore(this.jwtAuthenticationFilter,
 * UsernamePasswordAuthenticationFilter.class); }
 * 
 * 
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception {
 * auth.userDetailsService(this.customUserDetailService).passwordEncoder(null);
 * }
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); }
 * 
 * 
 * 
 * @Bean
 * 
 * @Override public AuthenticationManager authenticationManagerBean() throws
 * Exception { // TODO Auto-generated method stub return
 * super.authenticationManagerBean(); }
 * 
 * 
 * 
 * 
 * }
 */