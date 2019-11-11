package com.agenda.apirest.config.validacao;

public class ErroDeFormularioDto {
	
	// duas informações que preciso
	private String campo;
	private String erro;
	
	public ErroDeFormularioDto(String campo, String erro) {
		//super();
		this.campo = campo;
		this.erro = erro;
	}

	// Como Já recebo os parametros no construtor, só preciso dos gets
	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}

}
