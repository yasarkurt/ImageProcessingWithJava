package ımageProcessing;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedImage img = ImageOperations.readFromFile("src\\Image\\gm.jpg");
        int[][]dizi =ImageOperations.ımageToInt(img);


       // ImageOperations.esikleme(dizi);

        //ImageOperations.dondurme(dizi);
     //ImageOperations.karsitlik(dizi);
    //ImageOperations.ImageBrıghtness(dizi);//Parlaklık
        // ImageOperations.ImageMirroring(dizi);
       // ImageOperations.ImageFlip(dizi);//döndürme
        //ImageOperations.ImageTranslation(dizi);//öteleme
         //ImageOperations.dondurme(dizi);//negatifini alma
     // ImageOperations.yakinlastirma(dizi);
       //ImageOperations.uzaklastirma(dizi);
        //ImageOperations.germe(dizi);
     //  ImageOperations.histogram(dizi);
        ResimSahne rs = new ResimSahne(img);





            }
        }



