package br.com.josecampelo.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissaoController {

    // GET -- Mandar uma requisição para mostrar as missões
    @GetMapping("/listar")
    public String listarMissao(){
        return "Missão listadas com sucesso!";
    }

    // POST -- Mandar uma requisição para criar as missões
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missão criada com sucesso!";
    }

    // PUT -- Mandar uma requisição para alterar as missões
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missão alterada com sucesso!";
    }

    // PUT -- Mandar uma requisição para deletar as missões
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missão deletada com sucesso!";
    }
}