package sapo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sapo.facade.Facade;

class AtividadesTest {

	@BeforeEach
	void test() {
		Facade facade = new Facade();
		String[] habilidades = {"oop", "linda"};
		facade.cadastraPessoa("089101898-32", "Leticia", habilidades);
		var idAtividade = facade.cadastrarAtividade("Estudar 00", "fjdfkljsdjklf", "089101898-32");
		String[] habilidadesAt = {"oop", "organizado"};
		var tarefaId = facade.cadastrarTarefa(idAtividade, "fazer resumo", habilidadesAt);
	}

	@Test

	void toStringTest(){
		Facade facade = new Facade();
		String[] habilidades = {"oop", "linda"};
		facade.cadastraPessoa("089101898-32", "Leticia", habilidades);
		var idAtividade = facade.cadastrarAtividade("Estudar 00", "fjdfkljsdjklf", "089101898-32");
		String[] habilidadesAt = {"oop", "organizado"};
		var tarefaId = facade.cadastrarTarefa(idAtividade, "fazer resumo", habilidadesAt);
		System.out.println(facade.exibirAtividades(idAtividade));
	}

}
