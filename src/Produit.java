public class Produit {
    private int identifiant;
    private String nom;
    private double prix;

    public Produit(int identifiant, String nom, double prix) {
        this.identifiant = identifiant;
        this.nom = nom;

            this.prix = prix;

    }

    public int getIdentifiant() {
        return identifiant;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        if (prix >= 0) {
            this.prix = prix;
        } else {
            throw new IllegalArgumentException("Le prix ne peut pas être négatif");
        }
    }

    public static boolean comparer2(Produit produit1, Produit produit2) {
        return produit1.getIdentifiant() == produit2.getIdentifiant() &&
                produit1.getNom().equals(produit2.getNom()) &&
                produit1.getPrix() == produit2.getPrix();
    }






}
