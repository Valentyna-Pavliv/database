package sample;

import dnl.utils.text.table.TextTable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class queries1 {
    public static void configure_queries_1(Scene scene) {
        TextArea result_predefined_queries = (TextArea) scene.lookup("#result_predefined_queries");
        result_predefined_queries.setEditable(false);
        result_predefined_queries.setFont(Font.font(java.awt.Font.MONOSPACED, 16));
        Text description_query_set_1 = (Text) scene.lookup("#description_query_set_1");

        Button query1 = (Button) scene.lookup("#query1");
        Button query2 = (Button) scene.lookup("#query2");
        Button query3 = (Button) scene.lookup("#query3");
        Button query4 = (Button) scene.lookup("#query4");
        Button query5 = (Button) scene.lookup("#query5");
        Button query6 = (Button) scene.lookup("#query6");
        Button query7 = (Button) scene.lookup("#query7");
        Button query8 = (Button) scene.lookup("#query8");
        Button query9 = (Button) scene.lookup("#query9");
        Button query10 = (Button) scene.lookup("#query10");

        query1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_1.setText("What is the average price for a listing with 8 bedrooms?");
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/database2019",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT AVG(c.price)\n" +
                            "FROM calendars c, houses h\n" +
                            "WHERE h.bedrooms = 8 AND c.id_listing = h.id_listing;\n" );
                    while ( rs.next() ) {
                        float avgPrice = rs.getFloat(1);
                        builder.append( "Average price : " + avgPrice);
                        builder.append(System.lineSeparator());
                    }
                    rs.close();
                    stmt.close();
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(e.getClass().getName()+": "+e.getMessage());
                    System.exit(0);
                }
                String string = builder.toString();
                result_predefined_queries.setText(string);
            }
        });

        query2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_1.setText("What is the average cleaning review score for listings with TV?");
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/database2019",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT AVG(rs.rating)\n" +
                            "FROM review_scores rs, has_amenities ra\n" +
                            "WHERE (ra.amenity_type = 'TV')\n" +
                            "AND rs.id_listing=ra.id_listing;\n" );
                    while ( rs.next() ) {
                        float avg_price = rs.getFloat(1);
                        builder.append( "Average cleaning review score : " + avg_price);
                        builder.append(System.lineSeparator());
                    }
                    rs.close();
                    stmt.close();
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(e.getClass().getName()+": "+e.getMessage());
                    System.exit(0);
                }
                String string = builder.toString();
                result_predefined_queries.setText(string);
            }
        });

        query3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_1.setText("Print all the hosts who have an available property between date 03.2019 and 09.2019.");
                Connection c = null;
                Statement stmt = null;
                String[][] data = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/database2019",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT DISTINCT u.user_name , u.id_user\n" +
                            "FROM listings l , users u,\n" +
                            "(SELECT c.id_listing, bool_and(c.available) a\n" +
                            "FROM calendars c\n" +
                            "WHERE c.calendar_date >= '2019-03-01' AND c.calendar_date < '2019-10-01'\n" +
                            "GROUP BY c.id_listing)cal\n" +
                            "WHERE cal.a AND l.id_listing = cal.id_listing AND l.host_id = u.id_user;\n" );
                    data = new String[4815][2];
                    while ( rs.next() ) {
                        String user_name = rs.getString("user_name");
                        int id_user = rs.getInt("id_user");
                        String[] temp = {user_name, String.valueOf(id_user)};
                        data[rs.getRow()-1] = temp;
                    }
                    rs.close();
                    stmt.close();
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(e.getClass().getName()+": "+e.getMessage());
                    System.exit(0);
                }
                String[] columnNames = {"User name", "User id",};
                TextTable tt = new TextTable(columnNames, data);
                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try (PrintStream ps = new PrintStream(baos, true, "UTF-8")) {
                    tt.printTable(ps, 1);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                String result = new String(baos.toByteArray(), StandardCharsets.UTF_8);
                result_predefined_queries.setText(result);
            }
        });

        query4.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_1.setText("Print how many listing items exist that are posted by two different hosts but the hosts have the same name.");
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/database2019",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT COUNT(l1.host_id)\n" +
                            " FROM users u1, users u2, listings l1, listings l2\n" +
                            " WHERE l1.host_id != l2.host_id\n" +
                            "      AND u1.user_name = u2.user_name\n" +
                            "      AND l1.host_id = u1.id_user\n" +
                            "      AND u2.id_user = l2.host_id;\n" );
                    while ( rs.next() ) {
                        int count = rs.getInt(1);
                        builder.append( "Number of listing items : " + count);
                        builder.append(System.lineSeparator());
                    }
                    rs.close();
                    stmt.close();
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(e.getClass().getName()+": "+e.getMessage());
                    System.exit(0);
                }
                String string = builder.toString();
                result_predefined_queries.setText(string);
            }
        });

        query5.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_1.setText("Print all the dates that 'Viajes Eco' has available accommodations for rent.");
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                String[][] data = new String[579][2];
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/database2019",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);
                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT c.calendar_date\n" +
                            "FROM calendars c, listings l, users u\n" +
                            "WHERE u.user_name ='Viajes Eco'\n" +
                            "    AND u.id_user = l.host_id\n" +
                            "    AND l.id_listing = c.id_listing  AND c.available;\n" );
                    while ( rs.next() ) {
                        Date date = rs.getDate("calendar_date");
                        String[] temp = {date.toString()};
                        data[rs.getRow()-1] = temp;
                    }
                    rs.close();
                    stmt.close();
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(e.getClass().getName()+": "+e.getMessage());
                    System.exit(0);
                }
                String[] columnNames = {"Availabe date",};
                TextTable tt = new TextTable(columnNames, data);
                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try (PrintStream ps = new PrintStream(baos, true, "UTF-8")) {
                    tt.printTable(ps, 1);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                String result = new String(baos.toByteArray(), StandardCharsets.UTF_8);
                result_predefined_queries.setText(result);
            }
        });

        query6.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_1.setText("Find all the hosts (host_ids, host_names) that have only one listing.");
                Connection c = null;
                Statement stmt = null;
                String[][] data = new String[21263][2];
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/database2019",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT u.id_user, u.user_name\n" +
                            "FROM users u,\n" +
                            "     (SELECT l.host_id as id\n" +
                            "FROM listings l\n" +
                            "GROUP BY l.host_id\n" +
                            "HAVING COUNT(*) = 1)h\n" +
                            "WHERE u.id_user = h.id;\n" );
                    while ( rs.next() ) {
                        String user_name = rs.getString("user_name");
                        int id_user = rs.getInt("id_user");
                        String[] temp = {user_name, String.valueOf(id_user)};
                        data[rs.getRow()-1] = temp;
                    }
                    rs.close();
                    stmt.close();
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(e.getClass().getName()+": "+e.getMessage());
                    System.exit(0);
                }
                String[] columnNames = {"User name", "User id",};
                TextTable tt = new TextTable(columnNames, data);
                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try (PrintStream ps = new PrintStream(baos, true, "UTF-8")) {
                    tt.printTable(ps, 1);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                String result = new String(baos.toByteArray(), StandardCharsets.UTF_8);
                result_predefined_queries.setText(result);
            }
        });

        query7.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_1.setText("What is the difference in the average price of listings with and without Wifi.");
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/database2019",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT withWifi.avgWithWifi - withoutWifi.avgWithoutWifi AS difference\n" +
                            "FROM (SELECT AVG(c.daily_price) AS avgWithWifi\n" +
                            "        FROM calendars c, amenities a, has_amenities ha\n" +
                            "        WHERE ha.amenity_type = 'Wifi' AND \n" +
                            "ha.id_listing = c.id_listing) withWifi ,\n" +
                            "(SELECT AVG(c.daily_price) AS avgWithoutWifi\n" +
                            "FROM (SELECT a.id_listing as id \n" +
                            "FROM (\n" +
                            "(SELECT ha.id_listing AS id, ha.amenity_type  \n" +
                            "FROM has_amenities ha   \n" +
                            "WHERE ha.amenity_type = 'Wifi' )a \n" +
                            "RIGHT JOIN listings l ON a.id = l.id_listing)a \n" +
                            "WHERE a.amenity_type IS NULL )lids, calendars c\n" +
                            "WHERE  lids.id = c.id_listing) withoutWifi;\n" );
                    while ( rs.next() ) {
                        float avg_price = rs.getFloat(1);
                        builder.append( "Difference in the average price : " + avg_price);
                        builder.append(System.lineSeparator());
                    }
                    rs.close();
                    stmt.close();
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(e.getClass().getName()+": "+e.getMessage());
                    System.exit(0);
                }
                String string = builder.toString();
                result_predefined_queries.setText(string);
            }
        });

        query8.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_1.setText("How much more (or less) costly to rent a room with 8 beds in Berlin compared to Madrid on average?");
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/database2019",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT madridPricing.avgMadrid - berlinPricing.avgBerlin AS difference\n" +
                            "FROM (SELECT AVG(c.price) AS  avgMadrid\n" +
                            "FROM calendars c, houses h, locations l\n" +
                            "WHERE h.beds = 8 AND \n" +
                            "l.city = 'Madrid' AND \n" +
                            "l.id_listing = h.id_listing AND c.id_listing = h.id_listing) madridPricing ,\n" +
                            "(SELECT AVG(c.price) AS avgBerlin\n" +
                            "FROM calendars c, houses h, locations l\n" +
                            "WHERE h.beds = 8 AND \n" +
                            "l.city LIKE '%Berlin%' AND \n" +
                            "l.id_listing = h.id_listing AND \n" +
                            "c.id_listing = h.id_listing) berlinPricing;\n" );
                    while ( rs.next() ) {
                        float avg_price = rs.getFloat(1);
                        builder.append( "Cost difference : " + avg_price);
                        builder.append(System.lineSeparator());
                    }
                    rs.close();
                    stmt.close();
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(e.getClass().getName()+": "+e.getMessage());
                    System.exit(0);
                }
                String string = builder.toString();
                result_predefined_queries.setText(string);
            }
        });

        query9.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_1.setText("Find the top-‐10 (in terms of the number of listings) hosts (host_ids, host_names) in Spain.");
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                String[][] data = new String[10][2];
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/database2019",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT u.id_user, u.user_name\n" +
                            "  FROM users u  INNER JOIN (SELECT h.id_user, count(h.id_user) as cnt\n" +
                            "                       FROM (SELECT h.id_user as id_user\n" +
                            "                             FROM listings lis, locations l ,hosts h\n" +
                            "                             WHERE l.country = 'Spain' AND\n" +
                            "                             l.id_listing = lis.id_listing AND\n" +
                            "                             h.id_user = lis.host_id ) h\n" +
                            "                          GROUP BY h.id_user) cou ON u.id_user = cou.id_user\n" +
                            "                      ORDER BY cnt DESC\n" +
                            "                      LIMIT 10;\n" );
                    while ( rs.next() ) {
                        int id_user = rs.getInt("id_user");
                        String user_name = rs.getString("user_name");
                        String[] temp = {user_name, String.valueOf(id_user)};
                        data[rs.getRow()-1] = temp;
                    }
                    rs.close();
                    stmt.close();
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(e.getClass().getName()+": "+e.getMessage());
                    System.exit(0);
                }
                String[] columnNames = {"User name", "User id",};
                TextTable tt = new TextTable(columnNames, data);
                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try (PrintStream ps = new PrintStream(baos, true, "UTF-8")) {
                    tt.printTable(ps, 1);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                String result = new String(baos.toByteArray(), StandardCharsets.UTF_8);
                result_predefined_queries.setText(result);
            }
        });

        query10.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_1.setText("Find the top-‐10 rated (review_score_rating) apartments (id,name) in Barcelona.");
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                String[][] data = new String[10][2];
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/database2019",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT lis.id_listing, lis.name_listing  \n" +
                            "FROM listings lis, locations l ,review_scores rs\n" +
                            "WHERE NOT rs.rating is null \n" +
                            "AND l.city =  'Barcelona'\n" +
                            "AND l.id_listing = lis.id_listing\n" +
                            "AND rs.id_listing = lis.id_listing\n" +
                            "ORDER BY rs.rating DESC LIMIT 10;\n" );
                    while ( rs.next() ) {
                        int id_listing = rs.getInt("id_listing");
                        String name_listing = rs.getString("name_listing");
                        String[] temp = {name_listing, String.valueOf(id_listing)};
                        data[rs.getRow()-1] = temp;
                    }
                    rs.close();
                    stmt.close();
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(e.getClass().getName()+": "+e.getMessage());
                    System.exit(0);
                }
                String[] columnNames = {"Listing name", "Listing id",};
                TextTable tt = new TextTable(columnNames, data);
                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try (PrintStream ps = new PrintStream(baos, true, "UTF-8")) {
                    tt.printTable(ps, 1);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                String result = new String(baos.toByteArray(), StandardCharsets.UTF_8);
                result_predefined_queries.setText(result);
            }
        });
    }
}
