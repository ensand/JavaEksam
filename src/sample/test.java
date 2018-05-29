package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Map;
import java.util.Scanner;

public class test extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Goodbye World");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        String nimi;
        Float pikkus;
        Float laius;
        Float uks;

        Scanner scan = new Scanner(System.in);
        System.out.println("Nimi, pikkus, laius, uks");
        nimi = scan.nextLine();
        pikkus = scan.nextFloat();
        laius = scan.nextFloat();
        uks = scan.nextFloat();
        scan.close();

        Tuba tuba1 = new Tuba(nimi, pikkus, laius, uks);
        tuba1.anna_info();

//        SQLDao dao = new SQLDao();
//        Map<String, Tuba> data = dao.selectAll();
//        Tuba sqlTuba = data.get("6");
//        sqlTuba.anna_info();

        launch(args);
    }
}
