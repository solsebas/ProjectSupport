// When the user scrolls down 80px from the top of the document, resize the navbar's padding and the logo's font size
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
  if (document.body.scrollTop > 80 || document.documentElement.scrollTop > 80) {
    document.getElementById("logo").style.width = "3vw";
    document.getElementById("logo-text").style.fontSize = "0px";
    document.getElementById("navbar").style.padding = "0px";
    document.getElementById("side-navbar-button").style.width = "2.2vw";
    document.getElementById("side-navbar-button").style.height = "2.2vw";
  } else {

    if (window.innerWidth>610) {
      document.getElementById("logo").style.width = "5vw";
      document.getElementById("logo-text").style.fontSize = "3.5vw";
    } else {
      document.getElementById("logo").style.width = "5vw";
      document.getElementById("logo-text").style.fontSize = "0px";
    }

    document.getElementById("navbar").style.padding = "10px";
    document.getElementById("side-navbar-button").style.width = "3.5vw";
    document.getElementById("side-navbar-button").style.height = "3vw";
  }

}

window.onload = function() {colapse()};

function colapse() {
  if (document.getElementById("sideNavbar").style.display === "none") {
    document.getElementById("sideNavbar").style.display = "block";
  } else {
    document.getElementById("sideNavbar").style.display = "none";
  }
}

