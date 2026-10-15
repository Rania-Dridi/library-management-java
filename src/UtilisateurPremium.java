public class UtilisateurPremium extends Utilisateur {

    public UtilisateurPremium(String nom) {
        super(nom);
    }

    @Override
    public String toString() {
        return "UtilisateurPremium{id=" + getId() + ", nom='" + getNom() + "'}";
    }
}
