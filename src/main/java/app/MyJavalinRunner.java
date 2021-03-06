package app;

import app.model.dao.FakeDao;
import app.model.objects.SensorData;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;
import io.javalin.http.Handler;

import static app.model.mappers.RouteMapper.getSensorDataResponse;

public class MyJavalinRunner {

    public static void main(String[] args) {

        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins).start();

        app.get("/pbuf", handleServeProtobuf);
        app.get("/json", handleServeJSON);

        app.exception(Exception.class, (e, ctx) -> {
            e.printStackTrace();
            ctx.status(500);
        });

    }

    public static Handler handleServeProtobuf = ctx -> {
        // Here's where you'd get your SensorData from your DB or device, etc.
        FakeDao dao = new FakeDao();
        SensorData sData = dao.getSensorDataFromVehicleDB();

        ctx.status(200);
        ctx.contentType("application/x-protobuf");
        ctx.result(getSensorDataResponse(sData));
    };

    public static Handler handleServeJSON = ctx -> {
        // Here's where you'd get your SensorData from your DB or device, etc.
        FakeDao dao = new FakeDao();
        SensorData sData = dao.getSensorDataFromVehicleDB();

        ctx.status(200);
        ctx.json(sData);
    };

}
