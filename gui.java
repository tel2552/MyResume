// Builds a simple JList GUI that displays implementation descriptions for keywords when one is selected

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class HelpGUI implements ListSelectionListener, ActionListener {

  JButton close;
  JList jlst;
  JLabel jlab;
  JScrollPane jscrlp;

  // Create an array of names
  String keywords[] = { "If", "Switch", "For",
                     "While", "Do-While",  "Break",
                     "Continue" };

  HelpGUI() {
    // Create a new JFrame container
    JFrame jfrm = new JFrame("Help");

    // Specify a flow Layout
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size
    jfrm.setSize(200, 300);

    // Terminate the program when the user closes the application
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a JList
    jlst = new JList(keywords);

    // Set the list selection mode to single-selection
    jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    // Add list to a scroll pane
    jscrlp = new JScrollPane(jlst);

    // Set the preferred size of the scroll pane
    jscrlp.setPreferredSize(new Dimension(120, 90));

    // Make a label that displays the selection
    jlab = new JLabel("Please choose a keyword");

    // Create a button that exits the program on command
    close = new JButton("Close");

    // Add list selection handler
    jlst.addListSelectionListener(this);

    // Add exit button handler
    close.addActionListener(this);

    // Add the list and label to the content pane
    jfrm.add(jscrlp);
    jfrm.add(jlab);
    jfrm.add(close);

    // Display the frame
    jfrm.setVisible(true);
  }

  // Handle list selection events
  public void valueChanged(ListSelectionEvent le) {
    // Get the index of the changed item
    int idx = jlst.getSelectedIndex();

    // Display abstract implementation description for selected keyword
    if(idx != -1)
    	switch(idx) {
		case 0:
			jlab.setText("<html>The if:<br>if(condition) statement;<br>else statement;</html>");
			break;
		case 1:
			jlab.setText("<html>The switch:<br>switch(expression) {<br>	case constant:<br>	statement sequence<br>	break;<br>	// ...<br>}</html>");
			break;
		case 2:
			jlab.setText("<html>The for:<br>for(init; condition; iteration)<br>  statement;</html>");
			break;
		case 3:
			jlab.setText("<html>The while:<br>while(condition) statement;</html>");
			break;
		case 4:
			jlab.setText("<html>The do-while:<br>do {<br>	statement;<br>} while (condition);</html>");
			break;
		case 5:
			jlab.setText("<html>The break:<br>break; or break label;</html>");
			break;
		case 6:
			jlab.setText("<html>The continue:<br>continue; or continue label;</html>");
			break;
		} // end switch
	else
		jlab.setText("Please choose a keyword");
  } // end if

  public void actionPerformed(ActionEvent ae) {
	  System.exit(0);
  }

  public static void main(String args[]) {
    // Create the frame on the event dispatching thread
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new HelpGUI();
      }
    });
  }
}