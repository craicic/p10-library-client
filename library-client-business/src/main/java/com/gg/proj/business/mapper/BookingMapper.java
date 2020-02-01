package com.gg.proj.business.mapper;

import com.gg.proj.consumer.wsdl.bookings.*;
import com.gg.proj.model.BookMinModel;
import com.gg.proj.model.BookingModel;
import com.gg.proj.model.complex.BookingInfoModel;
import com.gg.proj.model.complex.BookingSummaryModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    BookingMin bookingModelToBookingMinDto(BookingModel model);

    @Mappings({
            @Mapping(source = "booking.id", target = "booking.id"),
            @Mapping(source = "booking.userId", target = "booking.userId"),
            @Mapping(source = "booking.bookId", target = "booking.bookId"),
    })
    BookingSummaryModel bookingSummaryDtoToModel(BookingSummary bookingSummary);

    BookMinModel bookMinDtoToModel(BookMin bookMin);

    BookingModel bookingDtoToModel(Booking booking);

    default LocalDate gregorianCalendarToLocalDate(XMLGregorianCalendar xmlGregorianCalendar) {
        return xmlGregorianCalendar.toGregorianCalendar().toZonedDateTime().toLocalDate();
    }

    @Mappings({
            @Mapping(source = "bookMin", target = "bookMinModel"),
            @Mapping(source = "booking", target = "bookingModel"),
    })
    BookingInfoModel bookingInfoDtoToModel(BookingInfo bookingInfo);

    List<BookingInfoModel> bookingInfoDtosToModels(List<BookingInfo> bookingInfoDtos);
}
