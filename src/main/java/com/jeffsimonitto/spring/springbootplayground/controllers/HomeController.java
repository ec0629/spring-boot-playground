package com.jeffsimonitto.spring.springbootplayground.controllers;

import com.jeffsimonitto.spring.springbootplayground.entities.*;
import com.jeffsimonitto.spring.springbootplayground.services.SeedStarterService;
import com.jeffsimonitto.spring.springbootplayground.services.VarietyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    private final VarietyService varietyService;
    private final SeedStarterService seedStarterService;

    public HomeController(VarietyService varietyService, SeedStarterService seedStarterService) {
        this.varietyService = varietyService;
        this.seedStarterService = seedStarterService;
    }

    @ModelAttribute("allTypes")
    public List<Type> populateTypes() {
        return Arrays.asList(Type.ALL);
    }

    @ModelAttribute("allFeatures")
    public List<Feature> populateFeatures() {
        return Arrays.asList(Feature.ALL);
    }

    @ModelAttribute("allVarieties")
    public List<Variety> populateVarieties() {
        return this.varietyService.findAll();
    }

    @ModelAttribute("allSeedStarters")
    public List<SeedStarter> populateSeedStarters() {
        return this.seedStarterService.findAll();
    }

    @GetMapping
    public String index(final SeedStarter seedStarter) {
        return "index";
    }

    @PostMapping(params = {"save"})
    public String saveSeedStarter(final SeedStarter seedStarter, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        this.seedStarterService.add(seedStarter);
        model.clear();
        return "redirect:/";
    }

    @PostMapping(params = {"addRow"})
    public String addRow(final SeedStarter seedStarter) {
        seedStarter.getRows().add(new Row());
        return "index";
    }

    @PostMapping
    public String removeRow(@RequestParam("removeRow") final int rowId, final SeedStarter seedStarter) {
        seedStarter.getRows().remove(rowId);
        return "index";
    }
}
