
function User(username, password, firstName, lastName) {
  this.username = username;
  this.password = password;
  this.firstName = firstName;
  this.lastName = lastName;

  this.setUsername = setUsername;
  this.getUsername = getUsername;

  this.setPassword = setPassword;
  this.getPassword = getPassword;

  this.setFirstname = setFirstname;
  this.getFirstname = getFirstname;

  this.setLastname = setLastname;
  this.getLastname = getLastname;

  function setUsername(username) {
    this.username = username;
  }
  function getUsername() {
    return this.username;
  }
  
  function setPassword(password) {
    this.password = password;
  }
  function getPassword() {
    return this.password;
  }

  function setFirstname(firstName) {
    this.firstName = firstName;
  }
  function getFirstname() {
    return this.firstName;
  }

  function setLastname(lastName) {
    this.lastName = lastName;
  }
  function getLastname() {
    return this.lastName;
  }
}  
