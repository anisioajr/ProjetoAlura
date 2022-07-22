package defaultPack;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception{
	// 	String urlApi = "https://api.nasa.gov/planetary/apod?api_key=BYApMaRbDDKytHfw0nEyXiwKwKoWFQyx4prHxFkJ&start_date=2022-06-01&end_date=2022-06-23";
	 	String urlApi = "https://imdb-api.com/en/API/Top250Movies/k_4r0exeae";
		var http = new clienteHttp();
		String json = http.buscaDados(urlApi);		

	// 	ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
	 	ExtratorDeConteudo extrator = new ExtratorConteudoIMDB();
		List<Conteudo> conteudos = extrator.extraiConteudos(json);
		var geradora = new stickerGenerator();
		for	(int i=0 ; i <3 ; i++) {
			Conteudo conteudo = conteudos.get(i);
			InputStream inputStream =  new URL(conteudo.getUrlImg()).openStream();
	        String nomeSaida =  conteudo.getTitulo();
	        geradora.cria(inputStream, nomeSaida);
			
			System.out.println(conteudo.getTitulo());
			System.out.println();
		}	
	}
}
