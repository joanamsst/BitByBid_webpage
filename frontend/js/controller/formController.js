let currentStep = 1;  // Começa no Step 1
const totalSteps = 4;  // Total de etapas
const formDataAccumulator = {}; // Objeto global para armazanar dados

export function init() {
    console.log("Form Controller Initialized");

    loadStep(currentStep);
}

// Função para carregar a página de cada step
function loadStep(step) {
    const app = document.getElementById('app');
    switch (step) {
        case 1:
            app.innerHTML = getStep1Content();
            break;
        case 2:
            app.innerHTML = getStep2Content();
            break;
        case 3:
            app.innerHTML = getStep3Content();
            break;
        case 4:
            app.innerHTML = getStep4Content();
            break;
        default:
            break;
    }
    addEventListeners();
}

// Funções para renderizar o conteúdo de cada etapa

// Step 1: Project Details
function getStep1Content() {
    return `
    <div class="container py-5">
        <div class="progress mb-4">
            <div class="progress-bar" id="progressStep1" role="progressbar" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
        </div>
            <div class="card-body">
                <h2 class="card-title text-primary mb-4">&lt;Project_details&gt;</h2>
                <form id="formStep1" class="row g-4">
                    <div class="col-md-6">
                        <label for="companyName" class="form-label">Company_name</label>
                        <input type="text" id="companyName" name="companyName" class="form-control" required>
                    </div>

                    <div class="col-md-6">
                        <label for="rfpDate" class="form-label">RFP_date</label>
                        <input type="date" id="rfpDate" name="rfpDate" class="form-control" required>
                    </div>

                    <div class="col-md-6">
                        <label for="endDate" class="form-label">End_date</label>
                        <input type="date" id="endDate" name="endDate" class="form-control" required>
                    </div>

                    <div class="col-md-6">
                        <label for="projectName" class="form-label">Project_name</label>
                        <input type="text" id="projectName" name="projectName" class="form-control" required>
                    </div>

                    <div class="col-12">
                        <label for="projectGoal" class="form-label">Project_goal</label>
                        <textarea id="projectGoal" name="projectGoal" class="form-control" rows="3" required></textarea>
                    </div>

                    <div class="col-12">
                        <label for="technicalDescription" class="form-label">Technical_description</label>
                        <textarea id="technicalDescription" name="technicalDescription" class="form-control" rows="3" required></textarea>
                    </div>

                    <div class="col-12">
                        <label for="integrationPlan" class="form-label">Integration_plan</label>
                        <textarea id="integrationPlan" name="integrationPlan" class="form-control" rows="2" required></textarea>
                    </div>

                    <div class="col-12">
                        <label for="dataSecurity" class="form-label">Data_security</label>
                        <textarea id="dataSecurity" name="dataSecurity" class="form-control" rows="2" required></textarea>
                    </div>

                    <div class="col-md-6">
                        <label for="totalPrice" class="form-label">Total_price</label>
                        <input type="number" id="totalPrice" name="totalPrice" class="form-control" required>
                    </div>

                    <div class="col-12">
                        <label for="supportWarranty" class="form-label">Support_and_warranty</label>
                        <textarea id="supportWarranty" name="supportWarranty" class="form-control" rows="2" required></textarea>
                    </div>

                    <div class="col-12 text-end mt-4">
                        <button type="button" id="nextBtn" class="btn btn-lg btn-primary px-4">Next -&gt;</button>
                    </div>
                </form>
            </div>
    </div>
    `;
}

