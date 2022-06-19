package in.co.works.panda.ctl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.works.panda.dto.BookingDTO;
import in.co.works.panda.dto.GuestDTO;
import in.co.works.panda.form.BookingForm;
import in.co.works.panda.service.BookingServiceInt;
import in.co.works.panda.service.GuestServiceInt;
import in.co.works.panda.service.PaymentServiceInt;
import in.co.works.panda.service.PriceManagerServiceInt;
import in.co.works.panda.service.RoomServiceInt;
import in.co.works.panda.service.RoomTypeServiceInt;

@Controller
public class WelcomeCtl extends BaseCtl {
	
	@Autowired
	private BookingServiceInt service;
	
	@Autowired
	private GuestServiceInt guestService;
	
	@Autowired
	private RoomTypeServiceInt roomTypeService;
	
	@Autowired
	private RoomServiceInt roomService;
	
	@Autowired
	private PaymentServiceInt paymentService;
	
	@Autowired
	private PriceManagerServiceInt priceManagerService;

	 @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	    public String welcome(@ModelAttribute("form") BookingForm form, @RequestParam(required = false) String operation,
				HttpSession session, Model model) {
		 
		 if(session.getAttribute("user")==null) {
			 return "redirect:/login";
		 }
		 
		 int pageNo = form.getPageNo();
			int pageSize = form.getPageSize();

			if (OP_NEXT.equals(operation)) {
				pageNo++;
			} else if (OP_PREVIOUS.equals(operation)) {
				pageNo--;
			} else if (OP_NEW.equals(operation)) {
				return "redirect:/ctl/booking";
			}

			pageNo = (pageNo < 1) ? 1 : pageNo;
			pageSize = (pageSize < 1) ? 10 : pageSize;

			if (OP_DELETE.equals(operation)) {
				pageNo = 1;
				if (form.getIds() != null) {
					for (long id : form.getIds()) {
						BookingDTO dto = new BookingDTO();
						dto.setId(id);
						service.delete(dto);
					}
					model.addAttribute("success", "Deleted Successfully!!!");
				} else {
					model.addAttribute("error", "Select at least one record");
				}
			}
			BookingDTO dto = (BookingDTO) form.getDTO();
			List<BookingDTO> list = service.list(pageNo, pageSize);
			List<BookingDTO> totallist = service.search(dto);
			model.addAttribute("list", list);

			if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
				model.addAttribute("error", "Record not found");
			}

			int listsize = list.size();
			int total = totallist.size();
			int pageNoPageSize = pageNo * pageSize;

			form.setPageNo(pageNo);
			form.setPageSize(pageSize);
			model.addAttribute("pageNo", pageNo);
			model.addAttribute("pageSize", pageSize);
			model.addAttribute("listsize", listsize);
			model.addAttribute("total", total);
			model.addAttribute("pagenosize", pageNoPageSize);
			model.addAttribute("form", form);
			model.addAttribute("roomTotal",roomService.search(null).size());
			model.addAttribute("bookingTotal",service.search(null).size());
			model.addAttribute("amountTotal",paymentService.getTotalAmount());
			model.addAttribute("guestTotal", guestService.search(null).size());
	        return "welcome";
	    }	
}
