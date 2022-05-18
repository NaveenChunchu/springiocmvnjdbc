package ai.jobiak.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShowController {
	
	@Autowired
	SignupDAO show;
	
	public ShowController(SignupDAO signup) {
		this.show=signup;
	}
	
	@RequestMapping(value="show",method=RequestMethod.POST)
	public String doSignup(User user,ModelMap map) {
		
		user=show.showUser(user.getMobile());
		map.put("name",user.getFname());
		map.put("email",user.getEmail());
		map.put("mobile",user.getMobile());
		
		return "user";
	}


}
