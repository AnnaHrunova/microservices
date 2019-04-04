$('#btnCreateUser').click(function() {
    window.location='createUser.html'
    newUser();
    return false;
});

$('#btnAllUsers').click(function() {
    window.location='allUsers.html'
    return false;
});

function newUser() {
    currentUser = {};
    renderDetails(currentUser); // Display empty form
}