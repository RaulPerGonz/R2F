

const toggle = document.querySelector('.toggle');
const menu = document.querySelector('.menu');
const nav = document.querySelector('nav');
toggle.addEventListener('click', () => {
  menu.classList.toggle('active');
});
toggle.addEventListener('click', () => {
    nav.classList.toggle('active');
  });