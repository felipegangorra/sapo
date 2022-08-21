package sapo.pessoa;

public class Comentario {

    private String texto;
    private String autorCpf;
    private String localTime;
    
    // salva a data e hora de criuação do comentario
    public Comentario(String texto, String autorCpf){
        this.texto = texto;
        this.autorCpf = autorCpf;
    }
}