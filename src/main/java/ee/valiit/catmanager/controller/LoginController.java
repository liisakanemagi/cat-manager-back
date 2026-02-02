package ee.valiit.catmanager.controller;

import ee.valiit.catmanager.infrastructure.error.ApiError;
import ee.valiit.catmanager.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    @Operation(summary = "Sisse logimine. Tagastab userId, userRole ja tokeni",
            description = """
                    Süsteemist otsitakse username ja password abil kasutajat.
                    Kui vastet ei leita vistakse viga errorCode'ga 111""")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Vale kasutajanimi või parool", content = @Content(schema = @Schema(implementation = ApiError.class)))})

    public LoginResponse login (@RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest.getUsername(), loginRequest.getPassword());
    }
}