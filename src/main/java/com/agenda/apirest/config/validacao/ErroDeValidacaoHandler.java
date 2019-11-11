package com.agenda.apirest.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroDeValidacaoHandler {
	
	// Pegar a mensagem Internacional
	// Injetar a classe Handler um atributo messageSource
	@Autowired
	private MessageSource messageSource;
	// Para alterar o status code
	@ResponseStatus(code = HttpStatus.BAD_REQUEST) // devolver 400, independente se tiver tratando erro, não pode devolver 200
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeFormularioDto> handle(MethodArgumentNotValidException exception) /* será a nossa mensagem personalizada de erro */ {
		List<ErroDeFormularioDto> dto = new ArrayList<>(); 
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		// Percorrendo para cada fieldErrors e criar objeto ErroDeFormularioDto e guardar na lista
		// Utilizando Java 8
		fieldErrors.forEach(e -> {
			// Passando a lambda
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale()); // pegar a mensagem traduzida
			ErroDeFormularioDto erro = new ErroDeFormularioDto(e.getField(), mensagem);
			dto.add(erro);
		});
		
		return dto;
	}

}
