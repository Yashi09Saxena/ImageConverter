
/**
 * Write a description of BatchInversions here.
 * This class returns a new image that is the inverse(negative) of the original image.
 * @author (Yashi Saxena) 
 * @version (07/08/2020)
 */
import edu.duke.*;
import java.io.*;
public class BatchInversions {
    public ImageResource makeInversion(ImageResource inImage)
    {
        ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());
        for(Pixel pixel:outImage.pixels())
        {
            Pixel inPixel= inImage.getPixel(pixel.getX(),pixel.getY());
            pixel.setRed(255-inPixel.getRed());
            pixel.setGreen(255-inPixel.getGreen());
            pixel.setBlue(255-inPixel.getBlue());
        }
        return outImage;
    }
    //selectAndConvert()-> This method allows the user to select several files and save each inverted image as a file with a new filename and display images.
    public void selectAndConvert()
    {
        DirectoryResource dr= new DirectoryResource();
        for(File f: dr.selectedFiles())
        {
          ImageResource inImage = new ImageResource(f);
          inImage.draw();
          String fname = inImage.getFileName();
          String newName  = "inverted-" +fname;
          ImageResource inverted= makeInversion(inImage);
          inverted.setFileName(newName);
          inverted.save();
          inverted.draw();
        }
    }
}
