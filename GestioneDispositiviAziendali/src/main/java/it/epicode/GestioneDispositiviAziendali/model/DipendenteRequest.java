package it.epicode.GestioneDispositiviAziendali.model;



import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class DipendenteRequest {

    private byte[] profileImage;
    @NotNull(message = "Il campo username non   può essere vuoto")
    @NotEmpty(message = "L'username è obbligatorio")
    @Size(min = 3, max = 20, message = "L'username deve essere lungo dai 3 ai 20 caratteri")
    private String username;

   @NotNull(message = "Il campo nome non può essere vuoto")
    @NotEmpty(message = "Il nome è obbligatorio")
   @Size(min = 3, max = 20, message = "Il nome deve essere lungo dai 3 ai 20 caratteri")
    private String nome;

    @NotNull(message = "Il cognome non può essere vuoto")
    @NotEmpty(message = "Il cognome è obbligatorio")
    @Size(min = 3, max = 20, message = "Il cognome deve essere lungo dai 3 ai 20 caratteri")
    private String cognome;

    @Email(message = "Deve essere un indirizzo email valido")
    @NotBlank(message = "L'email non può essere vuota")
    @NotEmpty(message = "L'email è obbligatoria")
    private String email;

    public DipendenteRequest() {
    }
    public DipendenteRequest(String username, String nome, String cognome, String email) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }








}