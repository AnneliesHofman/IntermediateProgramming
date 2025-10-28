package nl.miwnn.ch17.annelies.imppractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

/**
 * @author Annelies Hofman
 * TODO
 */

@Controller
public class ColorController {

    @GetMapping("/colors")
    private static String showColorOverview(Model datamodel) {

        datamodel.addAttribute("requestTime", LocalDateTime.now());

        return "colorOverview";
    }
}
