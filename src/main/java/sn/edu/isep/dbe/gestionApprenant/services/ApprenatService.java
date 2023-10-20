package sn.edu.isep.dbe.gestionApprenant.services;

import org.springframework.stereotype.Service;
import sn.edu.isep.dbe.gestionApprenant.model.Apprenant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ApprenatService {

    private static List<Apprenant> apprenants = new ArrayList<>(Arrays.asList(
            new Apprenant(1, "Mansour", "Ciss", "Diamniadio", "ciss@gmail.com"),
            new Apprenant(2, "Oumar", "Soumare", "Fouta", "soumare@gmail.com"),
            new Apprenant(3, "Amina", "Kah", "Dakar", "kha@gmail.com")
    ));

    public List<Apprenant> getApprenant() {
        return apprenants;
    }

    public Apprenant getApprenantByID(Integer id) {
        Optional<Apprenant> apprenant = apprenants.stream()
                .filter(a -> a.getId() == id)
                .findFirst();
        return apprenant.orElse(null);
    }

    public Apprenant createApprenant(Apprenant apprenant) {
        apprenant.setId(apprenants.size() + 1);
        apprenants.add(apprenant);
        return apprenant;
    }

    public Apprenant updateApprenant(Apprenant apprenant, Integer id) {
        Optional<Apprenant> existingApprenant = apprenants.stream()
                .filter(a -> a.getId() == id)
                .findFirst();
        if (existingApprenant.isPresent()) {
            Apprenant updatedApprenant = existingApprenant.get();
            updatedApprenant.setNom(apprenant.getNom());
            updatedApprenant.setPrenom(apprenant.getPrenom());
            updatedApprenant.setAdresse(apprenant.getAdresse());
            updatedApprenant.setEmail(apprenant.getEmail());
            return updatedApprenant;
        } else {
            return null;
        }
    }

    public void deleteApprenant(Integer id) {
        apprenants.removeIf(a -> a.getId() == id);
    }
}
