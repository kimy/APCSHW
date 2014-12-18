import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Window extends JFrame{
    private Container pane;
    private Container buttons;
    private Container text;
    private JButton FC;
    private JButton CF; 
    private JLabel l;
    private JTextField temp;

    public Window(){

	this.setTitle("Farenheit and Celsius");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new GridLayout(2,1));

	text = new Container();
	buttons = new Container();

	text.setLayout(new FlowLayout());
	buttons.setLayout(new FlowLayout());
	pane.add(text);
	pane.add(buttons);

	l = new JLabel("Temperature:", null, JLabel.CENTER);

	FC = new JButton("Farenheit");
	CF = new JButton("Celcius");
	temp = new JTextField(30);

	text.add(l);
	text.add(temp);

	buttons.add(FC);
	buttons.add(CF);

	CF.setActionCommand("CtoF");
	CF.addActionListener(this);
	FC.setActionCommand("FtoC");
	FC.addActionListner(this);

    }

    public void ActionPerformed(ActionEvent e){
	String action = e.getActionCommand();
	String in  = l.getText();
	Double i = Double.parsDouble(in);
	Double t;
	if(action.equals("FtoC")){
		t = 1.8*i + 32;
	}
	if(action.equals("CtoF")){
	    t = (i - 32) * (5.0/9.0);
	}
	temp.setText("" + t);

    }

   

    public static void main(String[]args){
	Window w = new Window();
	w.setVisible(true);



    }

}
