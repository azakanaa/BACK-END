package progettosettimanale;
import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Gestione {
    private List<Catalogo> catalogo;

    public Gestione(List<Catalogo> catalogo) {
        this.catalogo = catalogo;
    }

    public void addItem(Catalogo item) {
        catalogo.add(item);
    }

    public void sameISBN(Scanner scanner, Catalogo nuovoElemento) {
        Optional<Catalogo> existingItem = findByISBN(nuovoElemento.getISBN());
        if (existingItem.isPresent()) {
            System.out.println("Un elemento con lo stesso ISBN è già presente nel catalogo:");
            System.out.println(existingItem.get());
            System.out.println("Vuoi sovrascrivere questo elemento? (S/N)");
            String risposta = scanner.nextLine().toUpperCase();
            if ("S".equals(risposta)) {
                removeItemByISBN(nuovoElemento.getISBN());
                addItem(nuovoElemento);
                System.out.println("Elemento sovrascritto correttamente");
            } else if ("N".equals(risposta)) {
                System.out.println("Nessuna modifica effettuata.");
            } else {
                System.out.println("Risposta non valida. Si prega di inserire 'S' per sovrascrivere o 'N' per annullare.");
            }
        } else {
            addItem(nuovoElemento);
            System.out.println("Elemento aggiunto correttamente");
        }
    }

    public void removeItemByISBN(int isbn) {
        catalogo.removeIf(item -> item.getISBN() == isbn);
    }

    public Optional<Catalogo> findByISBN(int isbn) {
        return catalogo.stream()
                .filter(item -> item.getISBN() == isbn)
                .findFirst();
    }

    public List<Catalogo> findByPublicationYear(int year) {
        return catalogo.stream()
                .filter(item -> item.getPubblicazione() == year)
                .toList();
    }

    public List<Catalogo> findByAuthor(String autore) {
        return catalogo.stream()
                .filter(item -> item instanceof Libri && ((Libri) item).getAutore().equals(autore))
                .toList();
    }

    public List<Catalogo> getCatalogo() {
        return catalogo;
    }

    public void savecatalogo(String filePath) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(catalogo);
            System.out.println("Catalogo salvato correttamente su disco.");
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio del catalogo su disco: " + e.getMessage());
        }
    }

    public List<Catalogo> loadcatalogo(String filePath) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            catalogo = (List<Catalogo>) inputStream.readObject();
            System.out.println("Catalogo caricato correttamente da disco.");
            return catalogo;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Errore durante il caricamento del catalogo da disco: " + e.getMessage());
            return null;
        }
    }
}
