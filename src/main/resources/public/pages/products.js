$(document).ready(function() {
    if (localStorage.getItem('status') === 'success') {
       $("#validation-success").fadeIn(3000).fadeOut(3000);
        localStorage.setItem('status', '');
    };
    $.getJSON("/api/product", function(data, status) {
        $.each(data, function(i, item) {
            $tdForCheckbox = $('<td>').append(
                $('<input>', {
                    class: "w3-check",
                    type: "checkbox"
                }));
            var $tr = $('<tr class="product-row product-row-' + item.id + '">').append(
                $tdForCheckbox,
                $('<td id="name">').text(item.name),
                $('<td id="description">').text(item.description),
                $('<td id="author">').text(item.author),
                $('<td id="price">').text(item.price),
                $('<td id="image_path">').text(item.image_path),
            ).appendTo('#products');
        });
    });

    $("#add-product").click(function() {
        var body = validateForm();

        if (body) {
            return $.ajax({
                type: 'POST',
                url: '/api/product',
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

    $('#delete-product').on('click', function() {
        var stories = getSelectedStories();

        $.ajax({
                type: 'DELETE',
                url: '/api/product',
                data: JSON.stringify(stories),
                success: function(data) {
                    $("#validation-success").fadeIn(3000).fadeOut(3000);
                    $.each(stories, function(i, row) {
                        var rowToDelete = $(".product-row-" + row.id);
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
        name: $("#name-input").val(),
        description: $("#description-input").val()
    };
    if (body.name == "" || body.description == "") {
        showError('Please fill all fields', 'All fields must pe populated');
        return false;
    }
    return body;
}

function getSelectedStories() {
    var selected = [];
    $("tr.product-row").each(function() {
        $this = $(this);
        var isSelected = $this.find(".w3-check").is(':checked');
        if (isSelected) {
            var body = {
                name: $this.find("#name").text(),
                description: $this.find("#description").text()
             };
            selected.push(body);
        }
    });
    return selected;
}