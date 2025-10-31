package nl.miwnn.ch17.annelies.imppractice.controller;

import nl.miwnn.ch17.annelies.imppractice.model.Color;
import nl.miwnn.ch17.annelies.imppractice.model.Object;
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

    public InitializeController(ColorRepository colorRepository, ObjectRepository objectRepository) {
        this.colorRepository = colorRepository;
        this.objectRepository = objectRepository;
    }

    @EventListener
    private void seed(ContextRefreshedEvent ignoredEvent) {
        if (colorRepository.count() == 0) {
            initializeColorDB();
        }
        if (objectRepository.count() == 0) {
            initializeObjectDB();
        }
    }

    private void initializeColorDB() {
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
    }

    private void initializeObjectDB() {
        Object snakePlant = makeObject("Snake Plant",
                "/images/plnt_pl-SnakePlant-1-light-0.png",
                "/images/plnt_pl-SnakePlant-1-hue-0.png",
                "/images/plnt_pl-SnakePlant-1-shade-0.png");
        snakePlant.setStaticImage("/images/plnt_pl-SnakePlant-2-static-0.png");

        Object cornerSofa = makeObject("Sofa Corner",
                "/images/seat_md-SimpleModularCorner-1-light-0.png",
                "/images/seat_md-SimpleModularCorner-1-hue-0.png",
                "/images/seat_md-SimpleModularCorner-1-shade-0.png");

        Object tallCabinet = makeObject("Tall Cabinet",
                "/images/csg_cb-TallChestOfDrawers-1-light-0.png",
                "/images/csg_cb-TallChestOfDrawers-1-hue-0.png",
                "/images/csg_cb-TallChestOfDrawers-1-shade-0.png");

        Object rhombusTable = makeObject("Rhombus Table",
                "/images/csg_stb-RoundedRhombusCoffeeTable-1-light-120.png",
                "/images/csg_stb-RoundedRhombusCoffeeTable-1-hue-120.png",
                "/images/csg_stb-RoundedRhombusCoffeeTable-1-shade-120.png");

        Object cookieJar = makeObject("Cookie Jar",
                "/images/acc_fd-CookieJar-1-light-0.png",
                "/images/acc_fd-CookieJar-1-hue-0.png",
                "/images/acc_fd-CookieJar-1-shade-0.png");
        cookieJar.setStaticImage("/images/acc_fd-CookieJar-2-static-0.png");
    }

    private Object makeObject(String name, String light, String hue, String shade) {
        Object object = new Object();

        object.setObjectName(name);
        object.setLightImage(light);
        object.setHueImage(hue);
        object.setShadeImage(shade);

        objectRepository.save(object);

        return object;
    }
}
