async function loadReservations() {
    const container = document.getElementById('my-reservations');
    try {
        const response = await fetch('http://localhost:8080/api/reservations');
        const data = await response.json();

        if (data.length === 0) {
            container.innerHTML = '<p>Zatím nejsou žádné rezervace.</p>';
            return;
        }


        container.innerHTML = data.reverse().map(res => `
            <div class="card">
                <h3>PC #${res.idStanice}</h3>
                <p><b>С:</b> ${new Date(res.casOd).toLocaleString()}</p>
                <p><b>До:</b> ${new Date(res.casDo).toLocaleString()}</p>
                <p><b>Статус:</b> <span style="color:var(--accent)">${res.stavRezervace}</span></p>
            </div>
        `).join('');
    } catch (err) {
        container.innerHTML = '<p>Nepodařilo se načíst data из Oracle!</p>';
    }
}
document.addEventListener('DOMContentLoaded', loadReservations);
