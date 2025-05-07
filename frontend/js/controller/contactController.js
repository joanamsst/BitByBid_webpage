export function init() {
  const app = document.getElementById("app");

  app.innerHTML = `
  <form class="contactForm">
    <p class="formTitle">&lt;Contact_us/&gt;</p>

    <div class="mb-3">
      <label for="contactName" class="insertName">Name_</label>
      <input type="text" id="contactName" class="contactName" placeholder="//Insert Name">
    </div>

    <div class="mb-3">
      <label for="contactEmail" class="insertEmail">Email_</label>
      <input type="email" id="contactEmail" class="contactEmail" placeholder="//Insert Email">
    </div>

    <div class="mb-3">
      <label for="contactQuestion" class="insertQuestion">Question_</label>
      <input type="text" id="contactQuestion" class="contactQuestion" placeholder="//Insert Question">
    </div>

    <button type="submit" class="btn btn-primary">{ Submit }</button>

    <div id="formMessage" class="form-message" style="display: none;"></div>
  </form>

  <!-- Modal de Sucesso -->
  <div class="modal" id="successModal">
    <div class="modal-content">
      <p>Your message has been sent successfully!</p>
      <div class="modal-buttons">
        <button id="okBtn">OK_</button>
        <button onclick="window.location.href='/'">Home_</button>
      </div>
    </div>
  </div>
`;

  const form = document.querySelector(".contactForm");
  const msg = document.getElementById("formMessage");

  // Inicializa o EmailJS
  emailjs.init("PnQaTaTut6OZf-AzA"); // Substitua com sua chave pública do EmailJS

  // Quando o formulário for enviado
  form.addEventListener("submit", function (e) {
    e.preventDefault();

    const name = document.getElementById("contactName").value;
    const email = document.getElementById("contactEmail").value;
    const question = document.getElementById("contactQuestion").value;

    emailjs.send("BitByBid", "template_u5jwido", {
      name: name,
      email: email,
      message: question
    }).then(
      function (response) {
        console.log("SUCCESS!", response.status, response.text);
        showModal();
        form.reset();
      },
      function (error) {
        console.log("FAILED...", error);
        alert(`Something went wrong: ${error.text}`);
      }
    );
  });
}
function showModal() {
  const modal = document.getElementById("successModal");
  modal.style.display = "flex";

  const okBtn = document.getElementById("okBtn");
  okBtn.addEventListener("click", () => {
    modal.style.display = "none";
  });
}