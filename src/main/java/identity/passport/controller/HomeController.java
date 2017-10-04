package identity.passport.controller;

import java.io.UnsupportedEncodingException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.exceptions.JWTCreationException;

import identity.passport.entity.PrincipleUser;
import identity.passport.form.LoginForm;
import identity.passport.service.JwtTokenService;

@RestController
public class HomeController {
	@Autowired
	private JwtTokenService jwtTokenService;
	
	@PostMapping("/login")
	@ResponseBody
	public String login(@RequestBody LoginForm loginForm){
		try {
			// TODO check login
			System.out.println(loginForm.getUsername());
			return jwtTokenService.createToken("t.shiono@id-entity.jp");
		} catch (IllegalArgumentException | JWTCreationException | UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/test")
	@ResponseBody
	public String test(Authentication authentication){
		PrincipleUser pu = (PrincipleUser) authentication.getPrincipal();
		System.out.println(pu.getPassword() + "  " + pu.getUser().getId());
		return "test authentication";
	}
	
	@GetMapping("/error401")
	@ResponseBody
	public String error(){
		return "This is error";
	}
}
