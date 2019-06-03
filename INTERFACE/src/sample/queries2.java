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

public class queries2 {

    public static void configure_queries_2(Scene scene){
        TextArea result_predefined_queries_2 = (TextArea) scene.lookup("#result_predefined_queries_2");
        result_predefined_queries_2.setEditable(false);
        result_predefined_queries_2.setFont(Font.font(java.awt.Font.MONOSPACED, 16));
        Text description_query_set_2 = (Text) scene.lookup("#description_query_set_2");

        Button query21 = (Button) scene.lookup("#query21");
        Button query22 = (Button) scene.lookup("#query22");
        Button query23 = (Button) scene.lookup("#query23");
        Button query24 = (Button) scene.lookup("#query24");
        Button query25 = (Button) scene.lookup("#query25");
        Button query26 = (Button) scene.lookup("#query26");
        Button query27 = (Button) scene.lookup("#query27");
        Button query28 = (Button) scene.lookup("#query28");
        Button query29 = (Button) scene.lookup("#query29");
        Button query210 = (Button) scene.lookup("#query210");
        Button query211 = (Button) scene.lookup("#query211");
        Button query212 = (Button) scene.lookup("#query212");

        query21.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_2.setText("Print how many hosts in each city have declared the area of their property in square meters. Sort the output based on the city name in ascending order.");
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                String[][] data = new String[3][2];
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/database2019",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT l.city, count(*)\n" +
                            "FROM houses h, locations l\n" +
                            "WHERE h.square_feet is not null\n" +
                            "AND h.id_listing=l.id_listing\n" +
                            "group by l.city\n" +
                            "ORDER BY count(*) DESC;\n" );

