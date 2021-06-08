package com.example.demo.security;

import com.example.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * User�G���e�B�e�B
 */
public class SimpleUserDetailsService implements UserDetailsService
{
    private final UserRepository userRepository;

    SimpleUserDetailsService(UserRepository userRepository) 
    {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String email) 
    {
        // email�Ńf�[�^�x�[�X���烆�[�U�[�G���e�B�e�B����������
        return userRepository.findByEmail(email)
                .map(SimpleLoginUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
}
