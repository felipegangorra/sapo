package sapo.pessoa;

import java.util.HashMap;
import java.util.Map;

public class PessoaRepository {
    private Map<String,Pessoa> pessoas;

    public PessoaRepository() {
        this.pessoas = new HashMap<>();
    }

    public void salvaPessoa(Pessoa pessoa) {
        this.pessoas.put(pessoa.getCpf(), pessoa);
    }

    public Pessoa getPessoa(String cpf) {
        return pessoas.get(cpf);
    }

    public void deletaPessoa(String cpf) {
        if (pessoas.containsKey(cpf)) {
            pessoas.remove(cpf);
        }
    }

}