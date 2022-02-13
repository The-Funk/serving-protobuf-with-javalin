package app.model.objects.pojo;

import java.sql.Timestamp;

public class SensorData implements Bufferable<SensorData>{

    private int ID;
    private String make;
    private String model;
    private double fluxCapacitorReading;
    private double clockSkewPicoSeconds;
    private int destinationYear;
    private Timestamp lastCheckIn;
    private boolean toggleSwitchOn;
    private boolean safetyBeltsOn;

    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public double getFluxCapacitorReading() { return fluxCapacitorReading; }
    public void setFluxCapacitorReading(double fluxCapacitorReading) { this.fluxCapacitorReading = fluxCapacitorReading; }

    public double getClockSkewPicoSeconds() { return clockSkewPicoSeconds; }
    public void setClockSkewPicoSeconds(double clockSkewPicoSeconds) { this.clockSkewPicoSeconds = clockSkewPicoSeconds; }

    public int getDestinationYear() { return destinationYear; }
    public void setDestinationYear(int destinationYear) { this.destinationYear = destinationYear; }

    public Timestamp getLastCheckIn() { return lastCheckIn; }
    public void setLastCheckIn(Timestamp lastCheckIn) { this.lastCheckIn = lastCheckIn; }

    public boolean isToggleSwitchOn() { return toggleSwitchOn; }
    public void setToggleSwitchOn(boolean toggleSwitchOn) { this.toggleSwitchOn = toggleSwitchOn; }

    public boolean isSafetyBeltsOn() { return safetyBeltsOn; }
    public void setSafetyBeltsOn(boolean safetyBeltsOn) { this.safetyBeltsOn = safetyBeltsOn; }


}
