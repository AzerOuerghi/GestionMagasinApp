public class GestionMagasinApp {
    public static void main(String[] args) throws Magasin.MagasinPleinException, Magasin.PrixNegatifException {
        // Create some Magasin objects
        Magasin magasin1 = new Magasin(1, "Carrefour", "Centre-Ville", 50);
        Magasin magasin2 = new Magasin(2, "Monoprix", "Menzah 6", 50);

        // Create some Employe objects
        Caissier caissier1 = new Caissier(1, "Jean", "Adresse 1", 190, 1);
        Vendeur vendeur1 = new Vendeur(2, "Alice", "Adresse 2", 160, 20);
        Responsable responsable1 = new Responsable(3, "Paul", "Adresse 3", 170, 100);

        Caissier caissier2 = new Caissier(4, "Marie", "Adresse 4", 175, 2);
        Vendeur vendeur2 = new Vendeur(5, "Julien", "Adresse 5", 150, 15);
        Vendeur vendeur3 = new Vendeur(6, "Sophie", "Adresse 6", 170, 18);
        Responsable responsable2 = new Responsable(7, "Pierre", "Adresse 7", 180, 120);

        // Add employees to magasins
        magasin1.ajouterEmploye(caissier1);
        magasin1.ajouterEmploye(vendeur1);
        magasin1.ajouterEmploye(responsable1);

        magasin2.ajouterEmploye(caissier2);
        magasin2.ajouterEmploye(vendeur2);
        magasin2.ajouterEmploye(vendeur3);
        magasin2.ajouterEmploye(responsable2);

        // Create some Produit objects
        Produit produit1 = new Produit(1, "Laptop", 999.99);
        Produit produit2 = new Produit(2, "Smartphone", 499.99);
        Produit produit3 = new Produit(3, "Tablet", 299.99);

        // Add produits to magasins
        magasin1.ajouterProduit(produit1);
        magasin1.ajouterProduit(produit1);
        magasin2.ajouterProduit(produit3);

        magasin1.supprimerProduit(produit1);
        magasin1.supprimerProduit(produit2);

        Magasin.magasinAvecLePlusDeProduits(magasin1, magasin2);

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
            System.out.println("Le produit existe dans le magasin");
        } else {
            System.out.println("Le produit n'existe pas dans le magasin");
        }

        // Display magasin characteristics
        System.out.println("Caractéristiques du Magasin 1:");
        magasin1.afficherCaracteristiques();

        System.out.println("\nCaractéristiques du Magasin 2:");
        magasin2.afficherCaracteristiques();

        // Display salaries and other employee information
        System.out.println("\nSalaires des employés dans Magasin 1:");
            magasin1.afficheSalaire();

        System.out.println("\nPrimes des responsables dans Magasin 2:");
        magasin2.affichePrimeResponsable();
        System.out.println("\nNombre d'employés par type dans Magasin 2:");

        magasin2.afficheNombreEmployesParType();

        System.out.println("\nNombre d'employés par type dans Magasin 1:");
        magasin1.afficheNombreEmployesParType();
        System.out.println("\nPrimes des responsables dans Magasin 1:");

        magasin1.affichePrimeResponsable();

    }
}
