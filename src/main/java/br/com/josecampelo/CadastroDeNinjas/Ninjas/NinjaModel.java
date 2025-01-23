package br.com.josecampelo.CadastroDeNinjas.Ninjas;

import br.com.josecampelo.CadastroDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private int idade;

    // @ManyToOne -> Muitos Ninjas (NinjaModel) para uma missão (MissaoModel)
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreing Key ou chave estrangeira
    private MissaoModel missoes;

}