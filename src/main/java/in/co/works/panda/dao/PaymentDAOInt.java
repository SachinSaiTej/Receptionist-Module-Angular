package in.co.works.panda.dao;

import java.util.List;

import in.co.works.panda.dto.PaymentDTO;



public interface PaymentDAOInt {

	public long add(PaymentDTO dto);
	
	public void delete(PaymentDTO dto);
	
	public PaymentDTO findBypk(long pk);
	
	public PaymentDTO findByName(String name);
	
	public long getTotalAmount();
	
	public void update(PaymentDTO dto);
	
	public List<PaymentDTO> list();
	
	public List<PaymentDTO>list(int pageNo,int pageSize);
	
	public List<PaymentDTO> search(PaymentDTO dto);
	
	public List<PaymentDTO> search(PaymentDTO dto,int pageNo,int pageSize);
	
}
