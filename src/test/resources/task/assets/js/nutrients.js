var xml = $.parseXML("<nutrients></nutrients>");
var isEditing = false;
var editRowIndex = -1;

$(xml).find('nutrients').append("<nutrient><name>Protein</name><value>0.45</value></nutrient>");

jQuery(document).ready(function() {
	
	loadNutrientDetails($(xml));

	$('#addNutrientModal button').eq(1).on('click', function(e) { 
	
		var name = $('#nutrients-form input').eq(0).val();
		var value = $('#nutrients-form input').eq(1).val();
	
		if (isEditing)
		{
			$(xml).find('nutrient').eq(editRowIndex).find('name').text(name);
			$(xml).find('nutrient').eq(editRowIndex).find('value').text(value);
			
			isEditing = false;
		}
		else
		{
			$(xml).find('nutrients').append("<nutrient><name>" + name + "</name><value>" + value + "</value></nutrient>");
		}
		
		loadNutrientDetails($(xml));
		
		$('#nutrients-form input').eq(0).val('');
		$('#nutrients-form input').eq(1).val('');
	});
});

function loadNutrientDetails(xml) {

	$('#nutrient-table tbody').html('');
	
	
	$(xml).find('nutrient').each(function() {
		
		var name = $(this).find('name').text();
		var value = $(this).find('value').text();
	
	
	
		var html = '<tr><td>1</td><td>' + name + '</td><td>' + value + '</td><td>' + '</td><td><span id="btnDelete" class="glyphicon glyphicon-remove" onclick="removeRow(this)" title="Delete"></span><span id="btnEdit" class="glyphicon glyphicon-wrench" onclick="editRow(this)" title="Edit"></span></td></tr>';
		
		$('#nutrient-table').append(html);
		
		
	});

}

function removeRow(r) {
	var opts = {
	  lines: 13 // The number of lines to draw
	, length: 28 // The length of each line
	, width: 14 // The line thickness
	, radius: 42 // The radius of the inner circle
	, scale: 1 // Scales overall size of the spinner
	, corners: 1 // Corner roundness (0..1)
	, color: '#000' // #rgb or #rrggbb or array of colors
	, opacity: 0.25 // Opacity of the lines
	, rotate: 0 // The rotation offset
	, direction: 1 // 1: clockwise, -1: counterclockwise
	, speed: 1 // Rounds per second
	, trail: 60 // Afterglow percentage
	, fps: 20 // Frames per second when using setTimeout() as a fallback for CSS
	, zIndex: 2e9 // The z-index (defaults to 2000000000)
	, className: 'spinner' // The CSS class to assign to the spinner
	, top: '50%' // Top position relative to parent
	, left: '50%' // Left position relative to parent
	, shadow: false // Whether to render a shadow
	, hwaccel: false // Whether to use hardware acceleration
	, position: 'absolute' // Element positioning
	}
	var target = document.getElementById('nutrient-table')
	var spinner = new Spinner(opts).spin(target);
	setTimeout(function(){
	var i = r.parentNode.parentNode.rowIndex;
	document.getElementById("nutrient-table").deleteRow(i);
	removeFromXml(i - 1);
	spinner.stop();
	}, 3000);
}

function editRow(r) {
	isEditing = true;
	editRowIndex = r.parentNode.parentNode.rowIndex - 1;
	
	var name = $(xml).find('nutrient').eq(editRowIndex).find('name').text();
	var value = $(xml).find('nutrient').eq(editRowIndex).find('value').text();

	
	$('#nutrients-form input').eq(0).val(name);
	$('#nutrients-form input').eq(1).val(value);
	
	$('#addNutrientModal').modal('show');
}

function removeFromXml(index)
{
	$(xml).find('nutrient').eq(index).remove();
}


