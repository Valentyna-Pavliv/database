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


        // CONFIGURATION INSERTION DELETION
        ChoiceBox choicebox_insdel = (ChoiceBox) scene.lookup("#choicebox_insdel");
        Button insert_button_insdel = (Button) scene.lookup("#insert_button_insdel");
        Button delete_button_insdel = (Button) scene.lookup("#delete_button_insdel");
        Text error_message_insdel = (Text) scene.lookup("#error_message_insdel");

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
        Text text11_insdel = (Text) scene.lookup("#text11_insdel");
        Text text12_insdel = (Text) scene.lookup("#text12_insdel");
        Text text13_insdel = (Text) scene.lookup("#text13_insdel");
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
        TextField input11_insdel = (TextField) scene.lookup("#input11_insdel");
        TextField input12_insdel = (TextField) scene.lookup("#input12_insdel");
        TextField input13_insdel = (TextField) scene.lookup("#input13_insdel");

        // Insert button
        insert_button_insdel.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                Connection c = null;
                PreparedStatement stmt = null;
                if (choicebox_insdel.getValue() == null) {
                   error_message_insdel.setText("Please select a table !");
                }
                else {
                    try {
                        Class.forName("org.postgresql.Driver");
                        c = DriverManager
                                .getConnection("jdbc:postgresql://localhost:5432/database2019",
                                        "postgres", "database2019");

                        c.setAutoCommit(false);

                        ResultSet rs = null;
                        switch ((String) choicebox_insdel.getValue()) {
                            case "has_verifications": {
                                String selectStatement = "INSERT INTO has_verifications VALUES (?, ?);";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(1, input1_insdel.getText());
                                int foo;
                                try {
                                    foo = Integer.parseInt(input2_insdel.getText());
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }
                                stmt.setObject(2, foo);

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }

                            case "verifications": {
                                String selectStatement = "INSERT INTO verifications VALUES (?);";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(1, input1_insdel.getText());

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }

                            case "response_time": {
                                String selectStatement = "INSERT INTO response_time VALUES (?, ?);";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(1, input1_insdel.getText());
                                int foo;
                                try {
                                    foo = Integer.parseInt(input2_insdel.getText());
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }
                                stmt.setObject(2, foo);

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "hosts": {
                                String selectStatement = "INSERT INTO hosts VALUES (?, ?, ?, ?, ?);";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(1, input1_insdel.getText());
                                int foo;
                                try {
                                    foo = Integer.parseInt(input2_insdel.getText());
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }
                                stmt.setObject(2, foo);
                                Date date = null;
                                try {
                                    date = (Date) Date.valueOf(input3_insdel.getText());
                                }
                                catch (Exception e){
                                    error_message_insdel.setText("Wrong format for input date !");
                                    break;
                                }
                                stmt.setDate(3, date);
                                stmt.setObject(4, input4_insdel.getText());
                                stmt.setObject(5, input5_insdel.getText());

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "review_scores": {
                                String selectStatement = "INSERT INTO review_scores VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
                                stmt = c.prepareStatement(selectStatement);
                                try {
                                    stmt.setObject(1, Integer.parseInt(input1_insdel.getText()));
                                    stmt.setObject(2, Integer.parseInt(input2_insdel.getText()));
                                    stmt.setObject(3, Integer.parseInt(input3_insdel.getText()));
                                    stmt.setObject(4, Integer.parseInt(input4_insdel.getText()));
                                    stmt.setObject(5, Integer.parseInt(input5_insdel.getText()));
                                    stmt.setObject(6, Integer.parseInt(input6_insdel.getText()));
                                    stmt.setObject(7, Integer.parseInt(input7_insdel.getText()));
                                    stmt.setObject(8, Integer.parseInt(input8_insdel.getText()));
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }
                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "users": {
                                String selectStatement = "INSERT INTO users VALUES (?, ?);";
                                stmt = c.prepareStatement(selectStatement);
                                int foo;
                                try {
                                    foo = Integer.parseInt(input1_insdel.getText());
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }
                                stmt.setObject(1, foo);
                                stmt.setObject(2, input2_insdel.getText());
                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "amenities": {
                                String selectStatement = "INSERT INTO amenities VALUES (?);";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(1, input1_insdel.getText());
                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "has_amenites": {
                                String selectStatement = "INSERT INTO has_amenites VALUES (?, ?);";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(1, input1_insdel.getText());
                                int foo;
                                try {
                                    foo = Integer.parseInt(input2_insdel.getText());
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for input user id");
                                    break;
                                }
                                stmt.setObject(2, foo);
                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "listings": {
                                String selectStatement = "INSERT INTO listings VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                                stmt = c.prepareStatement(selectStatement);
                                int foo;
                                try {
                                    foo = Integer.parseInt(input1_insdel.getText());
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for input user id");
                                    break;
                                }
                                stmt.setObject(1, foo);
                                stmt.setObject(2, input2_insdel.getText());
                                stmt.setObject(3, input3_insdel.getText());
                                stmt.setObject(4, input4_insdel.getText());
                                stmt.setObject(5, input5_insdel.getText());
                                stmt.setObject(6, input6_insdel.getText());
                                stmt.setObject(7, input7_insdel.getText());
                                stmt.setObject(8, input8_insdel.getText());
                                stmt.setObject(9, input9_insdel.getText());
                                stmt.setObject(10, input10_insdel.getText());
                                stmt.setObject(11, input11_insdel.getText());
                                try {
                                    foo = Integer.parseInt(input12_insdel.getText());
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for input user id");
                                    break;
                                }
                                stmt.setObject(12, foo);
                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "reviews": {
                                String selectStatement = "INSERT INTO reviews VALUES (?, ?, ?, ?, ?);";
                                stmt = c.prepareStatement(selectStatement);
                                try {
                                    stmt.setObject(1, Integer.parseInt(input1_insdel.getText()));
                                    stmt.setObject(2, Integer.parseInt(input2_insdel.getText()));
                                    stmt.setObject(3, Integer.parseInt(input3_insdel.getText()));
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }
                                Date date = null;
                                try {
                                    date = (Date) Date.valueOf(input4_insdel.getText());
                                }
                                catch (Exception e){
                                    error_message_insdel.setText("Wrong format for input date !");
                                    break;
                                }
                                stmt.setDate(4, date);
                                stmt.setObject(5, input5_insdel.getText());

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "booking_polices": {
                                String selectStatement = "INSERT INTO booking_polices VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
                                stmt = c.prepareStatement(selectStatement);
                                try {
                                    stmt.setObject(1, Integer.parseInt(input1_insdel.getText()));
                                    stmt.setObject(2, Integer.parseInt(input2_insdel.getText()));
                                    stmt.setObject(6, Integer.parseInt(input6_insdel.getText()));
                                    stmt.setObject(7, Integer.parseInt(input7_insdel.getText()));
                                    stmt.setObject(8, Integer.parseInt(input8_insdel.getText()));
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }
                                stmt.setObject(3, input3_insdel.getText());
                                stmt.setObject(4, input4_insdel.getText());
                                stmt.setObject(5, input5_insdel.getText());

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "calendars": {
                                String selectStatement = "INSERT INTO calendars VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
                                stmt = c.prepareStatement(selectStatement);
                                Date date = null;
                                try {
                                    date = (Date) Date.valueOf(input1_insdel.getText());
                                }
                                catch (Exception e){
                                    error_message_insdel.setText("Wrong format for input date !");
                                    break;
                                }
                                stmt.setDate(1, date);
                                stmt.setObject(3, input3_insdel.getText());
                                try {
                                    stmt.setObject(2, Integer.parseInt(input2_insdel.getText()));
                                    stmt.setObject(4, Integer.parseInt(input4_insdel.getText()));
                                    stmt.setObject(5, Integer.parseInt(input5_insdel.getText()));
                                    stmt.setObject(6, Integer.parseInt(input6_insdel.getText()));
                                    stmt.setObject(7, Integer.parseInt(input7_insdel.getText()));
                                    stmt.setObject(8, Integer.parseInt(input8_insdel.getText()));
                                    stmt.setObject(9, Integer.parseInt(input9_insdel.getText()));
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "locations": {
                                String selectStatement = "INSERT INTO locations VALUES (?, ?, ?, ?, ?, ?);";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(4, input4_insdel.getText());
                                stmt.setObject(5, input5_insdel.getText());
                                stmt.setObject(6, input6_insdel.getText());
                                try {
                                    stmt.setObject(1, Float.parseFloat(input1_insdel.getText()));
                                    stmt.setObject(2, Float.parseFloat(input2_insdel.getText()));
                                    stmt.setObject(3, Integer.parseInt(input3_insdel.getText()));
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "houses": {
                                String selectStatement = "INSERT INTO houses VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(3, input3_insdel.getText());
                                stmt.setObject(4, input4_insdel.getText());
                                try {
                                    stmt.setObject(1, Float.parseFloat(input1_insdel.getText()));
                                    stmt.setObject(2, Float.parseFloat(input2_insdel.getText()));
                                    stmt.setObject(5, Integer.parseInt(input5_insdel.getText()));
                                    stmt.setObject(6, Float.parseFloat(input6_insdel.getText()));
                                    stmt.setObject(7, Float.parseFloat(input7_insdel.getText()));
                                    stmt.setObject(8, Float.parseFloat(input8_insdel.getText()));
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "property": {
                                String selectStatement = "INSERT INTO property VALUES (?, ?);";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(2, input2_insdel.getText());

                                try {
                                    stmt.setObject(1, Float.parseFloat(input1_insdel.getText()));
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "cancellation_policy": {
                                String selectStatement = "INSERT INTO cancellation_policy VALUES (?, ?);";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(1, input1_insdel.getText());

                                try {
                                    stmt.setObject(2, Float.parseFloat(input2_insdel.getText()));
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "room_type": {
                                String selectStatement = "INSERT INTO room_type VALUES (?, ?);";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(2, input2_insdel.getText());

                                try {
                                    stmt.setObject(1, Float.parseFloat(input1_insdel.getText()));
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "bed_type": {
                                String selectStatement = "INSERT INTO bed_type VALUES (?, ?);";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(2, input2_insdel.getText());

                                try {
                                    stmt.setObject(1, Float.parseFloat(input1_insdel.getText()));
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                        }
                        if(rs != null) {
                            rs.close();
                        }
                        if (stmt != null){
                            stmt.close();
                        }
                        if (c != null){
                            c.commit();
                            c.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                        System.exit(0);
                    }
                }
            }
        });

        // Delete button
        delete_button_insdel.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                Connection c = null;
                PreparedStatement stmt = null;
                if (choicebox_insdel.getValue() == null) {
                    error_message_insdel.setText("Please select a table !");
                }
                else {
                    try {
                        Class.forName("org.postgresql.Driver");
                        c = DriverManager
                                .getConnection("jdbc:postgresql://localhost:5432/database2019",
                                        "postgres", "database2019");

                        c.setAutoCommit(false);

                        ResultSet rs = null;
                        switch ((String) choicebox_insdel.getValue()) {
                            case "has_verifications": {
                                String selectStatement = "DELETE FROM has_verifications WHERE verification_type = ? AND user_id = ?;";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(1, input1_insdel.getText());
                                int foo;
                                try {
                                    foo = Integer.parseInt(input2_insdel.getText());
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for input user id");
                                    break;
                                }
                                stmt.setObject(2, foo);

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Deletion done !");
                                break;
                            }

                            case "verifications": {
                                String selectStatement = "DELETE FROM verifications WHERE verification_type = ?;";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(1, input1_insdel.getText());

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Deletion done !");
                                break;
                            }

                            case "response_time": {
                                String selectStatement = "DELETE FROM response_time WHERE verification_type = ? AND host_id = ?;";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(1, input1_insdel.getText());
                                int foo;
                                try {
                                    foo = Integer.parseInt(input2_insdel.getText());
                                }
                                catch (NumberFormatException e)
                                {
                                    foo = 0;
                                }
                                stmt.setObject(2, foo);

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Deletion done !");
                                break;
                            }

                            case "hosts": {
                                String selectStatement = "DELETE FROM hosts WHERE url = ? AND id_user = ? AND since = ? AND about = ? AND thumbnail_url = ?;";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(1, input1_insdel.getText());
                                int foo;
                                try {
                                    foo = Integer.parseInt(input2_insdel.getText());
                                }
                                catch (NumberFormatException e)
                                {
                                    foo = 0;
                                }
                                stmt.setObject(2, foo);
                                Date date = null;
                                try {
                                    date = (Date) Date.valueOf(input3_insdel.getText());
                                }
                                catch (Exception e){
                                    error_message_insdel.setText("Wrong format for the date !");
                                    break;
                                }
                                stmt.setDate(3, date);
                                stmt.setObject(4, input4_insdel.getText());
                                stmt.setObject(5, input5_insdel.getText());

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Deletion done !");
                                break;
                            }
                            case "review_scores": {
                                String selectStatement = "DELETE FROM review_scores WHERE value = ? AND id_listing = ? AND checking = ? AND rating = ? AND location = ? " +
                                        "AND accuracy = ? AND communication = ? AND cleanliness = ?;";
                                stmt = c.prepareStatement(selectStatement);
                                try {
                                    stmt.setObject(1, Integer.parseInt(input1_insdel.getText()));
                                    stmt.setObject(2, Integer.parseInt(input2_insdel.getText()));
                                    stmt.setObject(3, Integer.parseInt(input3_insdel.getText()));
                                    stmt.setObject(4, Integer.parseInt(input4_insdel.getText()));
                                    stmt.setObject(5, Integer.parseInt(input5_insdel.getText()));
                                    stmt.setObject(6, Integer.parseInt(input6_insdel.getText()));
                                    stmt.setObject(7, Integer.parseInt(input7_insdel.getText()));
                                    stmt.setObject(8, Integer.parseInt(input8_insdel.getText()));
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }
                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "users": {
                                String selectStatement = "DELETE FROM users WHERE id_user = ? AND user_name = ?;";
                                stmt = c.prepareStatement(selectStatement);
                                int foo;
                                try {
                                    foo = Integer.parseInt(input1_insdel.getText());
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }
                                stmt.setObject(1, foo);
                                stmt.setObject(2, input2_insdel.getText());
                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "amenities": {
                                String selectStatement = "DELETE FROM amenity_type WHERE id_user = ?;";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(1, input1_insdel.getText());
                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "has_amenites": {
                                String selectStatement = "DELETE FROM has_amenites WHERE amenity_type = ? AND id_listing = ?;";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(1, input1_insdel.getText());
                                int foo;
                                try {
                                    foo = Integer.parseInt(input2_insdel.getText());
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for input user id");
                                    break;
                                }
                                stmt.setObject(2, foo);
                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "listings": {
                                String selectStatement = "DELETE FROM listings WHERE value = ? AND id_listing = ? AND name_listing = ? AND url = ? AND space = ? " +
                                        "AND interaction = ? AND notes = ? AND picture_url = ? AND description = ? AND neighbourhood_overview = ? AND summary = ? " +
                                        "AND transit = ? AND listing_access = ? AND host_id = ?;";
                                stmt = c.prepareStatement(selectStatement);
                                int foo;
                                try {
                                    foo = Integer.parseInt(input1_insdel.getText());
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for input user id");
                                    break;
                                }
                                stmt.setObject(1, foo);
                                stmt.setObject(2, input2_insdel.getText());
                                stmt.setObject(3, input3_insdel.getText());
                                stmt.setObject(4, input4_insdel.getText());
                                stmt.setObject(5, input5_insdel.getText());
                                stmt.setObject(6, input6_insdel.getText());
                                stmt.setObject(7, input7_insdel.getText());
                                stmt.setObject(8, input8_insdel.getText());
                                stmt.setObject(9, input9_insdel.getText());
                                stmt.setObject(10, input10_insdel.getText());
                                stmt.setObject(11, input11_insdel.getText());
                                try {
                                    foo = Integer.parseInt(input12_insdel.getText());
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for input user id");
                                    break;
                                }
                                stmt.setObject(12, foo);
                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "reviews": {
                                String selectStatement = "DELETE FROM reviews WHERE id_review = ? AND id_listing = ? AND id_reviewer = ? AND review_date = ? " +
                                        "AND review_comment = ?;";
                                stmt = c.prepareStatement(selectStatement);
                                try {
                                    stmt.setObject(1, Integer.parseInt(input1_insdel.getText()));
                                    stmt.setObject(2, Integer.parseInt(input2_insdel.getText()));
                                    stmt.setObject(3, Integer.parseInt(input3_insdel.getText()));
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }
                                Date date = null;
                                try {
                                    date = (Date) Date.valueOf(input4_insdel.getText());
                                }
                                catch (Exception e){
                                    error_message_insdel.setText("Wrong format for input date !");
                                    break;
                                }
                                stmt.setDate(4, date);
                                stmt.setObject(5, input5_insdel.getText());

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "booking_polices": {
                                String selectStatement = "DELETE FROM booking_polices WHERE id_listing = ? AND extra_people = ? AND is_business_travel_ready = ? " +
                                        "AND require_guest_profile_picture = ? AND require_guest_phone_verification = ? " +
                                        "AND maximum_nights = ? AND minimum_nights = ? AND guests_included = ?;";
                                stmt = c.prepareStatement(selectStatement);
                                try {
                                    stmt.setObject(1, Integer.parseInt(input1_insdel.getText()));
                                    stmt.setObject(2, Integer.parseInt(input2_insdel.getText()));
                                    stmt.setObject(6, Integer.parseInt(input6_insdel.getText()));
                                    stmt.setObject(7, Integer.parseInt(input7_insdel.getText()));
                                    stmt.setObject(8, Integer.parseInt(input8_insdel.getText()));
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }
                                stmt.setObject(3, input3_insdel.getText());
                                stmt.setObject(4, input4_insdel.getText());
                                stmt.setObject(5, input5_insdel.getText());

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "calendars": {
                                String selectStatement = "DELETE FROM calendars WHERE calendar_date = ? AND id_listing = ? AND available = ? " +
                                        "AND price = ? AND daily_price = ? " +
                                        "AND weekly_price = ? AND monthly_price = ? AND cleaning_fee = ? AND security_deposit = ?;";
                                stmt = c.prepareStatement(selectStatement);
                                Date date = null;
                                try {
                                    date = (Date) Date.valueOf(input1_insdel.getText());
                                }
                                catch (Exception e){
                                    error_message_insdel.setText("Wrong format for input date !");
                                    break;
                                }
                                stmt.setDate(1, date);
                                stmt.setObject(3, input3_insdel.getText());
                                try {
                                    stmt.setObject(2, Integer.parseInt(input2_insdel.getText()));
                                    stmt.setObject(4, Integer.parseInt(input4_insdel.getText()));
                                    stmt.setObject(5, Integer.parseInt(input5_insdel.getText()));
                                    stmt.setObject(6, Integer.parseInt(input6_insdel.getText()));
                                    stmt.setObject(7, Integer.parseInt(input7_insdel.getText()));
                                    stmt.setObject(8, Integer.parseInt(input8_insdel.getText()));
                                    stmt.setObject(9, Integer.parseInt(input9_insdel.getText()));
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "locations": {
                                String selectStatement = "DELETE FROM locations WHERE latitude = ? AND longitude = ? AND id_listing = ? " +
                                        "AND country = ? AND country_code = ? " +
                                        "AND city = ?;";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(4, input4_insdel.getText());
                                stmt.setObject(5, input5_insdel.getText());
                                stmt.setObject(6, input6_insdel.getText());
                                try {
                                    stmt.setObject(1, Float.parseFloat(input1_insdel.getText()));
                                    stmt.setObject(2, Float.parseFloat(input2_insdel.getText()));
                                    stmt.setObject(3, Integer.parseInt(input3_insdel.getText()));
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "houses": {
                                String selectStatement = "DELETE FROM houses WHERE neighbourhood = ? AND id_listing = ? AND beds = ? " +
                                        "AND space = ? AND house_rules = ? " +
                                        "AND accommodates = ? AND square_feet = ? AND bathrooms = ? AND bedrooms = ?;";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(3, input3_insdel.getText());
                                stmt.setObject(4, input4_insdel.getText());
                                try {
                                    stmt.setObject(1, Float.parseFloat(input1_insdel.getText()));
                                    stmt.setObject(2, Float.parseFloat(input2_insdel.getText()));
                                    stmt.setObject(5, Integer.parseInt(input5_insdel.getText()));
                                    stmt.setObject(6, Float.parseFloat(input6_insdel.getText()));
                                    stmt.setObject(7, Float.parseFloat(input7_insdel.getText()));
                                    stmt.setObject(8, Float.parseFloat(input8_insdel.getText()));
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "property": {
                                String selectStatement = "DELETE FROM property WHERE id_listing = ? AND property_type = ?;";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(2, input2_insdel.getText());

                                try {
                                    stmt.setObject(1, Float.parseFloat(input1_insdel.getText()));
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "cancellation_policy": {
                                String selectStatement = "DELETE FROM cancellation_policy WHERE cancellation_policy = ? AND id_listing = ?;";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(1, input1_insdel.getText());

                                try {
                                    stmt.setObject(2, Float.parseFloat(input2_insdel.getText()));
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "room_type": {
                                String selectStatement = "DELETE FROM room_type WHERE id_listing = ? AND room_type = ?;";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(2, input2_insdel.getText());

                                try {
                                    stmt.setObject(1, Float.parseFloat(input1_insdel.getText()));
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                            case "bed_type": {
                                String selectStatement = "DELETE FROM bed_type WHERE id_listing = ? AND bed_type = ?;";
                                stmt = c.prepareStatement(selectStatement);
                                stmt.setObject(2, input2_insdel.getText());

                                try {
                                    stmt.setObject(1, Float.parseFloat(input1_insdel.getText()));
                                }
                                catch (NumberFormatException e)
                                {
                                    error_message_insdel.setText("Wrong format for imput user id");
                                    break;
                                }

                                try {
                                    stmt.execute();
                                    rs = stmt.getResultSet();
                                }
                                catch (Exception e){
                                    error_message_insdel.setText(e.getMessage());
                                    break;
                                }
                                error_message_insdel.setText("Insertion done !");
                                break;
                            }
                        }
                        if(rs != null) {
                            rs.close();
                        }
                        if (stmt != null){
                            stmt.close();
                        }
                        if (c != null){
                            c.commit();
                            c.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                        System.exit(0);
                    }
                }
            }
        });

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
                        text11_insdel.setText("unused :");
                        text12_insdel.setText("unused :");
                        text13_insdel.setText("unused :");
                        break;
                    }
                    case "verifications" :  {
                        text1_insdel.setText("verification type :");
                        text2_insdel.setText("unused :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        text11_insdel.setText("unused :");
                        text12_insdel.setText("unused :");
                        text13_insdel.setText("unused :");
                        break;
                    }
                    case "response_time" :  {
                        text1_insdel.setText("response time :");
                        text2_insdel.setText("host id :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        text11_insdel.setText("unused :");
                        text12_insdel.setText("unused :");
                        text13_insdel.setText("unused :");
                        break;
                    }
                    case "hosts" :  {
                        text1_insdel.setText("url :");
                        text2_insdel.setText("user id :");
                        text3_insdel.setText("since :");
                        text4_insdel.setText("about :");
                        text5_insdel.setText("thumbnail url :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        text11_insdel.setText("unused :");
                        text12_insdel.setText("unused :");
                        text13_insdel.setText("unused :");
                        break;
                    }
                    case "review_scores" :  {
                        text1_insdel.setText("value :");
                        text2_insdel.setText("listing id :");
                        text3_insdel.setText("checking :");
                        text4_insdel.setText("rating :");
                        text5_insdel.setText("location :");
                        text6_insdel.setText("accuracy:");
                        text7_insdel.setText("communication :");
                        text8_insdel.setText("cleanliness :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        text11_insdel.setText("unused :");
                        text12_insdel.setText("unused :");
                        text13_insdel.setText("unused :");
                        break;
                    }
                    case "users" :  {
                        text1_insdel.setText("user id :");
                        text2_insdel.setText("user name :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        text11_insdel.setText("unused :");
                        text12_insdel.setText("unused :");
                        text13_insdel.setText("unused :");
                        break;
                    }
                    case "amenities" :  {
                        text1_insdel.setText("amenity type :");
                        text2_insdel.setText("user id :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        text11_insdel.setText("unused :");
                        text12_insdel.setText("unused :");
                        text13_insdel.setText("unused :");
                        break;
                    }
                    case "has_amenites" :  {
                        text1_insdel.setText("amenity type :");
                        text2_insdel.setText("listing id :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        text11_insdel.setText("unused :");
                        text12_insdel.setText("unused :");
                        text13_insdel.setText("unused :");
                        break;
                    }
                    case "listings" :  {
                        text1_insdel.setText("listing id :");
                        text2_insdel.setText("listing name :");
                        text3_insdel.setText("url :");
                        text4_insdel.setText("interaction :");
                        text5_insdel.setText("notes :");
                        text6_insdel.setText("picture url :");
                        text7_insdel.setText("description :");
                        text8_insdel.setText("neighbourhood overview :");
                        text9_insdel.setText("summary :");
                        text10_insdel.setText("transit :");
                        text11_insdel.setText("listing access :");
                        text12_insdel.setText("host id :");
                        break;
                    }
                    case "reviews" :  {
                        text1_insdel.setText("review id :");
                        text2_insdel.setText("listing id :");
                        text3_insdel.setText("reviewer id :");
                        text4_insdel.setText("review date :");
                        text5_insdel.setText("review comment :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        text11_insdel.setText("unused :");
                        text12_insdel.setText("unused :");
                        text13_insdel.setText("unused :");
                        break;
                    }
                    case "booking_polices" :  {
                        text1_insdel.setText("listing id :");
                        text2_insdel.setText("extra people :");
                        text3_insdel.setText("business travel ready :");
                        text4_insdel.setText("require guest profile picture :");
                        text5_insdel.setText("require guest phone verification :");
                        text6_insdel.setText("maximum night :");
                        text7_insdel.setText("minimum night :");
                        text8_insdel.setText("guest included :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        text11_insdel.setText("unused :");
                        text12_insdel.setText("unused :");
                        text13_insdel.setText("unused :");
                        break;
                    }
                    case "calendars" :  {
                        text1_insdel.setText("calendar date :");
                        text2_insdel.setText("listing id :");
                        text3_insdel.setText("available :");
                        text4_insdel.setText("price :");
                        text5_insdel.setText("daily price :");
                        text6_insdel.setText("weekly price :");
                        text7_insdel.setText("monthly price :");
                        text8_insdel.setText("cleaning fee :");
                        text9_insdel.setText("security deposit :");
                        text10_insdel.setText("unused :");
                        text11_insdel.setText("unused :");
                        text12_insdel.setText("unused :");
                        text13_insdel.setText("unused :");
                        break;
                    }
                    case "locations" :  {
                        text1_insdel.setText("latitude :");
                        text2_insdel.setText("longitude :");
                        text3_insdel.setText("listing id :");
                        text4_insdel.setText("country :");
                        text5_insdel.setText("country code :");
                        text6_insdel.setText("city :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        text11_insdel.setText("unused :");
                        text12_insdel.setText("unused :");
                        text13_insdel.setText("unused :");
                        break;
                    }
                    case "houses" :  {
                        text1_insdel.setText("neighbourhood :");
                        text2_insdel.setText("listing id :");
                        text3_insdel.setText("beds :");
                        text4_insdel.setText("space :");
                        text5_insdel.setText("house rules :");
                        text6_insdel.setText("accomodates :");
                        text7_insdel.setText("square feet :");
                        text8_insdel.setText("bathrooms :");
                        text9_insdel.setText("bedrooms :");
                        text10_insdel.setText("unused :");
                        text11_insdel.setText("unused :");
                        text12_insdel.setText("unused :");
                        text13_insdel.setText("unused :");
                        break;
                    }
                    case "property" :  {
                        text1_insdel.setText("listing id :");
                        text2_insdel.setText("property type :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        text11_insdel.setText("unused :");
                        text12_insdel.setText("unused :");
                        text13_insdel.setText("unused :");
                        break;
                    }
                    case "room_type" :  {
                        text1_insdel.setText("listing id :");
                        text2_insdel.setText("room type :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        text11_insdel.setText("unused :");
                        text12_insdel.setText("unused :");
                        text13_insdel.setText("unused :");
                        break;
                    }
                    case "bed_type" :  {
                        text1_insdel.setText("listing id :");
                        text2_insdel.setText("bed type :");
                        text3_insdel.setText("unused :");
                        text4_insdel.setText("unused :");
                        text5_insdel.setText("unused :");
                        text6_insdel.setText("unused :");
                        text7_insdel.setText("unused :");
                        text8_insdel.setText("unused :");
                        text9_insdel.setText("unused :");
                        text10_insdel.setText("unused :");
                        text11_insdel.setText("unused :");
                        text12_insdel.setText("unused :");
                        text13_insdel.setText("unused :");
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
                                int counter = 1;
                                while (rs.next()) {
                                    int user_id = rs.getInt("user_id");
                                    builder.append("Result " + counter + " : " + user_id);
                                    builder.append(System.lineSeparator());
                                    String verification_type = rs.getString("verification_type");
                                    builder.append("-> " + verification_type);
                                    builder.append(System.lineSeparator());
                                    builder.append(System.lineSeparator());
                                    counter++;
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
                            case "review_scores": {
                                String selectStatement = "SELECT *\n" +
                                        "                FROM review_scores x\n" +
                                        "                WHERE x.value LIKE ? OR x.id_listing = ? OR x.checking = ? OR x.rating LIKE ? OR x.location LIKE ? LIMIT 50;";
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
                String[][] data = new String[579][2];
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
                String[] columnNames = {"User name, User id",};
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

        query9.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_1.setText("Find the top-‐10 (in terms of the number of listings) hosts (host_ids, host_names) in Spain.");
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

        query10.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_1.setText("Find the top-‐10 rated (review_score_rating) apartments (id,name) in Barcelona.");
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


        // CONFIGURATION PREDEFINED QUERIES
        Text result_predefined_queries_2 = (Text) scene.lookup("#result_predefined_queries_2");
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
                        builder.append( city);
                        builder.append(System.lineSeparator());
                        builder.append("-> " + count);
                        builder.append(System.lineSeparator());
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

        query22.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_2.setText("The quality of a neighborhood is defined based on the number of listings and the review score of these listings, one way for computing that is using the median of the review scores, as medians are more robust to outliers. Find the top-‐5 neighborhoods using median review scores of listings in Madrid.");
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
                    ResultSet rs = stmt.executeQuery( "SELECT neighbourhood,AVG(rating) as median\n" +
                            "   FROM (SELECT rating, X.neighbourhood FROM\n" +
                            "  (SELECT h.neighbourhood, h.id_listing as id_listing, rating , count(rating) OVER (PARTITION BY neighbourhood) AS TotalRows,\n" +
                            "       row_number() OVER (PARTITION BY neighbourhood ORDER BY rating ASC) AS AmountOrder\n" +
                            "       FROM (houses h INNER JOIN review_scores rs ON rs.id_listing = h.id_listing)) X, locations l\n" +
                            "           WHERE X.AmountOrder  IN (floor((X.TotalRows+1)/2.0) , ceil((X.TotalRows+1)/2.0)) \n" +
                            "AND l.city = 'Madrid' AND l.id_listing = X.id_listing)X GROUP BY neighbourhood  ORDER BY median DESC LIMIT 5;\n" );
                    int counter = 1;
                    while ( rs.next() ) {
                        String neighbourhood = rs.getString("neighbourhood");
                        builder.append( "Top " + counter + " : " + neighbourhood);
                        builder.append(System.lineSeparator());
                        int median = rs.getInt(2);
                        builder.append( "-> " + median);
                        builder.append(System.lineSeparator());
                        builder.append(System.lineSeparator());
                        counter++;
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

        query23.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_2.setText("Find all the hosts (host_ids, host_names) with the highest number of listings.");
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
                    ResultSet rs = stmt.executeQuery( "SELECT u.id_user, u.user_name\n" +
                            " FROM users u,\n" +
                            "(SELECT l.host_id\n" +
                            "FROM listings l\n" +
                            "GROUP BY l.host_id\n" +
                            "ORDER BY count(*) desc) h\n" +
                            "WHERE h.host_id = u.id_user;\n" );
                    builder.append( "Result : ");
                    builder.append(System.lineSeparator());
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
                result_predefined_queries_2.setText(string);
            }
        });


        query24.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_2.setText("Find the 5 most cheapest Apartments (based on average price within the available dates) in Berlin available between 01-‐03-‐2019 and 30-‐04-‐2019 having at least 2 beds, a location review score of at least 8, flexible cancellation, and listed by a host with a verifiable government id.");
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
                    ResultSet rs = stmt.executeQuery( "SELECT distinct l.id_listing id_listing, l.name_listing name_listing, c_p_a.p price\n" +
                            "FROM houses hous, locations loc, review_scores rev_sc, cancellation_policy can_pol, has_verifications h_verif, listings l, (SELECT c.id_listing id, AVG(c.price) p, bool_and(c.available) b\n" +
                            "   FROM calendars c\n" +
                            "   WHERE c.calendar_date >= '2019-03-01' AND\n" +
                            "   c.calendar_date < '2019-04-30'  \n" +
                            "   GROUP BY c.id_listing)c_p_a\n" +
                            "WHERE hous.id_listing =l.id_listing AND\n" +
                            "hous.beds>=2 AND\n" +
                            "loc.id_listing = l.id_listing AND\n" +
                            "loc.city ='Berlin' AND\n" +
                            "rev_sc.location >= 8 AND\n" +
                            "can_pol.id_listing = l.id_listing AND\n" +
                            "can_pol.cancellation_policy ='flexible' AND\n" +
                            "h_verif.user_id = l.host_id AND\n" +
                            "(h_verif.verification_type ='government_id' OR\n" +
                            "h_verif.verification_type = 'offline_government_id') AND\n" +
                            "c_p_a.b AND c_p_a.id = l.id_listing\n" +
                            "ORDER BY c_p_a.p ASC LIMIT 5;\n" );
                    builder.append( "Result : ");
                    builder.append(System.lineSeparator());
                    while ( rs.next() ) {
                        int id_listing = rs.getInt("id_listing");
                        String name_listing = rs.getString("name_listing");
                        String price = rs.getString("price");
                        builder.append( "Listing id : " + id_listing + ", Listing name : " + name_listing + ", Price :" + price);
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

        query25.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_2.setText("Each property can accommodate different number of people (1 to 16). Find the top‐5 rated (review_score_rating) listings for each distinct category based on number of accommodated guests with at least two of these facilities: Wifi, Internet, TV, and Free street parking.");
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
                        builder.append("Accommodate : " + acc + ", Best rated listings : " + brl.toString());
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

        query26.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_2.setText("What are top three busiest listings per host? The more reviews a listing has, the busier the listing is.");
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
                        builder.append("Host id : " + host_id + ", Busiest listings : " + busiest_listings.toString());
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

        query27.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_2.setText("What are the three most frequently used amenities at each neighborhood in Berlin for the listings with “Private Room” room type?");
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
                        builder.append("Neighbourhood : " + neighbourhood + ", Top amenities : " + top_amenities.toString());
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
                    builder.append( "Result : ");
                    builder.append(System.lineSeparator());
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
                        builder.append( "Result : " + city);
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
                        builder.append(neighbourhood);
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

        query211.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_2.setText("Print all the countries that at least 20% of their listings were available in 2018.");
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
                        builder.append(country);
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

        query212.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent ae) {
                description_query_set_2.setText("Print all the neighborhoods in Barcelona where more than 5 percent of their accommodation cancelation policy is strict with grace period.");
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
                    ResultSet rs = stmt.executeQuery( " SELECT q.neighbourhood  \n" +
                            "FROM( \n" +
                            "    SELECT h.neighbourhood, (COUNT(CASE WHEN c. cancellation_policy = 'strict 14 with grace period ' THEN 1   END)*100)/count(*) percentage  \n" +
                            " FROM houses h  \n" +
                            "     INNER JOIN (SELECT l.id_listing FROM locations l WHERE l.city = 'Barcelona')l ON l.id_listing = h.id_listing\n" +
                            "     INNER JOIN cancellation_policy c ON c.id_listing = h.id_listing\n" +
                            " GROUP BY h.neighbourhood)q\n" +
                            " WHERE q.percentage>=0;\n" );
                    builder.append( "Result : ");
                    builder.append(System.lineSeparator());
                    while ( rs.next() ) {
                        String neighbourhood = rs.getString("neighbourhood");
                        builder.append(neighbourhood);
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
    }

    public static void main(String[] args) {
        launch(args);
    }
}
