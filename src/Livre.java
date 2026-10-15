public class Livre {
    private static int compteurId = 1;
    private int id;
    private String nom;
    private String auteur;
    private int quantite;
    private String description;

    public Livre(String nom, String auteur, int quantite, String description) {
        this.id = compteurId++;
        this.nom = nom;
        this.auteur = auteur;
        this.quantite = quantite;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Livre{id=" + id + ", nom='" + nom + "', auteur='" + auteur + "', quantite=" + quantite + ", description='" + description + "'}";
    }
}
