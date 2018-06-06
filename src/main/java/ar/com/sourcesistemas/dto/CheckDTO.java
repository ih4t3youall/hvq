package ar.com.sourcesistemas.dto;

import java.util.List;

public class CheckDTO {

	private List<ProductDTO> productsDTO;
	private String payWith;

	public List<ProductDTO> getProductsDTO() {
		return productsDTO;
	}

	public void setProductsDTO(List<ProductDTO> productsDTO) {
		this.productsDTO = productsDTO;
	}

	public String getPayWith() {
		return payWith;
	}

	public void setPayWith(String payWith) {
		this.payWith = payWith;
	}

	@Override
	public String toString() {
		StringBuilder productString = new StringBuilder();
		productsDTO.forEach((product) -> {

			productString.append("name: ").append(product.getName()).append(" price: ").append(product.getPrice())
					.append(" qty: ").append(product.getQty());

		});
		return new StringBuilder().append("payWith: ").append(payWith).append(" products: ").append(productString)
				.toString();

	}
}
