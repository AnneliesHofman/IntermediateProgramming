package nl.miwnn.ch17.annelies.imppractice.controller;

import nl.miwnn.ch17.annelies.imppractice.model.Color;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

/**
 * @author Annelies Hofman
 * TODO
 */

@Controller
public class ColorController {

    @GetMapping("/colors")
    private static String showColorOverview(Model datamodel) {

        ArrayList<Color> colors = new ArrayList<>();

        colors.add(new Color("142, 28%, 54%", "161, 59%, 27%", "159, 100%, 5%"));
        colors.add(new Color("72, 52%, 75%", "83, 28%, 59%", "124, 72%, 16%"));

        datamodel.addAttribute("colors", colors);

        return "colorOverview";
    }
}
