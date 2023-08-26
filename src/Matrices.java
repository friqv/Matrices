import java.io.*;

public class Matrices {
    public static void main(String[] args) {

        try {

            DataInputStream a = new DataInputStream(new FileInputStream("C:\\Users\\CM\\IdeaProjects\\Matrices\\src\\archivos\\a.mat"));

            int renglonesA = a.readByte();
            int columnasA = a.readByte();

            double[][] matrizA = new double[renglonesA][columnasA];

            System.out.println("Contenido matriz a:");
            for (int i = 0; i < renglonesA; i++) {
                for (int j = 0; j < columnasA; j++) {
                    matrizA[i][j] = a.readDouble();
                    System.out.print(matrizA[i][j] + "\t");


                }
                System.out.println();
            }
            a.close();

            DataInputStream b = new DataInputStream(new FileInputStream("C:\\Users\\CM\\IdeaProjects\\Matrices\\src\\archivos\\b.mat"));

            int renglonesB = b.readByte();
            int columnasB = b.readByte();

            double[][] matrizB = new double[renglonesA][columnasA];

            System.out.println("Contenido de matriz b:");
            for (int i = 0; i < renglonesB; i++) {
                for (int j = 0; j < columnasB; j++) {
                    matrizB[i][j] = b.readDouble();
                    System.out.print(matrizB[i][j] + "\t");
                }
                System.out.println();
            }

            b.close();

            double[][] matrizC = new double[renglonesA][columnasB];
            for (int i = 0; i < renglonesA; i++) {
                for (int j = 0; j < columnasB; j++) {
                    double sum = 0;
                    for (int k = 0; k < columnasA; k++) {
                        sum += matrizA[i][k] * matrizB[k][j];

                    }
                    matrizC[i][j] = sum;
                }
                DataOutputStream c = new DataOutputStream(new FileOutputStream("C:\\Users\\CM\\IdeaProjects\\matrizC\\archivos\\c.mat"));
                c.writeByte(renglonesA);
                c.writeByte(columnasB);

                for (int j = 0; j < renglonesA; j++) {
                    for (int k = 0; k < columnasB; k++) {
                        c.writeDouble(matrizC[i][j]);

                    }

                }
                c.close();


            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

