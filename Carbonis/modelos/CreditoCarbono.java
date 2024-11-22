package modelos;

public class CreditoCarbono {
    private String nome;
    private double qntdCO2;
    private String tipo;
    private double preco;

    public CreditoCarbono(String nome, double qntdCO2, String tipo, double preco) {
        this.nome = nome;
        this.qntdCO2 = qntdCO2;
        this.tipo = tipo;
        this.preco = preco;
    }

    public double getQntdCO2() {
        return qntdCO2;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPreco() {
        return preco;
    }
}
