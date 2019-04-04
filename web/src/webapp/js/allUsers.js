var rootURL = "http://localhost:8089";
var currentUser;

findAllUsers();




function findAllUsers() {
    console.log('findAll');
    $.ajax({
        type: 'GET',
        url: rootURL + '/get-users-with-items',
        dataType: 'json',
        error: function (xhr, status) {
            alert(status);
        } ,
        success: renderUsersList
    });
}

function renderUsersList(data) {
    var list = data == null ? [] : (data instanceof Array ? data : [data]);
    var html = '<table border="1">' +
        '           <tr>' +
        '               <td>' + 'id' + '</td>' +
        '               <td>' + 'name' + '</td>' +
        '               <td>' + 'age' + '</td>' +
        '               <td>' + 'port' + '</td>' +
        '               <td>' + 'message' + '</td>' +
        '               <td>' + 'items' + '</td>' +
        '           </tr>';

    $.each(list, function(index, userWithItem) {
        var items = userWithItem.items == null ? [] : (userWithItem.items instanceof Array ? userWithItem.items : [userWithItem.items]);
        html += '<tr>';
        html += '<td>' + userWithItem.user.id + '</td>';
        html += '<td>' + userWithItem.user.name + '</td>';
        html += '<td>' + userWithItem.user.age + '</td>';
        html += '<td>' + userWithItem.user.currentPort + '</td>';
        html += '<td>' + userWithItem.user.message + '</td>';
        html += '<td>' + extractItems(items) + '</td>';
        html += '</tr>';

    });
    html += '</table>';
    $('#usersList').append(html);


    function extractItems(data) {
        var list = data == null ? [] : (data instanceof Array ? data : [data]);
        var result = '';
        $.each(list, function(index, i) {
            result += '<p>' + index + ': ' + i.name  + '</p>'
        });
        return result;
    }
}