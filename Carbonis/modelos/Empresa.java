package modelos;

import java.util.Scanner;

public class Empresa extends Usuario {
    private String cnpj;
    private int numeroDeFuncionarios;
    private String ramo;

    public Empresa(String login, String senha, String documento, int numeroDeFuncionarios, String ramo) {
        super(login, senha, documento);
        this.numeroDeFuncionarios = numeroDeFuncionarios;
        this.ramo = ramo;
        setDocumento(documento);
    }

    public Empresa() {
        super();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira o número de funcionários: ");
        this.numeroDeFuncionarios = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Insira o ramo da empresa: ");
        this.ramo = scanner.nextLine();

    }

    @Override
    public void setDocumento(String documento) {
        if (documento.matches("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}")) {
            this.cnpj = documento;
            super.setDocumento(documento);
        } else {
            System.out.println("CNPJ inválido. Insira no formato xx.xxx.xxx/xxxx-xx");
        }
    }

    public int getNumeroDeFuncionarios() {
        return numeroDeFuncionarios;
    }

    public String getRamo() {
        return ramo;
    }

    public String getCnpj() {
        return cnpj;
    }
}
