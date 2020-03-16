package eye.xtreme;

import ij.ImagePlus;
import ij.plugin.filter.Convolver;
import ij.process.ImageConverter;
import ij.process.ImageProcessor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Engine 
{
        //DETECTA A POSIÇÃO DOS PRIMEIROS PIXELS EM BRANCO PARTINDO DE UMA POSIÇÃO DEFINIDA
    public int[] firstNonBlack(ImageProcessor img)
    {
        int medianaY = img.getHeight() / 2;
        int medianaX = img.getWidth() / 2;
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;

        //CALCULO DE P1 (Esquerda X)
        for(int cont = 0; cont < img.getWidth(); cont++)
        {
            int pixel = img.getPixel(cont, medianaY);

            if(  pixel > 20 )
            {
               p1 = cont + 10;   
               break;
            }
        }

        //CALCULO DE P2 (Acima Y)
        for(int cont = 0; cont < img.getHeight(); cont++)
        {
            int pixel = img.getPixel(medianaX, cont);

            if(  pixel > 20 )
            {
               p2 = cont;          
               break;
            }
        }

         //CALCULO DE P3 (Direita X)
        for(int cont = img.getWidth(); cont > 0; cont--)
        {
            int pixel = img.getPixel(cont, medianaY);

            if(  pixel > 20 )
            {
               p3 = cont - 20;    
               break;
            }
        }   

        //CALCULO DE P4 (Abaixo Y)
        for(int cont = img.getHeight(); cont > 0 ; cont--)
        {
            int pixel = img.getPixel(medianaX, cont);

            if(  pixel > 20 )
            {
               p4 = cont;  
               break;
            }
        }    

        return new int[]{p1,p2,p3,p4};
    }

    public int[] firstIris(ImageProcessor img)
    {
        int medianaY = img.getHeight() / 2;
        int medianaX = img.getWidth() / 2;
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;

        //CALCULO DE P1 (Esquerda X)
        for(int cont = 0; cont < img.getWidth(); cont++)
        {
            int pixel = img.getPixel(cont, medianaY);

            if(  pixel < 80 )
            {
               p1 = cont;   
               break;
            }
        }

        //CALCULO DE P2 (Acima Y)
        for(int cont = 0; cont < img.getHeight(); cont++)
        {
            int pixel = img.getPixel(medianaX, cont);

            if(  pixel < 80 )
            {
               p2 = cont;          
               break;
            }
        }

         //CALCULO DE P3 (Direita X)
        for(int cont = img.getWidth() - 10; cont > 0; cont--)
        {
            int pixel = img.getPixel(cont, medianaY);

            if(  pixel < 80 )
            {
               p3 = cont;    
               break;
            }
        }   

        //CALCULO DE P4 (Abaixo Y)
        for(int cont = img.getHeight(); cont > 0 ; cont--)
        {
            int pixel = img.getPixel(medianaX, cont);

            if(  pixel < 80 )
            {
               p4 = cont;  
               break;
            }
        }    

        return new int[]{p1,p2,p3,p4};
    }

    //FUNÇÃO QUE CRIA UMA NOVA IMAGEM RETIRANDO BORDAS DESNECESSÁRIAS
    public ImageProcessor newImg(ImageProcessor img, int[] startPos)
    {
        int pixelX = 0;
        int pixelY = 0;

        ImagePlus img1 = new ImagePlus(null, img);
        ImagePlus newImg = new ImagePlus(null, img1.getProcessor().resize(startPos[2] - startPos[0], startPos[3] - startPos[1]));

        ImageProcessor finalImg = newImg.getProcessor();

        for(int contX = startPos[0] ; contX < startPos[2] ; contX++) //FOR DA POSIÇÃO X
        {
           for(int contY = startPos[1]; contY < startPos[3]; contY++) //FOR DA POSIÇÃO Y
           {
               finalImg.putPixel(pixelX, pixelY, img.getPixel(contX, contY));
               pixelY++;
           }

           pixelY = 0;
           pixelX++;
        }

        return finalImg;
    }

    public ImageProcessor hold(ImageProcessor img)
    {

        for(int cont = 0 ; cont < img.getWidth() ; cont++)
        {
            for(int conty = 0 ; conty < img.getHeight() ; conty ++)
            {
                if(img.getPixel(cont, conty) > 120 || img.getPixel(cont, conty) < 75)
                {
                    img.putPixel(cont, conty, 0);
                }
            }
        }

        return img;

    }

    public ImageProcessor processaImagem(ImageProcessor imgEyeOld, ImageProcessor imgEyeNew, JLabel saida)
    {
        imgEyeNew = imgEyeOld.duplicate();

        ImagePlus img = new ImagePlus(null, imgEyeNew);
        ImageConverter converter = new ImageConverter(img);

        converter.convertToGray8();

        imgEyeNew = img.getProcessor();

        int[] Mark = firstNonBlack(imgEyeNew);
        imgEyeNew = newImg(imgEyeNew, Mark);  
        int[] MarkIris = firstIris(imgEyeNew);
        imgEyeNew = newImg(imgEyeNew, MarkIris); 

        exibeImagem(hold(imgEyeNew), saida);

        return imgEyeNew;
    }
       
    public void exibeImagem(ImageProcessor img, JLabel lblIMG)
    {
      ImagePlus iplus = new ImagePlus(null, img);
      ImagePlus iplusTB = new ImagePlus(null, iplus.getProcessor().resize(136, 139));

      //Jogando imagem na Label
      lblIMG.setIcon(new ImageIcon(iplusTB.getBufferedImage()));
    }
}
