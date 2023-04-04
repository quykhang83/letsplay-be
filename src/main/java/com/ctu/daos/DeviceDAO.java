package com.ctu.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ctu.exception.EmptyDeviceException;
import com.ctu.model.Device;
import com.ctu.model.User;

public class DeviceDAO {
    @PersistenceContext(unitName = "primary")
    EntityManager entityManager;

    public List<Device> getAllDevices() {
        List<Device> list = null;
        try {
            TypedQuery<Device> query = entityManager.createQuery("FROM Devices d ORDER by d.deviceId", Device.class);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Device createDevice(User user, String token) {
        Device device = new Device(user, token);
        System.out.println(device.getFcmToken());
        try {
            entityManager.persist(device);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return device;
    }

    public Device getDeviceByToken(String token) throws EmptyDeviceException {
        Device device = null;

        try {
            TypedQuery<Device> query = entityManager.createQuery("FROM Devices d WHERE d.fcmToken = :fcmToken", Device.class);
            device = query.setParameter("fcmToken", token).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (device == null) {
            throw new EmptyDeviceException(token);
        } else {
            return device;
        }
    }

    // public List<String> getTokenDevicesByUserId(Long userId) throws
    // EmailNotFoundException {
    // List<String> list = null;
    // try {
    // TypedQuery<String> query = entityManager.createQuery("SELECT d.fcmToken FROM
    // Devices d WHERE d.user.userId = :userId", String.class);
    // list = query.setParameter("userId", userId).getResultList();
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // return list;
    // }

    public void deleteDeviceByToken(String fcmToken) throws EmptyDeviceException {
        Device device = null;

        try {
            TypedQuery<Device> query = entityManager.createQuery("FROM Devices d WHERE d.fcmToken = :fcmToken", Device.class);
            device = query.setParameter("fcmToken", fcmToken).getSingleResult();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (device == null) {
            throw new EmptyDeviceException(fcmToken);
        }

        try {
            entityManager.remove(device);
            System.out.println("Delete device which has token: " + device.getFcmToken() + " successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
