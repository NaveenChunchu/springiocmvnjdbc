package ai.jobiak.mvc;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlProcessor.ResolutionMethod;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller

public class SignUpController {

	@Autowired
	SignupDAO signup;
	
	public SignUpController(SignupDAO signup) {  
		this.signup=signup;
	}
	
	@RequestMapping(value="signup",method=RequestMethod.POST)
	public String doSignup(User user,ModelMap map) {

		
		//ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("jdbc-beans2.xml");
		//SignupDAO dao = (SignupDAO) context.getBean("signup");
		//dao.insertRow(user.getFname(),user.getEmail(),user.getMobile());
	/*	map.put(fname,user.getFname());
		map.put(email,user.getEmail());
		map.put(mobile,user.getMobile());  */
		
		
		signup.insertRow(user.getFname(),user.getEmail(),user.getMobile());
		map.put("fname",user.getFname());
		map.put("email",user.getEmail());
		map.put("mobile",user.getMobile());
		return "user";
		
	}
	
} 