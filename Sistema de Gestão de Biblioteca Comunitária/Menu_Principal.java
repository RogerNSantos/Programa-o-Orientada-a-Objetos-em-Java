import java.util.Scanner;

public class MenuPrincipal {
    private Scanner scanner;
    private LivroService livroService;
    private UsuarioService usuarioService;
    private EmprestimoService emprestimoService;

    public MenuPrincipal() {
        this.scanner = new Scanner(System.in);
        this.livroService = new LivroServiceImpl(); // Inicialize com a implementação correta
        this.usuarioService = new UsuarioServiceImpl(); // Inicialize com a implementação correta
        this.emprestimoService = new EmprestimoServiceImpl(); // Inicialize com a implementação correta
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("### MENU PRINCIPAL ###");
            System.out.println("1. Cadastro de Livro");
            System.out.println("2. Cadastro de Usuário");
            System.out.println("3. Realizar Empréstimo");
            System.out.println("4. Realizar Devolução");
            System.out.println("5. Listar Livros");
            System.out.println("6. Listar Usuários");
            System.out.println("7. Listar Empréstimos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    cadastrarUsuario();
                    break;
                case 3:
                    realizarEmprestimo();
                    break;
                case 4:
                    realizarDevolucao();
                    break;
                case 5:
                    listarLivros();
                    break;
                case 6:
                    listarUsuarios();
                    break;
                case 7:
                    listarEmprestimos();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    private void cadastrarLivro() {
        // Implemente a lógica de cadastro de livro
    }

    private void cadastrarUsuario() {
        // Implemente a lógica de cadastro de usuário
    }

    private void realizarEmprestimo() {
        // Implemente a lógica de empréstimo de livro
    }

    private void realizarDevolucao() {
        // Implemente a lógica de devolução de livro
    }

    private void listarLivros() {
        // Implemente a lógica de listagem de livros
    }

    private void listarUsuarios() {
        // Implemente a lógica de listagem de usuários
    }

    private void listarEmprestimos() {
        // Implemente a lógica de listagem de empréstimos
    }

    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.exibirMenu();
    }
}