                    while ( rs.next() ) {
                        String city = rs.getString("city");
                        int count = rs.getInt(2);
                        String[] temp = {city, String.valueOf(count)};
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
                String[] columnNames = {"City", "Count",};
                TextTable tt = new TextTable(columnNames, data);
                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try (PrintStream ps = new PrintStream(baos, true, "UTF-8")) {
                    tt.printTable(ps, 1);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                String result = new String(baos.toByteArray(), StandardCharsets.UTF_8);
                result_predefined_queries_2.setText(result);
            }
        });

        query22.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_2.setText("The quality of a neighborhood is defined based on the number of listings and the review score of these listings, one way for computing that is using the median of the review scores, as medians are more robust to outliers. Find the top-‐5 neighborhoods using median review scores of listings in Madrid.");
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                String[][] data = new String[5][2];
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/database2019",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT neighbourhood,AVG(rating) as median\n" +
                            "   FROM (SELECT rating, X.neighbourhood FROM\n" +
                            "  (SELECT h.neighbourhood, h.id_listing as id_listing, rating , count(rating) OVER (PARTITION BY neighbourhood) AS TotalRows,\n" +
                            "       row_number() OVER (PARTITION BY neighbourhood ORDER BY rating ASC) AS AmountOrder\n" +
                            "       FROM (houses h INNER JOIN review_scores rs ON rs.id_listing = h.id_listing)) X, locations l\n" +
                            "           WHERE X.AmountOrder  IN (floor((X.TotalRows+1)/2.0) , ceil((X.TotalRows+1)/2.0)) \n" +
                            "AND l.city = 'Madrid' AND l.id_listing = X.id_listing)X GROUP BY neighbourhood  ORDER BY median DESC LIMIT 5;\n" );
                    while ( rs.next() ) {
                        String neighbourhood = rs.getString("neighbourhood");
                        int median = rs.getInt(2);
                        String[] temp = {neighbourhood, String.valueOf(median)};
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
                String[] columnNames = {"Neighbourhood", "Quality",};
                TextTable tt = new TextTable(columnNames, data);
                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try (PrintStream ps = new PrintStream(baos, true, "UTF-8")) {
                    tt.printTable(ps, 1);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                String result = new String(baos.toByteArray(), StandardCharsets.UTF_8);
                result_predefined_queries_2.setText(result);
            }
        });

        query23.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_2.setText("Find all the hosts (host_ids, host_names) with the highest number of listings.");
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                String[][] data = new String[26658][2];
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/database2019",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT u.id_user, u.user_name " +
                            "FROM users u, " +
                            "(SELECT l.host_id \n" +
                            "FROM listings l \n" +
                            "GROUP BY l.host_id \n" +
                            "ORDER BY count(*) desc) h \n" +
                            "WHERE h.host_id = u.id_user; \n" );
                    builder.append( "Result : ");
                    builder.append(System.lineSeparator());
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
                String[] columnNames = {"User name", "Id user",};
                TextTable tt = new TextTable(columnNames, data);
                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try (PrintStream ps = new PrintStream(baos, true, "UTF-8")) {
                    tt.printTable(ps, 1);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                String result = new String(baos.toByteArray(), StandardCharsets.UTF_8);
                result_predefined_queries_2.setText(result);
            }
        });


        query24.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_2.setText("Find the 5 most cheapest Apartments (based on average price within the available dates) in Berlin available between 01-‐03-‐2019 and 30-‐04-‐2019 having at least 2 beds, a location review score of at least 8, flexible cancellation, and listed by a host with a verifiable government id.");
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                String[][] data = new String[5][3];
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/database2019",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "WITH interval AS (\n" +
                            "SELECT id_listing, AVG(price) avg_price, bool_and(available) available\n" +
                            "FROM calendars\n" +
                            "WHERE calendar_date BETWEEN '2019-03-01' AND '2019-04-30'  \n" +
                            "GROUP BY id_listing\n" +
                            ")\n" +
                            "SELECT distinct l.id_listing, l.name_listing, i.avg_price price\n" +
                            "FROM houses h\n" +
                            "LEFT JOIN locations loc ON loc.id_listing = h.id_listing\n" +
                            "LEFT JOIN review_scores rs ON rs.id_listing = h.id_listing\n" +
                            "LEFT JOIN cancellation_policy cp ON cp.id_listing = h.id_listing\n" +
                            "LEFT JOIN interval i ON i.id_listing = h.id_listing\n" +
                            "LEFT JOIN listings l ON l.id_listing = h.id_listing\n" +
                            "LEFT JOIN has_verifications v ON v.user_id = l.host_id\n" +
                            "WHERE\n" +
                            "h.beds>=2 AND\n" +
                            "loc.city ='Berlin' AND\n" +
                            "rs.location >= 8 AND\n" +
                            "cp.cancellation_policy ='flexible' AND\n" +
                            "i.available AND\n" +
                            "(verification_type in ('government_id', 'offline_government_id'))\n" +
                            "ORDER BY i.avg_price ASC LIMIT 5;\n" );
                    builder.append( "Result : ");
                    builder.append(System.lineSeparator());
                    while ( rs.next() ) {
                        int id_listing = rs.getInt("id_listing");
                        String name_listing = rs.getString("name_listing");
                        String price = rs.getString("price");
                        String[] temp = {name_listing, String.valueOf(id_listing), String.valueOf(price)};
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
                String[] columnNames = {"Listing name", "Listing id", "Price",};
                TextTable tt = new TextTable(columnNames, data);
                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try (PrintStream ps = new PrintStream(baos, true, "UTF-8")) {
                    tt.printTable(ps, 1);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                String result = new String(baos.toByteArray(), StandardCharsets.UTF_8);
                result_predefined_queries_2.setText(result);
            }
        });

        query25.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_2.setText("Each property can accommodate different number of people (1 to 16). Find the top‐5 rated (review_score_rating) listings for each distinct category based on number of accommodated guests with at least two of these facilities: Wifi, Internet, TV, and Free street parking.");
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                String[][] data = new String[16][2];
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/database2019",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT h.accommodates acc, (array_agg(id_rat.id_listing ORDER BY id_rat.rating desc))[:5] best_rated_listings\n" +
                            "FROM houses h\n" +
                            "INNER JOIN(--id_listing, rating from all listings that have  at least 2 amenities and not null rating\n" +
                            "SELECT id_rs.id_listing id_listing, id_rs.rating rating\n" +
                            "--id_listing which have at least 2 facilities\n" +
                            "FROM (SELECT b_a.id_listing id_listing\n" +
                            "FROM (SELECT h_a.id_listing id_listing, h_a.amenity_type a\n" +
                            "FROM has_amenities h_a\n" +
                            "WHERE h_a.amenity_type = 'Wifi' OR\n" +
                            "h_a.amenity_type = 'Internet' OR\n" +
                            "h_a.amenity_type = 'TV' OR\n" +
                            "h_a.amenity_type = 'Free street parking') b_a\n" +
                            "GROUP BY b_a.id_listing\n" +
                            "HAVING count(*)>=2) ids\n" +
                            "INNER JOIN (--là on a id, rating\n" +
                            "SELECT r_s.id_listing id_listing, r_s.rating rating\n" +
                            "FROM review_scores r_s\n" +
                            "WHERE r_s.rating is not null) id_rs \n" +
                            "ON ids.id_listing=id_rs.id_listing) id_rat\n" +
                            "ON h.id_listing=id_rat.id_listing\n" +
                            "GROUP BY h.accommodates\n" +
                            "ORDER BY h.accommodates asc;\n" );
                    builder.append( "Result : ");
                    builder.append(System.lineSeparator());
                    while ( rs.next() ) {
                        String acc = rs.getString("acc");
                        Array brl = rs.getArray("best_rated_listings");
                        String[] temp = {acc, brl.toString()};
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
                String[] columnNames = {"Accommodates", "Top‐5 rated listings",};
                TextTable tt = new TextTable(columnNames, data);
                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try (PrintStream ps = new PrintStream(baos, true, "UTF-8")) {
                    tt.printTable(ps, 1);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                String result = new String(baos.toByteArray(), StandardCharsets.UTF_8);
                result_predefined_queries_2.setText(result);
            }
        });

        query26.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_2.setText("What are top three busiest listings per host? The more reviews a listing has, the busier the listing is.");
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                String[][] data = new String[22610][2];
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/database2019",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT l.host_id host_id, (array_agg(id_nbrev.id_listing ORDER BY id_nbrev.c desc))[:3] busiest_listings\n" +
                            "FROM listings l\n" +
                            "INNER JOIN (SELECT r.id_listing id_listing, count(*) c\n" +
                            "         FROM reviews r\n" +
                            "                       GROUP BY r.id_listing) id_nbrev\n" +
                            "ON l.id_listing=id_nbrev.id_listing\n" +
                            "GROUP BY l.host_id;\n" );
                    builder.append( "Result : ");
                    builder.append(System.lineSeparator());
                    while ( rs.next() ) {
                        String host_id = rs.getString("host_id");
                        Array busiest_listings = rs.getArray("busiest_listings");
                        String[] temp = {host_id, busiest_listings.toString()};
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
                String[] columnNames = {"Host id", "Busiest listings",};
                TextTable tt = new TextTable(columnNames, data);
                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try (PrintStream ps = new PrintStream(baos, true, "UTF-8")) {
                    tt.printTable(ps, 1);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                String result = new String(baos.toByteArray(), StandardCharsets.UTF_8);
                result_predefined_queries_2.setText(result);
            }
        });

        query27.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_2.setText("What are the three most frequently used amenities at each neighborhood in Berlin for the listings with “Private Room” room type?");
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                String[][] data = new String[88][2];
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/database2019",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT gr_c.ng neighbourhood, ((array_agg(gr_c.a ORDER BY gr_c.c DESC))[:3])top_amenities                                     FROM (SELECT am_ng.neighbourhood ng, am_ng.amenity a, count(am_ng.amenity) c\n" +
                            "FROM (SELECT l.amenity_type amenity, h.neighbourhood neighbourhood\n" +
                            "FROM has_amenities l, locations loc, room_type r, houses h\n" +
                            "WHERE loc.city ='Berlin' AND loc.id_listing = l.id_listing AND                                                                                                                      r.room_type = 'Private room' AND r.id_listing =l.id_listing\n" +
                            "AND r.id_listing=h.id_listing) am_ng\n" +
                            "GROUP BY am_ng.neighbourhood, am_ng.amenity) gr_c\n" +
                            "GROUP BY gr_c.ng;\n" );
                    builder.append( "Result : ");
                    builder.append(System.lineSeparator());
                    while ( rs.next() ) {
                        String neighbourhood = rs.getString("neighbourhood");
                        Array top_amenities = rs.getArray("top_amenities");
                        String[] temp = {neighbourhood, top_amenities.toString()};
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
                String[] columnNames = {"Neighbourhood", "Top amenities",};
                TextTable tt = new TextTable(columnNames, data);
                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try (PrintStream ps = new PrintStream(baos, true, "UTF-8")) {
                    tt.printTable(ps, 1);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                String result = new String(baos.toByteArray(), StandardCharsets.UTF_8);
                result_predefined_queries_2.setText(result);
            }
        });

        query28.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_2.setText("What is the difference in the average communication review score of the host who has the most diverse way of verifications and of the host who has the least diverse way of verifications. In case of a multiple number of the most or the least diverse verifying hosts, pick a host one from the most and one from the least verifying hosts.");
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
                    ResultSet rs = stmt.executeQuery( "WITH user_cnt AS(\n" +
                            "SELECT user_id, COUNT(DISTINCT verification_type)as cnt, AVG(communication) average\n" +
                            "FROM listings l\n" +
                            "LEFT JOIN has_verifications h ON l.host_id=h.user_id\n" +
                            "RIGHT JOIN review_scores rs ON rs.communication IS NOT NULL AND rs.id_listing=l.id_listing\n" +
                            "GROUP BY user_id\n" +
                            "HAVING AVG(communication) IS NOT NULL\n" +
                            "),\n" +
                            "most AS(\n" +
                            "SELECT *\n" +
                            "FROM user_cnt\n" +
                            "ORDER BY cnt DESC LIMIT 1\n" +
                            "),\n" +
                            "smallest AS(\n" +
                            "SELECT *\n" +
                            "FROM user_cnt\n" +
                            "ORDER BY cnt ASC LIMIT 1\n" +
                            ")\n" +
                            "\n" +
                            "SELECT (most.average - smallest.average)difference\n" +
                            "from most, smallest\n" );
                    while ( rs.next() ) {
                        float avg_price = rs.getFloat(1);
                        builder.append( "Difference : " + avg_price);
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
                result_predefined_queries_2.setText(string);
            }
        });

        query29.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_2.setText("What is the city who has the highest number of reviews for the room types whose average number of accommodates are greater than 3.");
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
                    ResultSet rs = stmt.executeQuery( "SELECT c_s.city city\n" +
                            "FROM(SELECT c_nbr.city city, SUM(c_nbr.nb_reviews) s\n" +
                            "FROM (SELECT c_nbr_rt.city city, c_nbr_rt.nb_reviews nb_reviews\n" +
                            "FROM (SELECT l.city city, idl_nbr.nb_reviews nb_reviews, r.room_type room_type\n" +
                            "FROM locations l, room_type r, \n" +
                            "(SELECT r.id_listing id_listing, COUNT(r.id_review) nb_reviews\n" +
                            "FROM reviews r\n" +
                            "GROUP BY r.id_listing)idl_nbr\n" +
                            "WHERE idl_nbr.id_listing=l.id_listing AND l.id_listing=r.id_listing)c_nbr_rt, \n" +
                            "(SELECT rt_a.room_type room_type, AVG(rt_a.acc) av\n" +
                            "FROM (SELECT r.room_type room_type, h.accommodates acc\n" +
                            "FROM houses h, room_type r\n" +
                            "WHERE h.id_listing=r.id_listing) rt_a\n" +
                            "GROUP BY rt_a.room_type)rt_av\n" +
                            "WHERE c_nbr_rt.room_type=rt_av.room_type  and rt_av.av > 3)c_nbr\n" +
                            "GROUP BY c_nbr.city) c_s\n" +
                            "ORDER BY c_s.s DESC LIMIT 1;\n" );
                    while ( rs.next() ) {
                        String city = rs.getString("city");
                        builder.append( "City who has the highest number of reviews : " + city);
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
                result_predefined_queries_2.setText(string);
            }
        });

        query210.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_2.setText("Print all the neighbourhoods in Madrid which had at least 50 percent of their listings occupied in 2019 and their host has joined airbnb no later than 01.06.2017.");
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                String[][] data = new String[65][2];
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/database2019",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( " SELECT q.neighbourhood    \n" +
                            "  FROM (SELECT h.neighbourhood, (COUNT(CASE WHEN NOT c.available THEN 1 END)*100)/count(*) percentage   \n" +
                            "           FROM houses h  \n" +
                            "     INNER JOIN listings list ON list.id_listing = h.id_listing\n" +
                            "INNER JOIN (SELECT h.id_user AS id_user, h.since FROM hosts h WHERE since <='01.06.2017' ) hosts\n" +
                            " ON list.host_id = hosts.id_user  \n" +
                            " INNER JOIN (SELECT l.id_listing FROM locations l WHERE l.city = 'Madrid')l ON l.id_listing = h.id_listing   \n" +
                            "      INNER JOIN (SELECT ca.id_listing AS id_listing, bool_and(ca.available) AS available  \n" +
                            "                       FROM calendars ca  \n" +
                            "                       WHERE extract(year from ca.calendar_date)=2019 GROUP BY id_listing)c \n" +
                            "ON c.id_listing = h.id_listing  \n" +
                            "  GROUP BY h.neighbourhood)q  \n" +
                            "  WHERE q.percentage>=50;\n" );
                    builder.append( "Result : ");
                    builder.append(System.lineSeparator());
                    while ( rs.next() ) {
                        String neighbourhood = rs.getString("neighbourhood");
                        String[] temp = {neighbourhood};
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
                String[] columnNames = {"Neighbourhood"};
                TextTable tt = new TextTable(columnNames, data);
                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try (PrintStream ps = new PrintStream(baos, true, "UTF-8")) {
                    tt.printTable(ps, 1);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                String result = new String(baos.toByteArray(), StandardCharsets.UTF_8);
                result_predefined_queries_2.setText(result);
            }
        });

        query211.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_2.setText("Print all the countries that at least 20% of their listings were available in 2018.");
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                String[][] data = new String[2][2];
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/database2019",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( " SELECT c_p.country \n" +
                            "FROM (SELECT a_c.country country, (COUNT(CASE WHEN available THEN 1 END)*100)/count(*) percentage\n" +
                            "FROM (SELECT id_a.available available, l.country country\n" +
                            "FROM locations l, (SELECT c.id_listing id_listing, bool_or(c.available) available\n" +
                            "FROM (SELECT ca.id_listing id_listing, ca.available\n" +
                            "FROM calendars ca\n" +
                            "WHERE extract(year from ca.calendar_date)=2018)c\n" +
                            "GROUP BY c.id_listing)id_a\n" +
                            "WHERE l.id_listing = id_a.id_listing) a_c\n" +
                            "GROUP BY a_c.country)c_p\n" +
                            "WHERE c_p.percentage>=20;\n" );
                    builder.append( "Result : ");
                    builder.append(System.lineSeparator());
                    while ( rs.next() ) {
                        String country = rs.getString("country");
                        String[] temp = {country};
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
                String[] columnNames = {"Country"};
                TextTable tt = new TextTable(columnNames, data);
                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try (PrintStream ps = new PrintStream(baos, true, "UTF-8")) {
                    tt.printTable(ps, 1);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                String result = new String(baos.toByteArray(), StandardCharsets.UTF_8);
                result_predefined_queries_2.setText(result);
            }
        });

        query212.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_2.setText("Print all the neighborhoods in Barcelona where more than 5 percent of their accommodation cancelation policy is strict with grace period.");
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                String[][] data = new String[64][2];
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/database2019",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT q.neighbourhood  \n" +
                            "FROM( \n" +
                            "SELECT h.neighbourhood, (COUNT(CASE WHEN c. cancellation_policy = 'strict 14 with grace period' THEN 1    END)*100)/count(*) percentage  \n" +
                            "FROM houses h  \n" +
                            "     INNER JOIN (SELECT l.id_listing FROM locations l WHERE l.city = 'Barcelona')l ON l.id_listing = h.id_listing\n" +
                            "     INNER JOIN cancellation_policy c ON c.id_listing = h.id_listing\n" +
                            " GROUP BY h.neighbourhood)q\n" +
                            " WHERE q.percentage>=5 ;\n" );
                    builder.append( "Result : ");
                    builder.append(System.lineSeparator());
                    while ( rs.next() ) {
                        String neighbourhood = rs.getString("neighbourhood");
                        String[] temp = {neighbourhood};
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
                String[] columnNames = {"Neighbourhood"};
                TextTable tt = new TextTable(columnNames, data);
                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try (PrintStream ps = new PrintStream(baos, true, "UTF-8")) {
                    tt.printTable(ps, 1);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                String result = new String(baos.toByteArray(), StandardCharsets.UTF_8);
                result_predefined_queries_2.setText(result);
            }
        });
    }
}
