import { navigate } from '../main.js';

export function init() {
  const app = document.getElementById("app");
  app.innerHTML = `
   <p>&nbsp;</p>
  <div class="about-carousel-wrapper">
    <div class="carousel-track">
      <div class="carousel-slide">
        <h1 class="about-title">About BitByBid</h1>
        <p>&nbsp;</p>
        <p class="about-text">
          BitByBid is a modern platform designed to simplify and streamline the RFP (Request for Proposal) process.
        </p>
      </div>

      <div class="carousel-slide">
        <h1 class="about-title">Our Mission</h1>
        <p>&nbsp;</p>
        <p class="about-text">
          Empowering businesses with tools to manage RFP submissions seamlessly, securely, and with full traceability.
        </p>
      </div>

      <div class="carousel-slide">
        <h1 class="about-title">Meet the Team</h1>
        <p>&nbsp;</p>
        <p class="about-text">
          BitByBid is powered by a passionate group of four developers who met at the Code for All bootcamp and share the belief in simplifying complex business processes.
        </p>
      </div>
    </div>

    <div class="carousel-controls">
      <button id="prevSlide" class="carousel-btn">&#10094;</button>
      <button id="nextSlide" class="carousel-btn">&#10095;</button>
    </div>
  </div>

  <div class="social-icons">
    <!-- GitHub -->
    <div class="icon-dropdown">
      <i class="fab fa-github icon-link"></i>
      <div class="dropdown-menu">
        <a href="https://github.com/DiogoCarvalho999" target="_blank"> Diogo Carvalho</a>
        <a href="https://github.com/joanamsst" target="_blank"> Joana Sousa</a>
        <a href="https://github.com/oliveirammluis" target="_blank"> Luís Oliveira</a>
        <a href="https://github.com/raquelvencovsky" target="_blank"> Raquel Vencovsky</a>
      </div>
    </div>

    <!-- LinkedIn -->
    <div class="icon-dropdown">
      <i class="fab fa-linkedin icon-link"></i>
      <div class="dropdown-menu">
        <a href="https://linkedin.com/in/diogoadcarvalho" target="_blank"> Diogo Carvalho</a>
        <a href="https://linkedin.com/in/joana-sousa-trindade" target="_blank"> Joana Sousa</a>
        <a href="https://linkedin.com/in/oliveirammluis" target="_blank"> Luís Oliveira</a>
        <a href="https://linkedin.com/in/raquelvencovsky" target="_blank"> Raquel Vencovsky</a>
      </div>
    </div>
  </div>
  `;

  // Carrossel
  let currentSlide = 0;
  const track = document.querySelector('.carousel-track');
  const slides = document.querySelectorAll('.carousel-slide');

  function updateSlide() {
    track.style.transform = `translateX(-${currentSlide * 100}%)`;
  }

  function nextSlide() {
    currentSlide = (currentSlide + 1) % slides.length;
    updateSlide();
  }

  function prevSlide() {
    currentSlide = (currentSlide === 0) ? slides.length - 1 : currentSlide - 1;
    updateSlide();
  }

  document.getElementById('nextSlide').addEventListener('click', () => {
    nextSlide();
    resetAutoplay();
  });

  document.getElementById('prevSlide').addEventListener('click', () => {
    prevSlide();
    resetAutoplay();
  });

  let autoplayInterval = setInterval(nextSlide, 5000);

  function resetAutoplay() {
    clearInterval(autoplayInterval);
    autoplayInterval = setInterval(nextSlide, 5000);
  }

  // Swipe para dispositivos móveis
  let touchStartX = 0;
  let touchEndX = 0;

  track.addEventListener('touchstart', (e) => {
    touchStartX = e.changedTouches[0].screenX;
  });

  track.addEventListener('touchend', (e) => {
    touchEndX = e.changedTouches[0].screenX;
    handleSwipe();
  });

  function handleSwipe() {
    if (touchStartX - touchEndX > 50) {
      nextSlide();
    }
    if (touchEndX - touchStartX > 50) {
      prevSlide();
    }
  }

  // Função para mostrar/esconder o dropdown
  const dropdowns = document.querySelectorAll('.icon-dropdown');
  
  dropdowns.forEach(dropdown => {
    const icon = dropdown.querySelector('.icon-link');
    const menu = dropdown.querySelector('.dropdown-menu');

    // Mostrar menu ao passar o mouse
    icon.addEventListener('mouseover', () => {
      menu.classList.add('show'); // Torna visível
    });

    // Esconder menu quando o mouse sair
    icon.addEventListener('mouseout', () => {
      menu.classList.remove('show'); // Torna invisível
    });
  });

  // Menu hambúrguer
  const hamburgerBtn = document.getElementById("hamburger");
  const hamburgerMenu = document.getElementById("hamburgerMenu");
  const closeMenuBtn = document.getElementById("closeMenuBtn");

  hamburgerBtn.addEventListener("click", () => {
    hamburgerMenu.classList.toggle("show"); // Alterna a visibilidade
  });

  closeMenuBtn.addEventListener("click", () => {
    hamburgerMenu.classList.remove("show");
  });

  // Navegação do menu hambúrguer
  document.getElementById("menuHome").addEventListener("click", (e) => {
    e.preventDefault();
    navigate('/');
  });

  document.getElementById("menuAbout").addEventListener("click", (e) => {
    e.preventDefault();
    navigate('/about');
  });

  document.getElementById("menuForm").addEventListener("click", (e) => {
    e.preventDefault();
    navigate('/form');
  });

  // Iniciar o autoplay
  updateSlide();
}
