package serilization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Persist {

    public static void main(String[] args) throws IOException {
        Emp emp1 = new Emp(123L,"ajay");
        Emp emp2 = new Emp(321L,"reshmi");
        Emp emp3 = new Emp(3212L,"menon");

        FileOutputStream outputStream = new FileOutputStream("out.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(emp1);
        objectOutputStream.writeObject(emp2);
        objectOutputStream.writeObject(emp3);
        objectOutputStream.flush();
        objectOutputStream.close();

        System.out.println("ser/des completed successfully");
    }
}