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

import in.co.works.panda.dto.PriceManagerDTO;
import in.co.works.panda.exception.DuplicateRecordException;
import in.co.works.panda.form.PriceManagerForm;
import in.co.works.panda.service.PriceManagerServiceInt;
import in.co.works.panda.service.RoomTypeServiceInt;

@Controller
@RequestMapping("/ctl/priceManager")
public class PriceManagerCtl extends BaseCtl {

	@Autowired
	private PriceManagerServiceInt service;

	@Autowired
	private RoomTypeServiceInt roomTypeService;
	
	@ModelAttribute
	public void preload(Model model) {
		model.addAttribute("roomTypeList",roomTypeService.search(null));
	}

	@GetMapping
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") PriceManagerForm form,
			Model model) {
		if (form.getId() > 0) {
			PriceManagerDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "priceManager";
	}

	@PostMapping
	public String submit(@Valid @ModelAttribute("form") PriceManagerForm form, BindingResult bindingResult, Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/priceManager";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					return "priceManager";
				}

				PriceManagerDTO bean = (PriceManagerDTO) form.getDTO();
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "PriceManager update Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "PriceManager Added Successfully!!!!");
				}
				return "priceManager";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "priceManager";
		}
		return "";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") PriceManagerForm form, @RequestParam(required = false) String operation,
			HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/priceManager/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/priceManager";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					PriceManagerDTO dto = new PriceManagerDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		PriceManagerDTO dto = (PriceManagerDTO) form.getDTO();
		List<PriceManagerDTO> list = service.search(dto, pageNo, pageSize);
		List<PriceManagerDTO> totallist = service.search(dto);
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
		return "priceManagerList";
	}

}
