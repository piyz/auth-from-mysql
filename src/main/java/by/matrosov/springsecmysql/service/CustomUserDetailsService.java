package by.matrosov.springsecmysql.service;

import by.matrosov.springsecmysql.model.CustomUserDetails;
import by.matrosov.springsecmysql.model.User;
import by.matrosov.springsecmysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<User> optionalUser = userRepository.findByFirstName(s);

        optionalUser.orElseThrow(()->new UsernameNotFoundException("Name not found"));

        return optionalUser.map(CustomUserDetails::new).get();
    }
}
