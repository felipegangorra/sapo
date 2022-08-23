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
    public static final String NOME_ATIVIDADE_1 = "projeto inove";
    public static final String NOME_ATIVIDADE_2 = "Lab06";
    public static final String DESCRICAO_1 = "Atividade p promover ino  no campus";
    public static final String DESCRICAO_2 = "atividade tiltante";
    protected Facade facade;


    @BeforeEach
    void setup(){
        this.facade = new Facade();
    }
}
