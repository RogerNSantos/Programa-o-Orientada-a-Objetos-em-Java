import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAOImpl implements LivroDAO {
    private Connection connection;

    public LivroDAOImpl() {
        try {
            this.connection = PostgreSQLConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados", e);
        }
    }

    @Override
    public void salvarLivro(Livro livro) {
        String sql = "INSERT INTO livros (id, titulo, autor, disponivel) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, livro.getId());
            stmt.setString(2, livro.getTitulo());
            stmt.setString(3, livro.getAutor());
            stmt.setBoolean(4, livro.isDisponivel());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar livro", e);
        }
    }

    @Override
    public Livro buscarLivroPorId(int id) {
        Livro livro = null;
        String sql = "SELECT * FROM livros WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                livro = new Livro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getBoolean("disponivel")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar livro por ID", e);
        }
        return livro;
    }

    @Override
    public List<Livro> listarLivros() {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livros";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Livro livro = new Livro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getBoolean("disponivel")
                );
                livros.add(livro);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar livros", e);
        }
        return livros;
    }

    @Override
    public void atualizarLivro(Livro livro) {
        String sql = "UPDATE livros SET titulo = ?, autor = ?, disponivel = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setBoolean(3, livro.isDisponivel());
            stmt.setInt(4, livro.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar livro", e);
        }
    }

    @Override
    public void deletarLivro(int id) {
        String sql = "DELETE FROM livros WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar livro", e);
        }
    }
}
