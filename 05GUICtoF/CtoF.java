import javax.swing.*;
import java.awt.*;
import java.awt.events.*;

public class CtoF extends JFrame implements ActionListener{
    private JRadioButton ctof, ftoc;
    private JLabel l;
    private JTextField t;
    private JButton b;
    
    public CtoF(){
	this.setTitle("Celcius to Fahrenheit converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	ctof = new JRadioButton("Celcius to Fahrenheit", true);
	ftoc = new JRadioButton("Fahrenheit to Celcius");
	l = new JLabel("Enter your temperature here:");
	t = new JTextField(10);
	b = new JButton("Calculate!");	

	pane.add(ctof);
	pane.add(ftoc);
	pane.add(l);
	pane.add(t);
	pane.add(b);
    }
    public void actionPerformed(Action e){
	String action = e.getActionCommand();
	if (ctof.isSelected()){
	    ConvertToF(
	}
}
