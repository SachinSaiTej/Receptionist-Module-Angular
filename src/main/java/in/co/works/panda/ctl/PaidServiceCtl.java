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

import in.co.works.panda.dto.PaidServiceDTO;
import in.co.works.panda.exception.DuplicateRecordException;
import in.co.works.panda.form.PaidServiceForm;
import in.co.works.panda.service.PaidServiceServiceInt;

@Controller
@RequestMapping("/ctl/paidService")
public class PaidServiceCtl extends BaseCtl {

	@Autowired
	private PaidServiceServiceInt service;

	@ModelAttribute
	public void preload(Model model) {

		Map<String, String> statusMap = new LinkedHashMap<String, String>();
		statusMap.put("Active", "Active");
		statusMap.put("UnAclive", "UnActive");
		model.addAttribute("statusMap", statusMap);
	}

	@GetMapping
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") PaidServiceForm form,
			Model model) {
		if (form.getId() > 0) {
			PaidServiceDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "paidService";
	}

	@PostMapping
	public String submit(@Valid @ModelAttribute("form") PaidServiceForm form, BindingResult bindingResult, Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/paidService";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					return "paidService";
				}

				PaidServiceDTO bean = (PaidServiceDTO) form.getDTO();
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "PaidService update Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "PaidService Added Successfully!!!!");
				}
				return "paidService";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "paidService";
		}
		return "";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") PaidServiceForm form, @RequestParam(required = false) String operation,
			HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/paidService/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/paidService";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					PaidServiceDTO dto = new PaidServiceDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		PaidServiceDTO dto = (PaidServiceDTO) form.getDTO();
		List<PaidServiceDTO> list = service.search(dto, pageNo, pageSize);
		List<PaidServiceDTO> totallist = service.search(dto);
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
		return "paidServiceList";
	}

}
