public class Cliente {
    private long id;
    private String nome;
    private Integer livello;

    public Cliente(long id, String nome, Integer livello) {
        this.id = id;
        this.nome = nome;
        this.livello = livello;
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

    public Integer getLivello() {
        return livello;
    }

    public void setLivello(Integer livello) {
        this.livello = livello;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", livello=" + livello +
                '}';
    }
}
