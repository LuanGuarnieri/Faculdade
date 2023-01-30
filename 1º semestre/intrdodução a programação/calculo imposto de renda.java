import java.util.Scanner;


/*Para realizar o cálculo do Imposto de Renda a ser pago, 
é solicitado a renda anual e o número de dependentes do contribuinte. 
A renda líquida é calculada sobre a renda anual com um desconto de 2% 
para cada dependente do contribuinte. O contribuinte com uma renda 
líquida de até R$ 2.000,00 não paga imposto. 
Para aqueles que possuem renda líquida entre R$ 2.000,00 e R$ 5.000,00 o 
imposto é de 5% sobre o valor da renda líquida; para rendas líquidas 
de R$ 5.000,00 até R$ 10.000,00 é de 10%. Rendas superiores a R$ 10.000,00 pagam 15% de imposto. */
public class Uni4Exe17{
        public static void main(String[] args) {
            Scanner teclado = new Scanner(System.in);
            
            System.out.println("Renda anual : R$ ");
            double RendaAnual = teclado.nextDouble();
            System.out.println("Numero de dependentes :  ");
            int Dependentes = teclado.nextInt();
            double Desconto = 2.0 / 100.0;
            double DesDep = Dependentes * Desconto  ;
            double RendaLiquida = RendaAnual - (RendaAnual * DesDep);
     
            //renda líquida é calculada sobre a renda anual com um desconto de 2%  para cada dependente do contribuinte.//
               if(RendaLiquida < 2000){
                   System.out.println( RendaLiquida + " Não paga ");
               }else{
            //renda líquida entre R$ 2.000,00 e R$ 5.000,00 o imposto é de 5% sobre o valor da renda líquida//
                if(RendaLiquida > 2000  || RendaLiquida < 5001){
                    Double Porcentagem = 0.05 * 100.0;
                    Double Valor = RendaLiquida - (RendaLiquida * (Porcentagem / 100.0));
                    double Final = RendaLiquida -Valor;
                    System.out.println(Final);
                }else{

                    //ESTÁ DANDO ERRO DE CÁLCULO A PARTIR DAQUI E NÃO CONSEGUI ARRUMAR//

                    //de R$ 5.000,00 até R$ 10.000,00 é de 10%.//
                    if(RendaLiquida >= 5001  || RendaLiquida < 10001){
                        Double Porcentagem = 0.1 * 100.0;
                        Double Valor = RendaLiquida - (RendaLiquida * (Porcentagem / 100.0));
                        double Final = RendaLiquida - Valor;
                        System.out.println(Final);
                    }else{

                        if(RendaLiquida > 10000){
                            Double Valor = RendaLiquida - (RendaLiquida * (15.0 /100.0));
                            double Final = Valor;
                            System.out.println(Final);
                        }
                    }
                }
               }
            teclado.close();
        }
}
