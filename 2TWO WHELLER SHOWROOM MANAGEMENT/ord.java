import javax.swing.JFrame;
public class ord
{
	 public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Customer Report");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
       	order_list newContentPane = new order_list();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    public ord()
    {
     createAndShowGUI();
    }
}
