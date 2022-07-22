package defaultPack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class stickerGenerator {
	// metodo para criar a imagem
	
	public void cria(InputStream inputStream, String nomeSaida) throws Exception {
		// ler imagem
		// InputStream inputStream = 
		//          new FileInputStream(new File("entrada/MostPopularTVs_1.jpg"));
        // InputStream inputStream = 
	    //	  new URL("https://imersao-java-apis.s3.amazonaws.com/MostPopularTVs_1.jpg")
        //	 .openStream();
		
		BufferedImage imgOriginal = ImageIO.read(inputStream);

		// criar nova imagem em memoria com transparencia e tamanho
		int largura = imgOriginal.getWidth();
		int altura = imgOriginal.getHeight();
		int novaAltura = altura + 200;
		
		BufferedImage novaImagem = 
				new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
		
		// copiar a imagem original para a nova (em memoria)
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imgOriginal, 0, 0, null);
		
		//configurar fonte
		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 32);
		graphics.setFont(fonte);
		graphics.setColor(Color.YELLOW);
		
		
		// inserir texto na nova imagem
		String textoUnd = "QUEBRE MEU DEDO";
		int largTexto = graphics.getFontMetrics().stringWidth(textoUnd);
		int centro = (largura/2) - (largTexto/2);
		graphics.drawString(textoUnd, centro, novaAltura - 100);

		
		// escrever a nova imagem em arquivo
		ImageIO.write(novaImagem, "png",  new File("saida/"+nomeSaida+".png"));
		
		
	}

	
}
