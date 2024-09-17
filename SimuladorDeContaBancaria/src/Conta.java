public class Conta {
    Double numeroConta;
    String agencia;
    String nomeCliente;
    Double saldo;

    public Conta(Double numeroConta,String agencia, String nomeCliente, Double saldo){
        this.saldo = saldo;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;

    }
    public void sacar(Double valorASerSacado){

         saldo -= valorASerSacado;
        
    }
    public void depositar(Double valorASerDepositado){
        saldo += valorASerDepositado;
    }
    public String verificarNomeCliente(){
        return nomeCliente;
    }
    public Double verificarNumeroDaConta(){
        return numeroConta;
    }
    public String verificarAgencia(){
        return agencia;
    }
    public Double verificarSaldo(){
        return saldo;
    }
}


