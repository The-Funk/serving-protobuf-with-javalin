package app;

import app.control.SensorController;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class MyJavalinRunner {

    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/public", Location.CLASSPATH);
            config.enableCorsForAllOrigins();
            config.addSinglePageRoot("/", "/view/index.html");
        }).start();

        app.get("/data", SensorController.serveSensorData);
        app.post("/update", SensorController.handleUpdateData);

    }

}
