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

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

public class Main extends JFrame {

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
	pane.add(getCheckBox(), BorderLayout.CENTER);
	pane.add(getCheckBox2(), BorderLayout.EAST);
	pane.add(getCheckBox3(), BorderLayout.WEST);
	pane.add(getButtonPanel(), BorderLayout.SOUTH);
    }

    protected JComponent getHeader() {
	JLabel label = new JLabel("The Othello Game", JLabel.CENTER);
	label.setFont(new Font("Courier", Font.BOLD, 24));
	return label;
    }

    
    protected JComponent getCheckBox() {
	return new JCheckBox("Random");
    }

    protected JComponent getCheckBox2() {
	return new JCheckBox("Black Goes First");
    
    }

    protected JComponent getCheckBox3() {
	return new JCheckBox("White Goes First");
    }
    protected JComponent getButtonPanel() {
	JPanel inner = new JPanel();
	inner.setLayout(new GridLayout(1, 2, 10, 0));
	inner.add(new JButton("New Game"));;
	return inner;
    }

}
