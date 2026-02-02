package ee.valiit.catmanager.service;

import ee.valiit.catmanager.controller.register.UserInfo;
import ee.valiit.catmanager.infrastructure.error.Error;
import ee.valiit.catmanager.infrastructure.exception.ForbiddenException;
import ee.valiit.catmanager.persistence.user.User;
import ee.valiit.catmanager.persistence.user.UserMapper;
import ee.valiit.catmanager.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Integer register (UserInfo userInfo){
        boolean usernameExists = userRepository.existsByUsername(userInfo.getUsername());

        if(usernameExists) {
            throw new ForbiddenException(Error.USERNAME_ALREADY_EXISTS.getMessage(), Error.USERNAME_ALREADY_EXISTS.getErrorCode());
        }
        boolean emailExists = userRepository.existsByEmail(userInfo.getEmail());
        if (emailExists){
            throw new ForbiddenException(Error.EMAIL_ALREADY_EXISTS.getMessage(), Error.EMAIL_ALREADY_EXISTS.getErrorCode());
        }
        User user = userMapper.toUser(userInfo);
        user.setRole("user");
        userRepository.save(user);
        return user.getId();
    }
}
