//package ProjektZamianaZnakow;
//
//import javafx.event.ActionEvent;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowEvent;
//
//import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;
//import static com.sun.glass.ui.Cursor.setVisible;
//
//
//public class TakeInputs {
//
//    static String input1 = "";
//    static String input2 = "";
//
//    public static void main(final String[] args) throws Exception {
//        final JFrame parent = new JFrame();
//        final JButton button = new JButton();
//
//
//
////        @Todo
//        // brak polskich znakow ze wzgledu na mozliwe problemy
//        button.setText("Kliknij żeby zmienić jeden ciąg bajtów na drugi");
//        parent.add(button);
//        parent.pack();
//        parent.setVisible(true);
//
////        @Todo // zrefactorowac
//
//
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                button.addActionListener(new java.awt.event.ActionListener() {
//                    @Override
//                    public void actionPerformed(java.awt.event.ActionEvent evt) {
//                        input1 = JOptionPane.showInputDialog(parent,
//                                "Wpisz nazwe pliku (bez rozszerzenia)");
//                    }
//                });
//            }
//        });
//
//
//        Thread t2 = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    button.addActionListener(new java.awt.event.ActionListener() {
//                        @Override
//                        public void actionPerformed(java.awt.event.ActionEvent evt) {
//                             input2 = JOptionPane.showInputDialog(parent,
//                                    "Wpisz roszerzenie (np txt, png, jpg)?");
//                        }
//                    });
//                }
//            });
//        }
//
//
//
//        t1.start();
//
//        t1.join();
//
//        t2.start();
//
//        t2.join();
//
//
////        parent.dispatchEvent(new WindowEvent(parent, WindowEvent.WINDOW_CLOSING));
//
////        setVisible(false); //you can't see me!
////        dispose(); //Destroy the JFrame object
//
//        System.out.println(input1);
//        System.out.println(input2);
//
//
//        }
//
//}