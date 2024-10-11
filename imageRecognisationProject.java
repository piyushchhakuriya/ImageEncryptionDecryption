import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.awt.FlowLayout;


public class imageRecognisationProject{

    public static void operate(int key){
        JFileChooser fileChooser = new JFileChooser();  // for choosing the file
        fileChooser.showOpenDialog(null);  // for centering
        File file = fileChooser.getSelectedFile();

        // for reding the file

        try{
            @SuppressWarnings("resource")
            FileInputStream fis = new FileInputStream(file);// reading the file
            byte[]data = new byte[fis.available()];  // the file has been converted into numbers in byte
            fis.read(data);
            // for encrypting we simply X-or the each value of byte of image with key  and for decryption we simply X-or the result value with the key
            int i = 0;
            for(byte b: data){
                System.out.println(b); // the bytes in the image will be printed
                data[i] = (byte)(b^key);
                i++;
            }

            FileOutputStream fos  = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null,"done");

        }catch(Exception e){
            e.printStackTrace();

        }



    }

    public static void main(String[]args){
        System.out.println("This is testing");

        JFrame f = new JFrame();
        f.setTitle("Image operation");  // for setting the title
        f.setSize(500,500);  // setting the size
        f.setLocationRelativeTo(null);  // for centering
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // for easy exit

        // for changing the font
        Font font = new Font("Roboto",Font.BOLD,25);

        // creating button
        JButton button  = new JButton();
        button.setText("open Image");
        button.setFont(font);// for adding the font

       



        // creating text field

        JTextField textField= new JTextField(10); // for textfield werite it in column
        textField.setFont(font);


        // action listener on button
        button.addActionListener(e->{    // lemda function  // button click karne par jo bhi lemda function ke andar hoga wo run ho jaayega
            System.out.println("button clicked");
            String text = textField.getText();
            int temp = Integer.parseInt(text); // wil convert the String into integer if we enter the string otherwise we just type the numbers
            operate(temp);
      });






        f.setLayout(new FlowLayout()); //arranging the above elements in frame
        f.add(button);
        f.add(textField);
        

         
        f.setVisible(true); // for visibility

    }

}