package in.co.works.panda.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="priceManager")
public class PriceManagerDTO extends BaseDTO {
	
	@ManyToOne
	@JoinColumn(name="ROOM_TYPE",nullable = false)
	private RoomTypeDTO roomType;
	
	@Column(name="SUNDAY_PRICE",length = 225)
	private String sun;
	@Column(name="MONDAY_PRICE",length = 225)
	private String mon;
	@Column(name="TUESDAY_PRICE",length = 225)
	private String tues;
	@Column(name="WEDNESDAY_PRICE",length = 225)
	private String wed;
	@Column(name="THUSDAY_PRICE",length = 225)
	private String thus;
	@Column(name="FRIDAY_PRICE",length = 225)
	private String fri;
	@Column(name="SATURDAY_PRICE",length = 225)
	private String sat;
	
	@Column(name="room_type_id")
	private long roomTypeId;
	
	
	@Override
	public String getKey() {
		return null;
	}

	@Override
	public String getValue() {
		return null;
	}

}
