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

//                String contents = new String(Files.readAllBytes(Paths.get(filePath)));
//                System.out.println( contents);
//                String contents2 = contents.replace(newString, oldString);
////                System.out.println("przed: " +contents2);
//
//                File root = new File("C:\\Users\\Maciej\\Desktop\\Java Projects3\\zamianaZnakow");
////                File root = new File("C:\\");



                try {




                    // co tutaj dalej zrobic


                    Files.walk(Paths.get("C:\\Users\\Maciej\\Desktop\\Java Projects3\\zamianaZnakow"))
                            .filter(p -> p.toString().equals(filePath))
                            .map(p -> p.getParent().getParent())
                            .distinct()
                            .forEach( path -> {
                                FileOutputStream fos = null;
                                try {
                                    String contents = new String(Files.readAllBytes(Paths.get(filePath)));
                                    System.out.println( contents); // plik wczytany do Stringa
                                    String contents2 = contents.replace(newString, oldString); // nowa zamieniona wartosc
//                System.out.println("przed: " +contents2);



                                    //

                                    File dir = new File("C:");
                                    FilenameFilter filter = new FilenameFilter() {
                                        public boolean accept (File dir, String name) {
                                            return name.startsWith("plik");
                                        }
                                    };
                                    String[] children = dir.list(filter);
                                    if (children == null) {
                                        System.out.println("Either dir does not exist or is not a directory");
                                    } else {
                                        for (int i = 0; i< children.length; i++) {
                                            System.out.println(i); //
                                            String filename = children[i];
                                            System.out.println(filename);
                                        }
                                    }
                                    //



                                    File root = new File("C:\\Users\\Maciej\\Desktop\\Java Projects3\\zamianaZnakow");
//                File root = new File("C:\\");


                                    Collection files = FileUtils.listFiles(root, null, true);


                                    fos = new FileOutputStream(filePath);

                                    DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));

                                    outStream.writeUTF(contents2);

                                    outStream.close();

                                } catch (Exception e1) {
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

            finally {

            }


        });




        myStage.setScene(myScene);

        myStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
