const API_URL = 'http://localhost:8080/api/stations';

async function fetchStations() {
    const container = document.getElementById('stations-container');
    if (!container) return;

    try {
        const response = await fetch(API_URL);
        const stations = await response.json();
        container.innerHTML = '';

        stations.forEach(station => {
            const isAvailable = station.stav === 'VOLNO';


            const buttonHtml = isAvailable
                ? `<button class="btn" onclick="reserveStation(${station.idStanice})">REZERVOVAT</button>`
                : `<button class="btn" style="background: #ff4444;" onclick="cancelReservation(${station.idStanice})">ZRUŠIT REZERVACI</button>`;


            const stationCard = `
    <article class="card">
        <h3>STANICE #${station.cisloStanice}</h3>
        <p>Stav: <b style="color: ${isAvailable ? '#00ff00' : '#ff4444'}">${isAvailable ? 'VOLNO' : 'OBSAZENO'}</b></p>
        <p>Cena: ${station.hodinovaCena} Kč/hod</p>

        <button class="btn"
                style="${!isAvailable ? 'background: #ff4444; border-color: #ff4444;' : ''}"
                onclick="${isAvailable ? `reserveStation(${station.idStanice})` : `cancelReservation(${station.idStanice})`}">
            ${isAvailable ? 'REZERVOVAT' : 'ZRUŠIT REZERVACI'}
        </button>

        <div class="reservation-inputs" style="margin: 10px 0;">
            <label style="font-size: 0.7rem; display: block;">Od:</label>
            <input type="datetime-local" id="time-from-${station.idStanice}" class="time-input">

            <label style="font-size: 0.7rem; display: block; margin-top: 5px;">Do:</label>
            <input type="datetime-local" id="time-to-${station.idStanice}" class="time-input">
        </div>

        <button class="btn" onclick="makeTimedReservation(${station.idStanice})">
            REZERVOVAT NA ČAS
        </button>

    </article>
`;



            container.innerHTML += stationCard;
        });
    } catch (error) {
        console.error('Chyba při načítání:', error);
    }
}

async function reserveStation(id) {
    if (!confirm('Opravdu chcete rezervovat tuto stanici?')) return;

    try {
        const response = await fetch(`${API_URL}/${id}/reserve`, {
            method: 'PATCH'
        });

        if (response.ok) {
            alert('Stanice byla úspěšně rezervována!');
            fetchStations();
        } else {
            alert('Chyba při rezervaci. Zkuste to znovu.');
        }
    } catch (error) {
        console.error('Chyba:', error);
    }
}

async function cancelReservation(id) {
    if (!confirm('Opravdu chcete zrušit rezervaci?')) return;

    try {
        const response = await fetch(`${API_URL}/${id}/cancel`, {
            method: 'PATCH'
        });

        if (response.ok) {
            alert('Rezervace byla zrušena!');
            fetchStations(); // Обновляем список
        }
    } catch (error) {
        console.error('Chyba:', error);
    }
}

async function makeTimedReservation(id) {
    // Исправленные ID (теперь они совпадают с теми, что в HTML карточки выше)
    const startInput = document.getElementById(`time-from-${id}`).value;
    const endInput = document.getElementById(`time-to-${id}`).value;

    if (!startInput || !endInput) {
        alert('Prosím, vyberte čas začátku a konce rezervace!');
        return;
    }

    const reservationData = {
        idStanice: id,
        casOd: startInput,
        casDo: endInput,
        idZakaznik: 1,
        stavRezervace: "POTVRZENO"
    };

    try {
        const response = await fetch('http://localhost:8080/api/reservations', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(reservationData)
        });

        if (response.ok) {
            alert('Rezervace byla úspěšně vytvořena!');
            fetchStations();
        } else {
            alert('Chyba při vytváření rezervace на сервере.');
        }
    } catch (error) {
        console.error('Fetch error:', error);
        alert('Nepodařilo se spojit se serverem.');
    }
}


fetchStations();