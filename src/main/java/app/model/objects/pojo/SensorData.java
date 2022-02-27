package app.model.objects.pojo;

import app.model.objects.generated.SensorDataOuterClass;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import static app.model.mappers.BaseMapper.sqltimeToProtoTime;

public class SensorData implements Serializable, Bufferable<SensorDataOuterClass.SensorData>{

    private String makeAndModel;
    private int destinationYear;
    private List<Double> fluxCapacitorReadings;
    private Timestamp lastCheckIn;
    private boolean safetyBeltsOn;

    public String getMakeAndModel() { return makeAndModel; }
    public void setMakeAndModel(String makeAndModel) { this.makeAndModel = makeAndModel; }

    public List<Double> getFluxCapacitorReadings() { return fluxCapacitorReadings; }
    public void setFluxCapacitorReadings(List<Double> fluxCapacitorReadings) { this.fluxCapacitorReadings = fluxCapacitorReadings; }

    public int getDestinationYear() { return destinationYear; }
    public void setDestinationYear(int destinationYear) { this.destinationYear = destinationYear; }

    public Timestamp getLastCheckIn() { return lastCheckIn; }
    public void setLastCheckIn(Timestamp lastCheckIn) { this.lastCheckIn = lastCheckIn; }

    public boolean isSafetyBeltsOn() { return safetyBeltsOn; }
    public void setSafetyBeltsOn(boolean safetyBeltsOn) { this.safetyBeltsOn = safetyBeltsOn; }


    @Override
    public SensorDataOuterClass.SensorData toBuffer() {
        SensorDataOuterClass.SensorData.Builder builder = SensorDataOuterClass.SensorData.newBuilder();

        // Set all non-nullable values first
        builder.addAllFluxCapacitorReadings(fluxCapacitorReadings)
                .setDestinationYear(destinationYear)
                .setSafetyBeltsOn(safetyBeltsOn);

        // Demonstrates using Java Optional for proto optionals, in this case lastCheckIn is optional in our proto
        // therefore we should check that lastCheckIn is not null prior to setting the lastCheckIn value on our proto object
        sqltimeToProtoTime(lastCheckIn).ifPresent(builder::setLastCheckIn);

        // Demonstrates null string check for proto optionals, in this case make and model can be null in our proto
        // so it can be assumed it could also be null in our datastore, thus we should check before setting it with our builder.
        if(makeAndModel != null){ builder.setMakeAndModel(makeAndModel); }

        return builder.build();
    }
}
