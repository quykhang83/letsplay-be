package com.ctu.services;

import java.util.List;

import com.ctu.model.Device;

public interface DeviceService {
    public void createDevice(String username, String token);

    public List<Device> getAllDevices();
}
