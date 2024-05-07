package epicode.entity;

import javax.persistence.*;

//@Embeddable
@Entity
@Table(name = "indirizzi")
public class Indirizzo {

    @Id
    @GeneratedValue
    private int id;
    private String via;
    private String comune;
    private String provincia;

    public Indirizzo(String via, String comune, String provincia) {
        this.via = via;
        this.comune = comune;
        this.provincia = provincia;
    }

    public Indirizzo() {
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
