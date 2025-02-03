package br.com.josecampelo.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Adiciona Ninja (CREATE)
    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninjaDTO){

        return ninjaService.criarNinja(ninjaDTO);
    }

    // Mostrar todos os Ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas(){
        return ninjaService.listarNinja();
    }

    // Procurar Ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public NinjaDTO listarNinjaPorId(@PathVariable Long id){
        return ninjaService.listarNinjaPorId(id);
    }

    // Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/atualizar/{id}")
    public NinjaDTO atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }
}