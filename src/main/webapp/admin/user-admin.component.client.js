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
            window.location.replace("https://webdev-deesha-shah-server-java.herokuapp.com/admin/user-admin.template.client.html");
        });

        $(document).on('click', '#wbdv-edit', function(){
            var userId = $(this).closest('tr').children('td.wbdv-user-id').text();
            var username = $(this).closest('tr').children('td.wbdv-username').text();
            var password = "*****"
            var firstName = $(this).closest('tr').children('td.wbdv-first-name').text();
            var lastName = $(this).closest('tr').children('td.wbdv-last-name').text();
            var role = $(this).closest('tr').children('td.wbdv-role').text();
            
            renderUser(userId, username, password, firstName, lastName);
            

            $(".wbdv-update").click(function(){
                var data = updateUser(userId);
                userService.updateUser(userId, data);
                window.location.replace("https://webdev-deesha-shah-server-java.herokuapp.com/admin/user-admin.template.client.html");


            })

        });

        $(document).on('click', '#wbdv-remove', function(){
            var userId = $(this).closest('tr').children('td.wbdv-user-id').text();
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
        userService.deleteUser(userId);
        window.location.replace("https://webdev-deesha-shah-server-java.herokuapp.com/admin/user-admin.template.client.html");

    }


    function renderUser(id, username, password, firstName, lastName, role) { 
        $usernameFld.val(username);
        $passwordFld.val(password);
        $firstNameFld.val(firstName);
        $lastNameFld.val(lastName);
        $("#roleFld option[value="+role+"]").prop('selected', 'selected');


    }

    function updateUser(userId) {
        $usernameFld = $("#usernameFld").val();
        $firstNameFld = $("#firstNameFld").val();
        $lastNameFld = $("#lastNameFld").val();
        $roleFld = $('#roleFld').val();
        var data =  {
            "id" : userId,
            "username": $usernameFld,
            "firstName": $firstNameFld,
            "lastName" : $lastNameFld,
            "role": $roleFld,
        }
        console.log("DATA: "+JSON.stringify(data));
        return data;
    }

    function search(users) {
        var filteredUsers = [];

        $usernameFld = $("#usernameFld").val();
        $firstNameFld = $("#firstNameFld").val();
        $lastNameFld = $("#lastNameFld").val();
        $roleFld = $("#roleFld option:selected").text();
        console.log($roleFld);
        for(var u=0; u<users.length; u++){
            var flag = true;
            if($usernameFld && $usernameFld!=users[u].username){
                flag = false;
                console.log("usernameFld");
            }
            if($firstNameFld && $firstNameFld!=users[u].firstName){
                flag = false;
                console.log("firstFld");
            }
            if($lastNameFld && $lastNameFld!=users[u].lastName){
                flag = false;
                console.log("lastFld");
            }
            if($roleFld){

                if($roleFld.toLowerCase()!=users[u].role.toLowerCase()){
                flag = false;
                console.log("roleFld");
                }
            }

            if(flag){
                filteredUsers.push(users[u]);
            }

        }
        console.log("Filtered" + filteredUsers);
        renderUsers(filteredUsers);
    }

    function renderUsers(users) {
        // clean previous users.
        $('.table tbody').empty(); 
        for(var u=0; u<users.length; u++) {
            var clone = $userRowTemplate.clone();
            clone.find(".wbdv-user-id").html(users[u].id).attr("id","element"+users[u].id);
            clone.find(".wbdv-username").html(users[u].username);
            clone.find(".wbdv-first-name").html(users[u].firstName);
            clone.find(".wbdv-last-name").html(users[u].lastName);
            clone.find(".wbdv-role").html(users[u].role);
            $tbody.append(clone);
        }
    }
})();
