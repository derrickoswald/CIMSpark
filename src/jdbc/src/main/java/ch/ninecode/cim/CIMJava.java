package ch.ninecode.cim;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.DriverManager;

/**
 * Sample JDBC access to CIMServerJDBC.
 *
 * Build CIMReader:
 * cd CIMReader
 * mvn -DskipTests package
 *
 * Run the spark-docker container:
 * cd src/test/resource
 * docker-compose up&
 *
 * In another terminal session execute CIMServerJDBC:
 * /spark/spark-2.1.1-bin-hadoop2.7/bin/spark-submit --master spark://sandbox:7077 --driver-memory 1g --executor-memory 4g target/CIMServerJDBC-2.11-2.1.1-2.1.0-jar-with-dependencies.jar "hdfs://sandbox:8020/data/some_CIM_data.rdf"
 *
 * In another terminal session build and execute the CIMJava jar:
 * cd src/jdbc
 * mvn package
 * java -jar target/CIMJava-0.0.1-SNAPSHOT-jar-with-dependencies.jar
 *
 * @implNote The above instructions run the CIMServerJDBC externally from the cluster,
 * I didn't have any success running the CIMServerJDBC on the spark master.
 * Running as root (or as derrick, see the USER environment usage in the code) there is an issue with how
 * credentials get passed from the client across to the cluster.
 * Connection succeeds for user derrick, but then executing a "select" query yields:
 * Exception “Caused by: org.apache.hadoop.ipc.RemoteException(org.apache.hadoop.security.authorize.AuthorizationException): User: derrick is not allowed to impersonate derrick”
 */
public class CIMJava
{
    private static String driverName = "org.apache.hive.jdbc.HiveDriver";
    private static String port = "10004";
    private static String database = "default";
    private static String host = "localhost";
    private static String user = "hive"; // replace "hive" here with the name of the user the queries should run as

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
        String url = "jdbc:hive2://" + host + ":" + port + "/" + database + ";AuthMech=0;transportMode=binary;"; // https://issues.apache.org/jira/browse/HIVE-6852
        // using the docker-compose "sandbox.yaml",
        // the value in the "USER" environment sets the "HADOOP_USER_NAME" (Spark owner/operator) on the spark_master node,
        // so we use the same value if available:
        String username = System.getenv ("USER");
        if (null == username)
            username = user;
        Connection con = DriverManager.getConnection (url, username, "");
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
            String name = res.getString (2);
            names.add (name);
        }
        res.close ();

        String[] ordered = new String[names.size ()];
        names.toArray (ordered);
        Arrays.sort (ordered);
        for (String name: ordered)
            System.out.println ("    " + name);

        System.out.println ();
        if (0 != names.size ())
        {
            // describe table
            System.out.println ("Running: describe <table>");
            for (String name: ordered)
            {
                System.out.println ("    " + name);
                sql = "describe " + name;
                res = stmt.executeQuery (sql);
                while (res.next ())
                    System.out.println ("        " + res.getString (1) + "\t" + res.getString (2));
                res.close ();
            }

            if (names.contains ("edges"))
            {
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
            }

            if (names.contains ("positionpoint"))
            {
                // select * query on PositionPoint
                sql = "select * from PositionPoint limit 5";
                System.out.println ("Running: " + sql);
                res = stmt.executeQuery (sql);
                while (res.next ())
                    System.out.println (res.getString (1) + "\t" + res.getInt (2) + "\t" + res.getString (3) + "\t" + res.getString (4) + "\t" + res.getString (5)+ "\t" + res.getString (6));
                res.close ();
            }

            if (names.contains ("location"))
            {
                // explicit query on Location
                // sup struct<sup:element,aliasName:string,description:string,mRID:string,name:string>
                // direction   string
                // geoInfoReference    string
                // type string
                // CoordinateSystem    string
                // electronicAddress   string
                // mainAddress string
                // phone1  string
                // phone2  string
                // secondaryAddress    string
                // status  string
                sql = "select IdentifiedObject.aliasName, IdentifiedObject.description, IdentifiedObject.mRID, IdentifiedObject.name, direction, geoInfoReference, type, CoordinateSystem, electronicAddress, mainAddress, phone1, phone2, secondaryAddress, status from Location limit 5";
                System.out.println ("Running: " + sql);
                res = stmt.executeQuery (sql);
                while (res.next ())
                    System.out.println (res.getString (1) + "\t" + res.getString (2) + "\t" + res.getString (3) + "\t" + res.getString (4) + "\t" + res.getString (5) + "\t" + res.getString (6) + "\t" + res.getString (7) + "\t" + res.getString (8) + "\t" + res.getString (9) + "\t" + res.getString (10) + "\t" + res.getString (11) + "\t" + res.getString (12) + "\t" + res.getString (13) + "\t" + res.getString (14));
                res.close ();
            }

            // java.lang.RuntimeException: scala.MatchError: ([null,],org.apache.spark.sql.types.ElementUDT@89856685) (of class scala.Tuple2)
            if (names.contains ("switch"))
            {
                // select * query on Switch
                sql = "select * from Switch limit 5";
                System.out.println ("Running: " + sql);
                res = stmt.executeQuery (sql);
                while (res.next ())
                    System.out.println (/*res.getString (1) + "\t" + */ res.getBoolean ("normalOpen") + "\t" + res.getBoolean ("open") + "\t" + res.getDouble ("ratedCurrent") + "\t" + res.getBoolean ("retained")+ "\t" + res.getInt ("switchOnCount"));
                res.close ();
            }

            if (names.contains ("switch") && names.contains ("location") && names.contains ("positionpoint"))
            {
                // join query on Switch
                sql = "select s.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.mRID mRID, s.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.aliasName aliasName, s.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.name name, s.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.description description, open, normalOpen no, l.CoordinateSystem cs, p.xPosition, p.yPosition from Switch s, Location l, PositionPoint p where s.ConductingEquipment.Equipment.PowerSystemResource.Location = l.IdentifiedObject.mRID and s.ConductingEquipment.Equipment.PowerSystemResource.Location = p.Location and p.sequenceNumber = 0 limit 5";
                System.out.println ("Running: " + sql);
                res = stmt.executeQuery (sql);
                while (res.next ())
                    System.out.println (res.getString (1) + "\t" + res.getString (2) + "\t" + res.getString (3) + "\t" + res.getString (4) + "\t" + res.getBoolean (5)+ "\t" + res.getBoolean (6) + "\t" + res.getString (7) + "\t" + res.getString (8) + "\t" + res.getString (9));
                res.close ();
            }
        }
        else
            System.out.println ("no tables found");

        System.out.println ("done");
        con.close ();
    }
}