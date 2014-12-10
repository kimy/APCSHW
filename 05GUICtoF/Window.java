import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame {
    private Container pane;
    private JButton F;
    private JButton C; 

    public Window(){
	this.setTitle("Farenheit and Celsius");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new GridLayout());

	F = new JButton("Farenheit");
	C = new JButton("Celcius");
    }

    public static void main(String[]args){
	Window w = new Window();



    }

}