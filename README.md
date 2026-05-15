NEONIX - Systém pro správu počítačového klubu

Semestrální projekt zaměřený na vytvoření Full-stack aplikace pro rezervaci herních míst.

DŮLEŽITÉ: Připojení k databázi
Projekt využívá databázi "Oracle SQL" umístěnou na univerzitním serveru. 
Pro úspěšné spuštění backendu a správné fungování aplikace je nutné:
Aktivní VPN připojení (Cisco AnyConnect) pro přístup k databázovému hostiteli.
Konfigurace připojení se nachází v souboru `src/main/resources/application.properties`.

Použité technologie
Backend:Java 17, Spring Boot, Spring Data JPA.
Databáze:Oracle SQL (Schéma: ST79048).
Frontend:HTML5, CSS3, JavaScript.

Struktura projektu
`/src` — zdrojový kód serverové části (Spring Boot).
`/frontend` — klientská část aplikace (hlavní soubor `index.html`).

Klíčové funkce
Prohlížení dostupných herních stanic.
Systém rezervace času v reálném čase.
Můj profil (Profil), kde se zobrazují pouze rezervace aktuálního uživatele (filtrace podle ID).

Instalace a spuštění:
1. Připojte se k univerzitní síti přes VPN.
2. Spusťte Spring Boot aplikaci (soubor `HerniKlubApplication.java`).
3. Otevřete `index.html` v adresáři `/frontend` pomocí libovolného webového prohlížeče.
