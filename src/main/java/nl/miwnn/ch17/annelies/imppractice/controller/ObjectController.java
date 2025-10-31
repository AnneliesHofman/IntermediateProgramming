package nl.miwnn.ch17.annelies.imppractice.controller;

import nl.miwnn.ch17.annelies.imppractice.model.Color;
import nl.miwnn.ch17.annelies.imppractice.model.ColorGroup;
import nl.miwnn.ch17.annelies.imppractice.model.Object;
import nl.miwnn.ch17.annelies.imppractice.repositories.ColorRepository;
import nl.miwnn.ch17.annelies.imppractice.repositories.ObjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Annelies Hofman
 * handle requests regarding objects
 */

@Controller
@RequestMapping("/object")
public class ObjectController {


    private final ColorRepository colorRepository;
    private final ObjectRepository objectRepository;

    public ObjectController(ColorRepository colorRepository, ObjectRepository objectRepository) {
        this.colorRepository = colorRepository;
        this.objectRepository = objectRepository;
    }

    @GetMapping({"/all", "/"})
    private String showObjectOverview(Model datamodel) {
        datamodel.addAttribute("objects", objectRepository.findAll());

        return "objectOverview";
    }
}
