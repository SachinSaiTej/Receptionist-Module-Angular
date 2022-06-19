package in.co.works.panda.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ROOM_TYPE")
@Getter
@Setter
public class RoomTypeDTO extends BaseDTO {
	
	
	@Column(name="TITLE", length = 225)
	private String title;
	@Column(name="slug", length = 225)
	private String slug;
	@Column(name="SORT_CODE", length = 225)
	private String shortCode;
	@Column(name="DESCRIPTION", length = 225)
	private String description;
	@Column(name="BASE_OCCUPANCY", length = 225)
	private String baseOccupancy;
	@Column(name="HIGHR_OCCUPANCY", length = 225)
	private String higherOccupancy;
	@Column(name="EXTRA_BAD", length = 225)
	private String extraBad;
	@Column(name="KID_OCCUPANCY", length = 225)
	private String kidOccupancy;
	@Column(name="AMENITIES", length = 225)
	private String amenities;
	@Column(name="BASE_PRICE", length = 225)
	private String basePrice;
	@Column(name="ADDI_PERSON_PRICE", length = 225)
	private String additionalPersionPrice;
	@Column(name="EXTRA_BAD_PRICE", length = 225)
	private String extraBedPrice;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "roomType")
	private Set<RoomDTO> rooms;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "roomType")
	private Set<PriceManagerDTO> priceManagers;
	

	

	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return title;
	}

}
