package ch.ninecode;

import java.sql.SQLException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.DriverManager;

public class CIMJava
{
    private static String driverName = "org.apache.hive.jdbc.HiveDriver";

    public static void main (String[] args) throws SQLException
    {
        int index;

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
        ArrayList<String> names = new ArrayList<> ();
        while (res.next ())
        {
            String name = res.getString (1);
            names.add (name);
        }
        res.close ();

        // describe table
        String[] ordered = new String[names.size ()];
        names.toArray (ordered);
        Arrays.sort (ordered);
        for (String name: ordered)
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
        if (names.contains ("edges"))
        {
            sql = "select id_seq_1, id_seq_2, id_equ, length, x1, y1, x2, y2 from edges";
            System.out.println ("Running: " + sql);
            res = stmt.executeQuery (sql);
            index = 0;
            while (res.next () && (index++ < 5))
                System.out.println (res.getString (1) + "\t" + res.getString (2) + "\t" + res.getString (3) + "\t" + res.getDouble (4) + "\t" + res.getString (5) + "\t" + res.getString (6) + "\t" + res.getString (7) + "\t" + res.getString (8));
            res.close ();
        }

        // select * query on PositionPoint
        sql = "select * from PositionPoint";
        System.out.println ("Running: " + sql);
        res = stmt.executeQuery (sql);
        index = 0;
        while (res.next () && (index++ < 5))
            System.out.println (res.getString (1) + "\t" + res.getString (2) + "\t" + res.getString (3) + "\t" + res.getString (4) + "\t" + res.getString (5) + "\t" + res.getString (6));
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
        sql = "select sup.aliasName aliasName, sup.description description, sup.name name, CoordinateSystem, typ from Location";
        System.out.println ("Running: " + sql);
        res = stmt.executeQuery (sql);
        index = 0;
        while (res.next () && (index++ < 5))
            System.out.println (res.getString (1) + "\t" + res.getString (2) + "\t" + res.getString (3) + "\t" + res.getString (4) + "\t" + res.getString (5));
        res.close ();

        // select * query on Switch
//        sup struct<sup:struct<sup:struct<sup:struct<sup:element,aliasName:string,description:string,mRID:string,name:string>,AssetDatasheet:string,Location:string,PSRType:string>,aggregate:boolean,normallyInService:boolean,EquipmentContainer:string>,BaseVoltage:string,GroundingAction:string,JumpingAction:string,SvStatus:string>
//        normalOpen  boolean
//        open    boolean
//        ratedCurrent    double
//        retained    boolean
//        switchOnCount   int
//        CompositeSwitch string
//        Outage  string
//        SwitchAction    string
        sql = "select * from Switch";
        System.out.println ("Running: " + sql);
        res = stmt.executeQuery (sql);
        index = 0;
        while (res.next () && (index++ < 5))
            System.out.println (res.getString (1) + "\t" + res.getBoolean (2) + "\t" +  res.getBoolean (3) + "\t" + res.getDouble (4) + "\t" + res.getBoolean (5) + "\t" + res.getInt (6) + "\t" + res.getString (7) + "\t" + res.getString (8) + "\t" + res.getString (9));
        res.close ();

        // join query on Switch
        sql = "select s.sup.sup.sup.sup.mRID mRID, s.sup.sup.sup.sup.aliasName aliasName, s.sup.sup.sup.sup.name name, s.sup.sup.sup.sup.description description, open, normalOpen no, l.CoordinateSystem cs, p.xPosition, p.yPosition from Switch s, Location l, PositionPoint p where s.sup.sup.sup.Location = l.sup.mRID and s.sup.sup.sup.Location = p.Location and p.sequenceNumber = 0";
        System.out.println ("Running: " + sql);
        res = stmt.executeQuery (sql);
        index = 0;
        while (res.next () && (index++ < 5))
            System.out.println (res.getString (1) + "\t" + res.getString (2) + "\t" + res.getString (3) + "\t" + res.getString (4) + "\t" + res.getBoolean (5)+ "\t" + res.getString (6) + "\t" + res.getString (7) + "\t" + res.getString (8));
        res.close ();

//        // query a many-to-many relationship
//        // note use a doctored RDF to have one of these many-to-many relationships
//        sql = "select PowerSystemResources from Asset";
//        res = stmt.executeQuery (sql);
//        while (res.next ())
//        {
//            Array a = res.getArray (1); // SQLException: "Method not supported"
//            if (!res.wasNull ())
//            {
//                Object obj = a.getArray ();
//                String[] strings = (String[])obj;
//                for (int i = 0; i < strings.length; i++)
//                    System.out.println ("PowerSystemResource " + i + " = " + strings[i]);
//            }
//        }
//        res.close ();

        System.out.println ("done");
        con.close ();
    }
}