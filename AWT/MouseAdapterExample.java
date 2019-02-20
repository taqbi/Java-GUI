import java.awt.*;  
import java.awt.event.*;  
public class MouseAdapterExample extends MouseAdapter{  
    Frame f;  
    MouseAdapterExample(){  
        f=new Frame("Mouse Adapter");  
        f.addMouseListener(this);  
          
        f.setSize(300,300);  
        f.setLayout(null);  
        f.setVisible(true);  
    }  
    public void mouseClicked(MouseEvent e) {  
        Graphics g=f.getGraphics();  
        g.setColor(Color.BLUE);  
        g.fillOval(e.getX(),e.getY(),30,30);  
    }  
      
public static void main(String[] args) {  
    new MouseAdapterExample();  
}  
}  