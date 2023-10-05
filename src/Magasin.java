import java.util.ArrayList;
import java.util.List;

public class Magasin {
    private final int identifiant;
    private final String adresse;
    private final String nom;

    private final int capacityMax;
    private List<Employe> employes; // Make sure this list is of type Employe
    private final int capacite;
    private ArrayList<Produit> produits = new ArrayList<>();

    public Magasin(int identifiant, String adresse, String nom, int capacityMax) {
        this.identifiant = identifiant;
        this.adresse = adresse;
        this.nom = nom;
        this.capacityMax = capacityMax;
        this.capacite = 20; // Capacité maximale par défaut

        this.produits = new ArrayList<>();
        this.employes = new ArrayList<>();
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


    // Méthode pour ajouter un employé
    public void ajouterEmploye(Employe employe) {
        if (employes.size() < capacite) {
            employes.add(employe);
        } else {
            System.out.println("Capacité maximale d'employés atteinte pour ce magasin.");
        }
    }

    public void calculerEtAfficherSalaires() {
        String nom = null;
        System.out.println("Salaires des employés du magasin " + nom + ":");
        for (Employe employe : employes) {
            double salaire = employe.calculerSalaire();
            System.out.println(employe.getNom() + ": " + salaire + " DT");
        }
    }


}
