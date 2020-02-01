package com.gg.proj.webapp;

import com.gg.proj.authentication.UserInfo;
import com.gg.proj.business.BookingManager;
import com.gg.proj.consumer.connectors.BookingConnector;
import com.gg.proj.model.complex.BookingInfoModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.ws.soap.client.SoapFaultClientException;

import javax.security.auth.login.CredentialException;
import javax.xml.soap.SOAPException;
import java.util.List;

@Controller
public class BookingController {

    private static final Logger log = LoggerFactory.getLogger(BookingController.class);

    private BookingManager bookingManager;

    @Autowired
    public BookingController(BookingManager bookingManager) {
        this.bookingManager = bookingManager;
    }

    @RequestMapping(value="/booking/perform_booking")
    public RedirectView performBooking(RedirectAttributes attributes,
                                       @RequestParam int bookId) {
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        attributes.addFlashAttribute("flashAttribute", "/booking/perform_booking");

        try {
            bookingManager.performBooking(bookId, userInfo.getId(), userInfo.getTokenUUID());
        } catch (CredentialException e) {
            log.error("CredentialException raised and caught - stacktrace : " + e);
            return new RedirectView("error");
        } catch (SOAPException e) {
            log.error("SOAPException raised and caught - stacktrace : " + e);
            return new RedirectView("error");
        }
        return new RedirectView("/booking/my_bookings");
    }

    @RequestMapping(value="/booking/my_bookings")
    public String myBooking(Model model) {
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<BookingInfoModel> bookings;
        try {
            bookings = bookingManager.getMyBookings(userInfo.getId(), userInfo.getTokenUUID());
        } catch (SOAPException e) {
            log.error("SOAPException raised and caught - stacktrace : " + e);
            return "error";
        } catch (CredentialException e) {
            log.error("CredentialException raised and caught - stacktrace : " + e);
            return "error";
        }
        model.addAttribute("bookings", bookings);
        return "bookings/my_bookings";
    }

    @RequestMapping(value="/booking/cancel")
    public RedirectView cancelBooking(RedirectAttributes attributes,
                                      @RequestParam int bookingId,
                                      @RequestParam int bookId
                                      ) {
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            bookingManager.cancelBooking(bookingId, bookId, userInfo.getId(), userInfo.getTokenUUID());
        } catch (SOAPException e) {
            log.error("SOAPException raised and caught - stacktrace : " + e);
            return new RedirectView("error");
        } catch (CredentialException e) {
            log.error("CredentialException raised and caught - stacktrace : " + e);
            return new RedirectView("error");
        }
        return new RedirectView("/booking/my_bookings");
    }
}
