package app.control;

import app.model.dao.FakeDao;
import app.model.objects.pojo.SensorData;
import io.javalin.http.Handler;

import static app.model.mappers.RouteMapper.getSensorDataResponse;

public class SensorController {

    public static boolean permissions = true;   //implement your own authorization scheme

    public static Handler handleServeProtobuf = ctx -> {
        try {
            if(permissions){
                // Here's where you'd get your SensorData from your DB or device, etc.
                FakeDao dao = new FakeDao();
                SensorData sData = dao.getSensorDataFromVehicleDB();

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
                FakeDao dao = new FakeDao();
                SensorData sData = dao.getSensorDataFromVehicleDB();

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
