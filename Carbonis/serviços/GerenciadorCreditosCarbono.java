package serviços;

import modelos.CreditoCarbono;
import java.util.ArrayList;

public class GerenciadorCreditosCarbono {
    private ArrayList<CreditoCarbono> creditosDisponiveis;

    public GerenciadorCreditosCarbono() {
        this.creditosDisponiveis = new ArrayList<>();
    }

    public void adicionarCredito(CreditoCarbono credito) {
        creditosDisponiveis.add(credito);
    }

    public void exibirCreditos() {
        System.out.println("=== Créditos de Carbono Disponíveis ===");
        for (int i = 0; i < creditosDisponiveis.size(); i++) {
            CreditoCarbono credito = creditosDisponiveis.get(i);
            System.out.printf("%d. %s - CO2: %.2f toneladas - Tipo: %s - Preço: R$%.2f%n",
                    i + 1, credito.getNome(), credito.getQntdCO2(), credito.getTipo(), credito.getPreco());
        }
    }

    public CreditoCarbono selecionarCredito(int indice) {
        if (indice < 1 || indice > creditosDisponiveis.size()) {
            System.out.println("Opção inválida.");
            return null;
        }
        return creditosDisponiveis.get(indice - 1);
    }
}
