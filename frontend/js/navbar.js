export function renderNavbar() {
    const navbarHTML = `
        <div class="wrapper">
            <div class="branding">
                <span id="typewriter"></span>
            </div>
            <nav class="menu">
                <a href="/" class="item" style="font-size: 1em;">Home</a>
                <a href="/form" class="item" style="font-size: 1em;">Form</a>
                <a href="/about" class="item" style="font-size: 1em;">About</a>
                <a href="/contact" class="item" style="font-size: 1em;">Contact</a>
                <a href="/submissions" class="item" style="font-size: 1em;">Submissions</a>
            </nav>
        </div>
    `;
    document.getElementById('navbar').innerHTML = navbarHTML;
    startTypewriterEffect("BitByBid.");

    // Lógica do menu hambúrguer
    const hamburger = document.getElementById('hamburger'); // fora do navbar, mas já está no DOM
    const menu = document.querySelector('.menu');

    if (hamburger && menu) {
        // Toggle do menu ao clicar
        hamburger.addEventListener('click', () => {
            menu.classList.toggle('show');
        });

        // Fecha o menu ao clicar num item
        menu.addEventListener('click', (e) => {
            if (e.target.classList.contains('item')) {
                menu.classList.remove('show');
            }
        });

        // Abrir ao passar o rato (opcional)
        hamburger.addEventListener('mouseenter', () => {
            menu.classList.add('show');
        });

        // Fechar se o rato sair da área do menu
        menu.addEventListener('mouseleave', () => {
            menu.classList.remove('show');
        });
    }
}

function startTypewriterEffect(text) {
    const element = document.getElementById("typewriter");
    let index = 0;
    let isDeleting = false;

    function type() {
        const visibleText = isDeleting ? text.substring(0, index--) : text.substring(0, index++);
        element.textContent = visibleText;

        if (!isDeleting && index === text.length + 1) {
            isDeleting = true;
            setTimeout(type, 1000);
        } else if (isDeleting && index === 0) {
            isDeleting = false;
            setTimeout(type, 500);
        } else {
            setTimeout(type, isDeleting ? 75 : 150);
        }
    }

    type();
}