// Step 2: Phase Details
function getStep2Content() {
    return `
    <div class="container py-5">
        <div class="progress mb-4">
            <div class="progress-bar" id="progressStep2" idrole="progressbar" style="width: 50%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
        </div>
      
            <div class="card-body">
                <h2 class="card-title text-primary mb-4">&lt;Phase_details&gt;</h2>
                <form id="formStep2" class="row g-4">
                    <div class="col-md-6">
                        <label for="phaseName" class="form-label">Phase_name</label>
                        <input type="text" id="phaseName" name="phaseName" class="form-control"  required>
                    </div>

                    <div class="col-md-6">
                        <label for="startDate" class="form-label">Start_date</label>
                        <input type="date" id="startDate" name="startDate" class="form-control" required>
                    </div>

                    <div class="col-md-6">
                        <label for="phaseEndDate" class="form-label">End_date</label>
                        <input type="date" id="phaseEndDate" name="phaseEndDate" class="form-control" required>
                    </div>

                    <div class="col-12">
                        <label for="deliverables" class="form-label">Deliverables</label>
                        <textarea id="deliverables" name="deliverables" class="form-control" rows="3" required></textarea>
                    </div>

                    <div class="col-12 d-flex justify-content-between mt-4">
                        <button type="button" id="prevBtn" class="btn btn-secondary px-4">&lt;- Previous</button>
                        <button type="button" id="nextBtn" class="btn btn-primary px-4">Next -&gt;</button>
                    </div>
                </form>
        </div>
    </div>
    `;
}

// Step 3: Certification Details
function getStep3Content() {
    return `
    <div class="container py-5">
        <div class="progress mb-4">
            <div class="progress-bar" id = "progressStep3" role="progressbar" style="width: 75%;" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
        </div>
      
            <div class="card-body">
                <h2 class="card-title text-primary mb-4">&lt;Certification_details&gt;</h2>
                <form id="formStep3" class="row g-4">
                    <div class="col-12">
                        <label for="companyCertifications" class="form-label">Company_certifications</label>
                        <input type="text" id="companyCertifications" name="companyCertifications" class="form-control" required>
                        <small class="form-text text-muted">Separate multiple certifications with commas.</small>
                    </div>

                    <div class="col-12 d-flex justify-content-between mt-4">
                        <button type="button" id="prevBtn" class="btn btn-secondary px-4">&lt;- Previous</button>
                        <button type="button" id="nextBtn" class="btn btn-primary px-4">Next -&gt;</button>
                    </div>
                </form>
            </div>
     
    </div>
    `;
}

// Step 4: Team Member and File Upload
function getStep4Content() {
    return `
    <div class="container py-5">
        <div class="progress mb-4">
            <div class="progress-bar" id = "progressStep4" role="progressbar" style="width: 100%;" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
        </div>
  
            <div class="card-body">
                <h2 class="card-title text-primary mb-4">&lt;Team_members&gt;</h2>
                <form id="formStep4" class="row g-4">
                    <div class="col-md-6">
                        <label for="memberName" class="form-label">Member_name</label>
                        <input type="text" id="memberName" name="memberName" class="form-control" required>
                    </div>

                    <div class="col-md-6">
                        <label for="role" class="form-label">Role</label>
                        <input type="text" id="role" name="role" class="form-control" required>
                    </div>

                    <div class="col-md-6">
                        <label for="specialization" class="form-label">Specialization</label>
                        <input type="text" id="specialization" name="specialization" class="form-control" required>
                    </div>

                    <div class="col-12 d-flex justify-content-between mt-4">
                        <button type="button" id="prevBtn" class="btn btn-secondary px-4">&lt- Previous</button>
                        <button type="submit" id="submitButton" class="btn btn-success px-4">{ Submit }</button>
                    </div>
                </form>
            </div>
    </div>
    `;
}

export function nextStep(event) {
    event.preventDefault();

    const formId = `formStep${currentStep}`;
    const form = document.getElementById(formId);

    if (validateForm(form)) {
        const formData = new FormData(form);
        const jsonData = Object.fromEntries(formData.entries());

        // Merge dos dados no acumulador
        Object.assign(formDataAccumulator, jsonData);

        if (currentStep < totalSteps) {
            currentStep++;
            loadStep(currentStep);
        }
    } else {
        console.log("Validation failed for Step " + currentStep);
    }
}

