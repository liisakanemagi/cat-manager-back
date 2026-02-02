package ee.valiit.catmanager.service;

import ee.valiit.catmanager.controller.LoginResponse;
import ee.valiit.catmanager.infrastructure.error.Error;
import ee.valiit.catmanager.infrastructure.exception.ForbiddenException;
import ee.valiit.catmanager.infrastructure.security.JwtService;
import ee.valiit.catmanager.persistence.user.User;
import ee.valiit.catmanager.persistence.user.UserMapper;
import ee.valiit.catmanager.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginResponse login (String username, String password){
        User user = userRepository.findUsersByUsername(username)
                .orElseThrow(() -> new ForbiddenException(Error.INCORRECT_CREDENTIALS.getMessage(), Error.INCORRECT_CREDENTIALS.getErrorCode()));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new ForbiddenException(Error.INCORRECT_CREDENTIALS.getMessage(), Error.INCORRECT_CREDENTIALS.getErrorCode());
        }

        LoginResponse loginResponse = userMapper.toLoginResponse(user);
        loginResponse.setToken(jwtService.createToken(user.getUsername()));
        return loginResponse;
    }

}