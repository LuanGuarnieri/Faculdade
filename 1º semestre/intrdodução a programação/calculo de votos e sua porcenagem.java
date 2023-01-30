/*Em uma eleição para presidência, existem 4 candidatos.
 Os votos são informados através de código. Os dados 
 utilizados para votação obedecem a seguinte codificação:
 
 1, 2, 3, 4 = voto para o respectivo candidato
5 = voto nulo
6 = voto em branco

 Elabore um programa que calcule e escreva:

total de votos para cada candidato;
total de votos nulos;
total de votos em branco;
percentual dos votos em branco e nulos sobre o total.
Se o usuário informar um número de operação incorreto, 
emitir a mensagem “Opção incorreta” e persistir solicitando 
um número de opção correto. Para interromper a operação, o usuário poderá fornecer o número 0.
*/

import java.util.Scanner;
public class Uni5Exe33 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("1 - Canditato 1\n2 - Candidato 2\n3 - Candidato 3\n4 - Candidato 4\n5 - Voto nulo\n6 - Voto em branco\n0 - Ecnerra os votos;\n\nDigite sua escolha : ");
        int opcao = teclado.nextInt();
        int cantidato1 = 0, candidato2 = 0, candidato3 = 0, candidato4 = 0, votosNulos = 0, votosEmBranco = 0;

        do {
            
            switch (opcao) {
                case 1:
                    cantidato1  ++;
                    break;
                    case 2:
                    candidato2 ++;                    
                    break;
                    case 3:
                    candidato3 ++;                   
                    break;
                    case 4:
                    candidato4 ++;                    
                    break;
                    case 5:
                    votosNulos ++;                   
                    break;   
                    case 6:
                    votosEmBranco ++;                   
                    break;
                default:
                    System.out.print("Opção invalida!");
                    break;
                }  
                    System.out.print("\nDigite sua opção novamente : ");  
                    opcao = teclado.nextInt();
            
            
        } while (opcao != 0);

        double votosTotais = cantidato1 + candidato2 + candidato3 + candidato4 + votosEmBranco + votosNulos;
        double brancoPer = ( votosEmBranco / votosTotais)* 100;
        double percentualNulos = (votosNulos / votosTotais) * 100;

        System.out.println("\nQuantidade de votos candidato 1 : " + cantidato1);
        System.out.println("Quantidade de votos candidato 2 : " + candidato2);
        System.out.println("Quantidade de votos candidato 3 : " + candidato3);
        System.out.println("Quantidade de votos candidato 4 : " + candidato4);
        System.out.println("Quantidade de votos nulos : " + votosNulos);
        System.out.println("Quantidade de votos em branco : " + votosEmBranco);
        System.out.println("Percentual de votos em branco : " + brancoPer + " %");
        System.out.println("Percentual de votos nulos: " + percentualNulos + " %");

        teclado.close();
    }
}
