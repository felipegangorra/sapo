package sapo.pessoa;

import java.util.HashMap;

import sapo.atividades.Atividade;

public class PessoaService {

    private PessoaRepository pr;

    public PessoaService(){
        this.pr = new PessoaRepository();
    }

    public void cadastrarPessoa(String cpf, String nome, String[] habilidades){
        Pessoa pessoa = new Pessoa(cpf, nome, cpf, []habilidades);
        this.pr.salvaPessoa(pessoa);
    }

    public String exibirPessoa(String cpf){
        return null;
    }

    public void alterarNomePessoa(String cpf, String novoNome){
    	return;
    }

    public void alterarHabilidadePessoa(String cpf, String[] novasHabilidades){
    	return;
    }

    public void removerPessoa(String cpf){
    	return;
    }

    public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf){
        return;
    }

    public String listarComentariosPessoa(String cpf){
    	return null;
    }

    public String[] busca(String consulta) {
    	return null;
    }
    public HashMap<String, Pessoa> getPessoas() {
        return pr.getPessoas();
    }

    public PessoaRepository getPessoasRepo(){return this.pr;}

}