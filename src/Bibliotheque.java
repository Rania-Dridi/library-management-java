public class Bibliotheque {
    private Livre[] livres;
    private Utilisateur[] utilisateurs;
    private Emprunt[] emprunts;
    private int nbLivres;
    private int nbUtilisateurs;
    private int nbEmprunts;

    public Bibliotheque() {
        livres = new Livre[100];
        utilisateurs = new Utilisateur[100];
        emprunts = new Emprunt[100];
        nbLivres = 0;
        nbUtilisateurs = 0;
        nbEmprunts = 0;
    }

    public void ajouterLivre(Livre livre) {
        if (livre == null) {
            System.out.println("Le livre est invalide.");
            return;
        }
        if (nbLivres >= livres.length) {
            System.out.println("La bibliothèque est pleine, impossible d'ajouter de nouveaux livres.");
            return;
        }
        for (int i = 0; i < nbLivres; i++) {
            if (livres[i].equals(livre)) {
                System.out.println("Le livre est déjà présent dans la bibliothèque.");
                return;
            }
        }
        livres[nbLivres++] = livre;
    }

    public Livre getLivreParNom(String nom) {
        if (nom == null || nom.isEmpty()) {
            System.out.println("Nom de livre invalide.");
            return null;
        }
        for (int i = 0; i < nbLivres; i++) {
            if (livres[i].getNom().equalsIgnoreCase(nom)) {
                return livres[i];
            }
        }
        System.out.println("Livre non trouvé.");
        return null;
    }

    public void afficherLivres() {
        if (nbLivres == 0) {
            System.out.println("Aucun livre disponible.");
            return;
        }
        for (int i = 0; i < nbLivres; i++) {
            System.out.println(livres[i]);
        }
    }

    public void ajouterUtilisateur(Utilisateur utilisateur) {
        if (utilisateur == null) {
            System.out.println("Utilisateur invalide.");
            return;
        }
        if (nbUtilisateurs >= utilisateurs.length) {
            System.out.println("La bibliothèque ne peut plus enregistrer de nouveaux utilisateurs.");
            return;
        }
        for (int i = 0; i < nbUtilisateurs; i++) {
            if (utilisateurs[i].equals(utilisateur)) {
                System.out.println("L'utilisateur est déjà enregistré.");
                return;
            }
        }
        utilisateurs[nbUtilisateurs++] = utilisateur;
    }

    public Utilisateur getUtilisateurParNom(String nom) {
        if (nom == null || nom.isEmpty()) {
            System.out.println("Nom d'utilisateur invalide.");
            return null;
        }
        for (int i = 0; i < nbUtilisateurs; i++) {
            if (utilisateurs[i].getNom().equalsIgnoreCase(nom)) {
                return utilisateurs[i];
            }
        }
        System.out.println("Utilisateur non trouvé.");
        return null;
    }

    public void afficherUtilisateurs() {
        if (nbUtilisateurs == 0) {
            System.out.println("Aucun utilisateur enregistré.");
            return;
        }
        for (int i = 0; i < nbUtilisateurs; i++) {
            System.out.println(utilisateurs[i]);
        }
    }

    public void ajouterEmprunt(Emprunt emprunt) {
        if (emprunt == null) {
            System.out.println("Emprunt invalide.");
            return;
        }
        if (nbEmprunts >= emprunts.length) {
            System.out.println("La bibliothèque ne peut plus enregistrer de nouveaux emprunts.");
            return;
        }
        emprunts[nbEmprunts++] = emprunt;
    }

    public Emprunt getEmpruntParUtilisateurEtLivre(Utilisateur utilisateur, Livre livre) {
        if (utilisateur == null || livre == null) {
            System.out.println("Données invalides pour l'emprunt.");
            return null;
        }
        for (int i = 0; i < nbEmprunts; i++) {
            if (emprunts[i].getUtilisateur().equals(utilisateur) && emprunts[i].getLivre().equals(livre)) {
                return emprunts[i];
            }
        }
        System.out.println("Aucun emprunt trouvé pour cet utilisateur et ce livre.");
        return null;
    }

    public void retournerEmprunt(Emprunt emprunt) {
        if (emprunt == null) {
            System.out.println("Emprunt invalide.");
            return;
        }
        for (int i = 0; i < nbEmprunts; i++) {
            if (emprunts[i].equals(emprunt)) {
                emprunts[i] = emprunts[--nbEmprunts];
                emprunts[nbEmprunts] = null;
                System.out.println("Emprunt retourné avec succès.");
                return;
            }
        }
        System.out.println("Emprunt non trouvé.");
    }

    public void afficherEmprunts() {
        if (nbEmprunts == 0) {
            System.out.println("Aucun emprunt en cours.");
            return;
        }
        for (int i = 0; i < nbEmprunts; i++) {
            System.out.println(emprunts[i]);
        }
    }
}
