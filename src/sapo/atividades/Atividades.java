package sapo.atividades;

public class Atividades {

    private String nome;
    private String descricao;
    private String cpf;
    private String id;

    public Atividades(String nome , String descricao, String cpf){
        this.nome = nome;
        this.descricao = descricao;
        this.cpf = cpf;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public String getCpf(){
        return this.cpf;
    }
    public String getId(){
        return this.id;
    }

    public void setId(String id){this.id = id;}


}
