package controllers;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import play.*;
import play.data.validation.Required;
import play.libs.Mail;
import play.mvc.*;

import models.MUsuario;

public class Application extends Controller {
	
	public static void index() {
		if (Security.isAuthorized())
			render();
		else
			login();
	}

	public static void index2() {
		render();
	}
	
	public static void getContato() throws EmailException, MalformedURLException{
		HtmlEmail email = new HtmlEmail();
		email.addTo("lord.sena@gmail.com");
		email.setFrom("lord.sena@gmail.com", "Thiago César");
		email.setSubject("Test email with inline image");
		// embed the image and get the content id
		URL url = new URL("http://designdicas.com/wp-content/uploads/2012/02/11-150x150.png");
		String cid = email.embed(url, "Meme logo");
		// set the html message
		email.setHtmlMsg("<html>Meme logo - <img src=\"cid:"+cid+"\"></html>");
		// set the alternative message
		email.setTextMsg("Your email client does not support HTML, too bad :(");
		Mail.send(email);
		
		render("Application/contato_enviado.html");
	}
	
	public static void inserir_anamnese(Long idPaciente) {
		render(idPaciente);
	}

	public static void login() {
		render();
	}
	
	public static void logout(){
		Security.setAuthorized(false);
		login();
	}
	
	public static void loginerror(){
		render();
	}

	public static void getLogin(String login, String senha){
		validation.required(login);
	    validation.required(senha);
			    
		MUsuario user = new MUsuario();
		user.setLogin(login);
		user.setSenha(senha);
		
		
		if (validation.hasErrors()) {
			render("Application/login.html", user);
		}
		
		MUsuario resultado = new MUsuario();
		resultado = resultado.getUsuario(login, senha);
		Security.setAuthorized(true);
		render("Application/index.html");

	}
	
	public static void sobre(){
		render();
	}
	
	public static void contato(){
		render();
	}
}
