package ee.valiit.catmanager.service;

import ee.valiit.catmanager.controller.register.UserInfo;
import ee.valiit.catmanager.infrastructure.error.Error;
import ee.valiit.catmanager.infrastructure.exception.ForbiddenException;
import ee.valiit.catmanager.persistence.user.User;
import ee.valiit.catmanager.persistence.user.UserMapper;
import ee.valiit.catmanager.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public Integer register (UserInfo userInfo){
        validateUsernameIsAvailable(userInfo);
        validateEmailIsAvailable(userInfo);
        User user = createAndSaveUser(userInfo);
        return user.getId();
    }

    private void validateUsernameIsAvailable(UserInfo userInfo) {
        boolean usernameExists = userRepository.existsByUsername(userInfo.getUsername());
        if(usernameExists) {
            throw new ForbiddenException(Error.USERNAME_ALREADY_EXISTS.getMessage(), Error.USERNAME_ALREADY_EXISTS.getErrorCode());
        }
    }

    private void validateEmailIsAvailable(UserInfo userInfo) {
        boolean emailExists = userRepository.existsByEmail(userInfo.getEmail());
        if (emailExists){
            throw new ForbiddenException(Error.EMAIL_ALREADY_EXISTS.getMessage(), Error.EMAIL_ALREADY_EXISTS.getErrorCode());
        }
    }

    private User createAndSaveUser(UserInfo userInfo) {
        User user = userMapper.toUser(userInfo);
        encodePassword(userInfo, user);
        user.setRole("user");
        userRepository.save(user);
        return user;
    }

    private void encodePassword(UserInfo userInfo, User user) {
        String rawPassword = userInfo.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        user.setPassword(encodedPassword);
    }
}
