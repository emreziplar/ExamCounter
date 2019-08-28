
import java.awt.Color;
import javax.swing.JButton;


public class ButtonOperations 
{
    private Color originalBgColor;
    public void buttonMouseEntered(JButton button , Color originalBgColor)
    {
        this.originalBgColor = originalBgColor;
        button.setBackground(Color.black);
        button.setForeground(Color.white);
    }
    
    public void buttonMouseExited(JButton button , Color fgColor)
    {
        button.setBackground(originalBgColor);
        button.setForeground(Color.black);
    }
}
