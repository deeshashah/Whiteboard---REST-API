function AdminUserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.url = 'https://webdev-deesha-shah-server-java.herokuapp.com/';
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

        xhr.open("POST", this.url);
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
    function findUserById(userId, callback) {
        return fetch(this.url+userId)
              .then(function(response){
                  return response.json();
              });
    }
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

        xhr.open("PUT", this.url+userId);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.setRequestHeader("cache-control", "no-cache");
        xhr.setRequestHeader("Postman-Token", "018a6d42-90c5-4208-9338-6756d69a7718");

        xhr.send(data);

      });
      return promise;

      
    }
    
    function deleteUser(userId, callback) {
      const promise = new Promise((resolve, reject) => {

        var data = JSON.stringify(false);

        var xhr = new XMLHttpRequest();
        xhr.withCredentials = true;

        xhr.addEventListener("readystatechange", function () {
          if (this.readyState === 4) {
            console.log(this.responseText);
          }
        });

        xhr.open("DELETE", this.url+userId);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.setRequestHeader("cache-control", "no-cache");
        xhr.setRequestHeader("Postman-Token", "fce7c71c-a6c8-43cb-a82c-71c7ef00f2e4");

        xhr.send(data);
        });
        return promise;
    }
}