package in.co.works.panda.ctl;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import in.co.works.panda.dto.GuestDTO;
import in.co.works.panda.exception.DuplicateRecordException;
import in.co.works.panda.form.GuestForm;
import in.co.works.panda.service.BookingServiceInt;
import in.co.works.panda.service.GuestServiceInt;
import in.co.works.panda.service.PaymentServiceInt;
import in.co.works.panda.util.DataUtility;

@Controller
@RequestMapping("/ctl/guest")
public class GuestCtl extends BaseCtl {

	@Autowired
	private GuestServiceInt service;

	@Autowired
	private BookingServiceInt bookingService;
	
	@Autowired
	private PaymentServiceInt paymentService;

	@ModelAttribute
	public void preload(Model model) {

		Map<String, String> genderMap = new LinkedHashMap<String, String>();
		genderMap.put("Female", "Female");
		genderMap.put("Male", "Male");
		model.addAttribute("gender", genderMap);

		Map<String, String> idType = new LinkedHashMap<String, String>();
		idType.put("Adhar Card", "Adhar Card");
		idType.put("Voter Id", "Voter Id");
		idType.put("Driving Licenece", "Driving Licenece");
		model.addAttribute("idTypeMap", idType);

		model.addAttribute("country", service.searchCountry(null));
		model.addAttribute("state", service.searchState(null));
		model.addAttribute("city", service.searchCity(null));

	}

	@GetMapping
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") GuestForm form,
			Model model) {
		if (form.getId() > 0) {
			GuestDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "guest";
	}

	@GetMapping("/detail")
	public String displayDetail(@RequestParam(required = false) Long id, HttpSession session,
			@ModelAttribute("form") GuestForm form, Model model) {
		
		if (form.getId() > 0) {
			session.setAttribute("gId", form.getId());
			GuestDTO bean = service.findBypk(id);
			model.addAttribute("dto", bean);
		}else {
				long gid=DataUtility.getLong(String.valueOf(session.getAttribute("gId")));	
				GuestDTO bean = service.findBypk(gid);
				model.addAttribute("dto", bean);
			
		}
		return "guestDetail";
	}

	@PostMapping
	public String submit(@RequestParam("idImage") MultipartFile file, @Valid @ModelAttribute("form") GuestForm form,
			BindingResult bindingResult, Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/guest";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					return "guest";
				}

				GuestDTO bean = (GuestDTO) form.getDTO();
				bean.setIdImage(file.getBytes());
				if (bean.getVip() == null) {
					bean.setVip("No");
				}
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "Guest update Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "Guest Added Successfully!!!!");
				}
				return "guest";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "guest";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") GuestForm form, @RequestParam(required = false) String operation,
			Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/guest/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/guest";
		} else if (OP_ADD_TO_VIP.equalsIgnoreCase(operation)) {
			GuestDTO gDto = service.findBypk(vid);
			gDto.setVip("Yes");
			try {
				service.update(gDto);
			} catch (DuplicateRecordException e) {
				e.printStackTrace();
			}
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					GuestDTO dto = new GuestDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		GuestDTO dto = (GuestDTO) form.getDTO();
		List<GuestDTO> list = service.search(dto, pageNo, pageSize);
		List<GuestDTO> totallist = service.search(dto);
		model.addAttribute("list", list);

		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			model.addAttribute("error", "Record not found");
		}

		int listsize = list.size();
		int total = totallist.size();
		int pageNoPageSize = pageNo * pageSize;

		form.setPageNo(pageNo);
		form.setPageSize(pageSize);

		GuestDTO gsDto = new GuestDTO();
		gsDto.setVip("Yes");
		model.addAttribute("vipTotal", service.search(gsDto).size());
		model.addAttribute("bookingTotal", bookingService.search(null).size());
		model.addAttribute("amountTotal",paymentService.getTotalAmount());
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("listsize", listsize);
		model.addAttribute("total", total);
		model.addAttribute("pagenosize", pageNoPageSize);
		model.addAttribute("form", form);
		return "guestList";
	}

}
