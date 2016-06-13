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

        String tableName = null;

        // show tables
        sql = "show tables";
        System.out.println ("Running: " + sql);
        res = stmt.executeQuery (sql);
        ArrayList<String> names = new ArrayList<String> ();
        while (res.next ())
        {
            String name = res.getString (1);
            names.add (name);
            if (name.equals ("edges"))
                tableName = name;
        }
        res.close ();

        // describe table
        for (String name: names)
        {
            System.out.println ("    " + name);
            sql = "describe " + name;
            res = stmt.executeQuery (sql);
            while (res.next ())
                System.out.println ("        " + res.getString (1) + "\t" + res.getString (2));
            res.close ();
        }

        if (null != tableName)
        {
            // count query
            sql = "select count(1) from " + tableName;
            System.out.println ("Running: " + sql);
            res = stmt.executeQuery (sql);
            while (res.next ())
                System.out.println (res.getString (1));
            res.close ();

            // select * query
//            sql = "select * from " + tableName;
//            sql = "select sup.aliasName, sup.description, sup.mRID, sup.name, direction, geoInfoReference, typ, CoordinateSystem, electronicAddress, mainAddress, phone1, phone2, secondaryAddress, status from " + tableName;
            sql = "select id_seq_1, id_seq_2, id_equ, length from edges " + tableName;
            System.out.println ("Running: " + sql);
            res = stmt.executeQuery (sql);
            int index = 0;
            while (res.next () && (index++ < 5))
                //System.out.println (res.getString (1) + "\t" + res.getString (2) + "\t" + res.getString (3) + "\t" + res.getString (4) + "\t" + res.getString (7) + "\t" + res.getString (8));
                System.out.println (res.getString (1) + "\t" + res.getString (2) + "\t" + res.getString (3) + "\t" + res.getDouble (4));
            res.close ();
        }

        System.out.println ("done");
        con.close ();
    }
}