// form/formHandler.js
import { validateFormData } from './formValidator.js';

export function initForm() {
    const form = document.getElementById('rfp-form');
    form.addEventListener('submit', handleFormSubmit);
}

async function handleFormSubmit(event) {
    event.preventDefault();

    const form = event.target;
    const formData = new FormData(form);
    const data = Object.fromEntries(formData.entries());

    clearMessages();

    // Use external validator
    const errors = validateFormData(data);
    if (errors.length > 0) {
        showError(errors.join(' '));
        return;
    }

    try {
        const response = await fetch('http://ec2-13-60-169-55.eu-north-1.compute.amazonaws.com:8080/api/rfp', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (!response.ok) {
            const error = await response.text();
            throw new Error(error || 'Something went wrong.');
        }

        showSuccess('RFP submitted successfully!');
        form.reset();

    } catch (err) {
        showError(`Error: ${err.message}`);
    }
}

function showError(message) {
    const form = document.getElementById('rfp-form');
    const errorDiv = document.createElement('div');
    errorDiv.className = 'form-error';
    errorDiv.style.color = 'red';
    errorDiv.textContent = message;
    form.appendChild(errorDiv);
}

function showSuccess(message) {
    const form = document.getElementById('rfp-form');
    const successDiv = document.createElement('div');
    successDiv.className = 'form-success';
    successDiv.style.color = 'green';
    successDiv.textContent = message;
    form.appendChild(successDiv);
}

function clearMessages() {
    document.querySelectorAll('.form-error, .form-success').forEach(el => el.remove());
}
