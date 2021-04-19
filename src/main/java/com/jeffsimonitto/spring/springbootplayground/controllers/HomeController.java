package com.jeffsimonitto.spring.springbootplayground.controllers;

import com.jeffsimonitto.spring.springbootplayground.entities.*;
import com.jeffsimonitto.spring.springbootplayground.services.SeedStarterService;
import com.jeffsimonitto.spring.springbootplayground.services.VarietyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {
    private final VarietyService varietyService;
    private final SeedStarterService seedStarterService;

    public HomeController(VarietyService varietyService, SeedStarterService seedStarterService) {
        this.varietyService = varietyService;
        this.seedStarterService = seedStarterService;
    }

    private Map<String, Object> populateModel() {
        Map<String, Object> map = new HashMap<>();
        map.put("allTypes", Arrays.asList(Type.ALL));
        map.put("allFeatures", Arrays.asList(Feature.ALL));
        map.put("allVarieties", this.varietyService.findAll());
        map.put("allSeedStarters", this.seedStarterService.findAll());
        return map;
    }

    @GetMapping
    public String index(Model model, SeedStarter seedStarter) {
        model.addAllAttributes(populateModel());
        model.addAttribute("seedStarter", seedStarter);
        return "index";
    }

    @PostMapping(params = {"save"})
    public String saveSeedStarter(Model model, SeedStarter seedStarter, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAllAttributes(populateModel());
            return "index";
        }
        this.seedStarterService.add(seedStarter);
        return "redirect:/";
    }

    @PostMapping(params = {"addRow"})
    public String addRow(SeedStarter seedStarter, RedirectAttributes attributes) {
        seedStarter.getRows().add(new Row());
        attributes.addFlashAttribute("seedStarter", seedStarter);
        return "redirect:/";
    }

    @PostMapping
    public String removeRow(@RequestParam("removeRow") int rowId,
                            SeedStarter seedStarter,
                            RedirectAttributes attributes) {
        seedStarter.getRows().remove(rowId);
        attributes.addFlashAttribute("seedStarter", seedStarter);
        return "redirect:/";
    }
}
