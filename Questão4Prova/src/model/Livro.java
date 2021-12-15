package model;

public class Livro {

    private long id;
    private String nome;
    private long quantFolhas;
    private Genero genero;
    private String autor;
    private Biblioteca idBiblioteca;

    public Livro() {
    }

    public Biblioteca getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(Biblioteca idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getQuantFolhas() {
        return quantFolhas;
    }

    public void setQuantFolhas(long quantFolhas) {
        this.quantFolhas = quantFolhas;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
