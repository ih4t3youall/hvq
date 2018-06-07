function calculateTotal() {
		var calculation = 0;
		$(".total").each(function(index, item) {

			calculation = +calculation + +item.innerHTML;

		});
		$("#total").empty("");
		$("#total").append(calculation);

	}


function agregarProduct() {
	var expense = new Object();
	expense.name = $('#myInput').val();
	expense.price = $("#price").val();
	expense.qty = $("#quantity").val();
	expense.total = expense.qty * expense.price;
	if (expense.name != null && expense.name != "") {
		addExpense(expense);
	}

}


function addExpense(expense) {
	$("#productList").append(generateExpenseHtml(expense));
	calculateTotal();
}

function generateExpenseHtml(expense) {

	return '<tr class="productRow"><th scope="row">'
			.concat($('tr').length)
			.concat('</th>')
			.concat('<td class="name">')
			.concat(expense.name)
			.concat('</td>')
			.concat('<td class="price">')
			.concat(expense.price)
			.concat('</td>')
			.concat('<td class="qty">')
			.concat(expense.qty)
			.concat('</td><td class="total">')
			.concat(expense.total)
			.concat(
					'</td><td><input class="btn btn-md btn-danger btn-block" value="x" type="button" onClick="confirmDeleteRow(this)"/></td></td></tr>');
}

function deleteRow(something) {
	other = $(something).closest('tr').remove();
	calculateTotal();

}

function confirmDeleteRow(row) {
	$.confirm({
		title : 'Confirmar!',
		animationBounce : 2.5,
		backgroundDismissAnimation : 'glow',
		content : 'Desea eliminar?',
		buttons : {
			borrar : function() {
				deleteRow(row);
			},
			cancel : function() {
				$.alert('Cancelado!');
			},
			edit : function() {
				$.alert('Editado!');

			}
		}
	});
}
