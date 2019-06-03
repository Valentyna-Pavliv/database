package sample;

import dnl.utils.text.table.TextTable;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.*;


public class Main extends Application {

    public String fill(int length, String with) {
        StringBuilder sb = new StringBuilder(length);
        while (sb.length() < length) {
            sb.append(with);
        }
        return sb.toString();
    }

    public String pad(int builder_length, int length) {
        return pad(builder_length, length, " ");
    }

    public String pad(int builder_length, int length, String with) {
        StringBuilder result = new StringBuilder(length);
        result.append(fill(length - builder_length, with));

        return result.toString();
    }

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
                String[][] data = null;
                if (table_selection_search.getValue() == null || search_bar.getText().isBlank()) {
                    builder.append("Please select a table or fill the search bar !");
                }
                else {
                    try {
                        Class.forName("org.postgresql.Driver");
                        c = DriverManager
                                .getConnection("jdbc:postgresql://localhost:5432/database2019",
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

                                data = new String[579][2];
                                while (rs.next()) {
                                    int user_id = rs.getInt("user_id");
                                    String verification_type = rs.getString("verification_type");
                                    String[] temp = {String.valueOf(user_id), verification_type};
                                    data[rs.getRow()-1] = temp;
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
                                        "                WHERE x.url LIKE ? OR x.id_user = ? OR x.since = ? OR x.about LIKE ? OR x.thumbnail_url LIKE ?;";
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
                            case "review_scores": {
                                String selectStatement = "SELECT *\n" +
                                        "                FROM review_scores x\n" +
                                        "                WHERE x.value LIKE ? OR x.id_listing = ? OR x.checking = ? OR x.rating LIKE ? OR x.location LIKE ?;";
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

//                            case "users": {
//                                String selectStatement = "SELECT *\n" +
//                                        "                FROM users x\n" +
//                                        "                WHERE x.user_name LIKE ? OR x.id_user = ?;";
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


//                    "users", "amenities", "has_amenites", "listings", "reviews", "booking_polices",
//                    "calendars", "locations", "houses", "property", "cancellation_policy", "room_type", "bed_type"
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

        // CONFIGURATION CHOICEBOX INSERT DELETE
        choicebox_insdel.configuration_choicebox_insdel(scene, table_name);

        // CONFIGURATION INSERT
        insert.configuration_insert(scene);

        // CONFIGURATION DELETE
        delete.configuration_deletion(scene);

        // CONFIGURATION PREDEFINED QUERIES
        queries1.configure_queries_1(scene);


        // CONFIGURATION PREDEFINED QUERIES 2
        queries2.configure_queries_2(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
