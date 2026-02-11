package ee.valiit.catmanager.controller.register;


import ee.valiit.catmanager.infrastructure.error.ApiError;
import ee.valiit.catmanager.service.RegisterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Uue kasutaja registreerimine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Registreerimine ebaõnnestus", content = @Content(
                    schema = @Schema(implementation = ApiError.class),
                    examples = {
                            @ExampleObject(name = "UsernameExists", summary = "Kasutajanimi on juba olemas", value = "{\"errorCode\": 113, \"message\": \"Kasutajanimi on juba olemas\"}"),
                            @ExampleObject(name = "EmailExists", summary = "Selle emailiga kasutaja on juba registreeritud", value = "{\"errorCode\": 114, \"message\": \"Selle emailiga kasutaja on juba registreeritud\"}")
                    }
            ))
    })

    public Integer register (@RequestBody @Valid UserInfo userInfo){
        return registerService.register(userInfo);

    }

}
