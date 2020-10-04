package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.ProdutoModel;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value ="/api")
@Api(value="API REST Produtos") // <-- Ela serve para dar um titulo a API
@CrossOrigin(origins="*") // <-- Permite que a API seja acessada por qualquer dominio
public class ProdutoResource {

	//api-rest-produtx-> heroku
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	//Lista todos os produtos
	@GetMapping("/produtos")
	@ApiOperation(value="Retorna uma lista de produtos") // <-- Nomeia a definição do metodo
	public List<ProdutoModel> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	//Lista um unico produto pelo ID
	@GetMapping("/produto/{id}")
	@ApiOperation(value="Retorna um unico produto")
	public ProdutoModel listaProdutoUnico(@PathVariable(value="id")long id) {
		return produtoRepository.findById(id);
	}
	
	// Salva os dados 
	@PostMapping("/produto")	
	@ApiOperation(value="Salva um produto na lista")
	public ProdutoModel salvaProduto(@RequestBody ProdutoModel produto) {
		return produtoRepository.save(produto);
	}
	
	//Excluir um produto do banco
	@DeleteMapping("/produto")
	@ApiOperation(value="Exclui um produto da lista")
	public void deletaProduto (@RequestBody ProdutoModel produto) {
		produtoRepository.delete(produto);;
	}
	
	//Atualiza os dados do banco
	@PutMapping("/produto")
	@ApiOperation(value="Atualiza um produto da lista")
	public ProdutoModel atualizaProduto (@RequestBody ProdutoModel produto) {
		return produtoRepository.save(produto);
	}
}
