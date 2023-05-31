package com.example.geektrust.entities.factory;

import com.example.geektrust.entities.Device;
import com.example.geektrust.entities.device.FourDevice;
import com.example.geektrust.entities.device.TenDevice;
import com.example.geektrust.enums.DeviceType;

public class DeviceFactory {
    public static Device getDevice(DeviceType deviceType) {
        switch (deviceType) {
            case FOUR_DEVICE:
                return new FourDevice();
            case TEN_DEVICE:
                return new TenDevice();
            default:
                return null;
        }
    }
}