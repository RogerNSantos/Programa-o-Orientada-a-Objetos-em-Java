public interface EmprestimoService {
    void realizarEmprestimo(Livro livro, Usuario usuario);
    void realizarDevolucao(Livro livro, Usuario usuario);
    List<Emprestimo> listarEmprestimos();
    List<Emprestimo> listarEmprestimosEmAtraso();
    List<Emprestimo> buscarEmprestimosPorUsuario(Usuario usuario);
}
