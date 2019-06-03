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
import java.util.ArrayList;


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
                "response_time", "hosts", "review_scores", "users", "amenities", "has_amenities", "listings", "reviews", "booking_polices",
                "calendars", "locations", "houses", "property", "cancellation_policy", "room_type", "bed_type");

        // CONFIGURATION SEARCH
        TextArea result_search_queries = (TextArea) scene.lookup("#result_search_queries");
        result_search_queries.setEditable(false);
        result_search_queries.setFont(Font.font(java.awt.Font.MONOSPACED, 16));
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
                ArrayList<String[]> tempy = new ArrayList<>();
                String[] columnNames = null;
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

                                while (rs.next()) {
                                    int user_id = rs.getInt("user_id");
                                    String verification_type = rs.getString("verification_type");
                                    String[] temp = {String.valueOf(user_id), verification_type};
                                    tempy.add(temp);
                                }
                                columnNames = new String[]{"User id", "Verification type"};
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
                                    String[] temp = {verification_type};
                                    tempy.add(temp);
                                }
                                columnNames = new String[]{"Verification type"};
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
                                    String[] temp = {String.valueOf(host_id), response_time};
                                    tempy.add(temp);
                                }
                                columnNames = new String[]{"Host id", "Response time"};
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

                                while (rs.next()) {
                                    String url = rs.getString("url");
                                    int id_user = rs.getInt("id_user");
                                    String since = rs.getString("since");
                                    String about = rs.getString("about");
                                    String thumbnail_url = rs.getString("thumbnail_url");
                                    String[] temp = {String.valueOf(id_user), url, since, about, thumbnail_url};
                                    tempy.add(temp);
                                }
                                columnNames = new String[]{"Id_user", "Url", "Since", "About", "Thumbnailurl"};
                                break;
                            }

                            case "review_scores": {
                                String selectStatement = "SELECT * \n" +
                                        "                FROM review_scores x \n" +
                                        "                WHERE x.value = ? OR x.id_listing = ? OR x.checking = ? OR x.rating = ? OR x.location = ? \n" +
                                        "OR x.accuracy = ? OR x.communication = ? OR x.cleanliness = ?;";
                                stmt = c.prepareStatement(selectStatement);
                                int foo = 0;
                                try {
                                    foo = Integer.parseInt(search_bar.getText());
                                }
                                catch (NumberFormatException e)
                                {
                                    foo = 0;
                                }
                                stmt.setInt(1, (Integer) foo);
                                stmt.setInt(2, (Integer) foo);
                                stmt.setInt(3, (Integer) foo);
                                stmt.setInt(4, (Integer) foo);
                                stmt.setInt(5, (Integer) foo);
                                stmt.setInt(6, (Integer) foo);
                                stmt.setInt(7, (Integer) foo);
                                stmt.setInt(8, (Integer) foo);

                                stmt.execute();
                                rs = stmt.getResultSet();

                                while (rs.next()) {
                                    int value = rs.getInt("value");
                                    int id_listing = rs.getInt("id_listing");
                                    int checking = rs.getInt("checking");
                                    int rating = rs.getInt("rating");
                                    int location = rs.getInt("location");
                                    int accuracy = rs.getInt("accuracy");
                                    int communication = rs.getInt("communication");
                                    int cleanliness = rs.getInt("cleanliness");
                                    String[] temp = {String.valueOf(value), String.valueOf(id_listing), String.valueOf(checking), String.valueOf(rating),
                                            String.valueOf(location), String.valueOf(accuracy), String.valueOf(communication), String.valueOf(cleanliness)};
                                    tempy.add(temp);
                                }
                                columnNames = new String[]{"Listing id", "Value", "Checking", "Rating", "Location", "Accuracy", "Communication", "Cleanliness"};
                                break;
                            }

                            case "users": {
                                String selectStatement = "SELECT *\n" +
                                        "                FROM users x\n" +
                                        "                WHERE x.user_name LIKE ? OR x.id_user = ?;";
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

                                while (rs.next()) {
                                    int id_user = rs.getInt("id_user");
                                    String user_name = rs.getString("user_name");
                                    String[] temp = {user_name, String.valueOf(id_user)};
                                    tempy.add(temp);
                                }
                                columnNames = new String[]{"User name", "User id"};
                                break;
                            }

                            case "amenities": {
                                String selectStatement = "SELECT *\n" +
                                        "                FROM amenities x\n" +
                                        "                WHERE x.amenity_type LIKE ?;";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(1, '%'+search_bar.getText()+'%');

                                stmt.execute();
                                rs = stmt.getResultSet();

                                while (rs.next()) {
                                    String amenity_type = rs.getString("amenity_type");
                                    String[] temp = {amenity_type};
                                    tempy.add(temp);
                                }
                                columnNames = new String[]{"Amenity type"};
                                break;
                            }

                            case "has_amenities": {
                                String selectStatement = "SELECT *\n" +
                                        "                FROM has_amenities x\n" +
                                        "                WHERE x.amenity_type LIKE ? OR x.id_listing = ?;";
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

                                while (rs.next()) {
                                    int id_listing = rs.getInt("id_listing");
                                    String amenity_type = rs.getString("amenity_type");
                                    String[] temp = {String.valueOf(id_listing), amenity_type};
                                    tempy.add(temp);
                                }
                                columnNames = new String[]{"Listing id", "Amenity type"};
                                break;
                            }

                            case "listings": {
                                String selectStatement = "SELECT *\n" +
                                        "                FROM listings x\n" +
                                        "                WHERE x.name_listing LIKE ? OR x.id_listing = ? OR x.host_id = ?" +
                                        "OR x.url LIKE ? OR x.interaction LIKE ? OR x.notes LIKE ?" +
                                        "OR x.picture_url LIKE ? OR x.description LIKE ? OR x.neighbourhood_overview LIKE ? OR x.summary LIKE ?" +
                                        "OR x.transit LIKE ? OR x.listing_access LIKE ? LIMIT 500;";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(1, '%'+search_bar.getText()+'%');
                                stmt.setObject(4, '%'+search_bar.getText()+'%');
                                stmt.setObject(5, '%'+search_bar.getText()+'%');
                                stmt.setObject(6, '%'+search_bar.getText()+'%');
                                stmt.setObject(7, '%'+search_bar.getText()+'%');
                                stmt.setObject(8, '%'+search_bar.getText()+'%');
                                stmt.setObject(9, '%'+search_bar.getText()+'%');
                                stmt.setObject(10, '%'+search_bar.getText()+'%');
                                stmt.setObject(11, '%'+search_bar.getText()+'%');
                                stmt.setObject(12, '%'+search_bar.getText()+'%');
                                int foo;
                                try {
                                    foo = Integer.parseInt(search_bar.getText());
                                }
                                catch (NumberFormatException e)
                                {
                                    foo = 0;
                                }
                                stmt.setObject(2, foo);
                                stmt.setObject(3, foo);

                                stmt.execute();
                                rs = stmt.getResultSet();

                                while (rs.next()) {
                                    int id_listing = rs.getInt("id_listing");
                                    int host_id = rs.getInt("host_id");
                                    String name_listing = rs.getString("name_listing");
                                    String url = rs.getString("url");
                                    String interaction = rs.getString("interaction");
                                    String notes = rs.getString("notes");
                                    String picture_url = rs.getString("picture_url");
                                    String description = rs.getString("description");
                                    String neighbourhood_overview = rs.getString("neighbourhood_overview");
                                    String summary = rs.getString("summary");
                                    String transit = rs.getString("transit");
                                    String listing_access = rs.getString("listing_access");
                                    String[] temp = {name_listing, String.valueOf(id_listing), String.valueOf(host_id), url, interaction, notes, picture_url,
                                            description, neighbourhood_overview, summary, transit, listing_access};
                                    tempy.add(temp);
                                }
                                columnNames = new String[]{"Listing name", "Listing id", "Host id", "Url", "Interaction", "Notes", "Picture url",
                                "Description", "Neighbourhood overview", "Summary", "transit", "Listing access"};
                                break;
                            }

                            case "reviews": {
                                String selectStatement = "SELECT *\n" +
                                        "                FROM reviews x\n" +
                                        "                WHERE x.review_comment LIKE ? OR x.id_review = ? OR x.id_listing = ? OR x.id_reviewer = ? OR x.review_date = ? LIMIT 500;";
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
                                stmt.setObject(3, foo);
                                stmt.setObject(4, foo);
                                Date date = null;
                                try {
                                    date = (Date) Date.valueOf(search_bar.getText());
                                }
                                catch (Exception e){
                                    date = new Date(System.currentTimeMillis());
                                }
                                stmt.setDate(5, date);

                                stmt.execute();
                                rs = stmt.getResultSet();

                                while (rs.next()) {
                                    String review_comment = rs.getString("review_comment");
                                    int id_review = rs.getInt("id_review");
                                    int id_listing = rs.getInt("id_listing");
                                    int id_reviewer = rs.getInt("id_reviewer");
                                    Date review_date = rs.getDate("review_date");
                                    String[] temp = {String.valueOf(id_review), String.valueOf(id_listing), String.valueOf(id_reviewer), review_date.toString(), review_comment};
                                    tempy.add(temp);
                                }
                                columnNames = new String[]{"Review id", "Listing id", "Reviewer id", "Review date", "Review comment"};
                                break;
                            }

                            case "booking_polices": {
                                String selectStatement = "SELECT *\n" +
                                        "                FROM booking_polices x\n" +
                                        "                WHERE x.is_business_travel_ready LIKE ? OR x.require_guest_profile_picture LIKE ? " +
                                        "OR x.require_guest_phone_verification LIKE ? OR x.id_listing = ? OR x.extra_people = ? " +
                                        "OR x.maximum_nights = ? OR x.minimum_nights = ? OR x.guests_included = ? LIMIT 500;";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(1, '%'+search_bar.getText()+'%');
                                stmt.setObject(2, '%'+search_bar.getText()+'%');
                                stmt.setObject(3, '%'+search_bar.getText()+'%');
                                int foo;
                                try {
                                    foo = Integer.parseInt(search_bar.getText());
                                }
                                catch (NumberFormatException e)
                                {
                                    foo = 0;
                                }
                                stmt.setObject(4, foo);
                                stmt.setObject(5, foo);
                                stmt.setObject(6, foo);
                                stmt.setObject(7, foo);
                                stmt.setObject(8, foo);

                                stmt.execute();
                                rs = stmt.getResultSet();

                                while (rs.next()) {
                                    String is_business_travel_ready = rs.getString("is_business_travel_ready");
                                    String require_guest_profile_picture = rs.getString("require_guest_profile_picture");
                                    String require_guest_phone_verification = rs.getString("require_guest_phone_verification");
                                    int id_listing = rs.getInt("id_listing");
                                    int extra_people = rs.getInt("extra_people");
                                    int maximum_nights = rs.getInt("maximum_nights");
                                    int minimum_nights = rs.getInt("minimum_nights");
                                    int guests_included = rs.getInt("guests_included");
                                    String[] temp = {String.valueOf(id_listing), String.valueOf(extra_people), is_business_travel_ready,
                                            require_guest_profile_picture, require_guest_phone_verification,
                                            String.valueOf(maximum_nights), String.valueOf(minimum_nights), String.valueOf(guests_included)};
                                    tempy.add(temp);
                                }
                                columnNames = new String[]{"Listing id", "Extra people", "Business travel ready", "Require profile picture",
                                        "Require phone verification", "Maximum nights", "Minimum nights", "Guests included"};
                                break;
                            }


//                     "booking_polices",
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
                String[][] data = new String[tempy.size()][2];
                for (int i = 0; i < tempy.size(); i++) {
                    data[i] = tempy.get(i);
                }
                TextTable tt = new TextTable(columnNames, data);
                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try (PrintStream ps = new PrintStream(baos, true, "UTF-8")) {
                    tt.printTable(ps, 1);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                String result = new String(baos.toByteArray(), StandardCharsets.UTF_8);
                result_search_queries.setText(result);
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
