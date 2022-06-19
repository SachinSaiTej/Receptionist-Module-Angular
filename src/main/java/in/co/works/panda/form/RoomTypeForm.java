package in.co.works.panda.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.NotBlank;

import in.co.works.panda.dto.BaseDTO;
import in.co.works.panda.dto.RoomTypeDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomTypeForm extends BaseForm {

	@NotEmpty(message = "Title is Required")
	private String title;
	@NotEmpty(message = "Slug is Required")
	private String slug;
	@NotEmpty(message = "Sort Code is Required")
	private String shortCode;
	@NotEmpty(message = "Description is Required")
	private String description;
	@NotEmpty(message = "Base Occupancy is Required")
	private String baseOccupancy;
	@NotEmpty(message = "Higher Occupancy is Required")
	private String higherOccupancy;
	@NotEmpty(message = "Extra Bad is Required")
	private String extraBad;
	@NotEmpty(message = "Kid Ocuupancy is Required")
	private String kidOccupancy;
	@NotEmpty(message = "Amenities is Required")
	private String amenities;
	@NotEmpty(message = "Base Price is Required")
	private String basePrice;
	@NotEmpty(message = "Additional Person Price is Required")
	private String additionalPersionPrice;
	@NotEmpty(message = "Extra Bed Price is Required")
	private String extraBedPrice;

	@Override
	public BaseDTO getDTO() {
		RoomTypeDTO bean = new RoomTypeDTO();
		bean.setId(id);
		bean.setTitle(title);
		bean.setSlug(slug);
		bean.setShortCode(shortCode);
		bean.setDescription(description);
		bean.setBaseOccupancy(baseOccupancy);
		bean.setHigherOccupancy(higherOccupancy);
		bean.setExtraBad(extraBad);
		bean.setKidOccupancy(kidOccupancy);
		bean.setAmenities(amenities);
		bean.setBasePrice(basePrice);
		bean.setAdditionalPersionPrice(additionalPersionPrice);
		bean.setExtraBedPrice(extraBedPrice);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		RoomTypeDTO bean=(RoomTypeDTO)bDto;
		id=bean.getId();
		title=bean.getTitle();
		slug=bean.getSlug();
		shortCode=bean.getShortCode();
		description=bean.getDescription();
		baseOccupancy=bean.getBaseOccupancy();
		higherOccupancy=bean.getHigherOccupancy();
		extraBad=bean.getExtraBad();
		kidOccupancy=bean.getKidOccupancy();
		amenities=bean.getAmenities();
		basePrice=bean.getBasePrice();
		additionalPersionPrice=bean.getAdditionalPersionPrice();
		extraBedPrice=bean.getExtraBedPrice();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();

	}

}
