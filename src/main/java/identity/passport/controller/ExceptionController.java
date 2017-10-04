package identity.passport.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(Exception.class)
	public @ResponseBody String handleException(){
		return "error";
	}
}
