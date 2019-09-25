package br.com.fiap.spring.spring.Controller;

import br.com.fiap.spring.spring.Model.Produto;
import br.com.fiap.spring.spring.Repository.ProdutoReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("produto")
public class ProdutoController {
    @Autowired
    private ProdutoReposiory reposiory;

    @GetMapping("/cadastrar")
    public String abirirFormulario(Produto produto, Model model){
        model.addAttribute("prod",produto);
        return "produto/form";
    }

    @PostMapping("/cadastrar")
    public String cadastrarProduto(Produto produto, Model model){
        model.addAttribute("prod",produto);
        reposiory.save(produto);
        return "redirect:/produto/listar";
    }

    @GetMapping("/listar")
    public String listarProdutos(Produto produto, Model model){
        model.addAttribute("produtos",reposiory.findAll());
        return "produto/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarProdutos(@PathVariable("id") int codigo, Model model){
        model.addAttribute("prod",reposiory.findById(codigo));
        return "produto/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluirProduto(@PathVariable("id") int codigo, Model model){
        reposiory.deleteById(codigo);
        return "produto/form";
    }




}
