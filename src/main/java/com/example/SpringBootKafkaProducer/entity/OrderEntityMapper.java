package com.example.SpringBootKafkaProducer.entity;

import com.ingka.spe.model.icart.OrderInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper
public interface OrderEntityMapper {

    OrderEntityMapper ORDER_ENTITY_MAPPER = Mappers.getMapper(OrderEntityMapper.class);

    @Mappings({
            @Mapping(target = "orderStatus", expression = "java(orderInput.getOrderStatus() == 1 ? true : false)"),
            @Mapping(target = "orderDate", source = "orderDate", qualifiedByName = "convertStringToSQLDate")
    })
    OrderEntity mapDTOToOrderEntity(OrderInput orderInput);

    @Named("convertStringToSQLDate")
    default Date convertStringToSQLDate(String orderDate) throws ParseException {
        LocalDate localDate = LocalDate.parse(orderDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(localDate.toString());
        Date sqlDate = new Date(date.getTime());
        return sqlDate;
    }
}
