package defaultPack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo {
	public List<Conteudo> extraiConteudos (String json){
		var parser =  new JsonParser();
		List<Map<String, String>> listaConteudo = parser.parse(json);
		List<Conteudo> conteudos = new ArrayList<>();
		
		//popular a lista
		for(Map<String, String> atributos:listaConteudo) {
			String titulo 	= atributos.get("title");
			String urlImg 	= atributos.get("url");
			var conteudo = new Conteudo(titulo, urlImg);
			conteudos.add(conteudo);
		}
		
		return conteudos;
	}
}
