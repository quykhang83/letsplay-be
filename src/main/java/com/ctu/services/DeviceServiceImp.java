package com.ctu.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.ctu.daos.DeviceDAO;
import com.ctu.daos.UserDAO;
import com.ctu.exception.InternalServerError;
import com.ctu.model.Device;
import com.ctu.model.User;

@Stateless
public class DeviceServiceImp implements DeviceService{
    @Inject
    UserDAO userDAO;
    @Inject
    DeviceDAO deviceDAO;

    @Override
    public void createDevice(String username, String token) {
        User user = userDAO.getUserByName(username);

        try {
            deviceDAO.createDevice(user, token);
        } catch (Exception ex) {
            throw new InternalServerError(ex.getMessage());
        }
    }

    @Override
    public List<Device> getAllDevices() {
        return deviceDAO.getAllDevices();
    }

    
    
}
