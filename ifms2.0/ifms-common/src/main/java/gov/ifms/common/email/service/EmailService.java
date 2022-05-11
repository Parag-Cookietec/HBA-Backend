package gov.ifms.common.email.service;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.email.dto.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailService {

	private JavaMailSender javaMailSender;

	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Async
	public void sendMail(final Email email) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setSubject(email.getSubject());
		simpleMailMessage.setFrom(MsgConstant.SEND_EMAIL_FROM);
		simpleMailMessage.setTo(email.getTo());
		simpleMailMessage.setText(email.getMessageText());
		javaMailSender.send(simpleMailMessage);
	}

	@Async
	public void sendMailWithLogo(final Email email,Resource resourceFile) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true,"UTF-8");
		mimeMessageHelper.setSubject(email.getSubject());
		mimeMessageHelper.setFrom(MsgConstant.SEND_EMAIL_FROM);
		mimeMessageHelper.setTo(email.getTo());
		mimeMessageHelper.setText(email.getMessageText(),true);
		mimeMessageHelper.addInline("attachment.png", resourceFile);
		javaMailSender.send(mimeMessage);
	}

	@Async
	public void sendMailWithAttachment(final Email email, File[] attachments) throws Exception {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true,"UTF-8");//Change
		mimeMessageHelper.setSubject(email.getSubject());
		mimeMessageHelper.setFrom(email.getFrom());
		mimeMessageHelper.setTo(email.getTo());
		if(email.getBcc()!= null){
			mimeMessageHelper.setBcc(email.getBcc());
		}
		if(email.getCc()!= null){
			mimeMessageHelper.setCc(email.getCc());
		}
		mimeMessageHelper.setText(email.getMessageText(),true);//Change
		for (File file : attachments) {
			FileSystemResource fr = new FileSystemResource(file);
			mimeMessageHelper.addAttachment(file.getName(), fr);
		}
		javaMailSender.send(mimeMessage);
	}

	@Async
	public void sendMailWithOutLogo(final Email email) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true,"UTF-8");
		mimeMessageHelper.setSubject(email.getSubject());
		mimeMessageHelper.setFrom(MsgConstant.SEND_EMAIL_FROM);
		mimeMessageHelper.setTo(email.getTo());
		mimeMessageHelper.setText(email.getMessageText(),true);
		if(email.getBcc()!= null){
			mimeMessageHelper.setBcc(email.getBcc());
		}
		if(email.getCc()!= null){
			mimeMessageHelper.setCc(email.getCc());
		}
		javaMailSender.send(mimeMessage);
	}
}
