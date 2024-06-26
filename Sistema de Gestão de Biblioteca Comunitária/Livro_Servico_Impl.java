import java.util.List;

public class LivroServiceImpl implements LivroService {
    private LivroDAO livroDAO;

    public LivroServiceImpl() {
        this.livroDAO = new LivroDAOImpl(); // ou injete via construtor, dependendo da sua arquitetura
    }

    @Override
    public void cadastrarLivro(Livro livro) {
        livroDAO.salvarLivro(livro);
    }

    @Override
    public Livro buscarLivroPorId(int id) {
        return livroDAO.buscarLivroPorId(id);
    }

    @Override
    public List<Livro> listarLivros() {
        return livroDAO.listarLivros();
    }

    @Override
    public void atualizarLivro(Livro livro) {
        livroDAO.atualizarLivro(livro);
    }

    @Override
    public void deletarLivro(int id) {
        livroDAO.deletarLivro(id);
    }
}
