package ee.valiit.catmanager.service;

import ee.valiit.catmanager.controller.register.UserInfo;
import ee.valiit.catmanager.infrastructure.error.Error;
import ee.valiit.catmanager.infrastructure.exception.ForbiddenException;
import ee.valiit.catmanager.persistence.user.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@NoArgsConstructor
public class RegisterService {

    private UserRepository userRepository;

    @Autowired
    public RegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register (UserInfo userInfo){
        boolean usernameExists = userRepository.userExistsByUsername(userInfo.getUsername());

        if(usernameExists) {
            throw new ForbiddenException(Error.USERNAME_ALREADY_EXISTS.getMessage(), Error.USERNAME_ALREADY_EXISTS.getErrorCode());
        }
        boolean emailExists = userRepository.userExistsByEmail(userInfo.getEmail());
        if (emailExists){
            throw new ForbiddenException(Error.EMAIL_ALREADY_EXISTS.getMessage(), Error.EMAIL_ALREADY_EXISTS.getErrorCode());
        }

    }
}
