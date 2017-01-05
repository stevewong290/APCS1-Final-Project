/*import java.awt.FlowLayout;
  import java.awt.GridLayout;
*/
/*from w  ww.j  a v a2 s.  com*/
/*import javax.swing.BoxLayout;
  import javax.swing.JButton;
  import javax.swing.JFrame;
  import javax.swing.JLabel;
  import javax.swing.JPanel;
  import javax.swing.JTextField;

  public class Main {
  public static void main(String args[]) {
  JFrame frame = new JFrame();
  JPanel topPane = new JPanel();
  JPanel midPane = new JPanel();
  JPanel panesHolder = new JPanel();
  JLabel label = new JLabel("Top label");
  JTextField field = new JTextField();
  field.setColumns(5);

  topPane.setLayout(new FlowLayout());
  midPane.setLayout(new GridLayout(3, 2));

  topPane.add(label);
  topPane.add(field);

  midPane.add(new JButton("Button 1"));
  midPane.add(new JButton("Button 2"));
  midPane.add(new JButton("A"));
  midPane.add(new JButton("H"));
  midPane.add(new JButton("I"));
  midPane.add(new JButton("T"));

  panesHolder.setLayout(new BoxLayout(panesHolder, BoxLayout.Y_AXIS));
  panesHolder.add(topPane);
  panesHolder.add(midPane);

  frame.add(panesHolder);
  frame.setSize(400, 300);
  frame.setVisible(true);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
  }
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {
    static String WhiteGoesFirstString = "White Goes First";
    static String BlackGoesFirstString = "Black Goes First";
    static String RandomString = "Random";


    public static void main(String[] args) {
	Main e = new Main();
	e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	e.setSize(400, 300);
	e.setVisible(true);
    }

    public Main() {
	Container pane = getContentPane();
	pane.setLayout(new BorderLayout());
	pane.add(getHeader(), BorderLayout.NORTH);
	pane.add(getRadioButton(), BorderLayout.CENTER);
	pane.add(getButtonPanel(), BorderLayout.SOUTH);
    }

    protected JComponent getHeader() {
	JLabel label = new JLabel("The Othello Game", JLabel.CENTER);
	label.setFont(new Font("Courier", Font.BOLD, 24));
	return label;
    }

    
	protected JComponent getRadioButton() {
	return new JRadioButton("White Goes First");
	}

    /*     protected JComponent getRadioButton1() {
	return new JRadioButton("White Goes First");
	}

	protected JComponent getRadioButton2() {
	return new JRadioButton("Black Goes First");
	}
    */
    
  
 
    /*
    protected JComponent getGroup() {
	JRadioButton whiteGoesFirstButton = new JRadioButton(WhiteGoesFirstString);
	whiteGoesFirstButton.setMnemonic(KeyEvent.VK_W);
	whiteGoesFirstButton.setActionCommand(WhiteGoesFirstString);
	whiteGoesFirstButton.setSelected(true);
 
	JRadioButton randomButton = new JRadioButton(RandomString);
	randomButton.setMnemonic(KeyEvent.VK_C);
	randomButton.setActionCommand(RandomString);
 
	JRadioButton blackGoesFirstButton = new JRadioButton(BlackGoesFirstString);
	blackGoesFirstButton.setMnemonic(KeyEvent.VK_D);
	blackGoesFirstButton.setActionCommand(BlackGoesFirstString);
	JButtonGroup group = new JButtonGroup();
        group.add(whiteGoesFirstButton);
        group.add(randomButton);
        group.add(blackGoesFirstButton);
	return group;
    }
    */

    /*   protected JComponent getCheckBox2() {
	 return new JCheckBox("Black Goes First");
    
	 }

	 protected JComponent getCheckBox3() {
	 return new JCheckBox("White Goes First");
	 }

    */
    protected JComponent getButtonPanel() {
	JPanel inner = new JPanel();
	inner.setLayout(new GridLayout(1, 2, 10, 0));
	inner.add(new JButton("New Game"));;
	return inner;
    }

}
