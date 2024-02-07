package com.joao.curso.remedios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joao.curso.remedios.remedio.DadosAtualizarRemedio;
import com.joao.curso.remedios.remedio.DadosCadastroRemedio;
import com.joao.curso.remedios.remedio.DadosListagemRemedio;
import com.joao.curso.remedios.remedio.Remedio;
import com.joao.curso.remedios.remedio.RemedioRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

	@Autowired
	private RemedioRepository repository;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroRemedio dados) {
		repository.save(new Remedio(dados));
	}

	@GetMapping
	public List<DadosListagemRemedio> listar() {
		return repository.findAllByAtivoTrue().stream().map(DadosListagemRemedio::new).toList();
	}

	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizarRemedio dados) {
		var remedio = repository.getReferenceById(dados.id());
		remedio.atualizarInformacoes(dados);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public void deletar(@PathVariable Long id) {
		repository.deleteById(id);
	}

	@DeleteMapping("desativar/{id}")
	@Transactional
	public void desativar(@PathVariable Long id) {
		var remedio = repository.getReferenceById(id);
		remedio.desativar();
	}

	@PutMapping("ativar/{id}")
	@Transactional
	public void ativar(@PathVariable Long id) {
		var remedio = repository.getReferenceById(id);
		remedio.ativar();
	}
}
