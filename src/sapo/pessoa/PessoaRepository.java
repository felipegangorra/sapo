package sapo.pessoa;

import java.util.HashMap;

public class PessoaRepository {
    private HashMap<String,Pessoa> pessoas;

    public PessoaRepository() {
        this.pessoas = new HashMap<>();
    }

    public void salvaPessoa(Pessoa pessoa) {
        this.pessoas.put(pessoa.getCpf(), pessoa);
    }

    public Pessoa getPessoa(String cpf) {
        if(pessoas.containsKey(cpf)){
            return pessoas.get(cpf);
        }else{
            throw new IllegalArgumentException("Não existe essa pessoa");
        }

    }

    public HashMap<String, Pessoa> getAllPessoas(){
        if(this.pessoas !=null){
            return pessoas;
        } else {
            throw new IllegalArgumentException("pessoas está vázio");
        }
    }

    public void deletaPessoa(String cpf) {
        if (pessoas.containsKey(cpf)) {
            pessoas.remove(cpf);
        }
    }

}