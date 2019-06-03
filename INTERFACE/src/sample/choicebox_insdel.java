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
    }
}
