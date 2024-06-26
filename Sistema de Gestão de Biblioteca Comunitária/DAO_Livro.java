public interface LivroDAO {
    void cadastrarLivro(Livro livro);
    void removerLivro(int id);
    List<Livro> listarLivros();
    Livro buscarLivroPorId(int id);
    List<Livro> buscarLivrosPorAutor(String autor);
    List<Livro> buscarLivrosDisponiveis();
}
