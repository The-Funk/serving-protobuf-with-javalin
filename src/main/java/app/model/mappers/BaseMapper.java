package app.model.mappers;

import com.google.protobuf.Timestamp;

import java.time.Instant;
import java.util.Optional;

//Class for mapping standard library types, enums, etc to protobuf
public class BaseMapper {

    public static Optional<Timestamp> sqltimeToProtoTime(java.sql.Timestamp sqltime){
        if(sqltime != null){
            Instant instant = sqltime.toInstant();
            return Optional.of(Timestamp.newBuilder().setSeconds(instant.getEpochSecond()).setNanos(instant.getNano()).build());
        }
        return Optional.empty();
    }

    public static java.sql.Timestamp protoTimetoSQLTime(Timestamp tstamp){
        return java.sql.Timestamp.from(Instant.ofEpochSecond(tstamp.getSeconds(), tstamp.getNanos()));
    }

}
