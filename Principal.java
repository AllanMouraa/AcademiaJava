import java.util.Scanner;
import java.util.logging.Level;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws IOException {
		/*Sistema para criação do log.txt já informando se iniciou ou se ocorreu falha.*/
		Log meuLogger = new Log("Log.txt");
		meuLogger.logger.setLevel (Level.FINE);
		try {
			meuLogger.logger.info("\n Calculadora Iniciada com sucesso!");
		} catch (Exception e) {
			meuLogger.logger.severe("\n Falha ao iniciar calculadora!");
			e.printStackTrace();
		}
		
		
		try (Scanner leitura = new Scanner(System.in)) {
			Calculadora c = new Calculadora();
			float a = 0, b = 0, resultado =0 ;
			String operador;
			System.out.println("Calcul"
					+ "adora");
			do {
				System.out.println("Insira o operador +, -, *, /");
				operador = leitura.nextLine();
			} while (!(operador.contains("+") || operador.contains("-") || operador.contains("*")
					|| operador.contains("/")));

			System.out.println("Insira o 1o valor");
			a = leitura.nextFloat();
			System.out.println("Insira o 2o valor");
			b = leitura.nextFloat();

			resultado = c.calcular(a, b, operador.charAt(0));
			System.out.println("O resultado de " + a + " " + operador + " " + b + " é:" + resultado);
		}

	}

}
