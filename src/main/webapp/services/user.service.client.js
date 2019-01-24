function AdminUserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.url = 'http://localhost:8080/api/user';
    var self = this;
    function createUser(user, callback) {
        const promise = new Promise((resolve, reject) => {
        var data = JSON.stringify(user);

        var xhr = new XMLHttpRequest();
        xhr.withCredentials = true;

        xhr.addEventListener("readystatechange", function () {
          if (this.readyState === 4) {
            console.log(this.responseText);
          }
        });

        xhr.open("POST", "http://localhost:8080/api/user");
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.setRequestHeader("cache-control", "no-cache");
        xhr.setRequestHeader("Postman-Token", "695905c2-3b79-4776-a861-e343f39483a9");

        xhr.send(data);
        });
        return promise;
    }

    function findAllUsers() {
        return fetch(this.url)
            .then(function(response) {
                return response.json();
            });
    }
    function findUserById(userId, callback) { }
    function updateUser(userId, user, callback) {
      const promise = new Promise((resolve, reject) => {
        var data = JSON.stringify(user);

        var xhr = new XMLHttpRequest();
        xhr.withCredentials = true;

        xhr.addEventListener("readystatechange", function () {
          if (this.readyState === 4) {
            console.log(this.responseText);
          }
        });

        xhr.open("PUT", "http://localhost:8080/api/user/"+userId);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.setRequestHeader("cache-control", "no-cache");
        xhr.setRequestHeader("Postman-Token", "7ca1de74-f86f-4d5e-813d-e2b7611079af");

        xhr.send(data);

      });
      return promise;

      
    }
    function deleteUser(userId, callback) { }
}