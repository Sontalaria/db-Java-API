public class Categoria{ 
    private int id;
    private String nome; private String ativo;
    public Categoria(String nome, String ativo) {
    this.nome = nome;
    this.ativo = ativo;
    }
        
    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getAtivo() { return ativo; }
    public void setAtivo(String ativo) { this.ativo = ativo; }
    
}