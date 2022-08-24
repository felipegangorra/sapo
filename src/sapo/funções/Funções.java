package sapo.funções;

import java.util.List;

import sapo.pessoa.Comentario;
import sapo.pessoa.Pessoa;

public class Funções extends Pessoa {
    public Funções(String cpf, String nome, String[] habilidades, List<Comentario> comentarios) {
        super(cpf, nome, habilidades, comentarios);
    }

}
