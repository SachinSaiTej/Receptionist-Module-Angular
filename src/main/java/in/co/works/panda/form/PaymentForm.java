package in.co.works.panda.form;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import in.co.works.panda.dto.BaseDTO;
import in.co.works.panda.dto.BookingDTO;
import in.co.works.panda.dto.PaymentDTO;
import in.co.works.panda.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentForm extends BaseForm {
	
	private long guestId;
	private String guestName;
	private String date;
	private String amount;
	private long invoiceNumber;
	
	

	@Override
	public BaseDTO getDTO() {
		PaymentDTO bean=new PaymentDTO();
			bean.setId(id);
			bean.setGuestId(guestId);
			bean.setGuestName(guestName);
			bean.setDate(DataUtility.getDate(date));
			bean.setAmount(amount);
			bean.setInvoiceNumber(invoiceNumber);
			bean.setCreatedBy(createdBy);
			bean.setModifiedBy(modifiedBy);
			bean.setCreatedDatetime(createdDateTime);
			bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		PaymentDTO bean=(PaymentDTO)bDto;
		id=bean.getId();
		guestId=bean.getGuestId();
		guestName=bean.getGuestName();
		date=DataUtility.getDateString(bean.getDate());
		amount=bean.getAmount();
		invoiceNumber=bean.getInvoiceNumber();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
