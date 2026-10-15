import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bibliotheque bibliotheque = new Bibliotheque();

        while (true) {
            System.out.println("------------------------------------------------------");
            System.out.println("Choisir une fonctionalité : ");
            System.out.println("1 - Gestion des livres");
            System.out.println("2 - Gestion des utilisateur");
            System.out.println("3 - Gestion des emprunt");
            System.out.println("4 - Quitter");
            System.out.print("Votre choix: ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    gestionLivres(bibliotheque, scanner);
                    break;
                case 2:
                    gestionUtilisateurs(bibliotheque, scanner);
                    break;
                case 3:
                    gestionEmprunts(bibliotheque, scanner);
                    break;
                case 4:
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("invalide. Réessayez.");
            }
        }
    }

    public static void gestionLivres(Bibliotheque bibliotheque, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Gestion des Livres ---");
            System.out.println("1 - Ajouter un livre");
            System.out.println("2 - Afficher les livres");
            System.out.println("3 - Retour");
            System.out.print("Votre choix: ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Nom du livre : ");
                    String nomLivre = scanner.nextLine();
                    System.out.print("Auteur: ");
                    String auteurLivre = scanner.nextLine();
                    System.out.print("Quantité du livre : ");
                    int quantiteLivre = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Description (optionnel) : ");
                    String descriptionLivre = scanner.nextLine();
                    Livre livre = new Livre(nomLivre, auteurLivre, quantiteLivre, descriptionLivre.isEmpty() ? null : descriptionLivre);
                    bibliotheque.ajouterLivre(livre);
                    break;
                case 2:
                    bibliotheque.afficherLivres();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("invalide. Réessayez.");
            }
        }
    }

    public static void gestionUtilisateurs(Bibliotheque bibliotheque, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Gestion des Utilisateurs ---");
            System.out.println("1 - Ajouter un utilisateur");
            System.out.println("2 - Afficher les utilisateurs");
            System.out.println("3 - Retour");
            System.out.print("Votre choix: ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Nom de l'utilisateur : ");
                    String nomUtilisateur = scanner.nextLine();
                    Utilisateur utilisateur = new Utilisateur(nomUtilisateur);
                    bibliotheque.ajouterUtilisateur(utilisateur);
                    break;
                case 2:
                    bibliotheque.afficherUtilisateurs();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("invalide. Réessayez.");
            }
        }
    }

    public static void gestionEmprunts(Bibliotheque bibliotheque, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Gestion des Emprunts ---");
            System.out.println("1 - Emprunter un livre");
            System.out.println("2 - Retourner un livre");
            System.out.println("3 - Afficher les emprunts");
            System.out.println("4 - Retour");
            System.out.print("Votre choix: ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Nom de l'utilisateur : ");
                    String nomUtilisateurEmprunt = scanner.nextLine();
                    System.out.print("Nom du livre : ");
                    String nomLivreEmprunt = scanner.nextLine();
                    System.out.print("Jour d'emprunt : ");
                    int jourEmprunt = scanner.nextInt();
                    System.out.print("Mois d'emprunt : ");
                    int moisEmprunt = scanner.nextInt();
                    scanner.nextLine();

                    Utilisateur utilisateurEmprunt = bibliotheque.getUtilisateurParNom(nomUtilisateurEmprunt);
                    Livre livreEmprunt = bibliotheque.getLivreParNom(nomLivreEmprunt);

                    if (utilisateurEmprunt != null && livreEmprunt != null && livreEmprunt.getQuantite() > 0) {
                        Emprunt emprunt = new Emprunt(utilisateurEmprunt, livreEmprunt, jourEmprunt, moisEmprunt);
                        bibliotheque.ajouterEmprunt(emprunt);
                        livreEmprunt.setQuantite(livreEmprunt.getQuantite() - 1);
                        System.out.println("Livre emprunté avec succés.");
                    } else {
                        System.out.println("Erreur : livre non disponible ou utilisateur non trouvé.");
                    }
                    break;

                case 2:
                    System.out.print("Nom de l'utilisateur : ");
                    String nomUtilisateurRetour = scanner.nextLine();
                    System.out.print("Nom du livre : ");
                    String nomLivreRetour = scanner.nextLine();
                    System.out.print("Jour de retour : ");
                    int jourRetour = scanner.nextInt();
                    System.out.print("Mois de retour : ");
                    int moisRetour = scanner.nextInt();
                    scanner.nextLine();

                    Utilisateur utilisateurRetour = bibliotheque.getUtilisateurParNom(nomUtilisateurRetour);
                    Livre livreRetour = bibliotheque.getLivreParNom(nomLivreRetour);

                    if (utilisateurRetour != null && livreRetour != null) {
                        Emprunt empruntRetour = bibliotheque.getEmpruntParUtilisateurEtLivre(utilisateurRetour, livreRetour);
                        if (empruntRetour != null) {
                            double penalite = empruntRetour.calculerPenalite(jourRetour, moisRetour);
                            bibliotheque.retournerEmprunt(empruntRetour);
                            livreRetour.setQuantite(livreRetour.getQuantite() + 1);

                            if (penalite > 0) {
                                System.out.println("Livre retourné avec une pénalité de " + penalite + " €.");
                            } else {
                                System.out.println("Livre retourné avec succès sans pénalité.");
                            }
                        } else {
                            System.out.println("Aucun emprunt trouvé pour cet utilisateur et ce livre.");
                        }
                    }
                    break;

                case 3:
                    bibliotheque.afficherEmprunts();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("invalide. Réessayez.");
            }
        }
    }
}
