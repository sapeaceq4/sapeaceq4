package com.sapient.ace.iq.macquirie.serialization;

import java.io.*;

/**
 * Created by Ravdeep Singh on 23-02-2017.
 */
public class TestThree extends TestTwo implements Serializable {

    int b;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TestThree t = new TestThree();
        System.out.println(
                "Serialization" +
                        ""
        );
        t.b = 10;
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("test.ser"));
        os.writeObject(t);

        os.flush();
        os.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.ser"));
        TestThree ds = (TestThree) in.readObject();
        System.out.println(ds.x + " " + ds.a + " " + ds.b + " ");

    }
}
