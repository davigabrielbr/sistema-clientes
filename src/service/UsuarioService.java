package service;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {
    private UsuarioDAO dao = new UsuarioDAO();

    public void cadastrar(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getNome().isBlank()) {
            System.out.println("O nome não pode estar vazio.");
            return;
        }

        if (usuario.getLogin() == null || usuario.getLogin().isBlank()) {
            System.out.println("O login não pode estar vazio.");
            return;
        }

        if (usuario.getSenha() == null || usuario.getSenha().isBlank()) {
            System.out.println("A senha não pode estar vazia.");
            return;
        }

        if (usuario.getSenha().length() < 6) {
            System.out.println("A senha deve ter pelo menos 6 caracteres.");
            return;
        }

        if (usuario.getEmail() == null || usuario.getEmail().isBlank()) {
            System.out.println("O email não pode estar vazio.");
            return;
        }

        if (!usuario.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            System.out.println("Digite um email válido.");
            return;
        }

        dao.cadastrarUsuario(usuario);

        System.out.println("Usuário cadastrado com sucesso.");
    }
}