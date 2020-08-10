
/**
 * Write a description of GrayScaleConverter here.
 * This class returns a new image that is the grayscale conversion of the original image.
 * @author (Yashi Saxena) 
 * @version (07/08/2020)
 */
import edu.duke.*;
import java.io.*;
public class GrayScaleConverter {

    public ImageResource makeGray(ImageResource inImage)
    {
        ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());
        for(Pixel pixel:outImage.pixels())
        {
            Pixel inPixel= inImage.getPixel(pixel.getX(),pixel.getY());
            int avg = (inPixel.getRed()+inPixel.getGreen()+inPixel.getBlue())/3;
            pixel.setRed(avg);
            pixel.setGreen(avg);
            pixel.setBlue(avg);
        }
        return outImage;
    }
    //selectAndConvert()-> This method allows the user to select several files and save each gray scale converted image as a file with a new filename and display images.
    public void selectAndConvert()
    {
        DirectoryResource dr= new DirectoryResource();
        for(File f: dr.selectedFiles())
        {
          ImageResource inImage = new ImageResource(f);
          inImage.draw();
          String fname = inImage.getFileName();
          String newName  = "gray-" +fname;
          ImageResource gray= makeGray(inImage);
          gray.setFileName(newName);
          gray.save();
          gray.draw();
        }
    }
}
