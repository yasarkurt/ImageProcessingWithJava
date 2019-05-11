package ımageProcessing;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.*;

public class ImageOperations {
    private static BufferedImage image;

    public static BufferedImage getImage() {
        return image;
    }

    public static void setImage(BufferedImage image) {
        ImageOperations.image = image;
    }

    public static BufferedImage readFromFile(String path) {

        File file = new File(path);
        try {
            image = ImageIO.read(file);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return image;
    }

    public static int[][] ımageToInt(BufferedImage img) {
        int[][] dizi = new int[img.getHeight()][img.getWidth()];
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                dizi[i][j] = img.getRGB(j,i);
            }
        }
        return dizi;

    }


    public static void yazdir(int[][] dizi) {
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < dizi[0].length; j++) {
                System.out.println(dizi[i][j]);
            }
        }
    }

    public static void negativeOfImage(int[][] dizi) {
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < dizi[0].length; j++) {
                int a = (dizi[i][j] >> 24) & 0xff;

                //get red
                int r = (dizi[i][j] >> 16) & 0xff;
                r = 255 - r;
                if (r < 0)
                    r = 0;
                //get green
                int g = (dizi[i][j] >> 8) & 0xff;
                g = 255 - g;
                if (g < 0)
                    g = 0;
                //get blue
                int b = dizi[i][j] & 0xff;
                b = 255 - b;
                if (b < 0)
                    b = 0;
                int p = (a << 24) | (r << 16) | (g << 8) | b;

                image.setRGB(j, i, p);

            }
        }
    }

    public static void ImageTranslation(int[][] dizi) {
        int[][] newDizi = new int[dizi.length + 50][dizi[0].length + 50];
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < dizi[0].length; j++) {
                newDizi[i + 50][j + 50] = dizi[i][j];
                image.setRGB(j, i, newDizi[i][j]);
            }
        }
    }

    public static void ImageFlip(int[][] dizi){
        int i,j;
        int[][] newDizi = new int[dizi.length ][dizi[0].length];
        for ( i = 0; i < dizi.length; i++) {
            for ( j = 0; j < dizi[0].length; j++) {
                newDizi[i][j] = dizi[dizi.length-1-i][j];

            }
        }
        for(i=0;i<newDizi.length;i++){
            for(j=0;j<newDizi[0].length;j++){
                image.setRGB(j, i, newDizi[i][j]);
            }
        }
    }

    public static void ImageMirroring(int[][] dizi){
        int i,j;
        int[][] newDizi = new int[dizi.length ][dizi[0].length];
        for ( i = 0; i < dizi.length; i++) {
            for ( j = 0; j < dizi[0].length; j++) {
                newDizi[i][j] = dizi[i][dizi[0].length-1-j];

            }
        }
        for(i=0;i<newDizi.length;i++){
            for(j=0;j<newDizi[0].length;j++){
                image.setRGB(j, i, newDizi[i][j]);
            }
        }
    }

    public static  void ImageBrıghtness(int[][] dizi){
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < dizi[0].length; j++) {
                int a = (dizi[i][j] >> 24) & 0xff;

                //get red
                int r = (dizi[i][j] >> 16) & 0xff;
                r = r+80 ;
                if (r >255)
                    r = 255;
                //get green
                int g = (dizi[i][j] >> 8) & 0xff;
                g = g+80;
                if (g >255)
                    g = 255;
                //get blue
                int b = dizi[i][j] & 0xff;
                b = b+80;
                if (b >255)
                    b = 255;
                int p = (a << 24) | (r << 16) | (g << 8) | b;

                image.setRGB(j, i, p);
            }
        }
    }

    public static void karsitlik(int[][] dizi){
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < dizi[0].length; j++) {
                int a = (dizi[i][j] >> 24) & 0xff;
                //get red
                int r = (dizi[i][j] >> 16) & 0xff;
                r = r*4 ;
                if (r >255)
                    r = 255;
                //get green
                int g = (dizi[i][j] >> 8) & 0xff;
                g = g*4;
                if (g >255)
                    g = 255;
                //get blue
                int b = dizi[i][j] & 0xff;
                b = b*4;
                if (b >255)
                    b = 255;
                int p = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(j, i, p);
            }
        }
    }
    public static void esikleme(int[][] dizi){
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
            if(dizi[i][j]>-5000000)
                dizi[i][j]=16777215;
            if(dizi[i][j]<-5000000)
                dizi[i][j]=0;
            image.setRGB(j,i,dizi[i][j]);
            }
        }
    }

    public static void yakinlastirma(int[][] d) throws IOException {
        BufferedImage foto= ImageIO.read(new File("src\\Image\\gm.jpg"));
        int[][] newDizi;
        newDizi=ımageToInt(foto);
       /* for (int t=0;t<newDizi.length;t++){
            for (int k=0;k<newDizi[0].length;k++){
                newDizi[t][k]=foto.getRGB(k,t);
            }
        }*/
        int n=0;
        int m=0;
        for(int i=0;i<newDizi.length;i++){
            m=0;
            for(int j=0;j<newDizi[0].length;j++){
                d[n][m]=newDizi[i][j];
                d[n][m+1]=newDizi[i][j];
                d[n+1][m+1]=newDizi[i][j];
                d[n+1][m]=newDizi[i][j];
                m=m+2;
            }
            n=n+2;
        }
        for(int i=0;i<d.length-1;i++){
            for(int j=0;j<d[0].length-1;j++){
                image.setRGB(j, i, d[i][j]);
            }
        }
    }



    public static void esikYayma(int[][] dizi) {
        int eb = -500000000;
        int ek = 16777215;
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < dizi[0].length; j++) {
                if (dizi[i][j] >= eb)
                    eb = dizi[i][j];
                if (dizi[i][j] <= ek)
                    ek = dizi[i][j];
            }
        }
        System.out.println("eb:"+eb);
        System.out.println("ek:"+ek);
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < dizi[0].length; j++) {
                dizi[i][j] = (Math.abs(dizi[i][j]) - Math.abs(eb) ) / (Math.abs(ek) - Math.abs(eb)) * (255);
                image.setRGB(i, j, dizi[i][j]);
            }
        }
    }

    public static void dondurme(int[][] dizi) throws IOException{
        BufferedImage foto= ImageIO.read(new File("src\\Image\\gm.jpg"));
        int[][] newDizi;
        newDizi=ımageToInt(foto);
        int x0=dizi[0].length,y0=dizi.length;
        
       /* int xort=foto.getWidth();
        int yort=foto.getHeight();
        int derece=60;
        double radian=Math.toRadians(derece);
        double sin=Math.abs(Math.sin(radian));
        double cos=Math.abs(Math.cos(radian));
        int neww = (int) Math.floor(xort* cos + yort * sin), newh = (int) Math.floor(yort * cos +xort * sin);
        System.out.println(neww+" "+newh);*/




    /*    BufferedImage img= ImageIO.read(new File("src\\Image\\gm.jpg"));
        int[][] newDizi=new int[img.getWidth()][img.getHeight()];
        for (int i=0;i<newDizi.length;i++){
            for (int j=0;j<newDizi[0].length;j++){
                newDizi[i][j]=img.getRGB(i,j);
            }
        }*/

    }
    public static void uzaklastirma(int[][] d) throws IOException {
        BufferedImage foto= ImageIO.read(new File("src\\Image\\gm.jpg"));
        int[][] newDizi;
        newDizi=ımageToInt(foto);
        int [][]dizi=new int[newDizi.length/2][newDizi[0].length/2];
        int n=0,m=0;
        for(int i=0;i<newDizi.length/2;i++) {
            n=0;
            for (int j=0;j<newDizi[0].length/2;j++) {
                dizi[i][j]=(newDizi[n][m]+newDizi[n+1][m]+newDizi[n][m+1]+newDizi[n+1][m+1])/4;
                n=n+2;
            }
            m=m+2;
        }
        for(int i=0;i<dizi.length;i++){
            for(int j=0;j<dizi[0].length;j++){
                image.setRGB(i,j,dizi[i][j]);
            }
        }
    }

  public static long[][] germe(int [][]d){
        int gecici;
        int enb=-5000000;
        int enk=-5000000;
        long[][] dizi=new long[d.length][d[0].length];
        for(int i=0;i<d.length;i++) {
            for (int j = 0; j < d[0].length; j++) {
                if (d[i][j] > enb)
                    enb = d[i][j];
                if (d[i][j] < enk)
                    enk = d[i][j];
            }
        }
        long bayrak=0;
        long bayrak1=0;
      for(int i=0;i<d.length;i++){
          for(int j=0;j<d[0].length;j++){
            bayrak=d[i][j]-enk;
            bayrak1=enb-enk;
              dizi[i][j]=255*bayrak/bayrak1;
              System.out.println(dizi[i][j]);
            gecici=(int) dizi[i][j];
              System.out.println(gecici);
              gecici=-gecici;
              image.setRGB(i,j,gecici);
          }
      }
        return dizi;
  }
    public static void histogram(int[][] d){
        long[][]histogramdizi=new long[d.length][d[0].length];
        histogramdizi=ImageOperations.germe(d);
        int[]sayac=new int[256];
        int gelen;
        for(int i=0;i<sayac.length;i++){
            sayac[i]=0;
        }
        for (int i = 0; i < histogramdizi.length; i++) {
            for (int j = 0; j < histogramdizi[0].length; j++) {
              gelen=(int)histogramdizi[i][j];
              sayac[gelen]=sayac[gelen]+1;
            }
        }
        for(int i=0;i<sayac.length;i++){
            System.out.println(i+"="+sayac[i]);
        }
    }


}
