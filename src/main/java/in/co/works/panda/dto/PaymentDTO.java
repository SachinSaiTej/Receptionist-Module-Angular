package in.co.works.panda.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="PAYMENT")
@Getter
@Setter
public class PaymentDTO extends BaseDTO {
	
	@Column(name="GUEST_ID")
	private long guestId;
	@Column(name="GUEST_NAME",length = 225)
	private String guestName;
	@Column(name="DATE")
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(name="AMOUNT",length = 225)
	private String amount;
	@Column(name="INVOICE_NUMBER")
	private long invoiceNumber;

	@Override
	public String getKey() {
		return null;
	}

	@Override
	public String getValue() {
		return null;
	}

}
