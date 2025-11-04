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

    //mappings voor objectOverview
    @GetMapping({"/all", "/"})
    private String showObjectOverview(Model datamodel) {
        datamodel.addAttribute("objects", objectRepository.findAll());

        return "objectOverview";
    }

    //mappings/methodes voor ObjectForm
        //geef object mee aan objectForm, en geef alle kleuren mee zodat lijst met kleuren wordt weergeven
    private String showObjectForm(Model datamodel, Object object) {
        datamodel.addAttribute("formObject", object);
        datamodel.addAttribute("colors", colorRepository.findAll());
        return "objectForm";
    }
        //ga naar objectForm en geef specifiek object mee
    @GetMapping("/edit/{objectId}")
    public String showEditObjectForm(@PathVariable("objectId") Long objectId, Model datamodel) {
        Optional<Object> optionalObject = objectRepository.findById(objectId);

        if (optionalObject.isPresent()) {
            return showObjectForm(datamodel, optionalObject.get());
        } else {
            return "redirect:/all";
        }
    }
        //sla object form op en ga meteen terug naar overzicht
    @PostMapping("/save")
    public String updateObject(@ModelAttribute("object") Object object, BindingResult result, Model datamodel) {
        datamodel.addAttribute("objects", objectRepository.findAll());

        if (!result.hasErrors()){
            objectRepository.save(object);
        }
        return "objectOverview";
    }
}
