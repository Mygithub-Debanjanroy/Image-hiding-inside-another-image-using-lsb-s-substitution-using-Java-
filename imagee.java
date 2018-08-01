import java.io.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class imagee
{	public static void main(String args[]) throws IOException
	{
		String imgpath=null;
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
	  	File f,e,o;
		System.out.println("enter image path of cover image");
		imgpath=br.readLine();
		f=new File(imgpath);
		BufferedImage img=ImageIO.read(f);
		
		System.out.println("enter image path of data image");
		imgpath=br.readLine();
		e=new File(imgpath);
		BufferedImage img2=ImageIO.read(e);
		int h2=img2.getHeight();
		int w2=img2.getWidth();

		int temp=h2;
		int c=0;
		while(h2>0)
		{	c++;
			h2/=10;
		}
		h2=temp;
		switch(c)
		{	case 2:
			{	System.out.print("00"+h2);
				break;
			}
			case 3:
			{	System.out.print("0"+h2);
				break;
			}
			default:
				System.out.print(h2);
		} 
		
		temp=w2;
		c=0;
		while(w2>0)
		{	c++;
			w2/=10;
		}
		w2=temp;
		switch(c)
		{	case 2:
			{	System.out.print("00"+w2);
				break;
			}
			case 3:
			{	System.out.print("0"+w2);
				break;
			}
			default:
				System.out.print(w2);
		} 

		
		o=new File("E:\\assing project\\stego.png");
		for(int i=0;i<w2;i++)
			for(int j=0;j<h2;j++)	
				{	int p2=img2.getRGB(i,j);
					int b2=p2 & 0xff;
					int p=img.getRGB(i,j);
					int a=(p>>24) & 0xff;
					int r=(p>>16) & 0xff;
					int g=(p>>8)& 0xf0;
					 temp=b2>>4;
					g=g | temp;
					int b=p & 0xf0;
					temp=b2 & 0x0f;
					b=b | temp;
					int p3=(a<<24) | (r<<16) | (g<<8) | b;
					img.setRGB(i,j,p3);

				}	
					
		//System.out.print(b);

					ImageIO.write(img,"png",o); 	
		System.out.println();
		

	
		
	}

	
}
                               