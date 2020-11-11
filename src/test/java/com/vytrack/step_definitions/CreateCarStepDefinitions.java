package com.vytrack.step_definitions;

import com.vytrack.pages.CreateCarPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.Map;


public class CreateCarStepDefinitions {

    CreateCarPage createCarPage = new CreateCarPage();
    @Given("user clicks on create car button")
    public void user_clicks_on_create_car_button() {

        createCarPage.clickOnCreateCar();
    }

    /**
     *  When user adds new Vehicle information
     *   | Licence Plate | SDET |
     *   | Model Year    | 2021 |
     *
     *   map is a data structure where every value is referenced by key
     *
     *   (in arraylist it's always index)
     *
     *   dataTable = { Licence Plate = SDET, Model Year = 2021 }
     *
     *   IF you want to turn data table into map, it must be exactly 2 columns
     *
     *   IF it's a 1 column, it can be just List:
     *   Then user verifies following list:
     *          |10|
     *          |20|
     *          |30|
     * @Then("user verifies following list:")
     * public void user_verifies_following_list(List<String></String>
     */


    @When("user adds new vehicle information")
    public void user_adds_new_vehicle_information(Map<String, String> dataTable) {

        //to get all keys and values one by one
        dataTable.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));

        for(Map.Entry<String, String> entry: dataTable.entrySet()){
           System.out.println("Key: " + entry.getKey() + ", value: "+entry.getValue());
       }

        System.out.println("License plate: " + dataTable.get("License Plate"));
        System.out.println("Model year: " + dataTable.get("Model Year"));

        createCarPage.enterLicensePlate(dataTable.get("Licence Plate"));
        createCarPage.enterModelYear(dataTable.get("Model Year"));


    }
}
