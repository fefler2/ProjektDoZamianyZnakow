package ProjektZamianaZnakow;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Iterator;

public class ZamianaZnakow extends Application {
    @Override
    public void start(Stage myStage) {

        myStage.setTitle("Zamiana bajtow");

        GridPane rootNode = new GridPane();
        rootNode.setPadding(new Insets(15));
        rootNode.setHgap(5);
        rootNode.setVgap(5);
        rootNode.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(rootNode, 700, 300);

        rootNode.add(new Label("Wprowadz nazwe pliku jaki chcesz przeszukac (bez rozszerzenia):"), 0, 0);
        TextField firstValue = new TextField();
        rootNode.add(firstValue, 1, 0);

        rootNode.add(new Label("Wpisz rozszerzenie pliku (np .txt, .png, .jpg)"), 0, 1);
        TextField secondValue = new TextField();
        rootNode.add(secondValue, 1, 1);

        rootNode.add(new Label("Wpisz ciag bajtow jaki chcesz zamienic"), 0, 2);
        TextField thirdValue = new TextField();
        rootNode.add(thirdValue, 1, 2);

        rootNode.add(new Label("Wpisz ciag bajtow na jaki chcesz zamienic poprzedni ciag"), 0, 3);
        TextField fourthValue = new TextField();
        rootNode.add(fourthValue, 1, 3);




        Button executiveButton = new Button("Wykonaj");
        rootNode.add(executiveButton, 1, 6);
        GridPane.setHalignment(executiveButton, HPos.LEFT);
        TextField result = new TextField();
        result.setEditable(false);



        executiveButton.setOnAction(e -> {



            String filePath = firstValue.getText() + "." + secondValue.getText();
            String newString = thirdValue.getText();
            String oldString = fourthValue.getText();



            BufferedWriter out = null;


            try {

                String contents = new String(Files.readAllBytes(Paths.get(filePath)));
                System.out.println( contents);
                String contents2 = contents.replace(newString, oldString);
                System.out.println(contents2);

                File root = new File("C:\\");



                try {


                    Collection files = FileUtils.listFiles(root, null, true);





                    Files.walk(Paths.get("C:\\Users\\Maciej\\Desktop\\Java Projects3\\zamianaZnakow"))
                            .filter(p -> p.toString().equals(filePath))
                            .map(p -> p.getParent().getParent())
                            .distinct()
                            .forEach( path -> {
                                FileOutputStream fos = null;
                                try {
                                    fos = new FileOutputStream(filePath);
                                } catch (FileNotFoundException e1) {
                                    e1.printStackTrace();
                                }
                                DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
                                try {
                                    outStream.writeUTF(contents2);
                                } catch (IOException e1) {
                                    e1.printStackTrace();
                                }
                                try {
                                    outStream.close();
                                } catch (IOException e1) {
                                    e1.printStackTrace();
                                }
                            });


//                    for (Iterator iterator = files.iterator(); iterator.hasNext();) {
//                        File file = (File) iterator.next();
//                        if (file.getName().equals(filePath))
//                        {
//                            FileOutputStream fos = new FileOutputStream(filePath);
//                            DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
//                            outStream.writeUTF(contents2);
//                            outStream.close();
//                        }
//
//                    }

                } catch (Exception e3) {
                    e3.printStackTrace();
                }



            }

            catch (IOException e2) {
                System.err.println("Error: " + e2.getMessage());
            }


        });




        myStage.setScene(myScene);

        myStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
