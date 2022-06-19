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

import in.co.works.panda.dto.PaymentDTO;
import in.co.works.panda.dto.GuestDTO;
import in.co.works.panda.dto.PaidServiceDTO;
import in.co.works.panda.dto.PaymentDTO;
import in.co.works.panda.dto.PriceManagerDTO;
import in.co.works.panda.exception.DuplicateRecordException;
import in.co.works.panda.form.PaymentForm;
import in.co.works.panda.service.PaymentServiceInt;
import in.co.works.panda.service.GuestServiceInt;
import in.co.works.panda.service.PaidServiceServiceInt;
import in.co.works.panda.service.PaymentServiceInt;
import in.co.works.panda.service.PriceManagerServiceInt;
import in.co.works.panda.service.RoomTypeServiceInt;
import in.co.works.panda.util.DataUtility;

@Controller
@RequestMapping("/ctl/payment")
public class PaymentCtl extends BaseCtl {

	@Autowired
	private PaymentServiceInt service;
	


	

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") PaymentForm form, @RequestParam(required = false) String operation,
			HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/payment/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/payment";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		
		PaymentDTO dto = (PaymentDTO) form.getDTO();
		long gid=DataUtility.getLong(String.valueOf(session.getAttribute("gId")));
		dto.setGuestId(gid);
		List<PaymentDTO> list = service.search(dto, pageNo, pageSize);
		List<PaymentDTO> totallist = service.search(dto);
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
		return "paymentList";
	}
	
	

}
