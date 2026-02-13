package ee.valiit.catmanager.service;

import ee.valiit.catmanager.infrastructure.exception.PrimaryKeyNotFoundException;
import ee.valiit.catmanager.persistence.user.User;
import ee.valiit.catmanager.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getValidUser(Integer userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new PrimaryKeyNotFoundException("useId", userId));
    }
}
