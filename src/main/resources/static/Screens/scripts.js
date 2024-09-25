document.querySelectorAll('.icon').forEach(icon => {
    icon.addEventListener('click', function() {
      document.querySelectorAll('.icon').forEach(el => el.classList.remove('active'));
      this.classList.add('active');
    });
  });
  function toggleDropdown() {
    const dropdownMenu = document.getElementById("dropdownMenu");
    dropdownMenu.classList.toggle("show");
}

// Close the dropdown if clicked outside
window.onclick = function(event) {
  if (!event.target.matches('.dropdown-icon')) {
    const dropdowns = document.getElementsByClassName("dropdown-menu");
    for (let i = 0; i < dropdowns.length; i++) {
      const openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
