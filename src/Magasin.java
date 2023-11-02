import java.util.ArrayList;
import java.util.List;

public class Magasin {
    private final int identifiant;
    private final String adresse;
    private final String nom;
    private final int capacityMax;
    private List<Employe> employes;
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

    public void ajouterProduit(Produit produit) throws MagasinPleinException, PrixNegatifException {
        if (produits.size() < capacityMax) {
            if (produit.getPrix() < 0) {
                throw new PrixNegatifException();
            }
            produits.add(produit);
        } else {
            throw new MagasinPleinException();
        }
    }


    public void afficherCaracteristiques() {
        System.out.println("Magasin ID: " + identifiant);
        System.out.println("Nom: " + nom);
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
        if (chercherProduit(this, produit)) {
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
        System.out.println("Salaires des employés du magasin " + nom + ":");
        for (Employe employe : employes) {
            double salaire = employe.calculerSalaire();
            System.out.println(employe.getNom() + ": " + salaire + " DT");
        }
    }

    public void affichePrimeResponsable() {
        System.out.println("Primes des responsables dans le magasin " + nom + ":");
        for (Employe employe : employes) {
            if (employe instanceof Responsable) {
                Responsable responsable = (Responsable) employe;
                System.out.println(responsable.getNom() + ": " + responsable.getPrime() + " DT");
            }
        }
    }

    public void afficheNombreEmployesParType() {
        int countCaissiers = 0;
        int countResponsables = 0;
        int countVendeurs = 0;

        for (Employe employe : employes) {
            if (employe instanceof Caissier) {
                countCaissiers++;
            } else if (employe instanceof Responsable) {
                countResponsables++;
            } else if (employe instanceof Vendeur) {
                countVendeurs++;
            }
        }

        System.out.println("Nombre de Caissiers: " + countCaissiers);
        System.out.println("Nombre de Responsables: " + countResponsables);
        System.out.println("Nombre de Vendeurs: " + countVendeurs);
    }

    public void afficheSalaire() {
        System.out.println("Salaires des employés du magasin " + nom + ":");
        for (Employe employe : employes) {
            double salaire = employe.calculerSalaire();
            System.out.println(employe.getNom() + ": " + salaire + " DT");
        }
    }
    public static class MagasinPleinException extends Exception {
        public MagasinPleinException() {
            super("Le magasin est plein. Impossible d'ajouter plus de produits.");
        }
    }
    public static class PrixNegatifException extends Exception {
        public PrixNegatifException() {
            super("Le prix du produit ne peut pas être négatif.");
        }
    }


}