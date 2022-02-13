package app.control;

import io.javalin.http.Handler;

public class SensorController {

    public static boolean permissions = true;   //implement your own authorization scheme

    public static Handler serveSensorData = ctx -> {
        try {
            if(permissions){
                ctx.status(200);
                ctx.contentType("application/x-protobuf");
                //ctx.result(getSensorData());
            }
            else { ctx.status(403); }
        }
        catch(Exception e){
            e.printStackTrace();
            ctx.status(500);
        }
    };

    public static Handler handleUpdateData = ctx -> {
        try {
            if(permissions){
                ctx.status(200);
                ctx.contentType("application/x-protobuf");
                //ctx.result(getSensorData());
            }
            else { ctx.status(403); }
        }
        catch(Exception e){
            e.printStackTrace();
            ctx.status(500);
        }
    };
}
