package facade;

import org.junit.jupiter.api.Test;
import sapo.facade.Facade;

class BuscasTest {

	@Test
	void buscaPessoa() {
		Facade facade = new Facade();
		String[] habilidades = {"oop", "linda"};
		facade.cadastraPessoa("089101898-32", "Leticia", habilidades);
		var idAtividade = facade.cadastrarAtividade("Estudar 00", "fjdfkljsdjklf", "089101898-32");
		String[] habilidadesAt = {"oop", "organizado"};
		var tarefaId = facade.cadastraTarefa(idAtividade, "fazer resumo", habilidadesAt);

		for(String a: facade.busca("Leticia linda")){
			System.out.println(a);
		}
		for(String a: facade.busca("linda")){
			System.out.println(a);
		}
	}

	// fazer texte busca pessoa
	//não é relevante se as chaves de busca estão em maiúsculas ou não, mostrar q funciona hab OI busca oi

}
