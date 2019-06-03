package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.*;

public class insert {
    public static void configuration_insert(Scene scene){
        ChoiceBox choicebox_insdel = (ChoiceBox) scene.lookup("#choicebox_insdel");
        Button insert_button_insdel = (Button) scene.lookup("#insert_button_insdel");
        Text error_message_insdel = (Text) scene.lookup("#error_message_insdel");

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
    }
}
