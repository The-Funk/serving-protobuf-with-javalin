package app.model.dao;

import app.model.objects.pojo.SensorData;

import java.sql.Timestamp;

public class FakeDao {

    public FakeDao(){}

    SensorData getSensorDataFromVehicleDB(){
        SensorData data = new SensorData();
        data.setID(1);
        data.setMake("DMC");
        data.setModel("DeLorean");
        data.setFluxCapacitorReading(58645.4554);
        data.setClockSkewPicoSeconds(0.0044);
        data.setDestinationYear(2035);
        data.setLastCheckIn(new Timestamp(System.currentTimeMillis()));
        data.setToggleSwitchOn(true);
        data.setSafetyBeltsOn(true);
        return data;
    }

}
