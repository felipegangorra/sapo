package sapo.pessoa;

import java.time.LocalDateTime;

public class Comentario {

    private String texto;
    private String autorCpf;
    private LocalDateTime data;
    
    // salva a data e hora de criuação do comentario
    public Comentario(String texto, String autorCpf){
        this.texto = texto;
        this.autorCpf = autorCpf;
        this.data = LocalDateTime.now();
    }

    public String getTexto() {
        return texto;
    }

    public String getAutorCpf() {
        return autorCpf;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setAutorCpf(String autorCpf) {
        this.autorCpf = autorCpf;
    }

    public String toString(){
        return texto;
    }
}