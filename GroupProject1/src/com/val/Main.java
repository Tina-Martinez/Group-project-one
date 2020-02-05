package com.val;

import java.text.MessageFormat;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //THIS CLASS IS PURELY USED FOR THE TESTING OF THE PROJECT
        Controller controller = new Controller();

        //read in all json shipment files from "input" directory and move them to "processed" directory after processing;
        List<Warehouse> warehouseList = controller.processJsonInputFile(MessageFormat.format("{0}/input/test.json", System.getProperty("user.dir")),
                MessageFormat.format("{0}/processed", System.getProperty("user.dir")));

        //get the first warehouse in the array and export its shipments to output directory
        if(warehouseList == null)
            return;

        Warehouse warehouse = warehouseList.get(0);
        warehouse.exportAllShipmentsToFile(MessageFormat.format( "{0}/output",System.getProperty("user.dir")));

        //show the list of all shipments for each warehouse
        controller.printAllWarehousesWithShipments();
    }
}
