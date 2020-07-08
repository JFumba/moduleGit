package testRecap_E_H_J;

public class Vetement extends Bien{
    private String taille;

    public Vetement(float prix,String taille) {
        super(prix);
        setTaille(taille);

    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        if (taille.equals("XS") || taille.equals("S") || taille.equals("M") || taille.equals("L") || taille.equals("XL")) {
            this.taille = taille;
        } else {
            System.out.println("Taille invalide");
        }
    }

    @Override
    public String toString() {
        return "Vetement à " + getPrix() + " Taille : " + getTaille();
    }
}
