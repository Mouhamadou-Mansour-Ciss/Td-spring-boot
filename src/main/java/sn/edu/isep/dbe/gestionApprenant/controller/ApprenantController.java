package sn.edu.isep.dbe.gestionApprenant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.edu.isep.dbe.gestionApprenant.model.Apprenant;
import sn.edu.isep.dbe.gestionApprenant.services.ApprenatService;

import java.util.List;

@RestController
@RequestMapping("/api/apprenants")
public class ApprenantController {
    @Autowired
    private ApprenatService apprenatService;

    @GetMapping
    public List<Apprenant> listerApprenants() {
        return apprenatService.getApprenant();
    }
    @GetMapping("/{id}")
    public Apprenant listerApprenantsParId(@PathVariable Integer id) {
       return  apprenatService.getApprenantByID(id);
    }
    @PostMapping
    public Apprenant ajouterApprenant(@RequestBody Apprenant apprenant) {

        return apprenatService.createApprenant(apprenant);
    }
    @PutMapping("/{id}")
    public Apprenant modifierApprenant(@PathVariable Integer id, @RequestBody Apprenant apprenant) {
        return  apprenatService.updateApprenant(apprenant, id);
    }
    @DeleteMapping("/{id}")
    public void supprimerApprenant(@PathVariable int id) {
       apprenatService.deleteApprenant(id);
    }
}
