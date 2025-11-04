package nl.miwnn.ch17.annelies.imppractice.controller;

import nl.miwnn.ch17.annelies.imppractice.model.Color;
import nl.miwnn.ch17.annelies.imppractice.repositories.ColorGroupRepository;
import nl.miwnn.ch17.annelies.imppractice.repositories.ColorRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Annelies Hofman
 * Handle all requests regarding colors
 */

@Controller
public class ColorController {

    private final ColorGroupRepository colorGroupRepository;
    private final ColorRepository colorRepository;

    public ColorController(ColorGroupRepository colorGroupRepository, ColorRepository colorRepository) {
        this.colorGroupRepository = colorGroupRepository;
        this.colorRepository = colorRepository;
    }

    //mappings voor colorOverview
    @GetMapping({"/color/all", "/color", "/"})
    private String showColorOverview(Model datamodel) {
        datamodel.addAttribute("colors", colorRepository.findAll());

        return "colorOverview";
    }

    //mappings voor colorForm
        // hulpmethode die waardes aan colorForm mee laat geven voor add en edit
    private String showColorForm(Model datamodel, Color color) {
        datamodel.addAttribute("formColor", color);
        datamodel.addAttribute("allColorGroups", colorGroupRepository.findAll());
        return "colorForm";
    }
        // nieuwe kleur maken
    @GetMapping("/color/add")
    public String showColorForm(Model datamodel) {
        return showColorForm(datamodel, new Color());
    }
        // showColorForm voor nieuwe kleur gebruiken, en invullen met data van Color.colorId
    @GetMapping("/color/edit/{colorId}")
    public String editColorForm(@PathVariable("colorId") Long colorId, Model datamodel) {
        Optional<Color> optionalColor = colorRepository.findById(colorId);

        if (optionalColor.isPresent()) {
            return showColorForm(datamodel, optionalColor.get());
        } else {
            return "redirect:/color/all";
        }
    }
        // slaat kleur op, en bepaalt wat er gebeurt voor verschillende knoppen in het formulier
    @PostMapping("/color/save")
    public String saveColorForm(@ModelAttribute("formColor") Color color,
                            BindingResult result, Model datamodel, @RequestParam String action) {
        datamodel.addAttribute("colors", colorRepository.findAll());
        datamodel.addAttribute("allColorGroups", colorGroupRepository.findAll());

        if (!result.hasErrors()) {
            colorRepository.save(color);
        }
        if (action.equals("apply")) {
            return "colorForm";
        } else {
            return "redirect:/color/all";
        }
    }

    //Kleur verwijderen
    @GetMapping("/color/delete/{colorId}")
    public String deleteColor(@PathVariable("colorId") Long colorId) {
        colorRepository.deleteById(colorId);
        return "redirect:/color/all";
    }
}
