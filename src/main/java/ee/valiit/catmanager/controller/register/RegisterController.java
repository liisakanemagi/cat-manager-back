package ee.valiit.catmanager.controller.register;


import ee.valiit.catmanager.service.RegisterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

    @PostMapping("/register")

    public Integer register (@RequestBody @Valid UserInfo userInfo){
        return registerService.register(userInfo);

    }

}
