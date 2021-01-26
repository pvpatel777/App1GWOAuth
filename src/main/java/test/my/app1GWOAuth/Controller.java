package test.my.app1GWOAuth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	// private OAuth2AuthorizedClientService authorizedClientService;

	Logger logger = LoggerFactory.getLogger(Controller.class);

	@GetMapping("/")
	public String index(Model model,
			@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
			@AuthenticationPrincipal OAuth2User oauth2User) {

		logger.debug("name:" + oauth2User.getName() + ", client:"
				+ authorizedClient.getClientRegistration().getClientName()
				+ ",attrs:" + oauth2User.getAttributes());
		model.addAttribute("userName", oauth2User.getName());
		model.addAttribute("clientName",
				authorizedClient.getClientRegistration().getClientName());
		model.addAttribute("userAttributes", oauth2User.getAttributes());
		return "index";
	}

	// @GetMapping("")
	// public ResponseEntity<Object> currentUserToken(
	// @AuthenticationPrincipal Principal principal) {
	// // if (principal instanceof OAuth2AuthenticationToken) {
	// // Map<String, Object> attributes = new HashMap<>();
	// // OAuth2AuthenticationToken oauth2AuthenticationToken =
	// // (OAuth2AuthenticationToken) principal;
	// //
	// // OAuth2AuthorizedClient oauth2AuthorizedClient =
	// // authorizedClientService
	// // .loadAuthorizedClient(
	// // oauth2AuthenticationToken
	// // .getAuthorizedClientRegistrationId(),
	// // oauth2AuthenticationToken.getName());
	// // OAuth2AccessToken accessToken = oauth2AuthorizedClient
	// // .getAccessToken();
	// // OAuth2RefreshToken refreshToken = oauth2AuthorizedClient
	// // .getRefreshToken();
	// //
	// // attributes.put("name", oauth2AuthenticationToken.getName());
	// // attributes.put("accessToken", accessToken);
	// // attributes.put("refreshToken", refreshToken);
	// // return ResponseEntity.ok(attributes);
	// // }
	//
	// return ResponseEntity.ok(principal);
	// }

}
