import java.io.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class extract
{	public static void main(String args[]) throws IOException
	{
		String imgpath;
		System.out.println("enter the stego image path");	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		imgpath=br.readLine();	
	  	File f,e;
		BufferedImage img=null,img2=null,img3=null;
		
		f=new File(imgpath);
		img=ImageIO.read(f);
		DataInputStream in=new DataInputStream(System.in);
	 	System.out.println("Enter the order of the stgoimage to be extract");
		int x=Integer.parseInt(in.readLine());
		int y=Integer.parseInt(in.readLine());
		img2=img.getSubimage(0,0,x,y);
		e=new File("C:\\javadoc\\extract_for_stego.png");
		int b=0;
		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++)
				
				
			{		int p=img.getRGB(i,j);
					int g=(p>>8) & 0xff;
					int n=(g<<4) & 0xff;
					b=p & 0x0f;
					n=(n | b) & 0xff;
					p=(255<<24) | (n<<16) | (n<<8) | n;
					img2.setRGB(i,j,p);
					 
					
			}
			
		//System.out.println();
		ImageIO.write(img2,"png",e);
		
	}

	
}
                               