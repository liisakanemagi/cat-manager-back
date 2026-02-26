package ee.valiit.catmanager.service;

import ee.valiit.catmanager.controller.cat.CatDto;
import ee.valiit.catmanager.controller.cat.CatInfo;
import ee.valiit.catmanager.infrastructure.error.Error;
import ee.valiit.catmanager.infrastructure.exception.ForbiddenException;
import ee.valiit.catmanager.infrastructure.exception.PrimaryKeyNotFoundException;
import ee.valiit.catmanager.persistence.cat.Cat;
import ee.valiit.catmanager.persistence.cat.CatMapper;
import ee.valiit.catmanager.persistence.cat.CatRepository;
import ee.valiit.catmanager.persistence.catstatus.CatStatus;
import ee.valiit.catmanager.persistence.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatService {

    private final UserService userService;
    private final CatStatusService catStatusService;
    private final CatMapper catMapper;
    private final CatRepository catRepository;

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

    public List<CatDto> getCats(Integer userId) {
        Sort sort = Sort.by(Sort.DEFAULT_DIRECTION, "name");
        List<Cat> cats = catRepository.findByUserId(userId, sort);
        return catMapper.toCatDtos(cats);
    }
    
    public CatDto getCat(Integer catId, Integer userId){
        Cat cat = getValidCat(catId, userId);
        return catMapper.toCatDto(cat);
    }

    private void validateCatNameIsAvailableForCurrentUser(CatInfo catInfo, Integer userId) {
        boolean catExists = catRepository.existsByUserIdAndName(userId, catInfo.getName());

        if (catExists) {
            throw new ForbiddenException(Error.CAT_NAME_UNAVAILABLE.getMessage(), Error.CAT_NAME_UNAVAILABLE.getErrorCode());
        }
    }

    public Cat getValidCat(Integer catId, Integer userId) {
        return catRepository.findByIdAndUserId(catId, userId)
                .orElseThrow(() -> new PrimaryKeyNotFoundException("Kassi ID " + catId + " kasutaja ID-ga " + userId + " ei leitud."));
    }

    public void deleteCat(Integer catId, Integer userId) {
        Cat cat = this.getValidCat(catId, userId);
        catRepository.delete(cat);

    }
}
