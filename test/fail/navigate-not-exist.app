//Not a valid navigate link, page does not exist
application test

  entity Entity0 {
    property :: String
  }

  define page root() {
    var e := Entity0{}
    navigate(bla()){""}
  }
  
  function bla(){}