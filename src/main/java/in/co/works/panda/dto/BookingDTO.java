package in.co.works.panda.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="BOOKING")
@Getter
@Setter
public class BookingDTO extends BaseDTO {
	
	
	@Column(name="BOOKING_NUMBER",length = 225)
	private String bookingNumber;
	
	@Column(name="CHECK_IN")
	@Temporal(TemporalType.DATE)
	private Date checkIn;
	
	@Column(name="CHECK_OUT")
	@Temporal(TemporalType.DATE)
	private Date checkOut;
	
	@Column(name="BOOKING_DATE")
	@Temporal(TemporalType.DATE)
	private Date bookingDate;
	
	@Column(name="PAYMENT_STATUS",length = 225)
	private String paymentStatus;
	
	@Column(name="BOOKING_STATUS",length = 225)
	private String bookingStatus;
	
	@Column(name="ADULT",length = 225)
	private String adult;
	
	@Column(name="KIDS",length = 225)
	private String kids;
	
	@Column(name="ROOM_TYPE_NAME",length = 225)
	private String roomTypeName;
	@Column(name="GUEST_NAME",length = 225)
	private String guestName;
	
	@Column(name="GUEST_ID")
	private long guestId;
	@Column(name="ROOM_TYPE_ID",length = 225)
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
