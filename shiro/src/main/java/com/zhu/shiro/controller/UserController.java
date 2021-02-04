package com.zhu.shiro.controller;

import com.zhu.shiro.entity.User;
import com.zhu.shiro.service.UserService;
import com.zhu.shiro.util.Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 朱桂林 create 2021/2/3 15:02
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Value("${shiro.salt}")
	private String salt;
	@Value("${shiro.password.md5.number}")
	private Integer number;
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login(String username,String password){
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(new UsernamePasswordToken(username,password));
			System.out.println("登录成功");
			subject.hasRole("admin");
			return "redirect:/index.jsp";
		} catch (UnknownAccountException e) {
			e.printStackTrace();
			System.out.println("用户名错误");
		} catch (IncorrectCredentialsException e){
			e.printStackTrace();
			System.out.println("密码错误");
		}
		return "redirect:/login.jsp";
	}

	@RequestMapping("/loginout")
	public String loginout(){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/login.jsp";
	}

	@RequestMapping("/regist")
	public String regist(String username,String password){
		if(StringUtils.hasText(username)&&StringUtils.hasText(password)){
			User user =new User();
			user.setUsername(username);
			String salt1 = Utils.getSalt();
			user.setSalt(salt1);

			Md5Hash md5Hash=new Md5Hash(password, salt1,number);
			String password1 = md5Hash.toHex();
			System.out.println(password1);
			user.setPassword(password1);

			userService.regist(user);
			return "redirect:/login.jsp";
		}
		return "redirect:/regist.jsp";
	}

	@RequestMapping("/encache")
	public String encache(){
		Subject subject = SecurityUtils.getSubject();
		subject.isAuthenticated();
		subject.hasRole("admin");
		return "redirect:/index.jsp";
	}
}
