package sapo.funções;

import sapo.pessoa.Comentario;
import sapo.pessoa.Pessoa;

import java.util.List;

public class Funções extends Pessoa{
    public Funções(String cpf, String nome, String[] habilidades, List<Comentario> comentarios) {
        super(cpf, nome, habilidades, comentarios);
    }

}
