package com.example.geektrust.entities.device;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.entities.Device;

public class FourDevice extends Device {
    public FourDevice() {
        super.price = Constants.FOUR_DEVICE_TOP_UP_PLAN_PRICE_PER_MONTH;
    }
}
