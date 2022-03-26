package app.model.mappers;


import app.model.objects.SensorData;

public class RouteMapper {
    public static byte[] getSensorDataResponse(SensorData data){
        return data.toBuffer().toByteArray();
    }

}
