package br.com.josecampelo.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Listar todos os meus Ninjas
    public List<NinjaModel> listarNinja() {
        return ninjaRepository.findAll();
    }

    // Listar todos os meus Ninjas por ID
    public NinjaModel listarNinjaPorId(@RequestBody Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }
}