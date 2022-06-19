package in.co.works.panda.ctl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.works.panda.dto.BookingDTO;
import in.co.works.panda.dto.GuestDTO;
import in.co.works.panda.dto.PaidServiceDTO;
import in.co.works.panda.dto.PaymentDTO;
import in.co.works.panda.dto.PriceManagerDTO;
import in.co.works.panda.exception.DuplicateRecordException;
import in.co.works.panda.form.BookingForm;
import in.co.works.panda.service.BookingServiceInt;
import in.co.works.panda.service.GuestServiceInt;
import in.co.works.panda.service.PaidServiceServiceInt;
import in.co.works.panda.service.PaymentServiceInt;
import in.co.works.panda.service.PriceManagerServiceInt;
import in.co.works.panda.service.RoomTypeServiceInt;
import in.co.works.panda.util.DataUtility;

@Controller
@RequestMapping("/ctl/booking")
public class BookingCtl extends BaseCtl {

	@Autowired
	private BookingServiceInt service;
	
	@Autowired
	private GuestServiceInt guestService;
	
	@Autowired
	private RoomTypeServiceInt roomTypeService;
	
	@Autowired
	private PaymentServiceInt paymentService;
	
	@Autowired
	private PriceManagerServiceInt priceManagerService;

	@ModelAttribute
	public void preload(Model model) {

		model.addAttribute("guestList", guestService.search(null));
		model.addAttribute("roomTypeList",roomTypeService.search(null));
		
	}

	@GetMapping
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") BookingForm form,
			Model model) {
		if (form.getId() > 0) {
			BookingDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "booking";
	}

	@PostMapping
	public String submit(@Valid @ModelAttribute("form") BookingForm form, BindingResult bindingResult, Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/booking";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					return "booking";
				}
					BookingDTO bean = (BookingDTO) form.getDTO();
					bean.setPaymentStatus("Success");
					bean.setBookingStatus("Success");
					GuestDTO gDto=guestService.findBypk(bean.getGuestId());
					bean.setGuestName(gDto.getFirstName()+" "+gDto.getLastName());
					bean.setRoomTypeName(roomTypeService.findBypk(bean.getRoomTypeId()).getTitle());
					bean.setBookingDate(DataUtility.getCurrentTimestamp());
					bean.setBookingNumber(String.valueOf(DataUtility.getRandomBooking()));
					service.add(bean);
					PaymentDTO pBean=new PaymentDTO();
					pBean.setDate(new java.util.Date());
					pBean.setInvoiceNumber(DataUtility.getRandomInvoice());
					pBean.setAmount(getAmount(bean.getRoomTypeId()));
					pBean.setGuestName(gDto.getFirstName()+" "+gDto.getLastName());
					pBean.setGuestId(bean.getGuestId());
					paymentService.add(pBean);
					model.addAttribute("success", "Booking Added Successfully!!!!");
				
				return "booking";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "booking";
		}
		return "";
	}

	private String getAmount(long roomTypeId) {
		System.out.println("ROom Type Id-----------"+roomTypeId);
		PriceManagerDTO pDto=priceManagerService.findBypkRoomTypeId(roomTypeId);
		System.out.println(pDto.toString());
		String day=DataUtility.getDayName();
		System.out.println("adchhhhhhhhhhhhhhha---------------"+pDto.getSun());
		String name=null;
		if(day.equalsIgnoreCase("Sun")) {
			name=pDto.getSun();
		}else if(day.equalsIgnoreCase("Mon")) {
			name=pDto.getMon();
		}else if(day.equalsIgnoreCase("Tue")) {
			name=pDto.getTues();
		}else if(day.equalsIgnoreCase("Wed")) {
			name=pDto.getWed();
		}else if(day.equalsIgnoreCase("Thu")) {
			name=pDto.getThus();
		}else if(day.equalsIgnoreCase("Fri")) {
			name=pDto.getFri();
		}else if(day.equalsIgnoreCase("Sat")) {
			name=pDto.getSat();
		}
		return name;
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") BookingForm form, @RequestParam(required = false) String operation,
			HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/booking/search";
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
		List<BookingDTO> list = service.search(dto, pageNo, pageSize);
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
		return "bookingList";
	}
	
	@RequestMapping(value = "/order", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchListDetail(@ModelAttribute("form") BookingForm form, @RequestParam(required = false) String operation,
			HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/booking/order";
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

		
		BookingDTO dto = (BookingDTO) form.getDTO();
		long gid=DataUtility.getLong(String.valueOf(session.getAttribute("gId")));
		dto.setGuestId(gid);
		List<BookingDTO> list = service.search(dto, pageNo, pageSize);
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
		return "orderList";
	}

}
