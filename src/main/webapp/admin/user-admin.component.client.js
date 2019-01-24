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

        $(document).on('click', '#wbdv-edit', function(){
            var userId = $('#wbdv-edit').closest('tr').children('td.wbdv-user-id').text();
            var username = $('#wbdv-edit').closest('tr').children('td.wbdv-username').text();
            var password = "*****"
            var firstName = $('#wbdv-edit').closest('tr').children('td.wbdv-first-name').text();
            var lastName = $('#wbdv-edit').closest('tr').children('td.wbdv-last-name').text();
            var role = $('#wbdv-edit').closest('tr').children('td.wbdv-role').text();
            renderUser(username, password, firstName, lastName);
            

            $(".wbdv-update").click(function(){
                var data = updateUser();
                userService.updateUser(userId, data).then(renderUsers);

            })
        });

        $(document).on('click', '#wbdv-remove', function(){
            var userId = $('#wbdv-remove').closest('tr').children('td.wbdv-user-id').text();
            deleteUser(userId);
        });

        $(".wbdv-search").click(function(){
            userService
            .findAllUsers()
            .then(search);
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

    function findAllUsers() {
        userService.findAllUsers();
    }
    function findUserById() {
        userService.findUserById();
    }
    function deleteUser(userId) {

        userService.deleteUser(userId).then(renderUsers);
    }


    function renderUser(username, password, firstName, lastName, role) { 
        $usernameFld.val(username);
        $passwordFld.val(password);
        $firstNameFld.val(firstName);
        $lastNameFld.val(lastName);
        $("#roleFld option[value="+role+"]").prop('selected', 'selected');

    }

    function updateUser() {
        $usernameFld = $("#usernameFld").val();
        $firstNameFld = $("#firstNameFld").val();
        $lastNameFld = $("#lastNameFld").val();
        $idFld = $("#idFld").val();
        $roleFld = $('#roleFld').val();
        var data =  {
            "id" : $idFld,
            "username": $usernameFld,
            "firstName": $firstNameFld,
            "lastName" : $lastNameFld,
            "role": $roleFld,
        }
        console.log(data);
        return data;
    }

    function search(users) {
        $usernameFld = $("#usernameFld").val();
        $firstNameFld = $("#firstNameFld").val();
        $lastNameFld = $("#lastNameFld").val();
        $roleFld = $("#roleFld option:selected").text();
        for(var u=0; u<users.length; u++){
            if($usernameFld.length!=0 && users[u].username != $usernameFld ||
                $firstNameFld.length!=0 && users[u].firstName != $firstNameFld ||
                $lastNameFld.length!=0 && users[u].lastName != $lastNameFld ||
                $roleFld!= users[u].role){
                $(".table tr td").each(function() {
                    var cell = $.trim($(this).text());
                    if(cell == users[u].id){
                        $(this).parent().hide();
                    }
                })
            }
        }
    }

    function renderUsers(users) {
        for(var u=0; u<users.length; u++) {
            console.log(users[u]);
            var clone = $userRowTemplate.clone();
            clone.find(".wbdv-user-id").html(users[u].id);
            clone.find(".wbdv-username").html(users[u].username);
            clone.find(".wbdv-first-name").html(users[u].firstName);
            clone.find(".wbdv-last-name").html(users[u].lastName);
            clone.find(".wbdv-role").html(users[u].role);
            $tbody.append(clone);
        }
    }
})();
