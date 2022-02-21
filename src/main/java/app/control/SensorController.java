package app.control;

import app.model.objects.pojo.SensorData;
import io.javalin.http.Handler;

import java.sql.Timestamp;
import java.time.Instant;

import static app.model.mappers.RouteMapper.getSensorDataResponse;

public class SensorController {

    public static boolean permissions = true;   //implement your own authorization scheme

    public static Handler handleServeProtobuf = ctx -> {
        try {
            if(permissions){
                // Here's where you'd get your SensorData from your DB or device, etc.
                SensorData sData = new SensorData();
                sData.setID(1);
                sData.setMake("DMC");
                sData.setModel("Delorean");
                sData.setDestinationYear(3030);
                sData.setFluxCapacitorReading(4985.435);
                sData.setClockSkewPicoSeconds(0.004);
                sData.setLastCheckIn(Timestamp.from(Instant.now()));
                sData.setToggleSwitchOn(true);
                sData.setSafetyBeltsOn(true);

                ctx.status(200);
                ctx.contentType("application/x-protobuf");
                ctx.result(getSensorDataResponse(sData));
            }
            else { ctx.status(403); }
        }
        catch(Exception e){
            e.printStackTrace();
            ctx.status(500);
        }
    };

    public static Handler handleServeJSON = ctx -> {
        try {
            if(permissions){
                // Here's where you'd get your SensorData from your DB or device, etc.
                SensorData sData = new SensorData();
                sData.setID(1);
                sData.setMake("DMC");
                sData.setModel("Delorean");
                sData.setDestinationYear(3030);
                sData.setFluxCapacitorReading(4985.435);
                sData.setClockSkewPicoSeconds(0.004);
                sData.setLastCheckIn(Timestamp.from(Instant.now()));
                sData.setToggleSwitchOn(true);
                sData.setSafetyBeltsOn(true);

                ctx.status(200);
                ctx.json(sData);
            }
            else { ctx.status(403); }
        }
        catch(Exception e){
            e.printStackTrace();
            ctx.status(500);
        }
    };
}
