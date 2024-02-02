import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GetSetPixels {
    public static void main(String args[]) throws IOException {
        BufferedImage img = null;
        File f = null;

        // read image
        try {
            f = new File("Px.png");
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }

        // get image width and height
        int width = img.getWidth();
        int height = img.getHeight();

        // Since, Inp.jpg is a single pixel image so, we
        // will not be using the width and height variable
        // get pixel value (the arguments in the getRGB
        // method denotes the coordinates of the image from
        // which the pixel values need to be extracted)
        int p = img.getRGB(0, 0);

        // We, have seen that the components of pixel occupy
        // 8 bits. To get the bits we have to first right
        // shift the 32 bits of the pixels by bit
        // position(such as 24 in case of alpha) and then
        // bitwise ADD it with 0xFF. 0xFF is the hexadecimal
        // representation of the decimal value 255.

        // get alpha
        int a = (p >> 24) & 0xff;

        // get red
        int r = (p >> 16) & 0xff;

        // get green
        int g = (p >> 8) & 0xff;

        // get blue
        int b = p & 0xff;

        

        a = 255;
        r = 0;
        g = 255;
        b = 0;

        // set the pixel value
        p = (a << 24) | (r << 16) | (g << 8) | b;
        img.setRGB(0, 0, p);

        // write image
        try {
            f = new File("Px - Copie.png");
            ImageIO.write(img, "png", f);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
