package modelos;

public class Pontuacao {
    private Usuario usuario;
    private double pontos;

    public Pontuacao(Usuario usuario) {
        this.usuario = usuario;
        this.pontos = 0;
    }

    public void economizarEnergia(double valor, Integer qtdDePessoas) {
        this.pontos += 1 * (valor / qtdDePessoas);
    }

    public void economizarEnergia(double valor, Integer qtdDePessoas, String ramo) {
        if (ramo.equals("Agropecuária") || ramo.equals("Transporte") || ramo.equals("Extração")) {
            this.pontos += 0.5 * (valor / qtdDePessoas);
        } else {
            this.pontos += 0.75 * (valor / qtdDePessoas);
        }

    }

    public void reciclagem(double kgs, Integer qtdDePessoas) {
        this.pontos += 1 * (kgs / qtdDePessoas);
    }

    public void reciclagem(double kgs, Integer qtdDePessoas, String ramo) {
        if (ramo.equals("Agropecuária") || ramo.equals("Transporte") || ramo.equals("Extração")) {
            this.pontos += 0.5 * (kgs / qtdDePessoas);
        } else {
            this.pontos += 0.75 * (kgs / qtdDePessoas);
        }
    }

    public void comprarCreditosCarbono(Integer qtd, Integer qtdDePessoas, CreditoCarbono creditoCarbono) {
        this.pontos += 1 * ((qtd * creditoCarbono.getQntdCO2()) / qtdDePessoas);
    }

    public void comprarCreditosCarbono(Integer qtd, Integer qtdDePessoas, String ramo, CreditoCarbono creditoCarbono) {
        if (ramo.equals("Agropecuária") || ramo.equals("Transporte") || ramo.equals("Extração")) {
            this.pontos += 0.5 * (qtd * creditoCarbono.getQntdCO2()) / qtdDePessoas;
        } else {
            this.pontos += 0.75 * (qtd * creditoCarbono.getQntdCO2()) / qtdDePessoas;
        }
    }

    public double getPontos() {
        return pontos;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
