import java.util.Scanner;
import modelos.*;
import serviços.*;

public class Main {
    public static void main(String[] args) {

        //region intâncias

        // Serviços
        Login servicoLogin = new Login();
        Ranking ranking = new Ranking();
        GerenciadorCreditosCarbono gerenciadorCreditos = new GerenciadorCreditosCarbono();

        // Usuários
        Usuario admin = new Usuario("admin", "admin123", "000.000.000-00");
        servicoLogin.adicionarUsuario(admin);

        Pessoa pessoa1 = new Pessoa("joao.silva", "Senha@123", "489.123.456-78", 3);
        Pessoa pessoa2 = new Pessoa("maria.oliveira", "Segura#2024", "392.456.789-12", 2);
        Pessoa pessoa3 = new Pessoa("ana.souza", "Strong!Senha99", "512.789.123-45", 4);
        servicoLogin.adicionarUsuario(pessoa1);
        servicoLogin.adicionarUsuario(pessoa2);
        servicoLogin.adicionarUsuario(pessoa3);

        Empresa empresa1 = new Empresa("tech.corp", "Secure@Empresa2024", "85.963.741/0001-32", 150, "Tecnologia");
        Empresa empresa2 = new Empresa("trans.log", "Pass!Transp123", "96.852.147/0001-85", 100, "Transporte");
        Empresa empresa3 = new Empresa("agro.prod", "Agro#Senha345", "47.258.369/0001-96", 200, "Agropecuária");
        servicoLogin.adicionarUsuario(empresa1);
        servicoLogin.adicionarUsuario(empresa2);
        servicoLogin.adicionarUsuario(empresa3);

        // Créditos de carbono
        CreditoCarbono credito1 = new CreditoCarbono("Floresta Amazônica", 100, "Florestamento", 50.0);
        CreditoCarbono credito2 = new CreditoCarbono("Parque Eólico", 200, "Energia Renovável", 100.0);
        CreditoCarbono credito3 = new CreditoCarbono("Usina Solar", 150, "Energia Solar", 75.0);

        gerenciadorCreditos.adicionarCredito(credito1);
        gerenciadorCreditos.adicionarCredito(credito2);
        gerenciadorCreditos.adicionarCredito(credito3);

        // Pontuações
        Pontuacao pontuacaoPessoa1 = new Pontuacao(pessoa1);
        pontuacaoPessoa1.economizarEnergia(120, pessoa1.getNumeroDeFamiliares());
        pontuacaoPessoa1.reciclagem(15, pessoa1.getNumeroDeFamiliares());
        pontuacaoPessoa1.comprarCreditosCarbono(2, pessoa1.getNumeroDeFamiliares(), credito1);

        Pontuacao pontuacaoPessoa2 = new Pontuacao(pessoa2);
        pontuacaoPessoa2.economizarEnergia(80, pessoa2.getNumeroDeFamiliares());
        pontuacaoPessoa2.reciclagem(10, pessoa2.getNumeroDeFamiliares());
        pontuacaoPessoa2.comprarCreditosCarbono(1, pessoa2.getNumeroDeFamiliares(), credito2);

        Pontuacao pontuacaoPessoa3 = new Pontuacao(pessoa3);
        pontuacaoPessoa3.economizarEnergia(150, pessoa3.getNumeroDeFamiliares());
        pontuacaoPessoa3.reciclagem(25, pessoa3.getNumeroDeFamiliares());
        pontuacaoPessoa3.comprarCreditosCarbono(3, pessoa3.getNumeroDeFamiliares(), credito3);

        Pontuacao pontuacaoEmpresa1 = new Pontuacao(empresa1);
        pontuacaoEmpresa1.economizarEnergia(8000, empresa1.getNumeroDeFuncionarios(), empresa1.getRamo());
        pontuacaoEmpresa1.reciclagem(300, empresa1.getNumeroDeFuncionarios(), empresa1.getRamo());
        pontuacaoEmpresa1.comprarCreditosCarbono(320, empresa1.getNumeroDeFuncionarios(), empresa1.getRamo(), credito1);

        Pontuacao pontuacaoEmpresa2 = new Pontuacao(empresa2);
        pontuacaoEmpresa2.economizarEnergia(5000, empresa2.getNumeroDeFuncionarios(), empresa2.getRamo());
        pontuacaoEmpresa2.reciclagem(200, empresa2.getNumeroDeFuncionarios(), empresa2.getRamo());
        pontuacaoEmpresa2.comprarCreditosCarbono(190, empresa2.getNumeroDeFuncionarios(), empresa2.getRamo(), credito2);

        Pontuacao pontuacaoEmpresa3 = new Pontuacao(empresa3);
        pontuacaoEmpresa3.economizarEnergia(10000, empresa3.getNumeroDeFuncionarios(), empresa3.getRamo());
        pontuacaoEmpresa3.reciclagem(600, empresa3.getNumeroDeFuncionarios(), empresa3.getRamo());
        pontuacaoEmpresa3.comprarCreditosCarbono(300, empresa3.getNumeroDeFuncionarios(), empresa3.getRamo(), credito3);

        // Ranking com pontuações
        ranking.atualizarPontuacao(pontuacaoPessoa1);
        ranking.atualizarPontuacao(pontuacaoPessoa2);
        ranking.atualizarPontuacao(pontuacaoPessoa3);
        ranking.atualizarPontuacao(pontuacaoEmpresa1);
        ranking.atualizarPontuacao(pontuacaoEmpresa2);
        ranking.atualizarPontuacao(pontuacaoEmpresa3);

        //endregion

        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            System.out.println("Bem-vindo à Carbonis!");
            System.out.println("1. Login");
            System.out.println("2. Criar Novo Usuário");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (opcao) {
                case 1:
                    System.out.print("Login: ");
                    String login = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();
                    Usuario usuario = servicoLogin.verificarLogin(login, senha);
                    if (usuario != null) {
                        Pontuacao pontuacaoAtual = ranking.consultarPontuacao(usuario);
                        if (pontuacaoAtual == null) {
                            pontuacaoAtual = new Pontuacao(usuario);
                            ranking.atualizarPontuacao(pontuacaoAtual);
                        }
                        System.out.println();
                        System.out.printf("Bem-vindo, %s!", usuario.getLogin());

                        boolean logado = true;
                        while (logado) {
                            System.out.println();
                            System.out.println("\n--- Menu do Usuário ---");
                            System.out.printf("Pontuação Atual: %.2f%n", pontuacaoAtual.getPontos());
                            System.out.println("1. Registrar Pontos");
                            System.out.println("2. Comprar Créditos de Carbono");
                            System.out.println("3. Exibir Ranking");
                            System.out.println("4. Sair");
                            System.out.print("Escolha uma opção: ");
                            int opcaoUsuario = scanner.nextInt();
                            scanner.nextLine();

                            switch (opcaoUsuario) {
                                case 1:
                                    boolean registrando = true;
                                    while (registrando) {
                                        System.out.println("\n--- Registrar Pontos ---");
                                        System.out.printf("Pontuação Atual: %.2f%n", pontuacaoAtual.getPontos());
                                        System.out.println("1. Economia de Energia");
                                        System.out.println("2. Reciclagem");
                                        System.out.println("3. Sair");
                                        System.out.print("Escolha uma opção: ");
                                        int opcaoRegistro = scanner.nextInt();
                                        scanner.nextLine();

                                        switch (opcaoRegistro) {
                                            case 1:
                                                System.out.println();
                                                System.out.print("Digite o valor economizado em kWh: ");
                                                double energiaEconomizada = scanner.nextDouble();
                                                scanner.nextLine();

                                                double pontosAntes = pontuacaoAtual.getPontos();

                                                if (usuario instanceof Pessoa) {
                                                    Pessoa pessoa = (Pessoa) usuario;
                                                    pontuacaoAtual.economizarEnergia(energiaEconomizada, pessoa.getNumeroDeFamiliares());
                                                } else if (usuario instanceof Empresa) {
                                                    Empresa empresa = (Empresa) usuario;
                                                    pontuacaoAtual.economizarEnergia(energiaEconomizada, empresa.getNumeroDeFuncionarios(), empresa.getRamo());
                                                }

                                                double pontosGerados = pontuacaoAtual.getPontos() - pontosAntes;
                                                System.out.printf("Pontuação gerada: %.2f. Pontuação Total: %.2f%n", pontosGerados, pontuacaoAtual.getPontos());
                                                break;

                                            case 2:
                                                System.out.println();
                                                System.out.print("Digite os quilos reciclados: ");
                                                double reciclados = scanner.nextDouble();
                                                scanner.nextLine();

                                                pontosAntes = pontuacaoAtual.getPontos();

                                                if (usuario instanceof Pessoa) {
                                                    Pessoa pessoa = (Pessoa) usuario;
                                                    pontuacaoAtual.reciclagem(reciclados, pessoa.getNumeroDeFamiliares());
                                                } else if (usuario instanceof Empresa) {
                                                    Empresa empresa = (Empresa) usuario;
                                                    pontuacaoAtual.reciclagem(reciclados, empresa.getNumeroDeFuncionarios(), empresa.getRamo());
                                                }

                                                pontosGerados = pontuacaoAtual.getPontos() - pontosAntes;
                                                System.out.println();
                                                System.out.printf("Pontuação gerada: %.2f. Pontuação Total: %.2f%n", pontosGerados, pontuacaoAtual.getPontos());
                                                break;


                                            case 3:
                                                registrando = false;
                                                System.out.println();
                                                System.out.println("Saindo do registro de pontos...");
                                                break;

                                            default:
                                                System.out.println();
                                                System.out.println("Opção inválida. Tente novamente.");
                                        }
                                    }
                                    break;

                                case 2:
                                    System.out.println();
                                    gerenciadorCreditos.exibirCreditos();
                                    System.out.println();
                                    System.out.print("Escolha um crédito: ");
                                    int escolha = scanner.nextInt();
                                    scanner.nextLine();

                                    CreditoCarbono creditoSelecionado = gerenciadorCreditos.selecionarCredito(escolha);
                                    if (creditoSelecionado != null) {
                                        System.out.println();
                                        System.out.print("Quantidade a comprar: ");
                                        int quantidade = scanner.nextInt();
                                        scanner.nextLine();

                                        double pontosAntes = pontuacaoAtual.getPontos();

                                        if (usuario instanceof Pessoa) {
                                            Pessoa pessoa = (Pessoa) usuario;
                                            pontuacaoAtual.comprarCreditosCarbono(quantidade, pessoa.getNumeroDeFamiliares(), creditoSelecionado);
                                        } else if (usuario instanceof Empresa) {
                                            Empresa empresa = (Empresa) usuario;
                                            pontuacaoAtual.comprarCreditosCarbono(quantidade, empresa.getNumeroDeFuncionarios(), empresa.getRamo(), creditoSelecionado);
                                        }

                                        double pontosGerados = pontuacaoAtual.getPontos() - pontosAntes;
                                        System.out.println();
                                        System.out.printf("Pontuação gerada: %.2f. Pontuação Total: %.2f%n", pontosGerados, pontuacaoAtual.getPontos());
                                    }
                                    break;

                                case 3:
                                    System.out.println();
                                    ranking.exibirRanking();
                                    break;

                                case 4:
                                    System.out.println();
                                    System.out.println("Saindo do menu do usuário...");
                                    logado = false;
                                    break;

                                default:
                                    System.out.println();
                                    System.out.println("Opção inválida. Tente novamente.");
                            }
                        }
                    } else {
                        System.out.println();
                        System.out.println("Login ou senha incorretos.");
                    }
                    break;
                case 2:
                    servicoLogin.criarUsuario();
                    break;
                case 3:
                    executando = false;
                    System.out.println();
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println();
                    System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.println();
        }
        scanner.close();
    }
}
