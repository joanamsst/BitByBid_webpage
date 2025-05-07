import routes from './routes.js';
import { initParticles } from './particles.js'; // ADICIONA ISTO

async function launchController(controllerName) {
  try {
    const module = await import(`./controller/${controllerName}.js`);
    module.init();
  } catch (error) {
    console.error("Error loading controller:", error);
  }
}

function setAnchorEventListener() {
  document.addEventListener('click', (e) => {
    if (e.target.tagName === 'A' && e.target.classList.contains('item')) {
      e.preventDefault();
      const path = e.target.getAttribute('href');
      navigate(path);
    }
  });
}

function setCurrentRoute({ path, controller }) {
  routes.currentPath.path = path;
  routes.currentPath.controller = controller;
}

function handlePopState({ state }) {
  const route = state || routes.home;
  setCurrentRoute(route);
  launchController(route.controller);
}

function navigate(path, firstLoad = false) {
  if (path === routes.currentPath.path) return;

  const routeKey = Object.keys(routes).find(key => routes[key].path === path);
  const route = routes[routeKey] || routes.home;

  setCurrentRoute(route);

  firstLoad
    ? history.replaceState(route, '', route.path)
    : history.pushState(route, '', route.path);

  launchController(route.controller);
}

function init() {
  const path = window.location.pathname;
  navigate(path, true);
  addEventListener('popstate', handlePopState);
  setAnchorEventListener();
}

document.addEventListener("DOMContentLoaded", () => {
  init(); // inicia a app
  initParticles(); // inicia partículas
  AOS.init(); // animações
});

document.addEventListener("DOMContentLoaded", () => {
  const hamburger = document.getElementById("hamburger");

  hamburger.addEventListener("click", () => {
      const menu = document.querySelector(".menu");
      if (menu) {
          menu.classList.toggle("show");
      }
  });
});

export { navigate };
