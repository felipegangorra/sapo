package facade;

import org.junit.jupiter.api.BeforeEach;
import sapo.facade.Facade;

public class BaseTest {

    public static final String[] HABILIDADES_1 = {"oop", "linda"};
    public static final String[] HABILIDADES_2 = {"oop", "linda", "estudo"};
    public static final String NOME_1 = "Leticia Farias";
    public static final String NOME_2 = "Arthur Macedo";
    public static final String CPF_1 = "08907070372";
    public static final String CPF_2 = "4234657683";
    protected Facade facade;


    @BeforeEach
    void setup(){
        this.facade = new Facade();
    }
}
