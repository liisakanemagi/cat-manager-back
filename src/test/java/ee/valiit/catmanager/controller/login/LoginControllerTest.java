package ee.valiit.catmanager.controller.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import ee.valiit.catmanager.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// @WebMvcTest testib ainult kontrollerit.
@WebMvcTest(LoginController.class)
// @AutoConfigureMockMvc(addFilters = false) on "võluvits".
// See lülitab testimise ajaks VÄLJA kõik Spring Security filtrid (sh sisselogimise kontrolli, CSRF jne).
// See tähendab, et me saame testida puhtalt kontrolleri loogikat ilma turvalisuse pärast muretsemata.
// See on ühiktestide jaoks sageli parim ja lihtsaim viis.
@AutoConfigureMockMvc(addFilters = false)
class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoginService loginService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void login_returnsLoginResponse_whenCredentialsAreCorrect() throws Exception {
        // ARRANGE
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("testuser");
        loginRequest.setPassword("testpass");

        LoginResponse loginResponse = new LoginResponse(1, "USER", "fake-jwt-token");

        when(loginService.login("testuser", "testpass")).thenReturn(loginResponse);

        // ACT & ASSERT
        mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.userRole").value("USER"))
                .andExpect(jsonPath("$.token").value("fake-jwt-token"));
    }

    @Test
    void login_returnsError_whenCredentialsAreIncorrect() throws Exception {
        // ARRANGE
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("wronguser");
        loginRequest.setPassword("wrongpass");

        // Simuleerime olukorda, kus teenus viskab vea.
        // Kuna turvafiltrid on väljas, peab see viga tulema kontrollerist või globaalsest veahaldusest.
        // Kui sinu rakenduses tegeleb vigadega @ControllerAdvice, siis see test peaks töötama.
        // Kui viga visatakse lihtsalt õhku, võib vastus olla 500 Internal Server Error, mitte 403.
        // Aga proovime ja vaatame, mis juhtub.
        when(loginService.login("wronguser", "wrongpass")).thenThrow(new RuntimeException("Vale kasutajanimi või parool"));

        // ACT & ASSERT
        mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                // Siin võib tulla muudatus: kui turvalisus on väljas, ei pruugi tulla 403.
                // Aga jätame selle esialgu nii ja vaatame, mis test ütleb.
                .andExpect(status().isForbidden());
    }
}
