package modelos;

import java.util.Scanner;

public class Pessoa extends Usuario {
    private String cpf;
    private int numeroDeFamiliares;

    public Pessoa(String login, String senha, String documento, int numeroDeFamiliares) {
        super(login, senha, documento);
        this.numeroDeFamiliares = numeroDeFamiliares;
        setDocumento(documento);
    }

    public Pessoa() {
        super();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira o número de familiares: ");
        this.numeroDeFamiliares = scanner.nextInt();

    }

    @Override
    public void setDocumento(String documento) {
        if (documento.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            this.cpf = documento;
            super.setDocumento(documento);
        } else {
            System.out.println("CPF inválido. Insira no formato xxx.xxx.xxx-xx");
        }
    }

    public int getNumeroDeFamiliares() {
        return numeroDeFamiliares;
    }

    public String getCpf() {
        return cpf;
    }
}
