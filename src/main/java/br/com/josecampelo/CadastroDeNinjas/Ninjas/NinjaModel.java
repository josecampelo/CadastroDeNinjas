package br.com.josecampelo.CadastroDeNinjas.Ninjas;

import br.com.josecampelo.CadastroDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "idade")
    private int idade;

    // @ManyToOne -> Muitos Ninjas (NinjaModel) para uma missão (MissaoModel)
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreing Key ou chave estrangeira
    private MissaoModel missoes;
}