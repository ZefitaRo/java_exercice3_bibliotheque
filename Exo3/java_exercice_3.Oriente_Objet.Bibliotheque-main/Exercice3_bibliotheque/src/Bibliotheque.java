import java.util.ArrayList;
import java.util.List;

class Bibliotheque {
    private List<Livre> livres;
    private List<Auteur> auteurs;
    private List<Emprunteur> emprunteurs;

    public Bibliotheque() {
        livres = new ArrayList<>();
        auteurs = new ArrayList<>();
        emprunteurs = new ArrayList<>();
    }

    public void ajouterLivre(Livre livre) {
        livres.add(livre);
    }

    public void ajouterAuteur(Auteur auteur) {
        auteurs.add(auteur);
    }

    public void ajouterEmprunteur(Emprunteur emprunteur) {
        emprunteurs.add(emprunteur);
    }

    public void supprimerLivre(Livre livre) {
        livres.remove(livre);
    }

    public void supprimerAuteur(Auteur auteur) {
        auteurs.remove(auteur);
    }

    public void supprimerEmprunteur(Emprunteur emprunteur) {
        emprunteurs.remove(emprunteur);
    }

    public void modifierLivre(Livre livre, String titre, String auteur, String datePublication, int numeroId, boolean disponibilite) {
        livre.setTitre(titre);
        livre.setAuteur(auteur);
        livre.setDatePublication(datePublication);
        livre.setNumeroId(numeroId);
        livre.setDisponibilite(disponibilite);
    }

    public void modifierAuteur(Auteur auteur, String nom, String dateNaissance, String nationalite) {
        auteur.setNom(nom);
        auteur.setDateNaissance(dateNaissance);
        auteur.setNationalite(nationalite);
    }

    public void modifierEmprunteur(Emprunteur emprunteur, String nom, String adresse, String numeroTelephone, String dateEmprunt, String dateRetour) {
        emprunteur.setNom(nom);
        emprunteur.setAdresse(adresse);
        emprunteur.setNumeroTelephone(numeroTelephone);
        emprunteur.setDateEmprunt(dateEmprunt);
        emprunteur.setDateRetour(dateRetour);
    }

    public void afficherLivres() {
        for (Livre livre : livres) {
            System.out.println(livre.getTitre() + " - " + livre.getAuteur() + " - " + livre.getDatePublication() + " - " + livre.getNumeroId() + " - " + livre.isDisponibilite());
        }
    }

    public void afficherAuteurs() {
        for (Auteur auteur : auteurs) {
            System.out.println(auteur.getNom() + " - " + auteur.getDateNaissance() + " - " + auteur.getNationalite());
        }
    }

    public void afficherEmprunteurs() {
        for (Emprunteur emprunteur : emprunteurs) {
            System.out.println(emprunteur.getNom() + " - " + emprunteur.getAdresse() + " - " + emprunteur.getNumeroTelephone() + " - " + emprunteur.getDateEmprunt() + " - " + emprunteur.getDateRetour());
        }
    }

    public void emprunterLivre(int numeroId, String nomEmprunteur) {
        Livre livre = null;
        for (Livre l : livres) {
            if (l.getNumeroId() == numeroId) {
                livre = l;
                break;
            }
        }
        if (livre != null && livre.isDisponibilite()) {
            livre.setDisponibilite(false);
            Emprunteur emprunteur = null;
            for (Emprunteur e : emprunteurs) {
                if (e.getNom().equals(nomEmprunteur)) {
                    emprunteur = e;
                    break;
                }
            }
            if (emprunteur != null) {
                emprunteur.setDateEmprunt("ce jour");
                emprunteur.setDateRetour("à déterminer");
            }
            System.out.println("Le livre \"" + livre.getTitre() + "\" a été emprunté par " + nomEmprunteur + ".");
        } else {
            System.out.println("Le livre n'est pas disponible ou n'existe pas.");
        }
    }

    public void retournerLivre(int numeroId) {
        Livre livre = null;
        for (Livre l : livres) {
            if (l.getNumeroId() == numeroId) {
                livre = l;
                break;
            }
        }
        if (livre != null && !livre.isDisponibilite()) {
            livre.setDisponibilite(true);
            Emprunteur emprunteur = null;
            for (Emprunteur e : emprunteurs) {
                if (e.getDateRetour().equals("à déterminer")) {
                    emprunteur = e;
                    break;
                }
            }
            if (emprunteur != null) {
                emprunteur.setDateRetour("ce jour");
            }
            System.out.println("Le livre \"" + livre.getTitre() + "\" est à nouveau disponible.");
        } else {
            System.out.println("Le livre n'a pas été emprunté ou n'existe pas.");
        }
    }
}

class Livre {
    private String titre;
    private String auteur;
    private String datePublication;
    private int numeroId;
    private boolean disponibilite;

    public Livre(String titre, String auteur, String datePublication, int numeroId, boolean disponibilite) {
        this.titre = titre;
        this.auteur = auteur;
        this.datePublication = datePublication;
        this.numeroId = numeroId;
        this.disponibilite = disponibilite;
    }

    // Getters et setters

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    public int getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(int numeroId) {
        this.numeroId = numeroId;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }
}

class Auteur {
    private String nom;
    private String dateNaissance;
    private String nationalite;

    public Auteur(String nom, String dateNaissance, String nationalite) {
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.nationalite = nationalite;
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }
}

class Emprunteur {
    private String nom;
    private String adresse;
    private String numeroTelephone;
    private String dateEmprunt;
    private String dateRetour;

    public Emprunteur(String nom, String adresse, String numeroTelephone, String dateEmprunt, String dateRetour) {
        this.nom = nom;
        this.adresse = adresse;
        this.numeroTelephone = numeroTelephone;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(String dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public String getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(String dateRetour) {
        this.dateRetour = dateRetour;
    }
}






