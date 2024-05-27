import javax.swing.JFrame;
public class quot
{
	 public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Customer Report");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        quotation_list newContentPane = new quotation_list();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    public quot()
    {
     createAndShowGUI();
    }
}
