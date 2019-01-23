(function () {
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $userRowTemplate, $tbody;
    var userService = new AdminUserServiceClient();
    var $i = 0;
    $(main);

    function main() {
        $usernameFld = $("#usernameFld");
        $passwordFld = $("#passwordFld");
        $firstNameFld = $("#firstNameFld");
        $lastNameFld = $("#lastNameFld");
        $roleFld = $("#roleFld")
        $userRowTemplate = $(".wbdv-template");
        $tbody = $("tbody");
        
        $usernameFld.val("alice");
        
        userService
            .findAllUsers()
            .then(renderUsers);

        $(".wbdv-create").click(function(){
            var data = createUser();
            userService.createUser(data);
        });
    }


    function createUser() {
        $usernameFld = $("#usernameFld").val();
        $passwordFld = $("#passwordFld").val();
        $firstNameFld = $("#firstNameFld").val();
        $lastNameFld = $("#lastNameFld").val();
        $lastNameFld = $("#lastNameFld").val();
        $roleFld = $("#roleFld option:selected").text();
        $idFld = $i;
        var data =  {
            "id" : $i++,
            "username": $usernameFld,
            "firstName": $firstNameFld,
            "lastName" : $lastNameFld,
            "role" : $roleFld,
        }
        return data;
    }

    function findAllUsers() { }
    function findUserById() { }
    function deleteUser() { }
    function selectUser() { }
    function updateUser() { }
    function renderUser(user) {  }
    function renderUsers(users) {
        for(var u=0; u<users.length; u++) {
            console.log(users[u]);
            var clone = $userRowTemplate.clone();
            clone.find(".wbdv-username").html(users[u].username);
            clone.find(".wbdv-first-name").html(users[u].firstName);
            clone.find(".wbdv-last-name").html(users[u].lastName);
            clone.find(".wbdv-role").html(users[u].role);
            $tbody.append(clone);
        }
    }
})();
