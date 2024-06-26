public interface UsuarioDAO {
    void cadastrarUsuario(Usuario usuario);
    void removerUsuario(int id);
    List<Usuario> listarUsuarios();
    Usuario buscarUsuarioPorId(int id);
}
