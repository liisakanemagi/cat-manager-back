package ee.valiit.catmanager.controller.cat;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class CatController {

    @PostMapping("/cat")
    public void addCat(@RequestBody @Valid CatInfo catInfo,) {

    }
}
