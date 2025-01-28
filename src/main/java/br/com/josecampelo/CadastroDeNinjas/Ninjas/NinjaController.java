package br.com.josecampelo.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ninja")
public class NinjaController {

    // Adiciona Ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado";
    }

    // Mostrar todos os Ninjas (READ)
    @GetMapping("/listar")
    public String mostrarTodosNinjas(){
        return "Mostrar Ninjas";
    }

    // Procurar Ninja por ID (READ)
    @GetMapping("/listarID")
    public String mostrarTodosNinjasPorId(){
        return "Mostrar Ninja por ID";
    }

    // Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar Ninja por ID";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Deletar Ninja por ID";
    }
}