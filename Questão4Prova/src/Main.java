import controller.BibliotecaController;
import controller.GeneroController;
import controller.LivroController;
import view.BibliotecaView;

public class Main {

    public static void main(String[] args) {


        BibliotecaController bibliotecaController = new BibliotecaController();
        GeneroController generoController = new GeneroController();
        LivroController livroController = new LivroController();

        BibliotecaView bibliotecaView = new BibliotecaView();

        generoController.criarTabelaGenero();
        bibliotecaController.criarTabelaBiblioteca();
        livroController.criarTabelaLivro();

        bibliotecaView.menuInicio();
    }
}
