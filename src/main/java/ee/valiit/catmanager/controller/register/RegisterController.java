package ee.valiit.catmanager.controller.register;


import ee.valiit.catmanager.infrastructure.error.ApiError;
import ee.valiit.catmanager.service.RegisterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
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
            @ApiResponse(responseCode = "403", description = "Kasutajanimi on juba olemas (errorCode 113)", content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "402", description = "Selle emailiga kasutaja on juba registreeritud (errorCode 114)", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })

    public Integer register (@RequestBody @Valid UserInfo userInfo){
        return registerService.register(userInfo);

    }

}
