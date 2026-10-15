public class Emprunt {
    private Utilisateur utilisateur;
    private Livre livre;
    private int jourEmprunt;
    private int moisEmprunt;
    private int jourRetour;
    private int moisRetour;

    public Emprunt(Utilisateur utilisateur, Livre livre, int jourEmprunt, int moisEmprunt) {
        this.utilisateur = utilisateur;
        this.livre = livre;
        this.jourEmprunt = jourEmprunt;
        this.moisEmprunt = moisEmprunt;
        calculerDateRetour();
    }

    private void calculerDateRetour() {
        int joursDansMois = 30;
        int retourJour = jourEmprunt + 7;

        if (retourJour > joursDansMois) {
            retourJour -= joursDansMois;
            moisRetour = moisEmprunt + 1;
        } else {
            moisRetour = moisEmprunt;
        }
        jourRetour = retourJour;
    }

    public double calculerPenalite(int jourActuel, int moisActuel) {
        int retardJours = calculerRetard(jourActuel, moisActuel);
        if (retardJours > 0) {
            return retardJours * 0.5;
        }
        return 0;
    }

    private int calculerRetard(int jourActuel, int moisActuel) {
        int joursDansMois = 30;
        int totalJoursRetour = (moisRetour - 1) * joursDansMois + jourRetour;
        int totalJoursActuels = (moisActuel - 1) * joursDansMois + jourActuel;
        return totalJoursActuels - totalJoursRetour;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public Livre getLivre() {
        return livre;
    }

    @Override
    public String toString() {
        return "Emprunt{utilisateur=" + utilisateur + ", livre=" + livre +
                ", dateEmprunt=" + jourEmprunt + "/" + moisEmprunt +
                ", dateRetour=" + jourRetour + "/" + moisRetour + "}";
    }
}
