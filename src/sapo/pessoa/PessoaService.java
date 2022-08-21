package sapo.pessoa;

public class PessoaService {

    private PessoaRepository pr;

    public PessoaService(){
        this.pr = new PessoaRepository();
    }

    public void cadastrarPessoa(String cpf, String nome, String[] habilidades){
        Pessoa pessoa = new Pessoa(cpf, nome, habilidades);
        this.pr.salvaPessoa(pessoa);
    }

    public String exibirPessoa(String cpf){
        Pessoa pessoa = this.pr.getPessoa(cpf);
        return pessoa.toString();
    }

    public void alterarNomePessoa(String cpf, String novoNome){
        Pessoa pessoa = this.pr.getPessoa(cpf);
        pessoa.setNome(novoNome);
    }

    public void alterarHabilidadePessoa(String cpf, String[] novasHabilidades){
    	Pessoa pessoa = this.pr.getPessoa(cpf);
    	pessoa.setHabilidades(novasHabilidades);
    }

    public void removerPessoa(String cpf){
    	pr.deletaPessoa(cpf);
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

    public PessoaRepository getPessoasRepo(){return this.pr;}

}