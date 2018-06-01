package ar.com.sourcesistemas.dto;

import java.util.List;

public class CheckDTO {

	private List<ProductDTO> productsDTO;
	private boolean postNet;

	public List<ProductDTO> getProductsDTO() {
		return productsDTO;
	}

	public void setProductsDTO(List<ProductDTO> productsDTO) {
		this.productsDTO = productsDTO;
	}

	public boolean isPostNet() {
		return postNet;
	}

	public void setPostNet(boolean postNet) {
		this.postNet = postNet;
	}

	@Override
	public String toString() {
		StringBuilder productString = new StringBuilder();
		productsDTO.forEach((product) -> {

			productString.append("name: ").append(product.getName()).append(" price: ").append(product.getPrice())
					.append(" qty: ").append(product.getQty());

		});
		return new StringBuilder().append("postNet: ").append(postNet).append(" products: ").append(productString)
				.toString();

	}
}
