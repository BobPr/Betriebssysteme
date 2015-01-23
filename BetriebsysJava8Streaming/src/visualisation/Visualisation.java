package visualisation;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import core.Main;
import core.Person;

public class Visualisation extends JPanel{
	
	private BufferedImage bg_img;
	private int visu_width = 800, visu_height = 600;
	
	public Visualisation(){
		loadBG();
		
		
		
		JFrame f = new JFrame();
		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		f.setSize( 800, 639 );
		f.add( this );
		
		// position the frame in the middle of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation((screenSize.width/2)-(visu_width/2),(screenSize.height/2)-(visu_height/2));
		f.setVisible( true );
	}
	
	private void vpaint( Graphics g )
	{
		g.setColor( Color.WHITE ); 
		g.fillRect( 0, 0, getWidth(), getHeight() );
		g.drawImage(bg_img, 0, 0, 800,	600, this);
		
		g.drawString("#Threads: 100", 600, 60);
	    // draw the passengers
	    ListIterator<Person> it = Main.p.listIterator();
	    while(it.hasNext()){
	    	Person tmp = it.next();
	    	System.out.println("######### "+tmp.y);
	    	g.setColor(new Color(0x9bda49));
			g.fillRect(tmp.x, tmp.y, 15, 15);
			g.setColor(Color.white);
			g.drawRect(tmp.x, tmp.y, 15, 15);
			
			g.setColor(Color.BLACK);
			g.drawString(tmp.getName(), tmp.x+2, tmp.y+15);
	    }
	}

	private final GraphicsConfiguration gfxConf = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

	private BufferedImage offImg;
	@Override protected void paintComponent( Graphics g ){
		if ( offImg == null || offImg.getWidth() != getWidth() || offImg.getHeight() != getHeight() ){
			offImg = gfxConf.createCompatibleImage( getWidth(), getHeight() );
			vpaint( offImg.createGraphics() );
		}
		
		g.drawImage( offImg, 0, 0, this );
		System.out.println("repainted");
		vpaint(g);
	}
	private void loadBG(){
		bg_img = null;
		try {
		    bg_img = ImageIO.read(new File("airport.png"));
		} catch (IOException e) {}
	}
}