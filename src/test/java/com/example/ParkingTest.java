package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ParkingTest {

    @Test
    public void VehiculesAutorisesVide_ajouterVehiculeAutorise_vehiculeDansLaList() {
        // Arranger

        Parking parking = new Parking(1);
        Vehicule nouveauVehicule = new Vehicule("ABC-123");

        // Agir

        parking.ajouterVehiculeAutorise(nouveauVehicule);

        // Assert

        assertEquals(1, parking.getNbVehiculesAutorises());

    }

    @Test
    public void VehiculesAutorisesVide_ajouterTroisVehiculesAutorises_vehiculesDansLaList() {
        // Arranger

        Parking parking = new Parking(1);
        Vehicule nouveauVehicule1 = new Vehicule("ABC-123");
        Vehicule nouveauVehicule2 = new Vehicule("ABC-456");
        Vehicule nouveauVehicule3 = new Vehicule("ABC-789");

        // Agir

        parking.ajouterVehiculeAutorise(nouveauVehicule1);
        parking.ajouterVehiculeAutorise(nouveauVehicule2);
        parking.ajouterVehiculeAutorise(nouveauVehicule3);

        // Assert

        assertEquals(3, parking.getNbVehiculesAutorises());

    }

    @Test
    public void VehiculesAutorisesVide_ajouterDoublonsVehiculesAutorises_unSeulVehiculeDansLaList() {
        // Arranger

        Parking parking = new Parking(1);
        Vehicule nouveauVehicule1 = new Vehicule("ABC-123");
        Vehicule nouveauVehicule2 = new Vehicule("ABC-123");

        // Agir

        parking.ajouterVehiculeAutorise(nouveauVehicule1);
        parking.ajouterVehiculeAutorise(nouveauVehicule2);

        // Assert

        assertEquals(1, parking.getNbVehiculesAutorises());

    }

    @Test
    public void VehiculesPresentsVide_EnregistrerEntree_VehiculeDansLeParking() {
        // Arranger

        Parking parking = new Parking(1);
        Vehicule nouveauVehicule1 = new Vehicule("ABC-123");
        parking.ajouterVehiculeAutorise(nouveauVehicule1);

        // Agir

        parking.enregistrerEntree(nouveauVehicule1);

        // Assert

        assertEquals(1, parking.getNbVehiculesPresents());

    }

    @Test
    public void Capacite0_EnregistrerEntreeAutorisee_VehiculePasDansLeParking() {
        // Arranger

        Parking parking = new Parking(0);
        Vehicule nouveauVehicule1 = new Vehicule("ABC-123");
        parking.ajouterVehiculeAutorise(nouveauVehicule1);

        // Agir

        parking.enregistrerEntree(nouveauVehicule1);

        // Assert

        assertEquals(0, parking.getNbVehiculesPresents());

    }

    @Test
    public void ParkingPlein_EnregistrerEntreeAutorisee_Refuser() {
        // Arranger

        Parking parking = new Parking(2);
        Vehicule nouveauVehicule1 = new Vehicule("ABC-123");
        Vehicule nouveauVehicule2 = new Vehicule("ABC-456");
        Vehicule nouveauVehicule3 = new Vehicule("ABC-789");
        parking.ajouterVehiculeAutorise(nouveauVehicule1);
        parking.ajouterVehiculeAutorise(nouveauVehicule2);
        parking.ajouterVehiculeAutorise(nouveauVehicule3);
        parking.enregistrerEntree(nouveauVehicule1);
        parking.enregistrerEntree(nouveauVehicule2);

        // Agir

        parking.enregistrerEntree(nouveauVehicule3);

        // Assert

        assertEquals(2, parking.getNbVehiculesPresents());

    }

    @Test
    public void deuxImmatriculationIdentiques_EnregistrerEntree_Refuser() {
        // Arranger

        Parking parking = new Parking(2);
        Vehicule nouveauVehicule1 = new Vehicule("ABC-123");
        Vehicule nouveauVehicule2 = new Vehicule("ABC-123");
        parking.ajouterVehiculeAutorise(nouveauVehicule1);
        parking.ajouterVehiculeAutorise(nouveauVehicule2);
        parking.enregistrerEntree(nouveauVehicule1);

        // Agir

        parking.enregistrerEntree(nouveauVehicule2);

        // Assert

        assertEquals(1, parking.getNbVehiculesPresents());

    }

    @Test
    public void vehiculePresent_enregistrerSortie_IlEstSorti() {
        // Arranger

        Parking parking = new Parking(1);
        Vehicule nouveauVehicule1 = new Vehicule("ABC-123");
        parking.ajouterVehiculeAutorise(nouveauVehicule1);
        parking.enregistrerEntree(nouveauVehicule1);

        // Agir

        parking.enregistrerSortie(nouveauVehicule1);

        // Assert

        assertEquals(0, parking.getNbVehiculesPresents());

    }

    @Test
    public void deuxvehiculePresent_enregistrerSortie_IlEstSorti() {
        // Arranger

        Parking parking = new Parking(2);
        Vehicule nouveauVehicule1 = new Vehicule("ABC-123");
        Vehicule nouveauVehicule2 = new Vehicule("ABC-456");
        parking.ajouterVehiculeAutorise(nouveauVehicule1);
        parking.ajouterVehiculeAutorise(nouveauVehicule2);
        parking.enregistrerEntree(nouveauVehicule1);
        parking.enregistrerEntree(nouveauVehicule2);

        // Agir

        parking.enregistrerSortie(nouveauVehicule2);

        // Assert

        assertEquals(1, parking.getNbVehiculesPresents());

    }

    @Test
    public void vehiculeNonPresent_enregistrerSortie_pasDansLeParking() {
        // Arranger

        Parking parking = new Parking(2);
        Vehicule nouveauVehicule1 = new Vehicule("ABC-123");
        Vehicule nouveauVehicule2 = new Vehicule("ABC-456");
        parking.ajouterVehiculeAutorise(nouveauVehicule1);
        parking.ajouterVehiculeAutorise(nouveauVehicule2);
        parking.enregistrerEntree(nouveauVehicule1);

        // Agir

        parking.enregistrerSortie(nouveauVehicule2);

        // Assert

        assertEquals(1, parking.getNbVehiculesPresents());

    }

    @Test
    public void vehiculeEtaitPresent_enregistrerSortie_prevenirProprio() {
        // Arranger

        Parking parking = new Parking(1);
        Vehicule nouveauVehicule1 = new Vehicule("ABC-123");
        Vehicule nouveauVehicule2 = new Vehicule("ABC-123");
        parking.ajouterVehiculeAutorise(nouveauVehicule1);
        parking.ajouterVehiculeAutorise(nouveauVehicule2);
        parking.enregistrerEntree(nouveauVehicule1);

        // Agir

        parking.enregistrerSortie(nouveauVehicule2);

        // Assert

        assertEquals(0, parking.getNbVehiculesPresents());

    }
}
