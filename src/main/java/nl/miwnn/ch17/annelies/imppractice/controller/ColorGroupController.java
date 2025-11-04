package nl.miwnn.ch17.annelies.imppractice.controller;

import nl.miwnn.ch17.annelies.imppractice.model.ColorGroup;
import nl.miwnn.ch17.annelies.imppractice.repositories.ColorGroupRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author Annelies Hofman
 * handles all requests related to color groups
 */

@Controller
@RequestMapping("/colorgroup")
public class ColorGroupController {

    private final ColorGroupRepository colorGroupRepository;

    public ColorGroupController(ColorGroupRepository colorGroupRepository) {
        this.colorGroupRepository = colorGroupRepository;
    }

    @GetMapping("/all")
    public String showColorGroupOverview(Model datamodel) {
        datamodel.addAttribute("allColorGroups", colorGroupRepository.findAll());
        datamodel.addAttribute("formColorGroup", new ColorGroup());

        return "colorGroupOverview";
    }

    @PostMapping("/save")
    public String saveOrUpdateColorGroup(@ModelAttribute("formColorGroup") ColorGroup colorGroup, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/colorgroup/all";
        }
        colorGroupRepository.save(colorGroup);
        return "redirect:/colorgroup/all";
    }

    @GetMapping("/delete/{colorGroupId}")
    public String deleteColorGroup(@PathVariable("colorGroupId") Long colorGroupId) {
        colorGroupRepository.deleteById(colorGroupId);
        return "redirect:/colorgroup/all";
    }
}
