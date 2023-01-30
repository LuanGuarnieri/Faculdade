/*Um comerciante deseja fazer um levantamento do 
lucro das 20 mercadorias que comercializa. Para 
cada mercadoria ele tem o nome, o preço de compra (PC)
 e o preço de venda (PV). Descreva um algoritmo que:

escreva quantas mercadorias proporcionam: (lucro < 10%), 
(10% <= lucro <= 20%) e (lucro > 20%), onde o percentual de 
lucro é calculado da seguinte forma: % = (PV - PC) / PC * 100;
determine e escreva o valor total de compra e de venda de todas as mercadorias, assim como o lucro total.
*/

import java.util.Scanner;

public class Uni5Exe14 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite a quantidade de produtos :");
        int Quantidade = teclado.nextInt();
        String NomeMercadoria, NomeFinal;
        double PC, PV, TotalCompra= 0, TotalVenda = 0, lucro, TotalLucro = 0;
        int Menos10 = 0, Menos20 = 0, Maior20 = 0;

        for (int i = 1; i <= Quantidade ; i++) {
            System.out.println("\n Digite o nome do "+ i +"º produto: ");
            NomeMercadoria = teclado.next();
            System.out.println("\n Digite o preço de compra de "+ NomeMercadoria + " : ");
            PC = teclado.nextDouble();
            System.out.println("\n Digite o preço de venda de "+ NomeMercadoria + " : ");
            PV = teclado.nextDouble();
            
            lucro = (PV - PC) / PC * 100;
            TotalCompra = TotalCompra + PC;
            TotalLucro =  TotalLucro + lucro;
             TotalVenda = (TotalVenda + PV);
            if(lucro < 10){
                
                Menos10++;               
            }
            if (10  <= lucro && lucro <=20) {
                Menos20 ++;
            }
            if (lucro > 20 ) {
                Maior20 ++;
            }
        }
            System.out.print("Produtos menores que 10 % : "+ Menos10 + " produto(s).  \n ");
            System.out.print("Produtos menores que 20 % : "+ Menos20 + " produto(s). \n ");
            System.out.print("Produtos maiores que 20 % : "+ Maior20 + " produto(s). \n " );
            System.out.println(" \n O valor total gasto é de : R$ "+ TotalCompra);
            System.out.println("\n O valor total das vendas foi de : R$ "+ TotalVenda);
            System.out.println("\n Onde obteve um lucro total de "+ TotalLucro + " %");

        teclado.close();
    }
}
;