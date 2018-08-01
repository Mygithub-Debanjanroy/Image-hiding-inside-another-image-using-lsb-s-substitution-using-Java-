import java.io.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import javax.imageio.ImageIO;
class testpsnr
{	public static void main(String args[]) throws IOException
	{	BufferedImage img1,img2;
		File f1,f2;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter original image path with extention(.png)");
		String imgpath1=br.readLine();
		System.out.println("Enter compair image path with extention(.png)");
		String imgpath2=br.readLine();
		f1=new File(imgpath1);
		f2=new File(imgpath2);
		img1=ImageIO.read(f1);
		img2=ImageIO.read(f2);
		Raster r1=img1.getRaster();
		Raster r2=img2.getRaster();
		int width=img1.getWidth();
		int height=img1.getHeight();
		float tmse=0;
		for(int i=0;i<width;i++)
		{	for(int j=0;j<height;j++)
			{	tmse +=((float)(Math.pow((r1.getSample(i,j,0)-r2.getSample(i,j,0)),2)));
			}
		}
		float mse=tmse/(float)(width*height);
		System.out.println("mse="+mse);
		float psnr=10*(float)(Math.log((255*255)/mse)/Math.log(10));
		System.out.println("psnr="+psnr);
	}
}