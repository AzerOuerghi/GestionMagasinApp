import java.util.ArrayList;

public class Magasin {
    private final int identifiant;
    private final String adresse;
    private final int capacityMax;
    private ArrayList<Produit> produits = new ArrayList<>();

    public Magasin(int identifiant, String adresse, int capacityMax) {
        this.identifiant = identifiant;
        this.adresse = adresse;
        this.capacityMax = capacityMax;
    }

    public void ajouterProduit(Produit produit) {
        boolean produitExiste = chercherProduit(this, produit);

        if (!produitExiste && produits.size() < capacityMax) {
            produits.add(produit);
        } else if (produitExiste) {
            System.out.println("Le produit existe déjà dans le magasin.");
        } else {
            System.out.println("Capacité maximale atteinte, impossible d'ajouter plus de produits.");
        }
    }


    public void afficherCaracteristiques() {
        System.out.println("Magasin ID: " + identifiant);
        System.out.println("Adresse: " + adresse);
        System.out.println("Capacité maximale: " + capacityMax);
        System.out.println("Produits dans le magasin:");
        for (Produit produit : produits) {
            System.out.println("Nom: " + produit.getNom() + ", Prix: " + produit.getPrix());
        }
    }

    public ArrayList<Produit> getProduits() {
        return produits;
    }
    public static boolean chercherProduit(Magasin magasin, Produit produit) {
        for (Produit p : magasin.getProduits()) {
            if (p.getIdentifiant() == produit.getIdentifiant() &&
                    p.getNom().equals(produit.getNom()) &&
                    p.getPrix() == produit.getPrix()) {
                return true; // Les produits sont identiques
            }
        }
        return false; // Les produits ne sont pas identiques
    }


    public void supprimerProduit(Produit produit) {
        if (chercherProduit(this,produit)) {
            produits.remove(produit);
        } else {
            System.out.println("Le produit n'existe pas dans le magasin.");
        }
    }

    public static Magasin magasinAvecLePlusDeProduits(Magasin magasin1, Magasin magasin2) {
        int nombreProduitsMagasin1 = magasin1.getProduits().size();
        int nombreProduitsMagasin2 = magasin2.getProduits().size();

        if (nombreProduitsMagasin1 > nombreProduitsMagasin2) {
            return magasin1;
        } else if (nombreProduitsMagasin1 < nombreProduitsMagasin2) {
            return magasin2;
        } else {
            return null; // Les deux magasins ont le même nombre de produits
        }
    }





}
