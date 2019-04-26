package ProjektZamianaZnakow;

import javafx.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;
import static com.sun.glass.ui.Cursor.setVisible;


public class CreateDialogFromOptionPane {

    public static void main(final String[] args) throws Exception {
        final JFrame parent = new JFrame();
        JButton button = new JButton();

//        @Todo
        // brak polskich znakow ze wzgledu na mozliwe problemy
        button.setText("Kliknij żeby wyszukac zmienić jeden ciąg bajtów na drugi");
        parent.add(button);
        parent.pack();
        parent.setVisible(true);

//        @Todo // zrefactorowac

        String input1 = "";
        String input2 = "";
        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String input1 = JOptionPane.showInputDialog(parent,
                        "Wpisz nazwe pliku (bez rozszerzenia)", null);
            }
        });
        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String input2 = JOptionPane.showInputDialog(parent,
                        "Wpisz roszerzenie (np txt, png, jpg)?", null);
            }
        });

//        parent.dispatchEvent(new WindowEvent(parent, WindowEvent.WINDOW_CLOSING));

//        setVisible(false); //you can't see me!
        dispose(); //Destroy the JFrame object

        System.out.println(input1);
        System.out.println(input2);


        }

}