package ee.valiit.catmanager.service;

import ee.valiit.catmanager.controller.LoginResponse;
import ee.valiit.catmanager.infrastructure.error.Error;
import ee.valiit.catmanager.infrastructure.exception.ForbiddenException;
import ee.valiit.catmanager.persistence.user.User;
import ee.valiit.catmanager.persistence.user.UserMapper;
import ee.valiit.catmanager.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public LoginResponse login (String username, String password){
        User user = userRepository.findUsersBy(username, password)
                .orElseThrow(() -> new ForbiddenException(Error.INCORRECT_CREDENTIALS.getMessage(), Error.INCORRECT_CREDENTIALS.getErrorCode()));
        return userMapper.toLoginResponse(user);
    }

}
