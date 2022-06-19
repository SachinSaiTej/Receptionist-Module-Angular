package in.co.works.panda.service;

import java.util.List;

import in.co.works.panda.dto.PaymentDTO;
import in.co.works.panda.exception.DuplicateRecordException;


public interface PaymentServiceInt {

	public long add(PaymentDTO dto) throws DuplicateRecordException;

	public void delete(PaymentDTO dto);

	public PaymentDTO findBypk(long pk);

	public PaymentDTO findByName(String name);
	
	public long getTotalAmount();

	public void update(PaymentDTO dto) throws DuplicateRecordException;

	public List<PaymentDTO> list();

	public List<PaymentDTO> list(int pageNo, int pageSize);

	public List<PaymentDTO> search(PaymentDTO dto);

	public List<PaymentDTO> search(PaymentDTO dto, int pageNo, int pageSize);

}
