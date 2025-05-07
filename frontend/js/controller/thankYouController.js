import { navigate } from '../main.js';

export function init() {
    const app = document.getElementById('app');
    const id = localStorage.getItem('submittedRfpId');

    app.innerHTML = `
        <div class="black-container">
            <div class="home-text-section">
                <h2 class="thank-title">Thank you for submitting your RFP!</h2>
                <p class="thank-description">
                    Your submission has been successfully saved. You can now download a ready-to-send PDF version of your RFP.
                </p>
                <div class="thank-buttons">
                    <button id="exportPdfBtn" class="export-pdf-btn">Export PDF</button>
                    <button id="backHomeBtn" class="back-home-btn">Back to Home</button>
                </div>
            </div>
        </div>
    `;

    document.getElementById('exportPdfBtn').addEventListener('click', () => {
        if (id) {
            window.open(`http://ec2-13-60-169-55.eu-north-1.compute.amazonaws.com:8080/api/rfp/export-pdf?ids=${id}`, '_blank');

        } else {
            alert("No submission ID found.");
        }
    });

    document.getElementById('backHomeBtn').addEventListener('click', () => {
        navigate('/');
    });
}
