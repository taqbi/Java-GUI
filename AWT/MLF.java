import java.awt.*;
import java.awt.event.*;

class MLF extends Frame implements MouseListener {
          TextField l1;

	MLF()
	{
		super("Example: MouseListener");
                 l1=new TestField();
                 add(l1);
                 l1.setVisible(true);

		addMouseListener(this);
		setSize(250,100);
	}

	public void mouseClicked(MouseEvent me)
	{
             l1.setText("Mouse clicked");
	}

	public void mouseEntered(MouseEvent me)
	{
           l1.setText("Mouse Entererd");
	}

	public void mouseExited(MouseEvent me)
	{
              l1.setText("Exited ");
	}

	public void mousePressed(MouseEvent me)
	{
                l1.setText("Pressed ");
	}

	public void mouseReleased(MouseEvent me)
	{
		//System.out.println(me);
 l1.setText("Released ");
	}
		
	public static void main(String[] args)
	{
		new MLF().setVisible(true);
	}

}
