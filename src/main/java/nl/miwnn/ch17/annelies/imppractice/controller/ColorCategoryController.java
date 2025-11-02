package nl.miwnn.ch17.annelies.imppractice.controller;

import nl.miwnn.ch17.annelies.imppractice.model.ColorCategory;
import nl.miwnn.ch17.annelies.imppractice.repositories.ColorCategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Annelies Hofman
 * handles all requests related to color categories
 */

@Controller
@RequestMapping("/colorcategory")
public class ColorCategoryController {
    private final ColorCategoryRepository colorCategoryRepository;

    public ColorCategoryController(ColorCategoryRepository colorCategoryRepository) {
        this.colorCategoryRepository = colorCategoryRepository;
    }

    @GetMapping("/all")
    public String showColorGroupOverview(Model datamodel) {
        datamodel.addAttribute("allColorCategories", colorCategoryRepository.findAll());
        datamodel.addAttribute("formColorCategory", new ColorCategory());

        return "colorCategoryOverview";
    }

//    private String showColCatForm(Model datamodel, ColorCategory colorCategory) {
//        datamodel.addAttribute("formColCat", colorCategory);
//        datamodel.addAttribute("allColorCategories", colorCategoryRepository.findAll());
//
//        return "colCatForm";
//    }

    @GetMapping("/edit/{colCatId}")
    public String showEditColCatForm(@PathVariable("colCatId") Long colCatId, Model datamodel) {
        Optional<ColorCategory> optionalColCat = colorCategoryRepository.findById(colCatId);

        if (optionalColCat.isPresent()) {
            datamodel.addAttribute("formColCat", optionalColCat);
            return "colCatForm";
        }
        return "redirect:/colorcategory/all";
    }

    @PostMapping("/save")
    public String updateColorCategory(@ModelAttribute("formColCat") ColorCategory colorCategory, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/colorcategory/all";
        }
        colorCategoryRepository.save(colorCategory);
        return "redirect:colorcategory/all";
    }
}
