package nl.miwnn.ch17.annelies.imppractice.controller;

import nl.miwnn.ch17.annelies.imppractice.model.Color;
import nl.miwnn.ch17.annelies.imppractice.model.PaintCan;
import nl.miwnn.ch17.annelies.imppractice.repositories.ColorRepository;
import nl.miwnn.ch17.annelies.imppractice.repositories.PaintCanRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * @author Annelies Hofman
 * handle requests regarding paint cans
 */

@Controller
@RequestMapping("/paintcan")
public class PaintCanController {

    private final ColorRepository colorRepository;
    private final PaintCanRepository paintCanRepository;

    public PaintCanController(ColorRepository colorRepository, PaintCanRepository paintCanRepository) {
        this.colorRepository = colorRepository;
        this.paintCanRepository = paintCanRepository;
    }

    @GetMapping("/new/{colorId}")
    private String createNewPaintCan(@PathVariable("colorId") Long colorId) {
        Optional<Color> optionalColor = colorRepository.findById(colorId);

        if (optionalColor.isPresent()) {
            PaintCan paintCan = new PaintCan(optionalColor.get());
            paintCanRepository.save(paintCan);
        }

        return "redirect:/color/all";
    }

}
