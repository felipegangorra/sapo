package sapo.funções;

import sapo.pessoa.Comentario;

import java.util.List;

public class FunçõesAluno extends Funções{
    public FunçõesAluno(String cpf, String nome, String[] habilidades, List<Comentario> comentarios) {
        super(cpf, nome, habilidades, comentarios);
    }
}
