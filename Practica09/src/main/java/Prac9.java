import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;
import processing.core.PApplet;
import processing.core.PImage;
/**
     * @author Escobar Rosales Luis Mario 
     */
public class Prac9 extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Prac9");
    }

    //Size
    @Override
    public void settings() {
        size(750, 750);
    }

    
     // Sets a color and loads the document
    @Override
    public void setup() {
        fill(50, 50, 50);
        String document = getClass().getResource("numeros.csv").getPath();
        graph(document);
    }

    /** 
     * Method that graphs circles 
     * @param  document
     */
    public void graphCircle(String document) {
            float rad = 30;
            List<String> lines = Files.readAllLines(Paths.get(document));
            for (String string : lines) {
                String row[] = string.split(",");
                ellipse(Float.parseFloat(row[0]), Float.parseFloat(row[1]), rad, rad);
        } 
    }

}