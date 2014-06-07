
package org.springside.examples.quickstart.rest;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.config.Config;
import org.springside.examples.quickstart.entity.TMBaseUser;
import org.springside.examples.quickstart.service.tennis.BaseUserService;
import org.springside.utils.AESutils;

@Controller
@RequestMapping(value = "/api/auth")
public class AuthController {

	private static Logger log = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	private BaseUserService baseUserService;
	
	
	@RequestMapping(value = "/register",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> register(@RequestBody String registerUser) {
		String password = "register"+Config.ENCODE_SALT;
		try {
			String strUser = new String(AESutils.decryptData(registerUser.getBytes(), password ),"utf-8");
			// TODO json to baseUser model
//			TMBaseUser baseUser =  
			// 保存任务
//			baseUserService.saveTMBaseUser(baseUser);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO return userid if ok
		return null;
	}
	
	
	private void login() {
		// TODO user  return  ok (user id) or fails and reasonmessage

	}
	
	private void logout() {
		// TODO user return ok or fails and reasonmessage

	}
	
	
	
	
}
