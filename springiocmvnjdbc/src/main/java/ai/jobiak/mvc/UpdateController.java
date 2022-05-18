package ai.jobiak.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UpdateController {
	
	@Autowired
	SignupDAO update;
	
	public UpdateController(SignupDAO signup) {
		this.update=signup;
	}
	
	@RequestMapping(value="updateemail",method=RequestMethod.POST)
	public String doSignup(User user,ModelMap map) {
		update.updateEmail(user.getMobile(),user.getEmail());
		user=update.showUser(user.getMobile());
		map.put("fname",user.getFname());
		map.put("mobile",user.getMobile());
		map.put("email",user.getEmail());
		return "user";
	}
	
	
 
	
	
	
	
}
