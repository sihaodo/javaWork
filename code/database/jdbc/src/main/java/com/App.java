package com;

import com.database.Jdbc;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )throws Exception{
        System.out.println( "Hello World!" );
        Jdbc.selectEmp();
    }
}
