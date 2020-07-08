package testRecap_E_H_J;

public class Bijou extends Bien {
    private String couleur;

    public Bijou(double prix,String couleur) {
        super(prix);
        setCouleur(couleur);
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public void setPrix(double prix) {
        if(getPrix()> prix) {
            System.out.println("opération impossible, le prix ne peut diminuer");
            super.setPrix(getPrix());
        } else {
            super.setPrix(prix);
        }

    }

    @Override
    public String toString() {
        return "Bijou à " + getPrix() + " Couleur : " + getCouleur();
    }
}