export function prevStep() {
    if (currentStep > 1) {
        currentStep--;
        loadStep(currentStep);
    }
}

function validateForm(form) {
    // Exemplo de validação: pode ser expandido conforme necessário
    let isValid = true;
    form.querySelectorAll("input, textarea").forEach(input => {
        if (!input.value) {
            isValid = false;
        }
    });
    return isValid;
}

function addEventListeners() {
    const form = document.querySelector("form");

    const nextBtn = document.getElementById("nextBtn");
    const prevBtn = document.getElementById("prevBtn");
    const submitButton = document.getElementById("submitButton");

    if (nextBtn) {
        nextBtn.addEventListener("click", (e) => {
            e.preventDefault();
            const form = document.querySelector("form");
            if (validateForm(form)) {
                // Junta os dados deste step
                const data = new FormData(form);
                for (const [key, value] of data.entries()) {
                    formDataAccumulator[key] = value;
                }
                nextStep(e);
            }
            else {
                alert("Please, fill all steps!"); // <-- aqui está o alerta
            }
        });
    }

    if (prevBtn) {
        prevBtn.addEventListener("click", (e) => {
            e.preventDefault();
            prevStep();
        });
    }

    if (submitButton) {
        submitButton.addEventListener("click", async (e) => {
            e.preventDefault();
            const form = document.querySelector("form");
            if (validateForm(form)) {
                const data = new FormData(form);
                for (const [key, value] of data.entries()) {
                    formDataAccumulator[key] = value;
                }

                // Se quiseres ver o resultado:
                console.log("Submiting JSON:", JSON.stringify(formDataAccumulator));

                const payload = {
                    companyName: formDataAccumulator.companyName,
                    rfpDate: formDataAccumulator.rfpDate,
                    endDate: formDataAccumulator.endDate,
                    projectName: formDataAccumulator.projectName,
                    projectGoal: formDataAccumulator.projectGoal,
                    technicalDescription: formDataAccumulator.technicalDescription,
                    integrationPlan: formDataAccumulator.integrationPlan,
                    dataSecurity: formDataAccumulator.dataSecurity,
                    totalPrice: parseFloat(formDataAccumulator.totalPrice),
                    supportAndWarranty: formDataAccumulator.supportWarranty,
                    // Corrected nested DTOs
                    cronogram: [
                      {
                        phaseName: formDataAccumulator.phaseName,
                        startDate: formDataAccumulator.startDate,
                        endDate: formDataAccumulator.phaseEndDate,
                        deliverables: formDataAccumulator.deliverables,
                      }
                    ],
                    companyCertifications: (formDataAccumulator.companyCertifications || "")
                    .split(',')
                    .map(name => ({ certificationName: name.trim() })),
                    teamMembers: [
                      {
                        memberName: formDataAccumulator.memberName,
                        role: formDataAccumulator.role,
                        specialization: formDataAccumulator.specialization
                      }
                    ]
                  };

                try {
                    const response = await fetch("http://ec2-13-60-169-55.eu-north-1.compute.amazonaws.com:8080/api/ai-analysis/generate-rfp-rag", {
                        method: "POST",
                        headers: {
                            "Content-Type": "application/json"
                        },
                        body: JSON.stringify(payload)
                    });

                    const response2 = await fetch('http://ec2-13-60-169-55.eu-north-1.compute.amazonaws.com:8080/api/rfp', {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify(payload)
                    });
            

               
                    if (response.ok) {
                        const blob = await response.blob();
                        const url = window.URL.createObjectURL(blob);
                        const a = document.createElement('a');
                        a.href = url;
                        a.download = "generated_rfp.pdf";
                        document.body.appendChild(a);
                        a.click();
                        a.remove();
                        window.URL.revokeObjectURL(url);
                      } else {
                        console.error("Erro ao gerar PDF:", await response.text());
                      }

                } catch (error) {
                    console.error("Requisiton error:", error);
                }
            } else {
                console.log("Validation failed.");
            }
        });
    }
}