package nl.miwnn.ch17.annelies.imppractice.controller;

import nl.miwnn.ch17.annelies.imppractice.model.Color;
import nl.miwnn.ch17.annelies.imppractice.repositories.ColorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

/**
 * @author Annelies Hofman
 * TODO
 */

@Controller
public class ColorController {

    private final ColorRepository colorRepository;

    public ColorController(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @GetMapping({"/color/all", "/"})
    private String showColorOverview(Model datamodel) {

        datamodel.addAttribute("colors", colorRepository.findAll());

        return "colorOverview";
    }

    @GetMapping("/color/add")
    public String showColorForm(Model datamodel) {
        datamodel.addAttribute("formColor", new Color());

        return "colorForm";
    }

    @PostMapping("/color/save")
    public String saveOrUpdateColor(@ModelAttribute("formColor") Color color, BindingResult result) {
        if (!result.hasErrors()){
            colorRepository.save(color);
        }

        return "redirect:/color/all";
    }
}
