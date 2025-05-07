// mainController.js

import { renderHomePage } from './homeController.js';
import { renderFormPage } from './formController.js';
import { renderContactPage } from './contactController.js';
import { renderAboutPage } from './aboutController.js';

export function init() {
    const app = document.getElementById('app');
    
    // Renderiza a página inicial
    app.innerHTML = renderHomePage();
    
    // Definir eventos de navegação
    document.getElementById('toFormPage').addEventListener('click', () => {
        renderFormPage();
    });
    document.getElementById('toContactPage').addEventListener('click', () => {
        renderContactPage();
    });
    document.getElementById('toAboutPage').addEventListener('click', () => {
        renderAboutPage();
    });
}
