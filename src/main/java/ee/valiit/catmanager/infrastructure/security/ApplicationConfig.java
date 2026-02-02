package ee.valiit.catmanager.infrastructure.security;

import ee.valiit.catmanager.infrastructure.error.Error;
import ee.valiit.catmanager.infrastructure.exception.DataNotFoundException;
import ee.valiit.catmanager.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findUsersByUsername(username)
                .orElseThrow(() -> new DataNotFoundException(Error.USER_NOT_FOUND.getMessage(), Error.USER_NOT_FOUND.getErrorCode()));
    }
}