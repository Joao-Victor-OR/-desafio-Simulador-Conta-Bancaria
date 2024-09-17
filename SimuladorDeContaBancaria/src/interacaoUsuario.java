import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class interacaoUsuario {
    private static Scanner userInput;
    static ArrayList <Conta> contas = new ArrayList<Conta>();
    static Conta conta;
    public interacaoUsuario(){
        userInput = new Scanner(System.in);
    }
    public static void exibeOpcoes(){
        System.out.println("Seja bem vindo!");
        System.out.println("Escolha a baixo o serviço que deseja utilizar: ");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Verificar saldo");
        System.out.println("3 - Sacar");
        System.out.println("4 - Depositar");
        System.out.println("5 - Sair");

        int opcao = Integer.parseInt(userInput.nextLine());
        menu(opcao);
    }
    public static void menu(int umaOpcao){
        
        switch(umaOpcao){
            case 1:
                criaConta();
                exibeOpcoes();
            case 2:
                exibeSaldo();
                exibeOpcoes();
            case 3:
                System.out.print("Quanto deseja sacar: ");
                double valor = Double.parseDouble(userInput.nextLine());
                sacar(valor);
                exibeOpcoes();
            case 4:
                System.out.print("Quanto deseja depositar: ");
                valor = Double.parseDouble(userInput.nextLine());
                depositar(valor);
                exibeOpcoes();
            case 5:
                break;
        }
        
    }
    public static void criaConta(){

    Random numeroAleatorio = new Random();
    double numeroDaConta = numeroAleatorio.nextDouble()*100;

    System.out.print("Digite o nome do proprietário da conta:");
    String nomeProprietario = userInput.nextLine();
    System.out.print("Digite o numero da agencia:");
    String numeroAgencia = userInput.nextLine();

    //cria conta bancaria
    System.out.println("Deseja criar uma conta com saldo em conta?");
    System.out.println("1 - Sim");
    System.out.println("2 - Não");
    int opcao = Integer.parseInt(userInput.nextLine());
    if(opcao == 1){
        System.out.print("Digite o valor que deseja depositar:");
        double valorInicial = Double.parseDouble(userInput.nextLine());
 
        for(Conta cont:contas){
            if(cont.verificarNumeroDaConta() == numeroDaConta){
                numeroDaConta = numeroAleatorio.nextDouble()*100;
            }
        }
        conta = new Conta(numeroDaConta, numeroAgencia, nomeProprietario, valorInicial);
        contas.add(conta);

        System.out.println("O número da sua conta é:"+ "" + conta.verificarNumeroDaConta());        
        System.out.println("Conta criada com sucesso!");


        }else{
            double valorInicial = 0;
            for(Conta cont:contas){
                if(cont.verificarNumeroDaConta() == numeroDaConta){
                    numeroDaConta = numeroAleatorio.nextDouble()*100;
                }
            }

            conta = new Conta(numeroDaConta, numeroAgencia, nomeProprietario, valorInicial);
            contas.add(conta);
            System.out.println("O número da sua conta é:"+ "" + conta.verificarNumeroDaConta());


            System.out.println("Conta criada com sucesso!");

       }
    }

    public static void exibeSaldo(){
        System.out.print("Qual o número da conta que deseja saber o saldo?");
        Double umNumero;
        umNumero = Double.parseDouble(userInput.nextLine());
        if(contas.size() > 0){
            for(Conta cont:contas){
                if(cont.verificarNumeroDaConta() == umNumero){
                    System.out.print(cont.verificarNomeCliente() + "Seu saldo é:");
                    System.out.println(cont.verificarSaldo());    
                }else if(cont == contas.get(contas.size()-1) && cont.verificarNumeroDaConta() != umNumero){
                    System.out.println("Numero de conta inválido.");
                }
            }
        }else{
            System.out.println("As contas ainda não foram criadas");
        }
    }
    public static void depositar(double quantia){
        System.out.print("Qual o número da conta que deseja saber o saldo?");
        Double umNumero;
        umNumero = Double.parseDouble(userInput.nextLine());
        if(contas.size() > 0){
            
            for(Conta cont:contas){
                if(umNumero == cont.verificarNumeroDaConta()){
                    cont.depositar(quantia);
                }else if(cont == contas.get(contas.size()-1) && cont.verificarNumeroDaConta() != umNumero){
                    System.out.println("Numero de conta inválido.");
                }
            }
        }else{
            System.out.println("As contas ainda não foram criadas");
        }
    }
    public static void sacar(double quantia){
        System.out.print("Qual o número da conta que deseja saber o saldo?");
        Double umNumero;
        umNumero = Double.parseDouble(userInput.nextLine());
        if(contas.size() > 0){
            for(Conta cont: contas){
                if(umNumero == cont.verificarNumeroDaConta()){
                    if((cont.verificarSaldo()- quantia) > 0){
                        cont.sacar(quantia);
                    }else{
                        System.out.println("Saldo insuficiente.");
                    }
                }else if(cont == contas.get(contas.size()-1) && cont.verificarNumeroDaConta() != umNumero){
                    System.out.println("Numero de conta inválido.");
                }
            }
        }else{
            System.out.println("As contas ainda não foram criadas");
        }
    }
    public void remove(){
        System.out.print("Digite o número da conta que deseja remover:");
        double contaRemove = Double.parseDouble(userInput.nextLine());
        for(Conta cont:contas){
            if(cont.verificarNumeroDaConta() == contaRemove){

                    contas.remove(cont);
    
            }else if(cont == contas.get(contas.size()-1) && cont.verificarNumeroDaConta() != contaRemove){
                System.out.println("Conta inexistente!");
            }
        }
    }

}
