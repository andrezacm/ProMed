package controllers;

import models.MAnamnese;
import models.MPaciente;

import java.util.List;
import models.MAnamnese;

import play.mvc.Controller;


public class Anamnese extends Controller {
	

	static MAnamnese _anam = new MAnamnese();
	
	public static void cadastrar() {
		render("Application/inserir_anamnese.html");
	}
	
	public static void index() {
		render("Application/index.html");
	}

	public static void cadastrar_anamnese(String endereco ,String estado_civil,String profissao,String local_de_trabal, String procedencia,
			String qp,String cd , String hda, String hpp, String hf){
		MAnamnese anamnese = new MAnamnese(endereco ,estado_civil,profissao,local_de_trabal,procedencia,
				qp,cd , hda, hpp, hf);
		if (validation.hasErrors()) {
			render("Application/inserir_anamnese.html", anamnese);
		}

		anamnese.salvar();
		index();
	
	}

}




