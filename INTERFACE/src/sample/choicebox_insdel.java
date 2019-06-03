package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class choicebox_insdel {


    public static void clear_field(Scene scene){
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

        text1_insdel.setVisible(false);
        text2_insdel.setVisible(false);
        text3_insdel.setVisible(false);
        text4_insdel.setVisible(false);
        text5_insdel.setVisible(false);
        text6_insdel.setVisible(false);
        text7_insdel.setVisible(false);
        text8_insdel.setVisible(false);
        text9_insdel.setVisible(false);
        text10_insdel.setVisible(false);
        text11_insdel.setVisible(false);
        text12_insdel.setVisible(false);

        input1_insdel.setVisible(false);
        input2_insdel.setVisible(false);
        input3_insdel.setVisible(false);
        input4_insdel.setVisible(false);
        input5_insdel.setVisible(false);
        input6_insdel.setVisible(false);
        input7_insdel.setVisible(false);
        input8_insdel.setVisible(false);
        input9_insdel.setVisible(false);
        input10_insdel.setVisible(false);
        input11_insdel.setVisible(false);
        input12_insdel.setVisible(false);

        input1_insdel.setText("");
        input2_insdel.setText("");
        input3_insdel.setText("");
        input4_insdel.setText("");
        input5_insdel.setText("");
        input6_insdel.setText("");
        input7_insdel.setText("");
        input8_insdel.setText("");
        input9_insdel.setText("");
        input10_insdel.setText("");
        input11_insdel.setText("");
        input12_insdel.setText("");
    }

    public static void configuration_choicebox_insdel(Scene scene, ObservableList table_name){

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

        text1_insdel.setVisible(false);
        text2_insdel.setVisible(false);
        text3_insdel.setVisible(false);
        text4_insdel.setVisible(false);
        text5_insdel.setVisible(false);
        text6_insdel.setVisible(false);
        text7_insdel.setVisible(false);
        text8_insdel.setVisible(false);
        text9_insdel.setVisible(false);
        text10_insdel.setVisible(false);
        text11_insdel.setVisible(false);
        text12_insdel.setVisible(false);

        input1_insdel.setVisible(false);
        input2_insdel.setVisible(false);
        input3_insdel.setVisible(false);
        input4_insdel.setVisible(false);
        input5_insdel.setVisible(false);
        input6_insdel.setVisible(false);
        input7_insdel.setVisible(false);
        input8_insdel.setVisible(false);
        input9_insdel.setVisible(false);
        input10_insdel.setVisible(false);
        input11_insdel.setVisible(false);
        input12_insdel.setVisible(false);


        // Selection box
        choicebox_insdel.setItems(table_name);
        choicebox_insdel.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                switch (choicebox_insdel.getSelectionModel().getSelectedItem().toString()){
                    case "has_verifications" :  {
                        clear_field(scene);
                        text1_insdel.setVisible(true);
                        text2_insdel.setVisible(true);
                        input1_insdel.setVisible(true);
                        input2_insdel.setVisible(true);
                        text1_insdel.setText("verification type :");
                        text2_insdel.setText("user id :");
                        break;
                    }
                    case "verifications" :  {
                        clear_field(scene);
                        text1_insdel.setVisible(true);
                        input1_insdel.setVisible(true);
                        break;
                    }
                    case "response_time" :  {
                        clear_field(scene);
                        text1_insdel.setVisible(true);
                        text2_insdel.setVisible(true);
                        input1_insdel.setVisible(true);
                        input2_insdel.setVisible(true);
                        text1_insdel.setText("response time :");
                        text2_insdel.setText("host id :");
                        break;
                    }
                    case "hosts" :  {
                        clear_field(scene);
                        text1_insdel.setVisible(true);
                        text2_insdel.setVisible(true);
                        text3_insdel.setVisible(true);
                        text4_insdel.setVisible(true);
                        text5_insdel.setVisible(true);
                        input1_insdel.setVisible(true);
                        input2_insdel.setVisible(true);
                        input3_insdel.setVisible(true);
                        input4_insdel.setVisible(true);
                        input5_insdel.setVisible(true);
                        text1_insdel.setText("url :");
                        text2_insdel.setText("user id :");
                        text3_insdel.setText("since :");
                        text4_insdel.setText("about :");
                        text5_insdel.setText("thumbnail url :");
                        break;
                    }
                    case "review_scores" :  {
                        clear_field(scene);
                        text1_insdel.setVisible(true);
                        text2_insdel.setVisible(true);
                        text3_insdel.setVisible(true);
                        text4_insdel.setVisible(true);
                        text5_insdel.setVisible(true);
                        text6_insdel.setVisible(true);
                        text7_insdel.setVisible(true);
                        text8_insdel.setVisible(true);
                        input1_insdel.setVisible(true);
                        input2_insdel.setVisible(true);
                        input3_insdel.setVisible(true);
                        input4_insdel.setVisible(true);
                        input5_insdel.setVisible(true);
                        input6_insdel.setVisible(true);
                        input7_insdel.setVisible(true);
                        input8_insdel.setVisible(true);
                        text1_insdel.setText("value :");
                        text2_insdel.setText("listing id :");
                        text3_insdel.setText("checking :");
                        text4_insdel.setText("rating :");
                        text5_insdel.setText("location :");
                        text6_insdel.setText("accuracy:");
                        text7_insdel.setText("communication :");
                        text8_insdel.setText("cleanliness :");
                        break;
                    }
                    case "users" :  {
                        clear_field(scene);
                        text1_insdel.setVisible(true);
                        text2_insdel.setVisible(true);
                        input1_insdel.setVisible(true);
                        input2_insdel.setVisible(true);
                        text1_insdel.setText("user id :");
                        text2_insdel.setText("user name :");
                        break;
                    }
                    case "amenities" :  {
                        clear_field(scene);
                        text1_insdel.setVisible(true);
                        text2_insdel.setVisible(true);
                        input1_insdel.setVisible(true);
                        input2_insdel.setVisible(true);
                        text1_insdel.setText("amenity type :");
                        text2_insdel.setText("user id :");
                        break;
                    }
                    case "has_amenites" :  {
                        clear_field(scene);
                        text1_insdel.setVisible(true);
                        text2_insdel.setVisible(true);
                        input1_insdel.setVisible(true);
                        input2_insdel.setVisible(true);
                        text1_insdel.setText("amenity type :");
                        text2_insdel.setText("listing id :");
                        break;
                    }
                    case "listings" :  {
                        clear_field(scene);
                        text1_insdel.setVisible(true);
                        text2_insdel.setVisible(true);
                        text3_insdel.setVisible(true);
                        text4_insdel.setVisible(true);
                        text5_insdel.setVisible(true);
                        text6_insdel.setVisible(true);
                        text7_insdel.setVisible(true);
                        text8_insdel.setVisible(true);
                        text9_insdel.setVisible(true);
                        text10_insdel.setVisible(true);
                        text11_insdel.setVisible(true);
                        text12_insdel.setVisible(true);
                        input1_insdel.setVisible(true);
                        input2_insdel.setVisible(true);
                        input3_insdel.setVisible(true);
                        input4_insdel.setVisible(true);
                        input5_insdel.setVisible(true);
                        input6_insdel.setVisible(true);
                        input7_insdel.setVisible(true);
                        input8_insdel.setVisible(true);
                        input9_insdel.setVisible(true);
                        input10_insdel.setVisible(true);
                        input11_insdel.setVisible(true);
                        input12_insdel.setVisible(true);
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
                        clear_field(scene);
                        text1_insdel.setVisible(true);
                        text2_insdel.setVisible(true);
                        text3_insdel.setVisible(true);
                        text4_insdel.setVisible(true);
                        text5_insdel.setVisible(true);
                        input1_insdel.setVisible(true);
                        input2_insdel.setVisible(true);
                        input3_insdel.setVisible(true);
                        input4_insdel.setVisible(true);
                        input5_insdel.setVisible(true);
                        text1_insdel.setText("review id :");
                        text2_insdel.setText("listing id :");
                        text3_insdel.setText("reviewer id :");
                        text4_insdel.setText("review date :");
                        text5_insdel.setText("review comment :");
                        break;
                    }
                    case "booking_polices" :  {
                        clear_field(scene);
                        text1_insdel.setVisible(true);
                        text2_insdel.setVisible(true);
                        text3_insdel.setVisible(true);
                        text4_insdel.setVisible(true);
                        text5_insdel.setVisible(true);
                        text6_insdel.setVisible(true);
                        text7_insdel.setVisible(true);
                        text8_insdel.setVisible(true);
                        input1_insdel.setVisible(true);
                        input2_insdel.setVisible(true);
                        input3_insdel.setVisible(true);
                        input4_insdel.setVisible(true);
                        input5_insdel.setVisible(true);
                        input6_insdel.setVisible(true);
                        input7_insdel.setVisible(true);
                        input8_insdel.setVisible(true);
                        text1_insdel.setText("listing id :");
                        text2_insdel.setText("extra people :");
                        text3_insdel.setText("business travel ready :");
                        text4_insdel.setText("require guest profile picture :");
                        text5_insdel.setText("require guest phone verification :");
                        text6_insdel.setText("maximum night :");
                        text7_insdel.setText("minimum night :");
                        text8_insdel.setText("guest included :");
                        break;
                    }
                    case "calendars" :  {
                        clear_field(scene);
                        text1_insdel.setVisible(true);
                        text2_insdel.setVisible(true);
                        text3_insdel.setVisible(true);
                        text4_insdel.setVisible(true);
                        text5_insdel.setVisible(true);
                        text6_insdel.setVisible(true);
                        text7_insdel.setVisible(true);
                        text8_insdel.setVisible(true);
                        text9_insdel.setVisible(true);
                        input1_insdel.setVisible(true);
                        input2_insdel.setVisible(true);
                        input3_insdel.setVisible(true);
                        input4_insdel.setVisible(true);
                        input5_insdel.setVisible(true);
                        input6_insdel.setVisible(true);
                        input7_insdel.setVisible(true);
                        input8_insdel.setVisible(true);
                        input9_insdel.setVisible(true);
                        text1_insdel.setText("calendar date :");
                        text2_insdel.setText("listing id :");
                        text3_insdel.setText("available :");
                        text4_insdel.setText("price :");
                        text5_insdel.setText("daily price :");
                        text6_insdel.setText("weekly price :");
                        text7_insdel.setText("monthly price :");
                        text8_insdel.setText("cleaning fee :");
                        text9_insdel.setText("security deposit :");
                        break;
                    }
                    case "locations" :  {
                        clear_field(scene);
                        text1_insdel.setVisible(true);
                        text2_insdel.setVisible(true);
                        text3_insdel.setVisible(true);
                        text4_insdel.setVisible(true);
                        text5_insdel.setVisible(true);
                        text6_insdel.setVisible(true);
                        input1_insdel.setVisible(true);
                        input2_insdel.setVisible(true);
                        input3_insdel.setVisible(true);
                        input4_insdel.setVisible(true);
                        input5_insdel.setVisible(true);
                        input6_insdel.setVisible(true);
                        text1_insdel.setText("latitude :");
                        text2_insdel.setText("longitude :");
                        text3_insdel.setText("listing id :");
                        text4_insdel.setText("country :");
                        text5_insdel.setText("country code :");
                        text6_insdel.setText("city :");
                        break;
                    }
                    case "houses" :  {
                        clear_field(scene);
                        text1_insdel.setVisible(true);
                        text2_insdel.setVisible(true);
                        text3_insdel.setVisible(true);
                        text4_insdel.setVisible(true);
                        text5_insdel.setVisible(true);
                        text6_insdel.setVisible(true);
                        text7_insdel.setVisible(true);
                        text8_insdel.setVisible(true);
                        text9_insdel.setVisible(true);
                        input1_insdel.setVisible(true);
                        input2_insdel.setVisible(true);
                        input3_insdel.setVisible(true);
                        input4_insdel.setVisible(true);
                        input5_insdel.setVisible(true);
                        input6_insdel.setVisible(true);
                        input7_insdel.setVisible(true);
                        input8_insdel.setVisible(true);
                        input9_insdel.setVisible(true);
                        text1_insdel.setText("neighbourhood :");
                        text2_insdel.setText("listing id :");
                        text3_insdel.setText("beds :");
                        text4_insdel.setText("space :");
                        text5_insdel.setText("house rules :");
                        text6_insdel.setText("accomodates :");
                        text7_insdel.setText("square feet :");
                        text8_insdel.setText("bathrooms :");
                        text9_insdel.setText("bedrooms :");
                        break;
                    }
                    case "property" :  {
                        clear_field(scene);
                        text1_insdel.setVisible(true);
                        text2_insdel.setVisible(true);
                        input1_insdel.setVisible(true);
                        input2_insdel.setVisible(true);
                        text1_insdel.setText("listing id :");
                        text2_insdel.setText("property type :");
                        break;
                    }
                    case "room_type" :  {
                        clear_field(scene);
                        text1_insdel.setVisible(true);
                        text2_insdel.setVisible(true);
                        input1_insdel.setVisible(true);
                        input2_insdel.setVisible(true);
                        text1_insdel.setText("listing id :");
                        text2_insdel.setText("room type :");
                        break;
                    }
                    case "bed_type" :  {
                        clear_field(scene);
                        text1_insdel.setVisible(true);
                        text2_insdel.setVisible(true);
                        input1_insdel.setVisible(true);
                        input2_insdel.setVisible(true);
                        text1_insdel.setText("listing id :");
                        text2_insdel.setText("bed type :");
                        break;
                    }
                }
            }
        });
    }
}
