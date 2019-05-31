package sample;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.sql.*;
import java.util.Properties;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // WINDOW CREATION
        Parent root = FXMLLoader.load(getClass().getResource("interface.fxml"));
        Scene scene = new Scene(root, 1024, 800);
        primaryStage.setScene(scene);
        primaryStage.show();

        // GLOBAL
        ObservableList table_name = FXCollections.observableArrayList("has_verifications", "verifications",
                "response_time", "hosts", "review_scores", "users", "amenities", "has_amenites", "listings", "reviews", "booking_polices",
                "calendars", "locations", "houses", "property", "cancellation_policy", "room_type", "bed_type");


        // CONFIGURATION INSERTION DELETION
        ChoiceBox choicebox_insdel = (ChoiceBox) scene.lookup("#choicebox_insdel");
        Button insert_button_insdel = (Button) scene.lookup("#insert_button_insdel");
        Button delete_button_insdel = (Button) scene.lookup("#delete_button_insdel");
        Text text1_insdel = (Text) scene.lookup("#text1_insdel");
        Text text2_insdel = (Text) scene.lookup("#text2_insdel");
        Text text3_insdel = (Text) scene.lookup("#text3_insdel");
        Text text4_insdel = (Text) scene.lookup("#text4_insdel");
        Text text5_insdel = (Text) scene.lookup("#text5_insdel");
        Text text6_insdel = (Text) scene.lookup("#text6_insdel");
        Text text7_insdel = (Text) scene.lookup("#text7_insdel");
        Text text8_insdel = (Text) scene.lookup("#text8_insdel");
        Text text9_insdel = (Text) scene.lookup("#text9_insdel");
        Text text10_insdel = (Text) scene.lookup("#text10_insdel");
        TextField input1_insdel = (TextField) scene.lookup("#input1_insdel");
        TextField input2_insdel = (TextField) scene.lookup("#input2_insdel");
        TextField input3_insdel = (TextField) scene.lookup("#input3_insdel");
        TextField input4_insdel = (TextField) scene.lookup("#input4_insdel");
        TextField input5_insdel = (TextField) scene.lookup("#input5_insdel");
        TextField input6_insdel = (TextField) scene.lookup("#input6_insdel");
        TextField input7_insdel = (TextField) scene.lookup("#input7_insdel");
        TextField input8_insdel = (TextField) scene.lookup("#input8_insdel");
        TextField input9_insdel = (TextField) scene.lookup("#input9_insdel");
        TextField input10_insdel = (TextField) scene.lookup("#input10_insdel");

        // Selection box
        choicebox_insdel.setItems(table_name);
        choicebox_insdel.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                switch (choicebox_insdel.getSelectionModel().getSelectedItem().toString()){
                    case "has_verifications" :  {
                        text1_insdel.setText("verification type :");
                        text2_insdel.setText("user id :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        break;
                    }
                    case "verifications" :  {
                        text1_insdel.setText("verification type :");
                        text2_insdel.setText("user id :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        break;
                    }
                    case "response_time" :  {
                        text1_insdel.setText("verification type :");
                        text2_insdel.setText("user id :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        break;
                    }
                    case "hosts" :  {
                        text1_insdel.setText("verification type :");
                        text2_insdel.setText("user id :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        break;
                    }
                    case "review_scores" :  {
                        text1_insdel.setText("verification type :");
                        text2_insdel.setText("user id :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        break;
                    }
                    case "users" :  {
                        text1_insdel.setText("verification type :");
                        text2_insdel.setText("user id :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        break;
                    }
                    case "amenities" :  {
                        text1_insdel.setText("verification type :");
                        text2_insdel.setText("user id :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        break;
                    }
                    case "has_amenites" :  {
                        text1_insdel.setText("verification type :");
                        text2_insdel.setText("user id :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        break;
                    }
                    case "listings" :  {
                        text1_insdel.setText("verification type :");
                        text2_insdel.setText("user id :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        break;
                    }
                    case "reviews" :  {
                        text1_insdel.setText("verification type :");
                        text2_insdel.setText("user id :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        break;
                    }
                    case "booking_polices" :  {
                        text1_insdel.setText("verification type :");
                        text2_insdel.setText("user id :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        break;
                    }
                    case "calendars" :  {
                        text1_insdel.setText("verification type :");
                        text2_insdel.setText("user id :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        break;
                    }
                    case "locations" :  {
                        text1_insdel.setText("verification type :");
                        text2_insdel.setText("user id :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        break;
                    }
                    case "houses" :  {
                        text1_insdel.setText("verification type :");
                        text2_insdel.setText("user id :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        break;
                    }
                    case "property" :  {
                        text1_insdel.setText("verification type :");
                        text2_insdel.setText("user id :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        break;
                    }
                    case "room_type" :  {
                        text1_insdel.setText("verification type :");
                        text2_insdel.setText("user id :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        break;
                    }
                    case "bed_type" :  {
                        text1_insdel.setText("verification type :");
                        text2_insdel.setText("user id :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        break;
                    }
                }
            }
        });


        // CONFIGURATION SEARCH
        Text result_search_queries = (Text) scene.lookup("#result_search_queries");
        Button search_button = (Button) scene.lookup("#search_button");
        ChoiceBox table_selection_search = (ChoiceBox) scene.lookup("#table_selection_search");
        TextField search_bar = (TextField) scene.lookup("#search_bar");

        // Selection table
        table_selection_search.setItems(table_name);

        // Search button
        search_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                PreparedStatement stmt = null;
                if (table_selection_search.getValue() == null || search_bar.getText().isBlank()) {
                    builder.append("Please select a table or fill the search bar !");
                }
                else {
                    try {
                        Class.forName("org.postgresql.Driver");
                        c = DriverManager
                                .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                        "postgres", "database2019");

                        c.setAutoCommit(false);

                        ResultSet rs = null;
                        switch ((String) table_selection_search.getValue()) {
                            case "has_verifications": {
                                String selectStatement = "SELECT *\n" +
                                        "                FROM has_verifications x\n" +
                                        "                WHERE x.verification_type LIKE ? OR x.user_id = ?;";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(1, '%'+search_bar.getText()+'%');
                                int foo;
                                try {
                                    foo = Integer.parseInt(search_bar.getText());
                                }
                                catch (NumberFormatException e)
                                {
                                    foo = 0;
                                }
                                stmt.setObject(2, foo);

                                stmt.execute();
                                rs = stmt.getResultSet();
                                builder.append("Result :");
                                builder.append(System.lineSeparator());
                                while (rs.next()) {
                                    String verification_type = rs.getString("verification_type");
                                    int user_id = rs.getInt("user_id");
                                    builder.append("Verification type : " + verification_type + ", User id : " + user_id);
                                    builder.append(System.lineSeparator());
                                }
                                break;
                            }

                            case "verifications": {
                                String selectStatement = "SELECT *\n" +
                                        "                FROM verifications x\n" +
                                        "                WHERE x.verification_type LIKE ?;";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(1, '%'+search_bar.getText()+'%');

                                stmt.execute();
                                rs = stmt.getResultSet();
                                builder.append("Result :");
                                builder.append(System.lineSeparator());
                                while (rs.next()) {
                                    String verification_type = rs.getString("verification_type");
                                    builder.append("Verification type : " + verification_type);
                                    builder.append(System.lineSeparator());
                                }
                                break;
                            }

                            case "response_time": {
                                String selectStatement = "SELECT *\n" +
                                        "                FROM response_time x\n" +
                                        "                WHERE x.response_time LIKE ? OR x.host_id = ?;";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(1, '%'+search_bar.getText()+'%');
                                int foo;
                                try {
                                    foo = Integer.parseInt(search_bar.getText());
                                }
                                catch (NumberFormatException e)
                                {
                                    foo = 0;
                                }
                                stmt.setObject(2, foo);

                                stmt.execute();
                                rs = stmt.getResultSet();
                                builder.append("Result :");
                                builder.append(System.lineSeparator());
                                while (rs.next()) {
                                    String response_time = rs.getString("response_time");
                                    int host_id = rs.getInt("host_id");
                                    builder.append("Response time : " + response_time + ", Host id : " + host_id);
                                    builder.append(System.lineSeparator());
                                }
                                break;
                            }

                            case "hosts": {
                                String selectStatement = "SELECT *\n" +
                                        "                FROM hosts x\n" +
                                        "                WHERE x.url LIKE ? OR x.id_user = ? OR x.since = ? OR x.about LIKE ? OR x.thumbnail_url LIKE ? LIMIT 50;";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(1, '%'+search_bar.getText()+'%');
                                int foo;
                                try {
                                    foo = Integer.parseInt(search_bar.getText());
                                }
                                catch (NumberFormatException e)
                                {
                                    foo = 0;
                                }
                                stmt.setObject(2, foo);
                                Date date = null;
                                try {
                                    date = (Date) Date.valueOf(search_bar.getText());
                                }
                                catch (Exception e){
                                    date = new Date(System.currentTimeMillis());
                                }
                                stmt.setDate(3, date);
                                stmt.setObject(4, '%'+search_bar.getText()+'%');
                                stmt.setObject(5, '%'+search_bar.getText()+'%');

                                stmt.execute();
                                rs = stmt.getResultSet();
                                builder.append("Result :");
                                builder.append(System.lineSeparator());
                                int counter = 1;
                                while (rs.next()) {
                                    builder.append("Entry " + counter + " : ");
                                    builder.append(System.lineSeparator());
                                    String url = rs.getString("url");
                                    int id_user = rs.getInt("id_user");
                                    String since = rs.getString("since");
                                    String about = rs.getString("about");
                                    String thumbnail_url = rs.getString("thumbnail_url");
                                    builder.append("Url : " + url);
                                    builder.append(System.lineSeparator());
                                    builder.append("User id : " + id_user);
                                    builder.append(System.lineSeparator());
                                    builder.append("Since : " + since);
                                    builder.append(System.lineSeparator());
                                    builder.append("About : " + about);
                                    builder.append(System.lineSeparator());
                                    builder.append("Thumbnail_url : " + thumbnail_url);
                                    builder.append(System.lineSeparator());
                                    counter++;
                                }
                                break;
                            }
                            // TODO: finsih search
//                            case "review_scores": {
//                                String selectStatement = "SELECT *\n" +
//                                        "                FROM hosts x\n" +
//                                        "                WHERE x.url LIKE ? OR x.id_user = ? OR x.since = ? OR x.about LIKE ? OR x.thumbnail_url LIKE ? LIMIT 50;";
//                                stmt = c.prepareStatement(selectStatement);
//                                stmt.setObject(1, '%'+search_bar.getText()+'%');
//                                int foo;
//                                try {
//                                    foo = Integer.parseInt(search_bar.getText());
//                                }
//                                catch (NumberFormatException e)
//                                {
//                                    foo = 0;
//                                }
//                                stmt.setObject(2, foo);
//                                Date date = null;
//                                try {
//                                    date = (Date) Date.valueOf(search_bar.getText());
//                                }
//                                catch (Exception e){
//                                    date = new Date(System.currentTimeMillis());
//                                }
//                                stmt.setDate(3, date);
//                                stmt.setObject(4, '%'+search_bar.getText()+'%');
//                                stmt.setObject(5, '%'+search_bar.getText()+'%');
//
//                                stmt.execute();
//                                rs = stmt.getResultSet();
//                                builder.append("Result :");
//                                builder.append(System.lineSeparator());
//                                int counter = 1;
//                                while (rs.next()) {
//                                    builder.append("Entry " + counter + " : ");
//                                    builder.append(System.lineSeparator());
//                                    String url = rs.getString("url");
//                                    int id_user = rs.getInt("id_user");
//                                    String since = rs.getString("since");
//                                    String about = rs.getString("about");
//                                    String thumbnail_url = rs.getString("thumbnail_url");
//                                    builder.append("Url : " + url);
//                                    builder.append(System.lineSeparator());
//                                    builder.append("User id : " + id_user);
//                                    builder.append(System.lineSeparator());
//                                    builder.append("Since : " + since);
//                                    builder.append(System.lineSeparator());
//                                    builder.append("About : " + about);
//                                    builder.append(System.lineSeparator());
//                                    builder.append("Thumbnail_url : " + thumbnail_url);
//                                    builder.append(System.lineSeparator());
//                                    counter++;
//                                }
//                                break;
//                            }
                        }
                        rs.close();
                        stmt.close();
                        c.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                        System.exit(0);
                    }
                }
                String string = builder.toString();
                result_search_queries.setText(string);
            }
        });


        // CONFIGURATION PREDEFINED QUERIES
        Text result_predefined_queries = (Text) scene.lookup("#result_predefined_queries");

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
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT AVG(c.price)\n" +
                            "FROM calendars c, houses h\n" +
                            "WHERE h.bedrooms >= 8 AND c.id_listing = h.id_listing LIMIT 50;" );
                    while ( rs.next() ) {
                        int avgPrice = rs.getInt(1);
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
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT AVG(rs.rating)\n" +
                            "FROM review_scores rs, amenities a, has_amenities ra\n" +
                            "WHERE (a.amenity_type LIKE '%TV%'\n" +
                            "        OR a.amenity_type LIKE '%Television%')\n" +
                            "        AND rs.id_listing =ra.id_listing AND a.amenity_type = ra.amenity_type LIMIT 50;" );
                    while ( rs.next() ) {
                        int avg_price = rs.getInt(1);
                        builder.append( "Average rating : " + avg_price);
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
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT DISTINCT u.user_name , u.id_user\n" +
                            " FROM calendars c, listings l , users u\n" +
                            " WHERE c.calendar_date >= '2019-03-01' AND c.calendar_date < '2019-10-01' AND c.available LIKE '%t%'\n" +
                            " AND l.id_listing = c.id_listing AND l.host_id = u.id_user LIMIT 50;" );
                    while ( rs.next() ) {
                        String user_name = rs.getString("user_name");
                        int id_user = rs.getInt("id_user");
                        builder.append( "User name : " + user_name + " : Id user" + id_user);
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

        query4.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT COUNT(l1.host_id)\n" +
                            " FROM users u1, users u2, listings l1, listings l2\n" +
                            " WHERE l1.host_id != l2.host_id AND u1.user_name = u2.user_name AND l1.host_id = u1.id_user AND u2.id_user = l2.host_id LIMIT 50;" );
                    while ( rs.next() ) {
                        int count = rs.getInt(1);
                        builder.append( "Host count : " + count);
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

        // FIXME: buggy query
        query5.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT c.calendar_date\n" +
                            "FROM calendars c, hosts h, users u\n" +
                            "WHERE u.user_name LIKE '%Viajes Eco%'\n" +
                            "    AND u.id_listing = h.id_listing\n" +
                            "    AND h.id_listing = c.id_listing\n" +
                            "    AND c.available = 't' LIMIT 50;" );
                    builder.append( "Available date: ");
                    while ( rs.next() ) {
                        Date date = rs.getDate("calendar_date");
                        builder.append( date);
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

        query6.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT u.id_user, u.user_name\n" +
                            "FROM users u,\n" +
                            "     (SELECT l.host_id as id\n" +
                            "FROM listings l\n" +
                            "GROUP BY l.host_id\n" +
                            "HAVING COUNT(*) = 1)h\n" +
                            "WHERE u.id_user = h.id LIMIT 50;" );
                    while ( rs.next() ) {
                        int id_user = rs.getInt("id_user");
                        String user_name = rs.getString("user_name");
                        builder.append( "User name : " + user_name + " : Id user : " + id_user);
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

        query7.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT withWifi.avgWithWifi - withoutWifi.avgWithoutWifi\n" +
                            "FROM (SELECT AVG(c.price) AS avgWithWifi\n" +
                            "        FROM calendars c, amenities a, has_amenities ha\n" +
                            "        WHERE (a.amenity_type LIKE '%Wifi%'\n" +
                            "            OR a.amenity_type LIKE '%WIFI%')\n" +
                            "            AND ha.amenity_type = a.amenity_type AND ha.id_listing = c.id_listing) withWifi ,\n" +
                            "     (SELECT AVG(c.price) avgWithoutWifi\n" +
                            "        FROM calendars c, amenities a, has_amenities ha\n" +
                            "        WHERE (NOT a.amenity_type LIKE '%Wifi%'\n" +
                            "            AND NOT a.amenity_type LIKE '%WIFI%')\n" +
                            "            AND ha.amenity_type = a.amenity_type AND ha.id_listing = c.id_listing) withoutWifi LIMIT 50;" );
                    while ( rs.next() ) {
                        int avg_price = rs.getInt(1);
                        builder.append( "Average wifi price : " + avg_price);
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
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "\n" +
                            "SELECT madridPricing.avgMadrid - berlinPricing.avgBerlin\n" +
                            "FROM (SELECT AVG(c.price) AS  avgMadrid\n" +
                            "      FROM calendars c,\n" +
                            "           houses h,\n" +
                            "           locations l\n" +
                            "      WHERE h.beds = 8\n" +
                            "        AND l.city LIKE '%Madrid%'\n" +
                            "        AND l.id_listing = h.id_listing\n" +
                            "        AND c.id_listing = h.id_listing\n" +
                            "    )madridPricing ,\n" +
                            "     (SELECT AVG(c.price) AS avgBerlin\n" +
                            "      FROM calendars c,\n" +
                            "           houses h,\n" +
                            "           locations l\n" +
                            "      WHERE h.beds = 8\n" +
                            "        AND l.city LIKE '%Berlin%'\n" +
                            "        AND l.id_listing = h.id_listing\n" +
                            "        AND c.id_listing = h.id_listing\n" +
                            "    )berlinPricing LIMIT 50;" );
                    while ( rs.next() ) {
                        int avg_price = rs.getInt(1);
                        builder.append( "Average pricing : " + avg_price);
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

        // FIXME: buggy query
        query9.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT u.id_user, u.user_name\n" +
                            "  FROM users u,\n" +
                            "       (SELECT l.host_id as id\n" +
                            "  FROM listings l\n" +
                            "  GROUP BY l.host_id\n" +
                            "  HAVING COUNT(*) = 1\n" +
                            "  )h\n" +
                            "  WHERE u.id_user = h.id;\n" +
                            "\n" +
                            "  SELECT(u.id_user, u.name)\n" +
                            "  FROM users u\n" +
                            "       INNER JOIN (SELECT id_user, count(id_user) as cnt\n" +
                            "                       FROM hosts\n" +
                            "                      GROUP BY id_user) cou ON u.id_user = cou.id_user\n" +
                            "                      ORDER BY cnt DESC\n" +
                            "                      LIMIT 10;" );
                    while ( rs.next() ) {
                        int id_user = rs.getInt("id_user");
                        String user_name = rs.getString("user_name");
                        builder.append( "User name : " + user_name + " : Id user : " + id_user);
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
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT u.id_user, u.user_name\n" +
                            "  FROM users u,\n" +
                            "       (SELECT l.host_id as id\n" +
                            "  FROM listings l\n" +
                            "  GROUP BY l.host_id\n" +
                            "  HAVING COUNT(*) = 1\n" +
                            "  )h\n" +
                            "  WHERE u.id_user = h.id;\n" +
                            "\n" +
                            "  SELECT(u.id_user, u.name)\n" +
                            "  FROM users u\n" +
                            "       INNER JOIN (SELECT id_user, count(id_user) as cnt\n" +
                            "                       FROM hosts\n" +
                            "                      GROUP BY id_user) cou ON u.id_user = cou.id_user\n" +
                            "                      ORDER BY cnt DESC\n" +
                            "                      LIMIT 10;" );
                    while ( rs.next() ) {
                        int id_user = rs.getInt("id_user");
                        String user_name = rs.getString("user_name");
                        builder.append( "User name : " + user_name + " : Id user : " + id_user);
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

        // FIXME: buggy query
        query10.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                StringBuilder builder = new StringBuilder();
                Connection c = null;
                Statement stmt = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                    "postgres", "database2019");

                    c.setAutoCommit(false);

                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( " SELECT (l.id_listing, l.name_listing)\n" +
                            "  FROM listings l\n" +
                            "       RIGHT JOIN (SELECT id_listing FROM review_scores rs) s ON l.id_listing = s.id_listing\n" +
                            "          INNER JOIN (SELECT id_listing, count(id_listing) as cnt\n" +
                            "                      FROM review_scores rs\n" +
                            "                      GROUP BY id_listing) cou ON l.id_listing = cou.id_listing\n" +
                            "                      ORDER BY cnt DESC\n" +
                            "                      LIMIT 10;" );
                    while ( rs.next() ) {
                        int id_listing = rs.getInt("id_listing");
                        String name_listing = rs.getString("name_listing");
                        builder.append( "User name : " + name_listing + " : Id user : " + id_listing);
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
    }

    public static void main(String[] args) {
        launch(args);
    }
}
