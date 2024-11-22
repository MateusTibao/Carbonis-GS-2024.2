package serviços;

import java.util.ArrayList;
import java.util.Scanner;
import modelos.*;

public class Login {
    private ArrayList<Usuario> usuarios;

    public Login() {
        this.usuarios = new ArrayList<>();
        usuarios.add(new Usuario("admin", "admin123", "000.000.000-00"));
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario verificarLogin(String login, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }

    private boolean loginOuDocumentoExistem(String login, String documento) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                System.out.println("Erro: O login já está em uso.");
                return true;
            }
            if (usuario.getDocumento().equals(documento)) {
                System.out.println("Erro: O documento já está em uso.");
                return true;
            }
        }
        return false;
    }

    public void criarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tipo de usuário (1 = Pessoa, 2 = Empresa): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Login: ");
        String login = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.print("Documento: ");
        String documento = scanner.nextLine();

        if (loginOuDocumentoExistem(login, documento)) {
            System.out.println("Não foi possível criar o usuário. Login ou documento já existem.");
            return;
        }

        if (tipo == 1) {
            System.out.print("Número de familiares: ");
            int numeroDeFamiliares = scanner.nextInt();
            Pessoa novaPessoa = new Pessoa(login, senha, documento, numeroDeFamiliares);
            adicionarUsuario(novaPessoa);
            System.out.println("Usuário pessoa criado com sucesso.");
        } else if (tipo == 2) {
            System.out.print("Número de funcionários: ");
            int numeroDeFuncionarios = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Ramo da empresa: ");
            String ramo = scanner.nextLine();
            Empresa novaEmpresa = new Empresa(login, senha, documento, numeroDeFuncionarios, ramo);
            adicionarUsuario(novaEmpresa);
            System.out.println("Usuário empresa criado com sucesso.");
        } else {
            System.out.println("Opção inválida.");
        }
    }
}

