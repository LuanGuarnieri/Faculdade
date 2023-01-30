/* Escreva um programa que imprime um calendário 
para um determinado mês. O calendário deve conter 
cada dia do mês e o dia da semana correspondente. 
A entrada consiste de um inteiro especificando em
 que dia da semana cai o primeiro dia do mês 
 (1=Domingo, 2=Segunda,...,7=Sábado) e um inteiro 
 especificando o número de dias que o mês possui.*/

import java.util.Scanner;
public class Uni5exe32 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Dia que começa o mês  (Domingo = 1 até Sabado = 7) : ");
        int Dia = teclado.nextInt();
        System.out.print("\nDigite quantos dias tem o mês : ");
        int Mes = teclado.nextInt();

        System.out.println("    D   S   T   Q   Q   S   S");
       for (int i = 0; i < Dia; i++) {
           System.out.print("   ");
       }
       for (int i = 0; i <= Mes; i++) {
           if (Dia >= 1 || Dia < 10) {
            System.out.print("|" + i + "  ");
           }
           if (Dia > 9) {
               System.out.print("|" + i);
           }
        ;
        if(Dia == 7){
            Dia = 1;
            System.out.print("\n");
        }else{
            Dia++;
        } 
       }

        teclado.close();
    }
}
