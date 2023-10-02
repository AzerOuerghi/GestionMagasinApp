
public class GestionMagasinApp {



    public static void main(String[] args) {
        // Create some Magasin objects
        Magasin magasin1 = new Magasin(1, "123 Main Street", 50);
        Magasin magasin2 = new Magasin(2, "456 Elm Avenue",50);

        // Create some Produit objects
        Produit produit1 = new Produit(1,"Laptop", 999.99);
        Produit produit2 = new Produit(2,"Smartphone", 499.99);
        Produit produit3 = new Produit(3,"Tablet", 299.99);

        // Add produits to magasins
        magasin1.ajouterProduit(produit1);
        magasin1.ajouterProduit(produit1);
        magasin2.ajouterProduit(produit3);

        magasin1.supprimerProduit(produit1);
        magasin1.supprimerProduit(produit2);


        Magasin.magasinAvecLePlusDeProduits(magasin1,magasin2);


        boolean areEqual = Produit.comparer2(produit2, produit3);

        // Print the result of the comparison
        if (areEqual) {
            System.out.println("Les produits sont identiques.");
        } else {
            System.out.println("Les produits ne sont pas identiques.");
        }

        boolean isThere = Magasin.chercherProduit(magasin1, produit3);

        // Print the result of the comparison
        if (isThere) {
            System.out.println("Le produit exist dans le magasin");
        } else {
            System.out.println("Le produit ne exist pas dans le magasin");
        }

        // Display magasin characteristics
        System.out.println("Caractéristiques du Magasin 1 :");
        magasin1.afficherCaracteristiques();

        System.out.println("\nCaractéristiques du Magasin 2 :");
        magasin2.afficherCaracteristiques();




    }




}



