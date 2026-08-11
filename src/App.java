import DAO.UsuarioDAO;
import model.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNome("Davi");
        usuario.setLogin("Davi");
        usuario.setSenha("1234");
        usuario.setEmail("davi_gabriel99@hotmail.com");

        new UsuarioDAO().cadastrarUsuario(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.setNome("Lucas");
        usuario2.setLogin("Lucas");
        usuario2.setSenha("12345");
        usuario2.setEmail("lucas_teste123@hotmail.com");

        new UsuarioDAO().cadastrarUsuario(usuario2);
    }
}