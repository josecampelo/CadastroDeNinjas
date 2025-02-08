package br.com.josecampelo.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninja")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criacao do ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaDTO){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninjaDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome());
    }

    @Operation(summary = "Lista todos os ninjas", description = "Rota que lista todos os ninjas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninjas listados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum ninja encontrado")
    })
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> listaNinjas = ninjaService.listarNinja();

        return ResponseEntity.ok(listaNinjas);
    }

    @Operation(summary = "Lista o ninja por id", description = "Rota que lista o ninja por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja listado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja nao encontrado")
    })
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjaPorId(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);

        if(ninja != null){
            return ResponseEntity.ok(ninja);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID: " + id + " não encontrado no banco de dados");
        }
    }

    @Operation(summary = "Altera o ninja por id", description = "Rota que altera o ninja por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja nao encontrado")
    })
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarNinja(
            @Parameter(description = "Usuario manda o id no caminho da requisicao")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados do ninja a ser atualizado no corpo da requisicao")
            @RequestBody NinjaDTO ninjaAtualizado){
            NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado
            );

        if(ninja != null){
            return ResponseEntity.ok(ninja);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID: " + id + " não encontrado. Digite um ID existente para a exclusão.");
        }
    }

    @Operation(summary = "Deleta um ninja", description = "Rota que deleta um ninja")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja nao encontrado")
    })
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){
        if(ninjaService.listarNinjaPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);

            return ResponseEntity.ok("Ninja com o ID: " + id + " deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID: " + id + " não encontrado. Digite um ID existente para a exclusão.");
        }
    }
}