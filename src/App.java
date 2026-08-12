import java.util.ArrayList;
import java.util.Scanner;

import DAO.UsuarioDAO;
import model.Usuario;
import service.UsuarioService;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        UsuarioDAO dao = new UsuarioDAO();
        UsuarioService service = new UsuarioService();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("================================");
            System.out.println("      SISTEMA DE USUÁRIOS");
            System.out.println("================================");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Atualizar usuário");
            System.out.println("4 - Deletar usuário");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o login: ");
                    String login = scanner.nextLine();

                    System.out.print("Digite a senha: ");
                    String senha = scanner.nextLine();

                    System.out.print("Digite o email: ");
                    String email = scanner.nextLine();

                    Usuario usuario = new Usuario();

                    usuario.setNome(nome);
                    usuario.setLogin(login);
                    usuario.setSenha(senha);
                    usuario.setEmail(email);

                    service.cadastrar(usuario);

                    break;
                case 2:
                    ArrayList<Usuario> usuarios = dao.listarUsuarios();

                    for (Usuario usuarioLista : usuarios) {
                        System.out.println();
                        System.out.println("ID: " + usuarioLista.getId());
                        System.out.println("Nome: " + usuarioLista.getNome());
                        System.out.println("Login: " + usuarioLista.getLogin());
                        System.out.println("Senha: " + usuarioLista.getSenha());
                        System.out.println("Email: " + usuarioLista.getEmail());
                    }

                    break;
                case 3:
                    System.out.print("Digite o ID do usuário: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o novo nome: ");
                    String nomeAtualizado = scanner.nextLine();

                    System.out.print("Digite o novo login: ");
                    String loginAtualizado = scanner.nextLine();

                    System.out.print("Digite a nova senha: ");
                    String senhaAtualizada = scanner.nextLine();

                    System.out.print("Digite o novo email: ");
                    String emailAtualizado = scanner.nextLine();

                    Usuario usuarioAtualizado = new Usuario();

                    usuarioAtualizado.setId(id);
                    usuarioAtualizado.setNome(nomeAtualizado);
                    usuarioAtualizado.setLogin(loginAtualizado);
                    usuarioAtualizado.setSenha(senhaAtualizada);
                    usuarioAtualizado.setEmail(emailAtualizado);

                    dao.atualizarUsuario(usuarioAtualizado);

                    break;
                case 4:
                    System.out.print("Digite o ID do usuário que deseja deletar: ");
                    int idUsuario = scanner.nextInt();

                    dao.deletarUsuario(idUsuario);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
         }
    }
}