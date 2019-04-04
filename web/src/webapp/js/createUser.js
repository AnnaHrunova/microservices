var rootURL = "http://localhost:8089";


$('#btnSave').click(function() {
    addUser();
    return false;
});

function formToJSON() {
    var jjson = JSON.stringify({
        "user": {
            "name": $('#userName').val(),
            "age": $('#userAge').val()
        },

        "items": [$('#itemName').val(), $('#itemName2').val()]
    });
    console.log(jjson);
    return jjson;
}

function addUser() {
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: rootURL + "/create-user-with-items",
        dataType: "json",
        data: formToJSON(),
        success: function(data, textStatus, jqXHR){
            alert('User created successfully');
            // $('#btnDelete').show();
            // $('#userId').val(data.id);
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('Some error happened');
        }

    });
}