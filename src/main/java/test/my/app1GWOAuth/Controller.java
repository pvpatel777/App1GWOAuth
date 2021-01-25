package test.my.app1GWOAuth;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	// private OAuth2AuthorizedClientService authorizedClientService;

	Logger logger = LoggerFactory.getLogger(Controller.class);

	@GetMapping("authorized")
	public String index() {
		return "index";
	}

	@GetMapping("")
	public ResponseEntity<Object> currentUserToken(
			@AuthenticationPrincipal Principal principal) {
		// if (principal instanceof OAuth2AuthenticationToken) {
		// Map<String, Object> attributes = new HashMap<>();
		// OAuth2AuthenticationToken oauth2AuthenticationToken =
		// (OAuth2AuthenticationToken) principal;
		//
		// OAuth2AuthorizedClient oauth2AuthorizedClient =
		// authorizedClientService
		// .loadAuthorizedClient(
		// oauth2AuthenticationToken
		// .getAuthorizedClientRegistrationId(),
		// oauth2AuthenticationToken.getName());
		// OAuth2AccessToken accessToken = oauth2AuthorizedClient
		// .getAccessToken();
		// OAuth2RefreshToken refreshToken = oauth2AuthorizedClient
		// .getRefreshToken();
		//
		// attributes.put("name", oauth2AuthenticationToken.getName());
		// attributes.put("accessToken", accessToken);
		// attributes.put("refreshToken", refreshToken);
		// return ResponseEntity.ok(attributes);
		// }

		return ResponseEntity.ok(principal);
	}

}
