package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.utils.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Telefone {

	//Atributos
	private int ddd;
	private int numero;

	//Construtores
	public Telefone() {
		super();
		this.ddd = 0;
		this.numero = 0;
	}

	//Getters e Setters
	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	//Métodos Próprios
	public static Telefone obtenhaInstancia(String telefoneFormatado) {
		//Regex para pegar só o ddd: (?<=\()\d{2}(?=\))
		Pattern padraoDdd = Pattern.compile("(?<=\\()\\d{2}(?=\\))");
		Matcher matcherDDD = padraoDdd.matcher(telefoneFormatado);
		int ddd = 0;

		if (matcherDDD.find()) {
			ddd = Utils.convertaParaInt(matcherDDD.group());
		}


		Pattern padraoNumero = Pattern.compile("(?<=\\))\\d{4,5}\\-\\d{4}");
		Matcher matcherNumero = padraoNumero.matcher(telefoneFormatado);
		int numero = 0;
		if (matcherNumero.find()) {
			numero = Utils.convertaParaInt(matcherNumero.group().replace("-", ""));
		}


		Telefone telefoneRetorno = new Telefone();
		telefoneRetorno.setDdd(ddd);
		telefoneRetorno.setNumero(numero);
		return telefoneRetorno;
	}

	@Override
	public String toString() {
		return "(" + this.ddd + ")" + numero;
	}
}
