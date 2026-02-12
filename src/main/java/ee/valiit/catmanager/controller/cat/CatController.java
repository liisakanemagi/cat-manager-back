package ee.valiit.catmanager.controller.cat;

 import ee.valiit.catmanager.persistence.user.User;
 import ee.valiit.catmanager.service.CatService;
 import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;

    @PostMapping("/cat")
    public void addCat(@RequestBody @Valid CatInfo catInfo) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        catService.addCat(catInfo, user.getId());
    }
}
