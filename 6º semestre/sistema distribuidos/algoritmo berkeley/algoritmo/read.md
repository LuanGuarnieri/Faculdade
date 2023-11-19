# Algoritmo de Berkeley
> [!NOTE]
> ### Implementação do algotirmo de berkeley utilizando java 21 e java RMI

Consiste em o servidor e o cliente implementando a interface que extende da Remote, sendo o meio de comunicação entre eles usando o RMI, e ao startar um cliente, é adicionado na lista de clientes no servidor e depois disso cabe ao servidor em um determinado de tempo fazer chamadas para os clientes e obter o tempo de diferença em segundos, calcular a media do tempo, e depois requisitar que os clientes sincronizem com o novo horário.

> [!IMPORTANT]
> **Primeiro deve-se rodar o servidor, para criar o objeto RMI**

> [!TIP]
> Na pasta onde contém os arquivos java, por linha de comnando execute os seguintes passos:
> 
> `javac *.java` - para compilar todos oos .java existentes
> 
> `start rmiregistry` - deverá ter configurado as variáveis de ambiente para conseguir startar o RMI
>
> * Ao startar o rmi, abrirá uma outra janela do prompt, deixa-a rodar
> * Volte no prompt anterior (que rodou o `rmiregistry`)
>
> `java TimeServer.java` - irá startar o servidor
> * **Importante** cada cliente deverá ser startado em outro prompt de comando, então abra outro prompt na mesma pasta dos .class gerados
> `java TimeClient.java` - irá startar o cliente
>
> Logo depois verá a mágica acontecer, como abaixo

![image](https://github.com/LuanGuarnieri/Faculdade/assets/85564044/180b7873-2e24-4753-8785-a90b2ca7551d)
