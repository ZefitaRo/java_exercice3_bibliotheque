public class Main {
    public static void main(String[] args) {
        Bibliotheque bibliotheque = new Bibliotheque();

        // Ajout de livres
        Livre livre1 = new Livre("1984", "George Orwell", "1949", 1, true);
        Livre livre2 = new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", "1943", 2, true);
        bibliotheque.ajouterLivre(livre1);
        bibliotheque.ajouterLivre(livre2);

        // Ajout d'auteurs
        Auteur auteur1 = new Auteur("George Orwell", "25 juin 1903", "Britannique");
        Auteur auteur2 = new Auteur("Antoine de Saint-Exupéry", "29 juin 1900", "Française");
        bibliotheque.ajouterAuteur(auteur1);
        bibliotheque.ajouterAuteur(auteur2);

        // Ajout d'emprunteurs
        Emprunteur emprunteur1 = new Emprunteur("James", "32 rue Concorde", "03 89 84 12 56", "", "");
        Emprunteur emprunteur2 = new Emprunteur("Hannah", "10 rue de la Liberté", "05 12 89 45 78", "", "");
        bibliotheque.ajouterEmprunteur(emprunteur1);
        bibliotheque.ajouterEmprunteur(emprunteur2);

        // Affichage des livres, auteurs et emprunteurs
        System.out.println("Liste des livres :");
        bibliotheque.afficherLivres();

        System.out.println("\nListe des auteurs :");
        bibliotheque.afficherAuteurs();

        System.out.println("\nListe des emprunteurs :");
        bibliotheque.afficherEmprunteurs();

        // Emprunt d'un livre
        bibliotheque.emprunterLivre(1, "Alice");

        // Affichage des livres et emprunteurs après emprunt
        System.out.println("\nListe des livres après emprunt :");
        bibliotheque.afficherLivres();

        System.out.println("\nListe des emprunteurs après emprunt :");
        bibliotheque.afficherEmprunteurs();

        // Retour d'un livre
        bibliotheque.retournerLivre(1);

        // Affichage des livres et emprunteurs après retour
        System.out.println("\nListe des livres après retour :");
        bibliotheque.afficherLivres();

        System.out.println("\nListe des emprunteurs après retour :");
        bibliotheque.afficherEmprunteurs();
    }
}