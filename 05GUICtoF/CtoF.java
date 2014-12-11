import java.awt.event.*;
import javax.swing.*;
import java.awt.*; 

public class CtoF extends JFrame implements ActionListener{
    private JRadioButton ctof, ftoc;
    private JLabel l, ans;
    private JTextField t;
    private JButton b;
    private Container pane;
    private ButtonGroup group;
    
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
	ans = new JLabel("Result:");

	group = new ButtonGroup();
	group.add(ctof);
	group.add(ftoc);

	ctof.addActionListener(this);
	ftoc.addActionListener(this);

	b.setActionCommand("calculate");
	b.addActionListener(this);
        
	pane.add(ctof);
	pane.add(ftoc);
	pane.add(l);
	pane.add(t);
	pane.add(b);
	pane.add(ans);
    }
    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
	String result = "";
	if (action.equals("calculate")){
	    if (ctof.isSelected()){
		result = convertToF(t.getText());
	    }
	    if (ftoc.isSelected()){
		result = convertToC(t.getText());
		}
	    ans.setText("Result: " + result);
	}
    }
    public String convertToF(String t){
	long c = Long.parseLong(t);
	c =(c*9)/5 + 32;
	return ""+c;
    }
    public String convertToC(String t){
	long f = Long.parseLong(t);
        f = ((f-32)*5)/9;
	return ""+f;
    }
    public static void main(String[]args){
	CtoF g = new CtoF();
	g.setVisible(true);
    }
}
