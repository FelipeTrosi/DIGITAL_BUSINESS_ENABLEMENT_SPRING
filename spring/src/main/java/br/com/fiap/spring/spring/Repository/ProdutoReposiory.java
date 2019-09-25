package br.com.fiap.spring.spring.Repository;

import br.com.fiap.spring.spring.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoReposiory extends JpaRepository<Produto, Integer> {

}
