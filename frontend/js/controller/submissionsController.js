// submissionsController.js
let allSubmissions = [];
let currentPage = 1;
const itemsPerPage = 5;
export function init() {
    const app = document.getElementById("app");
    app.innerHTML = `
        <div class="black-container">
            <div style="width: 100%; max-width: 800px;">
            <p>&nbsp;</p>
                <h2 style="color: #74b32d;  padding: 10px; margin-bottom: 20px; font-size: 2.5rem; font-family: monospace; font-weight: bolder;">&lt;Submitted_RFPs&gt;</h2>
                <input type="text" id="searchInput" placeholder="Search by project or company..." style="width: 100%; padding: 10px; margin-bottom: 20px; border-radius: 5px;" />
                <p>&nbsp;</p><div id="submissionList"></div>
                <div id="pagination" style="margin-top: 20px; display: flex; gap: 10px;"></div>
            </div>
        </div>
    `;
    fetch("http://ec2-13-60-169-55.eu-north-1.compute.amazonaws.com:8080/api/rfp")
        .then(res => res.json())
        .then(data => {
            allSubmissions = data;
            renderPage(currentPage);
            document.getElementById("searchInput").addEventListener("input", () => {
                currentPage = 1;
                renderPage(currentPage);
            });
        })
        .catch(err => {
            document.getElementById("submissionList").innerHTML = `<p>Error loading submissions.</p>`;
            console.error(err);
        });
}
function renderPage(page) {
    const list = document.getElementById("submissionList");
    const searchTerm = document.getElementById("searchInput").value.toLowerCase();
    const filtered = allSubmissions.filter(item =>
        item.projectName.toLowerCase().includes(searchTerm) ||
        item.companyName.toLowerCase().includes(searchTerm)
    );
    const totalPages = Math.ceil(filtered.length / itemsPerPage);
    const start = (page - 1) * itemsPerPage;
    const paginated = filtered.slice(start, start + itemsPerPage);
    list.innerHTML = paginated.map(item => `
        <div class="submission-card">
            <h4>${item.projectName}</h4>
            <p><strong>Company:</strong> ${item.companyName}</p>
            <p><strong>Goal:</strong> ${item.projectGoal}</p>
            <p><strong>Price:</strong> $${item.totalPrice}</p>
            <button class="download-btn" data-id="${item.requestId}">Download_PDF</button>
        </div>
    `).join('');
    // Add event listeners to download buttons
    document.querySelectorAll('.download-btn').forEach(btn => {
        btn.addEventListener('click', () => {
            const id = btn.dataset.id;
            window.open(`http://ec2-13-60-169-55.eu-north-1.compute.amazonaws.com:8080/api/rfp/export-pdf?ids=${id}`, '_blank');
        });
    });
    // Render pagination
    const pagination = document.getElementById("pagination");
    pagination.innerHTML = Array.from({ length: totalPages }, (_, i) => `
        <button class="page-btn" data-page="${i + 1}" ${i + 1 === page ? 'disabled' : ''}>${i + 1}</button>
    `).join('');
    document.querySelectorAll(".page-btn").forEach(btn => {
        btn.addEventListener("click", () => {
            currentPage = parseInt(btn.dataset.page);
            renderPage(currentPage);
        });
    });
}