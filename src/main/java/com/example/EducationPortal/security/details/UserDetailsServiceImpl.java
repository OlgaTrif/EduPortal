package com.example.EducationPortal.security.details;

import org.springframework.beans.factory.annotation.Autowired; import org.springframework.security.core.userdetails.UserDetails; import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.eduPortal.repositories.UsersRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService { @Autowired
private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return new
                UserDetailsImpl(usersRepository.findOneByLogin(login)
                .orElseThrow(IllegalArgumentException::new));

    }
}

