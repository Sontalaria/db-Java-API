import java.util.*;

public class Main {
    @SuppressWarnings("ConvertToTryWithResources") 
    public static void main(String[] args) {
        CategoriaDAO dao = new CategoriaDAO(); Scanner sc = new Scanner(System.in);
        System.out.println("1 - Inserir | 2 - Listar | 3 - Atualizar | 4 - Deletar");
        int opcao = sc.nextInt();

        sc.nextLine(); // Limpa buffer

        switch (opcao) {
            case 1:
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("Ativo: ");
                String ativo = sc.nextLine();
                Categoria p = new Categoria (nome, ativo);
                dao.inserir(p);
            break;

            case 2:
                for (Categoria prod: dao.listar()) {
                System.out.println(prod.getId() +prod.getNome() + " - " + prod.getAtivo());
                }
            break;

            case 3:
                System.out.print("ID do Categoria: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Novo nome: ");
                nome = sc.nextLine();

                System.out.print("Novo ativo: ");
                ativo = sc.nextLine();
                p = new Categoria(nome, ativo);
                p.setId(id);

                dao.atualizar (p);
            break;
                
            case 4:
                System.out.print("ID do Categoria a deletar: ");
                id = sc.nextInt();
                dao.deletar(id);
            break;

            default:
            System.out.println("Opcao invalida.");
        }
        sc.close();
    }
}