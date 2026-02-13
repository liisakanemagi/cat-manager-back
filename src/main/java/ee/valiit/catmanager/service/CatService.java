package ee.valiit.catmanager.service;

import ee.valiit.catmanager.controller.cat.CatInfo;
import ee.valiit.catmanager.infrastructure.error.Error;
import ee.valiit.catmanager.infrastructure.exception.ForbiddenException;
import ee.valiit.catmanager.persistence.cat.Cat;
import ee.valiit.catmanager.persistence.cat.CatMapper;
import ee.valiit.catmanager.persistence.cat.CatRepository;
import ee.valiit.catmanager.persistence.catstatus.CatStatus;
import ee.valiit.catmanager.persistence.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

@Service
@RequiredArgsConstructor
public class CatService {

    private final UserService userService;
    private final CatStatusService catStatusService;
    private final CatMapper catMapper;
    private final CatRepository catRepository;
    private final View error;

    public Cat addCat(CatInfo catInfo, Integer userId) {
        validateCatNameIsAvailableForCurrentUser(catInfo, userId);

        User user = userService.getValidUser(userId);
        CatStatus catStatus = catStatusService.getValidCatStatus(catInfo.getStatusId());

        Cat cat = catMapper.toCat(catInfo);
        cat.setUser(user);
        cat.setStatus(catStatus);
        catRepository.save(cat);
        return cat;
    }

    private void validateCatNameIsAvailableForCurrentUser(CatInfo catInfo, Integer userId) {
        boolean catExists = catRepository.catExistsBy(userId, catInfo.getName());
        if (catExists) {
            throw new ForbiddenException(Error.CAT_NAME_UNAVAILABLE.getMessage(), Error.CAT_NAME_UNAVAILABLE.getErrorCode());
        }
    }
}

