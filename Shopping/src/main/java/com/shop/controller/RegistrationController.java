package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.shop.model.User;
import com.shop.service.EmailService;
import com.shop.service.UserService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController

public class RegistrationController {

	@Autowired
	private UserService userService;
	@Autowired
	EmailService emailService;

	@PostMapping("/rest/create")
	public ResponseEntity<String> userRegister(@RequestBody User user) {

		Twilio.init("", "");
		Message message = Message.creator(new PhoneNumber(user.getMobileNumber()), new PhoneNumber("+14302305740"),
				"Thank you for Regiistration").create();
		userService.save(user);

		SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setText("To confirm your account, please click here");
        emailService.sendEmail(mailMessage);
		return new ResponseEntity<String>("User Added Successfully", HttpStatus.OK);

	}

	@GetMapping("/rest/getAll")
	public ResponseEntity<List<User>> getAllUser()
	{

		List users= userService.getallUsers();
		
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	
}
