package testRecap_E_H_J;

import java.util.ArrayList;
import java.util.List;

public class Habitant {
    private String nom;
    private String prenom;
    private double solde;
    private List<Bien> collection = new ArrayList<>();

    public Habitant(String nom, String prenom, double solde, List<Bien> collection) {
        this.nom = nom;
        this.prenom = prenom;
        this.solde = solde;
        this.collection = collection;
    }

    // surcharge constructor sans List
    public Habitant(String nom, String prenom, double solde) {
        this.nom = nom;
        this.prenom = prenom;
        this.solde = solde;
    }

    public void listePossession() {
        System.out.println("La liste de possession est : ");
        for (Bien biens : collection) {
            System.out.println(biens.toString());
        }
    }

    public Bien getBien(int i) {
        if (collection.size() < i || i < 0) {
            System.out.println("Cet élément n'est pas dans la liste");
            return null;
        } else
            return collection.get(i);
    }

    public void vendre(Bien bien) {
        if (collection.contains(bien)) {
            solde += bien.getPrix();
            collection.remove(bien);
            System.out.println(bien + " a été acheté pour " + bien.getPrix() + " €.");
        } else
            System.out.println(bien + "n'est pas en sa possession.");

    }

    public void vendre(Bien bien, Habitant acheteur) {
        if (collection.contains(bien)) {
            if (acheteur.acheter(bien)) {
                solde += bien.getPrix();
                collection.remove(bien);
                System.out.println(bien + " a été acheté par " + acheteur.getNom() + " pour " + bien.getPrix() + " €.");
            }
        } else
            System.out.println(bien + "n'est pas en sa possession.");
    }

    public boolean acheter(Bien bien) {
        if (solde < bien.getPrix())
            System.out.println("Pas assez riche.");
        else {
            solde -= bien.getPrix();
            collection.add(bien);
            System.out.println(bien + " est ajouté à la collection !");
            return true;
        }
        return false;
    }

    public void ajouterBiens(Bien ... bien) {
        for (Bien i : bien)
        {
            acheter(i);
        }

    }

    public void louer() {
        System.out.println(getNom() + " va louer :");
        for (Bien bien : collection) {
            if (bien instanceof Louer)
                ((Louer) bien).louer();
        }
    }

    public void rendre() {
        System.out.println(getNom() + " va rendre : ");
        for (Bien bien : collection) {
            if (bien instanceof Rendre)
                ((Rendre) bien).rendu();
        }
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public List<Bien> getCollection() {
        return collection;
    }

    public void setCollection(List<Bien> collection) {
        this.collection = collection;
    }
}
