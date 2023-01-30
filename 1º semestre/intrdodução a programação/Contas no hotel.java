/*      _QUESTAO 1_
LuanLavandoskiGuarnieri_1*/
/*Um hotel cobra R$ 45,00 de diária por hóspede e mais
uma taxa de serviços somado no valor total a ser pago.
A taxa de serviços é de:
 - R$ 9,50 caso número de diárias seja menor que 20;
 - R$ 8,50 caso número de diárias seja igual a 20;
 - R$ 7,00 caso número de diárias seja maior que 20.
Descreva um algoritmo que apresente as seguintes opções
ao recepcionista:
 _________ Controle de Hóspedes _________
 1. encerrar a conta de um hóspede
 2. verificar número de contas encerradas
 3. sair
Caso a opção escolhida seja a primeira, leia o nome e o
número de diárias do hóspede e escreva o nome e total a
ser pago. Caso a opção escolhida seja a segunda,
informe o número de hóspedes que deixaram o hotel
(número de contas encerradas). Caso a opção escolhida
seja a terceira finalize a execução do algoritmo. */

import java.util.Scanner;
public class Prova02Exe01{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

       System.out.println("_________ Controle de Hóspedes _________");
       System.out.print("\n1. encerrar a conta de um hóspede\n2. verificar número de contas encerradas\n3. sair\nOpção :");
        
       int opcao = teclado.nextInt();
       int diaria = 45, dias, encerradas = 0;
       String nome ;
       double total;

       do { 
           switch (opcao) {
               case 1:
                        System.out.println("\n______Hóspede______\n");
                        System.out.print("Nome :");
                        nome = teclado.next();
                        System.out.print("Diárias :");
                        dias = teclado.nextInt();
                        System.out.println("____________________\n");
                        if(dias < 20){

                                total = (dias * diaria) + 9.50;
                                System.out.print("Nome : "+ nome); 
                                System.out.printf("\nTotal : R$ %.2f", total);
                                encerradas++;
                        }
                        if(dias == 20){
                            
                            total = (dias * diaria) + 8.50;
                            System.out.print("Nome : "+ nome); 
                            System.out.printf("\nTotal : R$ %.2f", total);
                            encerradas++;
                            
                        }
                        if(dias > 20){

                            total = (dias * diaria) + 7.00;
                            System.out.print("Nome : "+ nome); 
                            System.out.printf("\nTotal : R$ %.2f", total);  
                            encerradas++;
                            
                        }                       
                            System.out.println("\n_________ Controle de Hóspedes _________");
                            System.out.print("\n1. encerrar a conta de um hóspede\n2. verificar número de contas encerradas\n3. sair\nOpção :");
                            opcao = teclado.nextInt();

                   break;
                   case 2 : System.out.println("Número de contas encerradas : "+ encerradas);

                            System.out.println("\n_________ Controle de Hóspedes _________");
                            System.out.print("\n1. encerrar a conta de um hóspede\n2. verificar número de contas encerradas\n3. sair\nOpção :");
                            opcao = teclado.nextInt();
                   break;
                   case 3 : System.out.println("Programa encerrado!");
           
               default:
                            System.out.println("Opção inválida!"); //caso for digitado outra opção//
                            System.out.println("\n_________ Controle de Hóspedes _________");
                            System.out.print("\n1. encerrar a conta de um hóspede\n2. verificar número de contas encerradas\n3. sair\nOpção :");
                            opcao = teclado.nextInt();
                   break;
           }
           
       } while (opcao !=3);
       
    }
}
