import { navigate } from '../main.js';

export function init() {
    const app = document.getElementById('app');
    app.innerHTML = `
        <div class="black-container">
            
            <div class="home-text-section">
                <h2>Welcome_to_BitByBid</h2>
                <p>
                    Complete the form with your requirements for a Request for Proposal (RFP),
                    and receive a professionally formatted PDF document — ready to send to your clients.
                </p>
                <button id="homeSubmitBtn" type="button" class="btn btn-outline-secondary mt-3">Submit your form!</button>
            </div>
<div class="home-image-section">
                <img src="assets/logo.png" alt="BitByBid Visual" class="hero-image" />
            </div>
        </div>
    `;

    const btn = document.getElementById('homeSubmitBtn');
    if (btn) {
        btn.addEventListener('click', () => {
            navigate('/form');
        });
    }
}
