import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CubeColors {
    public static void main(String args[]){
        BufferedImage img = null;
        File f = null;
        try {
            f = new File("DefCube.png");
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
        int width = img.getWidth();
        int height = img.getHeight();

        for (int col = 0; col < width; col++){
            for (int row = 0; row < height; row++){
                int p = img.getRGB(col, row);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;
                if (r != 0 && g != 0 && b != 0){
                    a = 255;
                    r = 255;
                    g = 0;
                    b = 0;
                    p = (a <<24) | (r << 16) | (g << 8) | b;
                    img.setRGB(col, row, p);
                }
                System.out.print(a);
                System.out.print(r);
                System.out.print(g);
                System.out.println(b);
            }
        }
        try {
            f = new File("DefCube - copy.png");
            ImageIO.write(img, "png", f);
        } catch (IOException e) {
            System.out.println(e);
        }
        
    }

}