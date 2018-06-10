function facturar() {

	if ($(".productRow").length == 0) {

		$.alert({
			backgroundDismiss : true,
			content : 'No Hay ningun producto!',
		});
	} else {
		cashDebit();
	}
}

function doCheck(payWith) {
	var productDTO = [];
	$('.productRow').each(function(index, item) {
		var product = new Object();
		product.price = $(item).find('.price').html();
		product.name = $(item).find('.name').html();
		product.qty = $(item).find('.qty').html();
		productDTO.push(product);
	});

	var checkDTO = new Object();
	checkDTO.payWith = payWith;
	checkDTO.productsDTO = productDTO;
	$.ajax({
		type : "POST",
		url : "doCheck.htm",
		data : JSON.stringify(checkDTO),
		contentType : "application/json",
		success : function(response) {
			console.log(response);
			window.location.replace("getCheck");
		},
		error : function(e) {
			console.log(e);
		}
	});
}

function cashDebit() {
	$.confirm({
		title : 'Confirmacion!',
		content : 'Seleccione con que abonar!',
		backgroundDismissAnimation : 'glow',
		buttons : {
			Debito : function() {
				doCheck("debito");
			},
			Efectivo : function() {
				doCheck("efectivo");
			},
			Credito : function() {
				doCheck("credito");
			},
			Cancelar : function() {

			}
		}
	});
}
