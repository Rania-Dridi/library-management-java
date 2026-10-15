public class Utilisateur {
    private static int compteurId = 1;
    private int id;
    private String nom;

    public Utilisateur(String nom) {
        this.id = compteurId++;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Utilisateur{id=" + id + ", nom='" + nom + "'}";
    }
}
