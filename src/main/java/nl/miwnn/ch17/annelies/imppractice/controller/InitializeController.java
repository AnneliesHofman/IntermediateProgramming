package nl.miwnn.ch17.annelies.imppractice.controller;

import nl.miwnn.ch17.annelies.imppractice.model.Color;
import nl.miwnn.ch17.annelies.imppractice.model.ColorCategory;
import nl.miwnn.ch17.annelies.imppractice.model.Object;
import nl.miwnn.ch17.annelies.imppractice.repositories.ColorCategoryRepository;
import nl.miwnn.ch17.annelies.imppractice.repositories.ColorRepository;
import nl.miwnn.ch17.annelies.imppractice.repositories.ObjectRepository;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Annelies Hofman
 * Initialize a database to test the program with
 */

@Controller
public class InitializeController {

    private final ColorRepository colorRepository;
    private final ObjectRepository objectRepository;
    private final ColorCategoryRepository colorCategoryRepository;


    public InitializeController(ColorRepository colorRepository, ObjectRepository objectRepository, ColorCategoryRepository colorCategoryRepository) {
        this.colorRepository = colorRepository;
        this.objectRepository = objectRepository;
        this.colorCategoryRepository = colorCategoryRepository;
    }

    @EventListener
    private void seed(ContextRefreshedEvent ignoredEvent) {
        if (colorRepository.count() == 0) {
            initializeDB();
        }
    }

    private void initializeDB() {
        Color defaultColor = new Color();
        defaultColor.setHue("308, 82%, 78%");
        defaultColor.setLight("304, 88%, 90%");
        defaultColor.setShade("330, 96%, 27%");
        colorRepository.save(defaultColor);

        File colorFile = new File("src/main/resources/static/colors/Paint.txt");

        ArrayList<Color> colors = new ArrayList<>();

        try (Scanner input = new Scanner(colorFile)) {
            while (input.hasNextLine()) {
                String[] regelArray = input.nextLine().split(":");
                String light = regelArray[0];
                String hue = regelArray[1];
                String shade = regelArray[2];
                colors.add(new Color(light, hue, shade));
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Bestand kon niet geopend worden.");
            System.err.println(fileNotFoundException.getMessage());
        }

        colorRepository.saveAll(colors);

        Object snakePlant = makeObject("Snake Plant",
                "/images/plnt_pl-SnakePlant-1-light-0.png",
                "/images/plnt_pl-SnakePlant-1-hue-0.png",
                "/images/plnt_pl-SnakePlant-1-shade-0.png",
                defaultColor,
                "/images/plnt_pl-SnakePlant-2-static-0.png");

        Object cornerSofa = makeObject("Sofa Corner",
                "/images/seat_md-SimpleModularCorner-1-light-0.png",
                "/images/seat_md-SimpleModularCorner-1-hue-0.png",
                "/images/seat_md-SimpleModularCorner-1-shade-0.png",
                defaultColor,
                null);

        Object tallCabinet = makeObject("Tall Cabinet",
                "/images/csg_cb-TallChestOfDrawers-1-light-0.png",
                "/images/csg_cb-TallChestOfDrawers-1-hue-0.png",
                "/images/csg_cb-TallChestOfDrawers-1-shade-0.png",
                defaultColor,
                null);

        Object rhombusTable = makeObject("Rhombus Table",
                "/images/csg_stb-RoundedRhombusCoffeeTable-1-light-120.png",
                "/images/csg_stb-RoundedRhombusCoffeeTable-1-hue-120.png",
                "/images/csg_stb-RoundedRhombusCoffeeTable-1-shade-120.png",
                defaultColor,
                null);

        Object cookieJar = makeObject("Cookie Jar",
                "/images/acc_fd-CookieJar-1-light-0.png",
                "/images/acc_fd-CookieJar-1-hue-0.png",
                "/images/acc_fd-CookieJar-1-shade-0.png",
                defaultColor,
                "/images/acc_fd-CookieJar-2-static-0.png");


        ColorCategory red = makeHueCategory("Red",345 ,15);
        ColorCategory orange = makeHueCategory("Orange",12 ,36);
        ColorCategory yellow = makeHueCategory("Yellow",32 ,65);
        ColorCategory green = makeHueCategory("Green",58 ,144);
        ColorCategory cyan = makeHueCategory("Cyan",140 ,180);
        ColorCategory blue = makeHueCategory("Blue",174 ,250);
        ColorCategory purple = makeHueCategory("Purple",248 ,282);
        ColorCategory pink = makeHueCategory("Pink",278 ,348);
        ColorCategory brown = makeTintCategory("Brown",0 ,40 ,0 ,50,0 ,80 );
        ColorCategory white = makeTintCategory("White",0 ,361,0 ,50 ,80 ,100 );
        ColorCategory black = makeTintCategory("Black",0 ,361,0 ,40 ,0 ,20 );
        ColorCategory light = makeLightnessCategory("Light",55 ,85);
        ColorCategory medium = makeLightnessCategory("Medium",35 ,75);
        ColorCategory dark = makeLightnessCategory("Dark",0 ,40);
        ColorCategory grey = makeSaturationCategory("Grey",0 ,25);
        ColorCategory muted = makeSaturationCategory("Muted",20 ,50);
        ColorCategory vibrant = makeSaturationCategory("Vibrant",45 ,100);
    }

    private Object makeObject(String name, String light, String hue, String shade, Color color, String staticImage) {
        Object object = new Object();

        object.setObjectName(name);
        object.setLightImage(light);
        object.setHueImage(hue);
        object.setShadeImage(shade);
        object.setStaticImage(staticImage);

        object.setColor(color);

        objectRepository.save(object);

        return object;
    }

    private ColorCategory makeHueCategory(String name, int minHue, int maxHue) {

        ColorCategory colorCategory = new ColorCategory();

        colorCategory.setColCatName(name);
        colorCategory.setHueMinValue(minHue);
        colorCategory.setHueMaxValue(maxHue);

        colorCategoryRepository.save(colorCategory);

        return colorCategory;
    }

    private ColorCategory makeLightnessCategory(String name, int minLight, int maxLight) {

        ColorCategory colorCategory = new ColorCategory();

        colorCategory.setColCatName(name);
        colorCategory.setLightnessMinValue(minLight);
        colorCategory.setLightnessMaxValue(maxLight);

        colorCategoryRepository.save(colorCategory);

        return colorCategory;
    }

    private ColorCategory makeSaturationCategory(String name, int minSat, int maxSat) {

        ColorCategory colorCategory = new ColorCategory();

        colorCategory.setColCatName(name);
        colorCategory.setSaturationMinValue(minSat);
        colorCategory.setSaturationMaxValue(maxSat);

        colorCategoryRepository.save(colorCategory);

        return colorCategory;
    }

    private ColorCategory makeTintCategory(String name, int minHue, int maxHue, int minSat, int maxSat, int minLight, int maxLight) {

        ColorCategory colorCategory = new ColorCategory();

        colorCategory.setColCatName(name);
        colorCategory.setHueMinValue(minHue);
        colorCategory.setHueMaxValue(maxHue);
        colorCategory.setSaturationMinValue(minSat);
        colorCategory.setSaturationMaxValue(maxSat);
        colorCategory.setLightnessMinValue(minLight);
        colorCategory.setLightnessMaxValue(maxLight);

        colorCategoryRepository.save(colorCategory);

        return colorCategory;
    }
}
