package in.co.works.panda.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import in.co.works.panda.dto.BaseDTO;
import in.co.works.panda.dto.BookingDTO;
import in.co.works.panda.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingForm extends BaseForm {
	
	@Min(value = 1,message = "Guest is required")
	private long guestId;
	@Min(value = 1,message = "Room Type is required")
	private long roomTypeId;
	@NotEmpty(message = "CheckIn Date is required")
	private String checkIn;
	@NotEmpty(message = "CheckOut Date is required")
	private String checkOut;
	@NotEmpty(message = "Adult is required")
	private String adult;
	@NotEmpty(message = "Kids is required")
	private String kids;
	
	private String bookingNumber;
	
	

	@Override
	public BaseDTO getDTO() {
		BookingDTO bean=new BookingDTO();
			bean.setId(id);
			bean.setBookingNumber(bookingNumber);
			bean.setGuestId(guestId);
			bean.setRoomTypeId(roomTypeId);
			bean.setCheckIn(DataUtility.getDate(checkIn));
			bean.setCheckOut(DataUtility.getDate(checkOut));
			bean.setAdult(adult);
			bean.setKids(kids);
			bean.setCreatedBy(createdBy);
			bean.setModifiedBy(modifiedBy);
			bean.setCreatedDatetime(createdDateTime);
			bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		BookingDTO bean=(BookingDTO)bDto;
		id=bean.getId();
		bookingNumber=bean.getBookingNumber();
		guestId=bean.getGuestId();
		roomTypeId=bean.getRoomTypeId();
		checkIn=DataUtility.getDateString(bean.getCheckIn());
		checkOut=DataUtility.getDateString(bean.getCheckOut());
		adult=bean.getAdult();
		kids=bean.getKids();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
