package com.shop.controller;

import java.io.ByteArrayInputStream;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.model.Product;
import com.shop.model.User;
import com.shop.service.PdfGenerator;
import com.shop.service.ProductService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
public class ProductController {

	
	@Autowired
	ProductService productService;
//	private JavaMailSender mailSender;
//	private SimpleMailMessage simpleMailMessage;

	
	@PostMapping("/rest/product")
	public ResponseEntity<String> userRegister(@RequestBody Product product) {

		productService.saveProduct(product);
		
		

//        ByteArrayInputStream bis = PdfGenerator
//                           .employeePDFReport(product);
//                           
//                           MimeMessage message = mailSender.createMimeMessage();
//		
// 	   try{
// 		MimeMessageHelper helper = new MimeMessageHelper(message, true);
// 			
// 		helper.setFrom(simpleMailMessage.getFrom());
// 		helper.setTo(simpleMailMessage.getTo());
// 		helper.setSubject(simpleMailMessage.getSubject());
// 		helper.setText(String.format(
// 			simpleMailMessage.getText()));
// 			
// 		FileSystemResource file = new FileSystemResource("C:\\log.txt");
// 		helper.addAttachment(file.getFilename(), file);
//
// 	     }catch (MessagingException e) {
// 		throw new MailParseException(e);
// 	     }
// 	     mailSender.send(message);
        return new ResponseEntity<String>("product Added Successfully", HttpStatus.OK);

	}
	
	
	
}
