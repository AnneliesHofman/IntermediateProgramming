package nl.miwnn.ch17.annelies.imppractice.controller;

import nl.miwnn.ch17.annelies.imppractice.model.Color;
import nl.miwnn.ch17.annelies.imppractice.model.ColorCategory;
import nl.miwnn.ch17.annelies.imppractice.repositories.ColorCategoryRepository;
import nl.miwnn.ch17.annelies.imppractice.repositories.ColorRepository;

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
    private final ColorRepository colorRepository;

    public ColorCategoryController(ColorCategoryRepository colorCategoryRepository, ColorRepository colorRepository) {
        this.colorCategoryRepository = colorCategoryRepository;
        this.colorRepository = colorRepository;
    }

    //overview
    @GetMapping("/all")
    public String showColorGroupOverview(Model datamodel) {
        datamodel.addAttribute("allColorCategories", colorCategoryRepository.findAll());
        //datamodel.addAttribute("formColorCategory", new ColorCategory());

        return "colorCategoryOverview";
    }
    @GetMapping("/calculate/{colCatId}")
    public String showCalculatedColors(@PathVariable("colCatId") Long colCatId, Model datamodel) {
        datamodel.addAttribute("allColorCategories", colorCategoryRepository.findAll());
        datamodel.addAttribute("colors", colorRepository.findAll());

        Optional<ColorCategory> colCat = colorCategoryRepository.findById(colCatId);

        for (Color color : colorRepository.findAll()) {
            calcColorsInCat(colCat.orElse(null), color);
        }
        return "colorCategoryOverview";
    }
    // add colors to category
    public void calcColorsInCat(ColorCategory colCat, Color color) {
        if (calcHueFit(colCat, color) && calcSatFit(colCat, color) && calcLightFit(colCat, color)) {
            colCat.getCatColors().add(color);
        }
    }
    // methods to compare color's HSL to category's min and max values
    public boolean calcHueFit(ColorCategory colCat, Color color) {
        int colHue = separateHue(color);
        return colHue > colCat.getHueMinValue() && colHue < colCat.getHueMaxValue();
    }
    public boolean calcSatFit(ColorCategory colCat, Color color) {
        int colSat = separateSaturation(color);
        return ((colSat > colCat.getSaturationMinValue()) && (colSat < colCat.getSaturationMaxValue()));
    }
    public boolean calcLightFit(ColorCategory colCat, Color color) {
        int colLight = separateLightness(color);
        return ((colLight > colCat.getLightnessMinValue()) && (colLight < colCat.getLightnessMaxValue()));
    }
    // methods for extracting separate Hue Saturation and Lightness values from Color
    // (based on color gradient's medium color (hue)
    public int separateHue(Color color) {
        return Integer.parseInt(color.getHue().substring(0,
                color.getHue().indexOf(",")));
    }
    public int separateSaturation(Color color) {
        return Integer.parseInt(color.getHue().substring((color.getHue().indexOf(" ")+1),
                color.getHue().indexOf("%")));
    }
    public int separateLightness(Color color) {
        return Integer.parseInt(color.getHue().substring((color.getHue().lastIndexOf(" ")+1),
                color.getHue().lastIndexOf("%")));
    }

    //form
    private String showColCatForm(Model datamodel, ColorCategory colorCategory) {
        datamodel.addAttribute("formColCat", colorCategory);
        datamodel.addAttribute("allColorCategories", colorCategoryRepository.findAll());

        return "colCatForm";
    }
    @GetMapping("/edit/{colCatId}")
    public String editColCatForm(@PathVariable("colCatId") Long colCatId, Model datamodel) {
        Optional<ColorCategory> optionalColCat = colorCategoryRepository.findById(colCatId);

        if (optionalColCat.isPresent()) {
            return showColCatForm(datamodel, optionalColCat.get());
        } else {
            return "redirect:/colorcategory/all";
        }
    }
    @PostMapping("/save")
    public String updateColorCategory(@ModelAttribute("formColCat") ColorCategory colorCategory,
                                      BindingResult result, Model datamodel, @RequestParam String action) {
        if (!result.hasErrors()) {
            colorCategoryRepository.save(colorCategory);
        }
        if (action.equals("apply")) {
            return "colorForm";
        } else {
            return "redirect:/color/all";
        }
    }
}
