package com.aulajava.springboot.pagina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aulajava.springboot.repository.PessoaRepository;

import curso.springboot.model.Pessoa;

@Controller
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/cadastropessoa") //Método GET passando redirecionando.
	
	public String inicio() {
		return "cadastro/cadastropessoa"; //O controller vai redirecionar para a tela conforme informado no retorno.
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/salvarpessoa")
	public String salvar(Pessoa pessoa) {
		
		pessoaRepository.save(pessoa);
		return "cadastro/cadastropessoa"; //Apos salvar as informações que iremos fazer atraves do metodo POST ira retornar para a pagina redirecionada
	}
	

}