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
import in.co.works.panda.dto.RoomDTO;
import in.co.works.panda.exception.DuplicateRecordException;
import in.co.works.panda.form.RoomForm;
import in.co.works.panda.service.BookingServiceInt;
import in.co.works.panda.service.FloorServiceInt;
import in.co.works.panda.service.RoomServiceInt;
import in.co.works.panda.service.RoomTypeServiceInt;
import in.co.works.panda.util.DataUtility;

@Controller
@RequestMapping("/ctl/room")
public class RoomCtl extends BaseCtl {

	@Autowired
	private RoomServiceInt service;
	
	@Autowired
	private FloorServiceInt floorService;
	
	@Autowired
	private RoomTypeServiceInt roomTypeService;
	
	@Autowired
	private BookingServiceInt bookingService;

	@ModelAttribute
	public void preload(Model model) {
		model.addAttribute("floorList",floorService.search(null));
		model.addAttribute("roomTypeList",roomTypeService.search(null));
	}

	@GetMapping
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") RoomForm form,
			Model model) {
		if (form.getId() > 0) {
			RoomDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "room";
	}

	@PostMapping
	public String submit(@Valid @ModelAttribute("form") RoomForm form, BindingResult bindingResult, Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/room";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					return "room";
				}

				RoomDTO bean = (RoomDTO) form.getDTO();
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "Room update Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "Room Added Successfully!!!!");
				}
				return "room";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "room";
		}
		return "";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") RoomForm form, @RequestParam(required = false) String operation,
			HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/room/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/room";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					RoomDTO dto = new RoomDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		RoomDTO dto = (RoomDTO) form.getDTO();
		List<RoomDTO> list = service.search(dto, pageNo, pageSize);
		List<RoomDTO> totallist = service.search(dto);
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
		model.addAttribute("roomTypeTotal",roomTypeService.search(null).size());
		model.addAttribute("floorTotal",floorService.search(null).size());
		BookingDTO bDto=new BookingDTO();
		bDto.setBookingDate(DataUtility.getDate(String.valueOf(new java.util.Date())));
		model.addAttribute("bookingTotal",bookingService.search(bDto).size());
		model.addAttribute("form", form);
		return "roomList";
	}

}
