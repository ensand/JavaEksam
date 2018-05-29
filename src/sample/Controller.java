package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import java.util.Map;


public class Controller {

    @FXML
    Canvas canvas1 = new Canvas();

    static int x = 30, y = 30, z = 20;

    static SQLDao dao = new SQLDao();
    static Map<String, sample.Tuba> data =  dao.selectAll();
    static sample.Tuba tuba = data.get("6");

    public void drawRoom(GraphicsContext gc) {
        double[] dashes1 = { 10 };
        double[] dashes2 = { 1 };
        gc.setFill(Color.BLACK);

        gc.strokeLine(x, y, x, y + z);
        gc.strokeLine(x, y + z + tuba.uks, x + z, y + z + tuba.uks);
        gc.strokeLine(x, y + z + tuba.uks, x, y + tuba.pikkus);
        gc.strokeLine(x, y + tuba.pikkus, x + tuba.laius - (3 * tuba.laius / 4), y + tuba.pikkus);
        gc.setLineDashes(dashes1);
        gc.strokeLine(x + tuba.laius - (3 * tuba.laius / 4), y + tuba.pikkus, x + tuba.laius - (tuba.laius / 4), y + tuba.pikkus);
        gc.setLineDashes(dashes2);
        gc.strokeLine(x + tuba.laius - (tuba.laius / 4), y + tuba.pikkus, x + tuba.laius, y + tuba.pikkus);
        gc.strokeLine(x + tuba.laius, y + tuba.pikkus, x + tuba.laius, y);
        gc.strokeLine(x + tuba.laius, y, x, y);

    }

    //@FXML
    public void click() {
        GraphicsContext gc = canvas1.getGraphicsContext2D();
        gc.setFill(Color.YELLOW);
        gc.fillRect(x, y, tuba.laius, tuba.pikkus);

        drawRoom(gc);
        //gc.fillText("Toa pindala on " + tuba.laius * tuba.pikkus, 30, 550);
    }

    @FXML
    public void enterPress(KeyEvent event) {
        double S = tuba.laius * tuba.pikkus;
        if (event.getCode() == KeyCode.ENTER) {
            GraphicsContext gc = canvas1.getGraphicsContext2D();
            gc.strokeText("Toa pindala on " + S, 30, 550);
        }
    }


    public void initialize() {
        canvas1.setFocusTraversable(true);
        GraphicsContext gc = canvas1.getGraphicsContext2D();
        drawRoom(gc);
    }


}
