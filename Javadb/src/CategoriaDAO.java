
import java.sql.*;
import java.util.*;

public class CategoriaDAO {
    @SuppressWarnings("CallToPrintStackTrace")

    public void inserir (Categoria p) {
        String sql = "INSERT INTO Categorias (nome, ativo) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar(); 
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNome());
            stmt.setString (2, p.getAtivo());
            stmt.executeUpdate();

            System.out.println("Categoria inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
        public List<Categoria> listar() {
        List<Categoria> lista = new ArrayList<>(); String sql = "SELECT * FROM Categorias";

        try (Connection conn = Conexao.conectar(); 
        Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
            Categoria p = new Categoria(rs.getString("nome"),
                                    rs.getString("ativo"));
            p.setId(rs.getInt("id"));
            lista.add(p);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return lista;
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public void atualizar (Categoria p) {
        String sql = "UPDATE Categorias SET nome=?, ativo=? WHERE id=?";

        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getAtivo());
            stmt.setInt(3, p.getId());
            stmt.executeUpdate();

            System.out.println("Categoria atualizado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void deletar(int id) {
        String sql = "DELETE FROM Categorias WHERE id=?";
        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        stmt.executeUpdate();

        System.out.println("Categoria deletado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    