
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversor com = new Conversor();
        int opcao=0;
        Double valor;

        while (opcao != 7){
            System.out.println("***************************************************");
            System.out.println("Conversor de Moedas Turbo Master 2.0");
            System.out.println("***************************************************");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileiro");
            System.out.println("4) Real brasileiro =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Sair");
            System.out.println("***************************************************");
            System.out.print("Escolha uma opção válida: ");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1 -> com.buscarTaxa("USD", "ARS");
                case 2 -> com.buscarTaxa("ARS", "USD");
                case 3 -> com.buscarTaxa("USD", "BRL");
                case 4 -> com.buscarTaxa("BRL", "USD");
                case 5 -> com.buscarTaxa("USD", "COP");
                case 6 -> com.buscarTaxa("COP", "USD");
                case 7 -> {
                    System.out.println("Encerrando o programa...");
                    return;
                }
                default -> {
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
                }
            }
            System.out.println("Digite o valor a ser convertido");
            valor = scanner.nextDouble();

            com.calcularConversao(valor);

            com.mostrarResultado();


        }


    };


}

