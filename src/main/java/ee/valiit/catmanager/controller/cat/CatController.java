package ee.valiit.catmanager.controller.cat;

 import ee.valiit.catmanager.persistence.cat.Cat;
 import ee.valiit.catmanager.persistence.user.User;
 import ee.valiit.catmanager.service.CatService;
 import io.swagger.v3.oas.annotations.security.SecurityRequirement;
 import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class CatController {

    private final CatService catService;

    @PostMapping("/cat")
    public Cat addCat(@RequestBody @Valid CatInfo catInfo) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return catService.addCat(catInfo, user.getId());
    }
}
