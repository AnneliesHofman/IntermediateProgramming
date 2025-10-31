package nl.miwnn.ch17.annelies.imppractice.controller;

import nl.miwnn.ch17.annelies.imppractice.model.Color;
import nl.miwnn.ch17.annelies.imppractice.repositories.ColorGroupRepository;
import nl.miwnn.ch17.annelies.imppractice.repositories.ColorRepository;
import org.aspectj.apache.bcel.classfile.SourceFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Annelies Hofman
 * TODO
 */

@Controller
public class ColorController {

    private final ColorGroupRepository colorGroupRepository;
    private final ColorRepository colorRepository;

    public ColorController(ColorGroupRepository colorGroupRepository, ColorRepository colorRepository) {
        this.colorGroupRepository = colorGroupRepository;
        this.colorRepository = colorRepository;
    }

    @GetMapping({"/color/all"})
    private String showColorOverview(Model datamodel) {
        datamodel.addAttribute("colors", colorRepository.findAll());

        return "colorOverview";
    }

    @GetMapping("/color/add")
    public String showColorForm(Model datamodel) {
        return showColorForm(datamodel, new Color());
    }

    @GetMapping("/color/edit/{colorId}")
    public String showEditColorForm(@PathVariable("colorId") Long colorId, Model datamodel) {
        Optional<Color> optionalColor = colorRepository.findById(colorId);

        if (optionalColor.isPresent()) {
            return showColorForm(datamodel, optionalColor.get());
        }
        return "redirect:/color/all";
    }

    @PostMapping("/color/save")
    public String saveOrUpdateColor(@ModelAttribute("formColor") Color color, BindingResult result) {
        if (!result.hasErrors()){
            colorRepository.save(color);
        }

        return "colorForm";
    }

    @GetMapping("/color/delete/{colorId}")
    public String deleteColor(@PathVariable("colorId") Long colorId) {
        colorRepository.deleteById(colorId);
        return "redirect:/color/all";
    }

    private String showColorForm(Model datamodel, Color color) {
        datamodel.addAttribute("formColor", color);
        datamodel.addAttribute("allColorGroups", colorGroupRepository.findAll());
        return "colorForm";
    }
}
