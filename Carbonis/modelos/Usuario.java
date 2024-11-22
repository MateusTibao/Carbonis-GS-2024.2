package modelos;

import java.util.Scanner;

public class Usuario {
    private String login;
    private String senha;
    private String documento;

    public Usuario(String login, String senha, String documento) {
        this.login = login;
        this.senha = senha;
        this.documento = documento;
    }

    public Usuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira o login: ");
        this.login = scanner.nextLine();

        System.out.print("Insira o senha: ");
        this.senha = scanner.nextLine();

        System.out.print("Insira um documento: ");
        setDocumento(scanner.nextLine());

        scanner.close();
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getDocumento() {
        return documento;
    }
}
