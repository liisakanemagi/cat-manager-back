package ee.valiit.catmanager.controller.cat;

import ee.valiit.catmanager.infrastructure.error.ApiError;
import ee.valiit.catmanager.persistence.cat.Cat;
import ee.valiit.catmanager.persistence.user.User;
import ee.valiit.catmanager.service.CatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class CatController {

    private final CatService catService;

    @PostMapping("/cat")
    @Operation(summary = "Uue kassi lisamine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Oled selle nimega kassi juba lisanud (errorCode 115)", content = @Content(schema = @Schema(implementation = ApiError.class)))})

    public Cat addCat(@RequestBody @Valid CatInfo catInfo) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return catService.addCat(catInfo, user.getId());
    }

    @GetMapping("/cats")
    @Operation(summary = "Toob ära nimekirja kasutaja lisatud kassidest")

    public List<CatDto> getCats(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return catService.getCats(user.getId());

    }

    @DeleteMapping("/cat")
    @Operation(summary= "Kassi kustutamine")
    public void deleteCat(@RequestParam Integer catId) {
        catService.deleteCat(catId);
    }
}
