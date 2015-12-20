package com.springapp.mvc.controller;

import com.springapp.mvc.domain.*;
import com.springapp.mvc.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * Created by Yurii on 12.12.2015.
 */
@Controller
public class DoctorController {

    private RevisionTypeRepository revisionTypeRepository;
    private OrganRepository organRepository;
    private RegionRepository regionRepository;
    private TermRepository termRepository;
    private FeaturesRepository featuresRepository;
    private CharacteristicRepository characteristicRepository;
    private MedicinecardRepository medicinecardRepository;
    @Autowired
    public DoctorController(RevisionTypeRepository revisionTypeRepository, OrganRepository organRepository,
                            RegionRepository regionRepository, TermRepository termRepository,
                            FeaturesRepository featuresRepository, CharacteristicRepository characteristicRepository,
                            MedicinecardRepository medicinecardRepository){
        this.revisionTypeRepository = revisionTypeRepository;
        this.organRepository = organRepository;
        this.regionRepository = regionRepository;
        this.termRepository = termRepository;
        this.featuresRepository = featuresRepository;
        this.characteristicRepository = characteristicRepository;
        this.medicinecardRepository = medicinecardRepository;
    }

    @RequestMapping(value = "newRevision", method = RequestMethod.GET)
    public String newRevision(Model model){
        List<Revisiontype> revisiontypes = this.revisionTypeRepository.getAll();
        model.addAttribute("revisionTypeList",revisiontypes);
        List<Medicinecard> medicinecards = this.medicinecardRepository.getAll();
        model.addAttribute("medicinecards",medicinecards);
        return "newRevision";
    }
    @RequestMapping(value = "revisionDescription/{id}", method = RequestMethod.GET)
    public String revisionDescription(Model model, @PathVariable Integer id){
        List<OrganDictionary> organDictionaries = this.organRepository.getById(id);
        List<RegionDictionary> regionDictionaries = this.regionRepository.getAll();
        List<TermDictionary> termDictionaries = this.termRepository.getAll();
        List<FeaturesDictionary> featuresDictionaries = this.featuresRepository.getAll();
        List<CharacteristicDictionary> characteristicDictionaries = this.characteristicRepository.getAll();
        model.addAttribute("organs", organDictionaries);
        model.addAttribute("regions", regionDictionaries);
        model.addAttribute("terms", termDictionaries);
        model.addAttribute("features", featuresDictionaries);
        model.addAttribute("characteristics", characteristicDictionaries);
        model.addAttribute("description", "");
        return "newRevision";
    }

    @RequestMapping(value = "completeRevision/{description}", method = RequestMethod.GET)
    public String completeRevision(@PathVariable String description){
        System.out.println(description);
        return "";
    }
}

//changed
