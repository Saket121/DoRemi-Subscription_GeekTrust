package com.example.geektrust.entities.device;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.entities.Device;

public class TenDevice extends Device {
    public TenDevice() {
        super.price = Constants.TEN_DEVICE_TOP_UP_PLAN_PRICE_PER_MONTH;
    }
}