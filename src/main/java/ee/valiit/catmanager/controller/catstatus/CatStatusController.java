package ee.valiit.catmanager.controller.catstatus;

import ee.valiit.catmanager.service.CatStatusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class CatStatusController {

    private final CatStatusService catStatusService;

    @GetMapping("/cat/status")
   @Operation(summary = "Kassistaatuste pärimine", description = "Tagastatakse nimekiri kassistaatustest")
    public List<CatStatusInfo> getCatStatuses(){
        return catStatusService.getCatStatuses();

    }

}
