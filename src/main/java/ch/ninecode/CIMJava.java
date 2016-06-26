package ch.ninecode;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.DriverManager;

public class CIMJava
{
    private static String driverName = "org.apache.hive.jdbc.HiveDriver";

    public static void main (String[] args) throws SQLException
    {
        try
        {
            Class.forName (driverName);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace ();
            System.exit (1);
        }
        // replace "hive" here with the name of the user the queries should run as
        Connection con = DriverManager.getConnection ("jdbc:hive2://localhost:10000/default", "hive", "");
        Statement stmt = con.createStatement ();

        // show databases
        String sql = "show databases";
        System.out.println ("Running: " + sql);
        ResultSet res = stmt.executeQuery (sql);
        while (res.next ())
            System.out.println ("    " + res.getString (1));
        res.close ();

        // show tables
        sql = "show tables";
        System.out.println ("Running: " + sql);
        res = stmt.executeQuery (sql);
        ArrayList<String> names = new ArrayList<String> ();
        while (res.next ())
        {
            String name = res.getString (1);
            names.add (name);
        }
        res.close ();

        // describe table
        for (String name: names)
        {
            System.out.print ("    " + name);
            // count query
            sql = "select count(1) from " + name;
            res = stmt.executeQuery (sql);
            while (res.next ())
                System.out.println (" has " + res.getString (1) + " rows");
            res.close ();
            sql = "describe " + name;
            res = stmt.executeQuery (sql);
            while (res.next ())
                System.out.println ("        " + res.getString (1) + "\t" + res.getString (2));
            res.close ();
        }

        // edges query
        // id_seq_1    string
        // id_seq_2    string
        // id_equ  string
        // container   string
        // length  double
        // voltage string
        // typ string
        // normalOpen  boolean
        // power   double
        // commissioned    string
        // status  string
        // x1  string
        // y1  string
        // x2  string
        // y2  string
        sql = "select id_seq_1, id_seq_2, id_equ, length, x1, y1, x2, y2 from edges";
        System.out.println ("Running: " + sql);
        res = stmt.executeQuery (sql);
        int index = 0;
        while (res.next () && (index++ < 5))
            System.out.println (res.getString (1) + "\t" + res.getString (2) + "\t" + res.getString (3) + "\t" + res.getDouble (4) + "\t" + res.getString (5) + "\t" + res.getString (6) + "\t" + res.getString (7) + "\t" + res.getString (8));
        res.close ();

        // select * query on PositionPoint
        sql = "select * from PositionPoint";
        System.out.println ("Running: " + sql);
        res = stmt.executeQuery (sql);
        index = 0;
        while (res.next () && (index++ < 5))
            System.out.println (res.getString (1) + "\t" + res.getInt (2) + "\t" + res.getString (3) + "\t" + res.getString (4) + "\t" + res.getString (5)+ "\t" + res.getString (6));
        res.close ();

        // explicit query on Location
        // sup struct<sup:element,aliasName:string,description:string,mRID:string,name:string>
        // direction   string
        // geoInfoReference    string
        // typ string
        // CoordinateSystem    string
        // electronicAddress   string
        // mainAddress string
        // phone1  string
        // phone2  string
        // secondaryAddress    string
        // status  string
        sql = "select sup.aliasName, sup.description, sup.mRID, sup.name, direction, geoInfoReference, typ, CoordinateSystem, electronicAddress, mainAddress, phone1, phone2, secondaryAddress, status from Location";
        System.out.println ("Running: " + sql);
        res = stmt.executeQuery (sql);
        index = 0;
        while (res.next () && (index++ < 5))
            System.out.println (res.getString (1) + "\t" + res.getString (2) + "\t" + res.getString (3) + "\t" + res.getString (4) + "\t" + res.getString (5) + "\t" + res.getString (6) + "\t" + res.getString (7) + "\t" + res.getString (8) + "\t" + res.getString (9) + "\t" + res.getString (10) + "\t" + res.getString (11) + "\t" + res.getString (12) + "\t" + res.getString (13) + "\t" + res.getString (14));
        res.close ();

        // select * query on Switch
        sql = "select * from Switch";
        System.out.println ("Running: " + sql);
        res = stmt.executeQuery (sql);
        index = 0;
        while (res.next () && (index++ < 5))
            System.out.println (res.getString (1) + "\t" + res.getBoolean (2) + "\t" + res.getBoolean (3) + "\t" + res.getString (4) + "\t" + res.getBoolean (5)+ "\t" + res.getInt (6));
        res.close ();

        System.out.println ("done");
        con.close ();
    }
}