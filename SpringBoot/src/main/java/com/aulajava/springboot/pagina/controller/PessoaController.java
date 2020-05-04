package com.aulajava.springboot.pagina.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aulajava.springboot.repository.PessoaRepository;


import curso.springboot.model.Pessoa;

@Controller
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/cadastropessoa") //Método GET passando redirecionando.
	
	public ModelAndView inicio() {
		ModelAndView modelAndView = new  ModelAndView("cadastro/cadastropessoa");
		modelAndView.addObject("pessoaobj", new Pessoa());
		return modelAndView; //O controller vai redirecionar para a tela conforme informado no retorno.
	}
	
	@RequestMapping(method = RequestMethod.POST, value ="**/salvarpessoa")
	public ModelAndView salvar(Pessoa pessoa) {
		
		pessoaRepository.save(pessoa);
		ModelAndView andView = new ModelAndView("cadastro/cadastropessoa");
		Iterable<Pessoa> pessoaIt = pessoaRepository.findAll(); //buscando no repositorio todo o cadastro de Pessoa
		andView.addObject("pessoas", pessoaIt); //adicionar a lista no atributo que está no HTML "Pessoa" 
		andView.addObject("pessoaobj", new Pessoa());
		return andView;//Apos salvar as informações que iremos fazer atraves do metodo POST ira retornar para a pagina redirecionada
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/listapessoas")
	public ModelAndView pessoas(){  //Modelo de dados e view  vai ligar o modelo de dados com tela

		ModelAndView andView = new ModelAndView("cadastro/cadastropessoa");
		Iterable<Pessoa> pessoaIt = pessoaRepository.findAll(); //buscando no repositorio todo o cadastro de Pessoa
		andView.addObject("pessoas", pessoaIt); //adicionar a lista no atributo que está no HTML "Pessoa" 
		andView.addObject("pessoaobj", new Pessoa());
		return andView;

	}
	
	@GetMapping("/editarpessoa/{idpessoa}")
	public ModelAndView editar(@PathVariable("idpessoa") Long idpessoa) {
		
		ModelAndView modelAndView = new  ModelAndView("cadastro/cadastropessoa");
		Optional<Pessoa> pessoa = pessoaRepository.findById(idpessoa);
		
		modelAndView.addObject("pessoaobj", pessoa.get());
		return modelAndView;
	}
	
	@GetMapping("/excluirpessoa/{idpessoa}")
	public ModelAndView excluir(@PathVariable("idpessoa")Long idpessoa) {
		
		pessoaRepository.deleteById(idpessoa);
		ModelAndView andView = new ModelAndView("cadastro/cadastropessoa");
		Iterable<Pessoa> pessoaIt = pessoaRepository.findAll(); //buscando no repositorio todo o cadastro de Pessoa
		andView.addObject("pessoas", pessoaIt); //adicionar a lista no atributo que está no HTML "Pessoa" 
		andView.addObject("pessoaobj", new Pessoa());
		return andView;//Apos salvar as informações que iremos fazer atraves do metodo POST ira retornar para a pagina redirecionada
	}

}