$(document).ready(function() {
    if (localStorage.getItem('status') === 'success') {
       $("#validation-success").fadeIn(3000).fadeOut(3000);
        localStorage.setItem('status', '');
    };
    $.getJSON("/api/store", function(data, status) {
        $.each(data, function(i, item) {
            $tdForCheckbox = $('<td>').append(
                $('<input>', {
                    class: "w3-check",
                    type: "checkbox"
                }));
            var $tr = $('<tr class="store-row store-row-' + item.id + '">').append(
                $tdForCheckbox,
                $('<td id="productId">').text(item.product_id),
                $('<td id="availableQty">').text(item.available_qty),
                $('<td id="bookedQty">').text(item.booked_qty),
                $('<td id="soldQty">').text(item.sold_qty)
            ).appendTo('#stores');
        });
    });

    $("#add-store").click(function() {
        var body = validateForm();

        if (body) {
            return $.ajax({
                type: 'POST',
                url: '/api/store',
                data: JSON.stringify(body),
                success: function(data) {
                    localStorage.setItem('status', 'success');
                    location.reload();

                },
                error: function(jqXHR, textStatus, errorThrown) {
                    showError(jqXHR.responseJSON.message, jqXHR.responseText);
                },
                contentType: "application/json",
                dataType: 'json'
            });
        }
    });

    $('#delete-store').on('click', function() {
        var stories = getSelectedStories();

        $.ajax({
                type: 'DELETE',
                url: '/api/store',
                data: JSON.stringify(stories),
                success: function(data) {
                    $("#validation-success").fadeIn(3000).fadeOut(3000);
                    $.each(stories, function(i, row) {
                        var rowToDelete = $(".store-row-" + row.jiraId);
                        rowToDelete.remove();
                    });
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    showError(jqXHR.responseJSON.message, jqXHR.responseText);
                },
                contentType: "application/json",
                dataType: 'json'
            });
    });
});

function validateForm() {
    var body = {
        productId: $("#productId-input").val(),
        availableQty: $("#available-input").val(),
        bookedQty: $("#booked-input").val(),
        soldQty: $("#sold-input").val()
    };
    if (body.productId == "" || body.availableQty == "" || body.bookedQty == "" || body.soldQty) {
        showError('Please fill all fields', 'All fields must pe populated');
        return false;
    }
    return body;
}

function getSelectedStories() {
    var selected = [];
    $("tr.store-row").each(function() {
        $this = $(this);
        var isSelected = $this.find(".w3-check").is(':checked');
        if (isSelected) {
            var body = {
                productId: $this.find("#productId").val(),
                availableQty: $this.find("#availableQty").val()
             };
            selected.push(body);
        }
    });
    return selected;
}