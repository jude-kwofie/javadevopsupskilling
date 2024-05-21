package com.jude;

import com.jude.array.StudentArray;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StudentArray studentArray = new StudentArray(6);
        studentArray.add(new Student("Alex", (short) 24, (byte) 2));
        studentArray.add(new Student("Mex", (short) 24, (byte) 2));
        studentArray.add(new Student("Jude", (short) 24, (byte) 2));
        studentArray.add(new Student("Aaron", (short) 24, (byte) 2));


        System.out.println(studentArray.search("Alex"));

        System.out.println(studentArray.delete("Jude"));
//        studentArray.display();

        System.out.println( "Hello World!" );
    }
}
