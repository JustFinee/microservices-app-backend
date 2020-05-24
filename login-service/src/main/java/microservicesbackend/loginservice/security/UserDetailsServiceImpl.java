package microservicesbackend.loginservice.security;

import microservicesbackend.loginservice.feignProxy.UserDto;
import microservicesbackend.loginservice.feignProxy.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    UserInterface userInterface;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDto userDto = userInterface.findUser(username);

        List<GrantedAuthority> grantedAuthorities =new ArrayList<>();

        userDto.getRoles().stream()
                .forEach(x-> {
                    SimpleGrantedAuthority auth = new SimpleGrantedAuthority("ROLE_"+x);
                    grantedAuthorities.add(auth);
                });


        User user = new User(userDto.getEmail(),encoder.encode(userDto.getPassword()),grantedAuthorities);
        return user;
    }
}
