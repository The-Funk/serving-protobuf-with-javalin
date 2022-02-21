package app;

import app.control.SensorController;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class MyJavalinRunner {

    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/view", Location.CLASSPATH);
            config.enableCorsForAllOrigins();
            config.addSinglePageRoot("/", "/view/index.html");
        }).start();

        app.get("/pbuf", SensorController.handleServeProtobuf);
        app.get("/json", SensorController.handleServeJSON);

    }

}
