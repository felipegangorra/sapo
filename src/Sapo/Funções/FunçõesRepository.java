package Sapo.Funções;

import Sapo.TarefasGerencias.TarefaGerenciais;


import java.util.HashMap;

public class FunçõesRepository {

    private HashMap<String, Funções> funções;

    public FunçõesRepository(){
        this.funções = new HashMap<>();
    }
    public void salvaFunção(Funções função){
        this.funções.put(função.getCpf(), função);
    }

    public Funções getFunção(String cpf) {
        return funções.get(cpf);
    }

    public void deletaFunção(String cpf) {
        if (funções.containsKey(cpf)) {
            funções.remove(cpf);
        }else{
            throw new IllegalArgumentException("Cpf não cadastrado");
        }
    }
}
