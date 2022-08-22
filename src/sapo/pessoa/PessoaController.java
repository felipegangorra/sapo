package sapo.pessoa;

import java.util.HashMap;

public class PessoaController {

    private PessoaService pessoaService;

    public PessoaController(PessoaService ps){
        this.pessoaService = ps;
    }

    public void cadastrarPessoa(String cpf, String nome, String[] habilidades){
        pessoaService.cadastrarPessoa(cpf, nome, habilidades);
    }

    public String exibirPessoa(String cpf){
        return pessoaService.exibirPessoa(cpf);
    }

    public void alterarNomePessoa(String cpf, String novoNome){
        pessoaService.alterarNomePessoa(cpf, novoNome);
    }

    public void alterarHabilidadePessoa(String cpf, String[] novasHabilidades){
        pessoaService.alterarHabilidadePessoa(cpf, novasHabilidades);
    }

    public void removerPessoa(String cpf){
        pessoaService.removerPessoa(cpf);
    }

    public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf){
        pessoaService.adicionarComentarioPessoa(cpf, comentario, autorCpf);
    }

    public String listarComentariosPessoa(String cpf){
        return pessoaService.listarComentariosPessoa(cpf);
    }

    public PessoaRepository getPessoas() {
        return pessoaService.getPessoasRepo();
    }

    public PessoaRepository getPessoasRepo(){return pessoaService.getPessoasRepo();}

}