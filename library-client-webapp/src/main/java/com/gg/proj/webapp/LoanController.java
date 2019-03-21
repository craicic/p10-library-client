package com.gg.proj.webapp;

import com.gg.proj.authentication.UserInfo;
import com.gg.proj.business.LoanManager;
import com.gg.proj.model.complex.LoanResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.List;


@Controller
public class LoanController {

    private LoanManager loanManager;

    @Autowired
    public LoanController(LoanManager loanManager) {
        this.loanManager = loanManager;
    }

    @RequestMapping(value = "/loan/my_loans", method = RequestMethod.GET)
    public String myLoans(Model model) {
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<LoanResultModel> loanList = loanManager.getMyCurrentLoans(userInfo.getId(), userInfo.getTokenUUID());
        model.addAttribute("loans", loanList);
        model.addAttribute("currentDate", LocalDate.now());
        return "loans/my_loans";
    }

    @RequestMapping(value = "/loan/extend")
    public String extendMyLoan(Model model,
                               @RequestParam int loanId) {
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("loanId" , loanId);
        return "loans/extend";
    }

    @RequestMapping(value = "/loan/perform_extension")
    public RedirectView performExtension(RedirectAttributes attributes,
                                         @RequestParam(required = false) LocalDate date,
                                         @RequestParam int loanId) {
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        attributes.addFlashAttribute("flashAttribute", "loan/perform_extension");
        loanManager.extendMyLoan(loanId, userInfo.getId(), userInfo.getTokenUUID());
        return new RedirectView("/loan/my_loans");
    }
}
