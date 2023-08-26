import java.io.DataInputStream;
import java.io.FileInputStream;

public class leerC {
    public static void main(String[] args) {
        try {

            DataInputStream c = new DataInputStream(new FileInputStream("C:\\Users\\CM\\IdeaProjects\\matrizC\\archivos\\c.mat"));

            int renglonesC = c.readByte();
            int columnasC = c.readByte();

            double[][] matrizC = new double[renglonesC][columnasC];

            System.out.println("Contenido matriz C:");
            for (int i = 0; i < renglonesC; i++) {
                for (int j = 0; j < columnasC; j++) {
                    matrizC[i][j] = c.readDouble();
                    System.out.print(matrizC[i][j] + "\t");


                }
                System.out.println();
            }
            c.close();
        } catch (Exception e){

        }
    }
}
