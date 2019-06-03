package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.*;

public class delete {
    public static void configuration_deletion(Scene scene){
        ChoiceBox choicebox_insdel = (ChoiceBox) scene.lookup("#choicebox_insdel");
        Button delete_button_insdel = (Button) scene.lookup("#delete_button_insdel");
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
                                error_message_insdel.setText("Deletion done !");
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
                                error_message_insdel.setText("Deletion done !");
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
                                error_message_insdel.setText("Deletion done !");
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
                                error_message_insdel.setText("Deletion done !");
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
                                error_message_insdel.setText("Deletion done !");
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
                                error_message_insdel.setText("Deletion done !");
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
                                error_message_insdel.setText("Deletion done !");
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
                                error_message_insdel.setText("Deletion done !");
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
                                error_message_insdel.setText("Deletion done !");
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
                                error_message_insdel.setText("Deletion done !");
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
                                error_message_insdel.setText("Deletion done !");
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
                                error_message_insdel.setText("Deletion done !");
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
                                error_message_insdel.setText("Deletion done !");
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
                                error_message_insdel.setText("Deletion done !");
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
