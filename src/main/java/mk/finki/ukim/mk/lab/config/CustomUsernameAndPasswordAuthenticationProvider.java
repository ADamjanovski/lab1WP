//package mk.finki.ukim.mk.lab.config;
//
//import mk.finki.ukim.mk.lab.service.UserService;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CustomUsernameAndPasswordAuthenticationProvider implements AuthenticationProvider {
//    private final UserService userService;
//    private final PasswordEncoder passwordEncoder;
//
//    public CustomUsernameAndPasswordAuthenticationProvider(UserService userService, PasswordEncoder passwordEncoder) {
//        this.userService = userService;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//       String username=authentication.getName();
//       String password=authentication.getCredentials().toString();
//       if(username.isEmpty() || password.isEmpty()){
//            throw new BadCredentialsException("Invalid credentials!");
//       }
//        UserDetails userDetails= userService.loadUserByUsername(username);
//       if(!passwordEncoder.matches(password,userDetails.getPassword())){
//           throw new BadCredentialsException("Invalid password!");
//       }
//       return new UsernamePasswordAuthenticationToken(userDetails,userDetails.getPassword(),userDetails.getAuthorities());
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}