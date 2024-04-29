import java.time.LocalDate;
import java.util.List;

public class Ordini {
    private long id;
    private String stato;
    private LocalDate dataOrdine;
    private LocalDate dataConsegna;

    private List<Prodotto> prodotti;
    private Cliente cliente;

    public Ordini(long id, String stato, LocalDate dataOrdine, LocalDate dataConsegna, List<Prodotto> prodotti, Cliente cliente) {
        this.id = id;
        this.stato = stato;
        this.dataOrdine = dataOrdine;
        this.dataConsegna = dataConsegna;
        this.prodotti = prodotti;
        this.cliente = cliente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public LocalDate getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(LocalDate dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    public LocalDate getDataConsegna() {
        return dataConsegna;
    }

    public void setDataConsegna(LocalDate dataConsegna) {
        this.dataConsegna = dataConsegna;
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Ordini{" +
                "id=" + id +
                ", stato='" + stato + '\'' +
                ", dataOrdine=" + dataOrdine +
                ", dataConsegna=" + dataConsegna +
                ", prodotti=" + prodotti +
                ", cliente=" + cliente +
                '}';
    }
}
