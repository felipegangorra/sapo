package sapo.test;

import org.junit.jupiter.api.BeforeEach;
import sapo.facade.Facade;

public class BaseTest {

    public static final String[] HABILIDADES_1 = {"oop", "linda"};
    public static final String[] HABILIDADES_2 = {"oop", "linda", "estudo"};
    public static final String[] HABILIDADES_3 = {"oop", "calculo", "estudo"};
    public static final String NOME_1 = "Leticia Farias";
    public static final String NOME_2 = "Arthur Macedo";
    public static final String NOME_3 = "Lucas Farias";
    public static final String CPF_1 = "08907070372";
    public static final String CPF_2 = "4234657683";
    public static final String CPF_3 = "32683";
    public static final String NOME_ATIVIDADE_1 = "projeto inove";
    public static final String NOME_ATIVIDADE_2 = "Laboratorio";
    public static final String DESCRICAO_1 = "Atividade p promover ino  no campus";
    public static final String DESCRICAO_2 = "atividade tiltante";
    public static final String NOME_TAREFA_1 = "planejar atividade";
    public static final String NOME_TAREFA_2 = "estudar mais";
    public static String ID_ATIVIDADE_1;
    public static final int HORAS_1 = 5;
    public static final int HORAS_2 = 3;
    protected Facade facade;


    @BeforeEach
    void setup(){
        this.facade = new Facade();
        facade.cadastraPessoa(CPF_3, NOME_3,HABILIDADES_3);
        this.ID_ATIVIDADE_1 = facade.cadastrarAtividade(NOME_ATIVIDADE_2, DESCRICAO_2, CPF_3);
    }
}

