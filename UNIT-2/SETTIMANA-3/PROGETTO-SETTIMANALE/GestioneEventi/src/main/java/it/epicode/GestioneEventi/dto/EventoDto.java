package it.epicode.GestioneEventi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EventoDto {
    @NotBlank(message = "titolo non può essere vuoto o nullo o con soli spazi")
    private String titolo;

    private String descrizione;

    @NotNull(message = "data non può essere null")
    private LocalDate data;

    @NotBlank(message = "luogo non può essere vuoto o nullo o con soli spazi")
    private String luogo;

    @NotNull(message = "i posti massimi non possono essere null")
    private Integer maxPosti;

    @Min(value = 0, message = "Il numero di posti disponibili deve essere maggiore o uguale a zero (se i posti sono finiti)")
    private Integer numeroPostiDisponibili;

    private List<Integer> partecipanti;
}
