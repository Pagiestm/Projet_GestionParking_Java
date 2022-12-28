package com.example;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private int capacite;
    private List<Vehicule> vehiculesPresents;
    private List<Vehicule> vehiculesAutorises;

    public Parking(int capacite) {
        this.capacite = capacite;
        this.vehiculesPresents = new ArrayList<>();
        this.vehiculesAutorises = new ArrayList<>();
    }

    public int getNbVehiculesAutorises() {
        return vehiculesAutorises.size();
    }

    public int getNbVehiculesPresents() {
        return vehiculesPresents.size();
    }

    public void ajouterVehiculeAutorise(Vehicule nouveau) {
        for (Vehicule vehicule : vehiculesAutorises) {
            if (vehicule.getImmatriculation().equals(nouveau.getImmatriculation())) {
                return;
            }
        }
        vehiculesAutorises.add(nouveau);
    }

    public void enregistrerEntree(Vehicule nouveau) {
        if (estPlein()) {
            return;
        }
        if (estDejaPresent(nouveau)) {
            return;
        }
        for (Vehicule v : vehiculesAutorises) {
            if (v.getImmatriculation().equals(nouveau.getImmatriculation())) {
                vehiculesPresents.add(nouveau);
                return;
            }
        }
    }

    private boolean estDejaPresent(Vehicule vehicule) {
        for (Vehicule v : vehiculesPresents) {
            if (v.getImmatriculation().equals(vehicule.getImmatriculation())) {
                return true;
            }
        }
        return false;
    }

    private boolean estPlein() {
        return vehiculesPresents.size() == capacite;
    }

    public void enregistrerSortie(Vehicule vehicule) {
        boolean etaitPresent = vehiculesPresents.remove(vehicule);
        if (!etaitPresent){
            //Prévenir le proprio
        }
    }
}
