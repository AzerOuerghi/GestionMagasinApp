    public   class Employe {
        private int identifiant;
        private String nom;
        private String adresse;
        protected int nbr_heures;

        public Employe(int identifiant, String nom, String adresse, int nbr_heures) {
            this.identifiant = identifiant;
            this.nom = nom;
            this.adresse = adresse;
            this.nbr_heures = nbr_heures;
        }


        public double calculerSalaire() {
            return 0;
        }


        public String getNom() {

            return nom;

        }
    }

    // Classe Caissier
    class Caissier extends Employe {
        private int numeroDeCaisse;

        public Caissier(int identifiant, String nom, String adresse, int nbr_heures, int numeroDeCaisse) {
            super(identifiant, nom, adresse, nbr_heures);
            this.numeroDeCaisse = numeroDeCaisse;
        }

        @Override
        public double calculerSalaire() {

            double salaire = nbr_heures * 5; // Salaire de base : 5DT/H
            if (nbr_heures > 180) {
                salaire += salaire * 0.15; // Bonus pour heures supplémentaires
            }
            return salaire;
        }

        // Getters et setters spécifiques à Caissier
        // ...
    }

    // Classe Responsable
    class Responsable extends Employe {
        private double prime;

        public Responsable(int identifiant, String nom, String adresse, int nbr_heures, double prime) {
            super(identifiant, nom, adresse, nbr_heures);
            this.prime = prime;
        }

        @Override
        public double calculerSalaire() {
            double salaire = nbr_heures * 10 + prime; // Salaire de base : 10DT/H + prime
            if (nbr_heures > 160) {
                salaire += (nbr_heures - 160) * 10 * 0.2; // Bonus pour heures supplémentaires
            }
            return salaire;
        }

        // Getters et setters spécifiques à Responsable
        // ...
    }

    // Classe Vendeur
    class Vendeur extends Employe {
        private double tauxDeVente;

        public Vendeur(int identifiant, String nom, String adresse, int nbr_heures, double tauxDeVente) {
            super(identifiant, nom, adresse, nbr_heures);
            this.tauxDeVente = tauxDeVente;
        }

        @Override
        public double calculerSalaire() {
            return 450 * (tauxDeVente / 100); // Salaire = 450 DT * taux_de_vente en %
        }

        // Getters et setters spécifiques à Vendeur
        // ...
    }



