package testRecap_E_H_J;

public class Livre extends Bien {
    private String titre;

    public Livre(float prix,String titre) {
        super(prix);
        setTitre(titre);
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "Livre à " + getPrix() + " Titre : " + getTitre();
    }
}
