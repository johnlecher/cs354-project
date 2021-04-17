import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class alertWindow {
  public static void main (String[] args) {
    JOptionPane optionPane = new JOptionPane(JOptionPane.WARNING_MESSAGE);
    JDialog dialog = optionPane.createDialog("Warning, mulitple errors in window!");
    dialog.setAlwaysOnTop(true);
    dialog.setVisible(true);
    }
}
