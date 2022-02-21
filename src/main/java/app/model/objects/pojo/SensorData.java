package app.model.objects.pojo;

import app.model.objects.generated.SensorDataOuterClass;

import java.sql.Timestamp;

import static app.model.mappers.BaseMapper.sqltimeToProtoTime;

public class SensorData implements Bufferable<SensorDataOuterClass.SensorData>{

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


    @Override
    public SensorDataOuterClass.SensorData toBuffer() {
        SensorDataOuterClass.SensorData.Builder builder = SensorDataOuterClass.SensorData.newBuilder();

        // Set all non-nullable values first
        builder.setId(ID)
                .setFluxCapacitorReading(fluxCapacitorReading)
                .setClockSkewPicoSeconds(clockSkewPicoSeconds)
                .setDestinationYear(destinationYear)
                .setToggleSwitchOn(toggleSwitchOn)
                .setSafetyBeltsOn(safetyBeltsOn);

        // Demonstrates using Java optional for proto optionals, in this case we didn't specify the lastCheckIn to be optional in the proto
        // so it could probably be assumed that the lastCheckIn will never be null in our datastore either, but this is just to showcase Optional
        sqltimeToProtoTime(lastCheckIn).ifPresent(builder::setLastCheckIn);

        // Demonstrates null string check for proto optionals, in this case make and model can be null in our proto
        // so it can be assumed they could also be null in our datastore, thus we should check before setting them with our builder.
        if(make != null){ builder.setMake(make); }
        if(model != null){ builder.setModel(model); }

        return builder.build();
    }
}
