import java.awt.*;
import java.applet.*;
import java.awt.image.*;

/*<applet code="cuckoo" WIDTH="800" HEIGHT="700"></applet>
<param name="img" value="a.jpeg">
*/
public  class cuckoo  extends Applet
{Image img;
	Canvas c=new Canvas();	
	public void init()
	{
Image img=getImage(getDocumentBase(),getParameter("img"));
	}
public void paint(Graphics g)
	{
	g.drawImage(img,0,0,this);
	
	}
}