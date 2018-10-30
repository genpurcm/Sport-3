    $(document).ready(function() {
  // executes when HTML-Document is loaded and DOM is ready

  // There is a little gap below the button so if you didn't have the timeout function delay it would remove the open class before you actually stop hovering the component.

  //sets timer variable
  var timer;

  // when the button and button menu are hovered
  $('.dropdown button, .dropdown-menu').hover(function() {

    // Clears the time on hover to prevent a que or waiting for the delay to finish from a previous hover event
    clearTimeout(timer);
    // Add the class .open and show the menu
//    $(this).addClass('open');
    $('.dropdown').addClass('show');
    $('.dropdown-menu').addClass('show');
//    document.getElementById("dropdownMenuButton").setAttribute('aria-expanded', 'true')

  }, function() {

    // Sets the timer variable to run the timeout delay
    timer = setTimeout(function() {
      // remove the class .open and hide the submenu
      $('.dropdown' ).removeClass('show');
      $('.dropdown-menu').removeClass('show');
//      document.getElementById("dropdownMenuButton").setAttribute('aria-expanded', 'false')
    }, 500);

  });

  // document ready
});
